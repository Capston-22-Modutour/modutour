package com.spring.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.BoardDTO;
import com.spring.dto.Page;
import com.spring.dto.ReplyDTO;
import com.spring.service.BoardService;
import com.spring.service.ReplyService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	BoardService service;

	@Inject
	private ReplyService replyService;

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
	public String postWrite(BoardDTO dto) throws Exception {
		service.write(dto);

		return "redirect:/board/list";
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

		return "redirect:/board/list";
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

	// -------------------------------------
	/*
	// 패키지 설계 게시글 목록
	@RequestMapping(value = "/want_list", method = RequestMethod.GET)
	public void getWantList(Model model) throws Exception {
		// Model = Controller와 View 연결해주는 역할
		List<BoardDTO> want_list = null;
		want_list = service.want_list();

		model.addAttribute("want_list", want_list);
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
	public String postWantWrite(BoardDTO dto) throws Exception {
		service.want_write(dto);

		return "redirect:/want_board/want_list";
	}

	// 패키지 설계 게시글 조회
	@RequestMapping(value = "/want_view", method = RequestMethod.GET)
	public void getWantView(@RequestParam("board_want_bno") int board_want_bno, Model model) throws Exception {
		BoardDTO dto = service.want_view(board_want_bno);

		model.addAttribute("want_view", dto);

		// 패키지 설계 댓글 조회
		List<ReplyDTO> want_reply = null;
		//want_reply = replyService.want_list(board_want_bno);
		model.addAttribute("want_reply", want_reply);
	}

	// 패키지 설계 게시글 수정
	@RequestMapping(value = "/want_modify", method = RequestMethod.GET)
	public void getWantModify(@RequestParam("board_want_bno") int board_want_bno, Model model) throws Exception {
		BoardDTO dto = service.want_view(board_want_bno);

		model.addAttribute("want_view", dto);
	}

	// 패키지 설계 게시글 수정
	@RequestMapping(value = "/want_modify", method = RequestMethod.POST)
	public String postWantModify(BoardDTO dto) throws Exception {
		service.want_modify(dto);

		return "redirect:/want_board/want_view?board_want_bno=" + dto.getBoard_want_bno();
	}

	// 자유 게시글 삭제
	@RequestMapping(value = "/want_delete", method = RequestMethod.GET)
	public String getWantDelete(@RequestParam("board_want_bno") int board_want_bno) throws Exception {
		service.want_delete(board_want_bno);

		return "redirect:/want_board/want_list";
	}

	
	// 패키지 설계 게시글 목록 + 페이징 추가 + 검색
	@RequestMapping(value = "/want_listPageSearch", method = RequestMethod.GET)
	public void getWantListPageSearch(Model model, @RequestParam("num") int num,
			@RequestParam(value = "searchType", required = false, defaultValue = "want_title") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword)
			throws Exception {

		Page want_page = new Page();

		want_page.setNum(num);
		want_page.setCount(service.want_searchCount(searchType, keyword));

		// 검색 타입과 검색어
		want_page.setSearchType(searchType);
		want_page.setKeyword(keyword);

		List<BoardDTO> want_list = null;
		want_list = service.want_listPageSearch(want_page.getDisplayPost(), want_page.getPostNum(), searchType, keyword);

		model.addAttribute("list", want_list);
		model.addAttribute("page", want_page);
		model.addAttribute("select", num);
	}
	*/
}
