package com.spring.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
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
import com.spring.service.BoardService;
import com.spring.service.ReplyService;
import com.spring.utils.UploadFileUtils;

@Controller
@RequestMapping("/want_board/*")
public class WantBoardController {
	
	@Inject
	BoardService service;

	@Inject
	private ReplyService replyService;
	
	@Resource(name="uploadPath")
    private String uploadPath;
	
	// 패키지 설계 게시글 목록
	@RequestMapping(value = "/want_list", method = RequestMethod.GET)
	public void getWantList(Model model) throws Exception {
		
		// Model = Controller와 View 연결해주는 역할
		List<BoardDTO> list = null;
		list = service.want_list();
		
		model.addAttribute("list", list);
	}

	// 패키지 설계 게시글 작성 get
	@RequestMapping(value = "/want_write", method = RequestMethod.GET)
	public void getWantWrite(HttpSession session, Model model) throws Exception {
		Object loginInfo = session.getAttribute("member");

		if (loginInfo == null) {
			model.addAttribute("msg", "login_error");
		}
	}

	// 패키지 설계 게시글 작성 post
	@RequestMapping(value = "/want_write", method = RequestMethod.POST)
	public String postWantWrite(BoardDTO dto, MultipartFile file) throws Exception {
		
		String imgUploadPath = uploadPath + File.separator + "upload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String file_name = null;
		System.out.println(imgUploadPath);
		if(file != null) {
		 file_name =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
		 file_name = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		dto.setBoard_want_img(File.separator + "upload" + ymdPath + File.separator + file_name);
		dto.setBoard_want_thumbnail(File.separator + "upload" + ymdPath + File.separator + "s" + File.separator + "s_" + file_name);
		
		service.want_write(dto);

		return "redirect:/want_board/want_listPageSearch?num=1";
	}

	// 패키지 설계 게시글 조회
	@RequestMapping(value = "/want_view", method = RequestMethod.GET)
	public void getWantView(@RequestParam("board_want_bno") int board_want_bno, Model model) throws Exception {
		
		BoardDTO dto = service.want_view(board_want_bno);
		
		model.addAttribute("view", dto);

		// 패키지 설계 댓글 조회
		List<ReplyDTO> reply = null;
		reply = replyService.want_list(board_want_bno);
		model.addAttribute("reply", reply);
	}

	// 패키지 설계 게시글 수정
	@RequestMapping(value = "/want_modify", method = RequestMethod.GET)
	public void getWantModify(@RequestParam("board_want_bno") int board_want_bno, Model model) throws Exception {
		BoardDTO dto = service.want_view(board_want_bno);

		model.addAttribute("view", dto);
	}

	// 패키지 설계 게시글 수정
	@RequestMapping(value = "/want_modify", method = RequestMethod.POST)
	public String postWantModify(BoardDTO dto) throws Exception {
		service.want_modify(dto);

		return "redirect:/want_board/want_view?board_want_bno=" + dto.getBoard_want_bno();
	}

	// 패키지 설계 게시글 삭제
	@RequestMapping(value = "/want_delete", method = RequestMethod.GET)
	public String getWantDelete(@RequestParam("board_want_bno") int board_want_bno) throws Exception {
		service.want_delete(board_want_bno);

		return "redirect:/want_board/want_listPageSearch?num=1";
	}

	// 패키지 설계 게시글 목록 + 페이징 추가 + 검색
	@RequestMapping(value = "/want_listPageSearch", method = RequestMethod.GET)
	public void getWantListPageSearch(Model model, @RequestParam("num") int num,
			@RequestParam(value = "searchType", required = false, defaultValue = "title") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword)
			throws Exception {

		Page page = new Page();

		page.setNum(num);
		page.setCount(service.want_searchCount(searchType, keyword));

		// 검색 타입과 검색어
		page.setSearchType(searchType);
		page.setKeyword(keyword);

		List<BoardDTO> list = null;
		list = service.want_listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);

		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("select", num);
	}
	
	//게시물 추천 관련 메소드 get
	@ResponseBody
	@RequestMapping(value = "/want_updateLike", method = RequestMethod.GET)
	public void getWantUpdateLike() throws Exception {

	}
	
	// 게시물 추천 관련 메소드 post
	@ResponseBody
	@RequestMapping(value = "/want_updateLike", method = RequestMethod.POST)
	public int postWantUpdateLike(int board_want_bno, int user_num) throws Exception {

		int want_likeCheck = service.want_likeCheck(board_want_bno, user_num);
		if (want_likeCheck == 0) {
			// 좋아요 처음누름
			service.want_insertLike(board_want_bno, user_num); // like테이블 삽입
			service.want_updateLike(board_want_bno); // 게시판테이블 +1
			service.want_updateLikeCheck(board_want_bno, user_num);// like테이블 구분자 1
		} else if (want_likeCheck == 1) {
			service.want_updateLikeCheckCancel(board_want_bno, user_num); // like테이블 구분자0
			service.want_updateLikeCancel(board_want_bno); // 게시판테이블 - 1
			service.want_deleteLike(board_want_bno, user_num); // like테이블 삭제
		}
		return want_likeCheck;
	}
}
