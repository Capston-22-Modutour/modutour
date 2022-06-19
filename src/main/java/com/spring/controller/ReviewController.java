package com.spring.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dto.BoardDTO;
import com.spring.dto.Page;
import com.spring.dto.ReplyDTO;
import com.spring.service.ReplyService;
import com.spring.service.ReviewBoardService;
import com.spring.utils.UploadFileUtils;

@Controller
@RequestMapping("/review/*")
public class ReviewController {

	@Inject
	ReviewBoardService service;

	@Inject
	private ReplyService replyService;
	
	@Resource(name="uploadPath")
    private String uploadPath;

	// 여행후기 목록
	@RequestMapping(value = "/review_list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		
		// Model = Controller와 View 연결해주는 역할
		List<BoardDTO> list = null;
		list = service.review_list();

		model.addAttribute("list", list);
	}

	// 여행후기 작성 get
	@RequestMapping(value = "/review_write", method = RequestMethod.GET)
	public void getWrite(HttpSession session, Model model) throws Exception {
		Object loginInfo = session.getAttribute("member");

		if (loginInfo == null) {
			model.addAttribute("msg", "login_error");
		}
	}

	// 여행후기 작성 post
	@RequestMapping(value = "/review_write", method = RequestMethod.POST)
	public String postWrite(HttpServletRequest request, BoardDTO dto, MultipartFile file) throws Exception {
		
		String imgUploadPath = uploadPath + File.separator + "upload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String file_name = null;
		System.out.println(imgUploadPath);
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 file_name =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
		 file_name = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		HttpSession session = request.getSession();
		session.getAttribute("member");
		int user_num = (Integer)session.getAttribute("user_num");
		
		dto.setReview_img(File.separator + "upload" + ymdPath + File.separator + file_name);
		dto.setReview_thumbnail(File.separator + "upload" + ymdPath + File.separator + "s" + File.separator + "s_" + file_name);
		dto.setUser_num(user_num);
		
		service.review_write(dto);
		
		return "redirect:/review/review_listPageSearch?num=1";
	}

	// 여행후기 조회
	@RequestMapping(value = "/review_view", method = RequestMethod.GET)
	public void getView(@RequestParam("review_bno") int review_bno, Model model) throws Exception {
		
		BoardDTO dto = service.review_view(review_bno);
		
		model.addAttribute("view", dto);

		// 댓글 조회
		List<ReplyDTO> reply = null;
		reply = replyService.review_list(review_bno);
		model.addAttribute("reply", reply);
		
	}

	// 여행후기 수정
	@RequestMapping(value = "/review_modify", method = RequestMethod.GET)
	public void getModify(@RequestParam("review_bno") int review_bno, Model model) throws Exception {
		BoardDTO dto = service.review_view(review_bno);

		model.addAttribute("view", dto);
	}

	// 여행후기 수정
	@RequestMapping(value = "/review_modify", method = RequestMethod.POST)
	public String postModify(BoardDTO dto) throws Exception {
		service.review_modify(dto);

		return "redirect:/review/review_view?review_bno=" + dto.getReview_bno();
	}

	// 여행후기 삭제
	@RequestMapping(value = "/review_delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("review_bno") int review_bno) throws Exception {
		service.review_delete(review_bno);

		return "redirect:/review/review_listPageSearch?num=1";
	}

	// 여행후기 목록 + 페이징 추가 + 검색
	@RequestMapping(value = "/review_listPageSearch", method = RequestMethod.GET)
	public void getListPageSearch(Model model, @RequestParam("num") int num,
			@RequestParam(value = "searchType", required = false, defaultValue = "title") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) throws Exception {

		Page page = new Page();

		page.setNum(num);
		page.setCount(service.review_searchCount(searchType, keyword));

		// 검색 타입과 검색어
		page.setSearchType(searchType);
		page.setKeyword(keyword);

		List<BoardDTO> list = null;
		list = service.review_listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);

		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("select", num);
	}
	
	//게시물 추천 관련 메소드 get
	@ResponseBody
	@RequestMapping(value = "/review_updateLike", method = RequestMethod.GET)
	public void gettUpdateLike() throws Exception {
		
	}
	
	//게시물 추천 관련 메소드 post
	@ResponseBody
	@RequestMapping(value = "/review_updateLike" , method = RequestMethod.POST)
	public int postUpdateLike(int review_bno, int user_num)throws Exception{

		int likeCheck = service.review_likeCheck(review_bno, user_num);
		if (likeCheck == 0) {
			// 좋아요 처음누름
			service.review_insertLike(review_bno, user_num); // like테이블 삽입
			service.review_updateLike(review_bno); // 게시판테이블 +1
			service.review_updateLikeCheck(review_bno, user_num);// like테이블 구분자 1
		} else if (likeCheck == 1) {
			service.review_updateLikeCheckCancel(review_bno, user_num); // like테이블 구분자0
			service.review_updateLikeCancel(review_bno); // 게시판테이블 - 1
			service.review_deleteLike(review_bno, user_num); // like테이블 삭제
		}
		return likeCheck;
	}
	
}
