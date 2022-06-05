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
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	BoardService service;

	@Inject
	private ReplyService replyService;
	
	@Resource(name="uploadPath")
    private String uploadPath;

	// 자유 게시글 목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		
		// Model = Controller와 View 연결해주는 역할
		List<BoardDTO> list = null;
		list = service.list();

		model.addAttribute("list", list);
	}

	// 자유 게시글 작성 get
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWrite(HttpSession session, Model model) throws Exception {
		Object loginInfo = session.getAttribute("member");

		if (loginInfo == null) {
			model.addAttribute("msg", "login_error");
		}
	}

	// 자유 게시글 작성 post
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWrite(BoardDTO dto, MultipartFile file) throws Exception {
		
		String imgUploadPath = uploadPath + File.separator + "upload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String file_name = null;
		System.out.println(imgUploadPath);
		if(file != null) {
		 file_name =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
		 file_name = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		dto.setBoard_img(File.separator + "upload" + ymdPath + File.separator + file_name);
		dto.setBoard_thumbnail(File.separator + "upload" + ymdPath + File.separator + "s" + File.separator + "s_" + file_name);
		
		service.write(dto);

		return "redirect:/board/listPageSearch?num=1";
	}

	// 자유 게시글 조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("board_bno") int board_bno, Model model) throws Exception {
		
		BoardDTO dto = service.view(board_bno);

		model.addAttribute("view", dto);

		// 댓글 조회
		List<ReplyDTO> reply = null;
		reply = replyService.list(board_bno);
		model.addAttribute("reply", reply);
	}

	// 자유 게시글 수정
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getModify(@RequestParam("board_bno") int board_bno, Model model) throws Exception {
		BoardDTO dto = service.view(board_bno);

		model.addAttribute("view", dto);
	}

	// 자유 게시글 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postModify(BoardDTO dto) throws Exception {
		service.modify(dto);

		return "redirect:/board/view?board_bno=" + dto.getBoard_bno();
	}

	// 자유 게시글 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("board_bno") int board_bno) throws Exception {
		service.delete(board_bno);

		return "redirect:/board/listPageSearch?num=1";
	}

	// 자유 게시글 목록 + 페이징 추가
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void getListPage(Model model, @RequestParam("num") int num) throws Exception {

		Page page = new Page();

		page.setNum(num);
		page.setCount(service.count());

		List<BoardDTO> list = null;
		list = service.listPage(page.getDisplayPost(), page.getPostNum());

		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("select", num);
	}

	// 자유 게시글 목록 + 페이징 추가 + 검색
	@RequestMapping(value = "/listPageSearch", method = RequestMethod.GET)
	public void getListPageSearch(Model model, @RequestParam("num") int num,
			@RequestParam(value = "searchType", required = false, defaultValue = "title") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword) throws Exception {

		Page page = new Page();

		page.setNum(num);
		page.setCount(service.searchCount(searchType, keyword));

		// 검색 타입과 검색어
		page.setSearchType(searchType);
		page.setKeyword(keyword);

		List<BoardDTO> list = null;
		list = service.listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);

		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("select", num);
	}
	
	//게시물 추천 관련 메소드 get
	@ResponseBody
	@RequestMapping(value = "/updateLike", method = RequestMethod.GET)
	public void gettUpdateLike() throws Exception {
		
	}
	
	//게시물 추천 관련 메소드 post
	@ResponseBody
	@RequestMapping(value = "/updateLike" , method = RequestMethod.POST)
	public int postUpdateLike(int board_bno, int user_num)throws Exception{

		int likeCheck = service.likeCheck(board_bno, user_num);
		if (likeCheck == 0) {
			// 좋아요 처음누름
			service.insertLike(board_bno, user_num); // like테이블 삽입
			service.updateLike(board_bno); // 게시판테이블 +1
			service.updateLikeCheck(board_bno, user_num);// like테이블 구분자 1
		} else if (likeCheck == 1) {
			service.updateLikeCheckCancel(board_bno, user_num); // like테이블 구분자0
			service.updateLikeCancel(board_bno); // 게시판테이블 - 1
			service.deleteLike(board_bno, user_num); // like테이블 삭제
		}
		return likeCheck;
	}
	
}
