package com.spring.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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
@RequestMapping("/want_board/*")
public class WantBoardController {
	
	@Inject
	BoardService service;

	@Inject
	private ReplyService replyService;
	
	// 패키지 설계 게시글 목록
	@RequestMapping(value = "/want_list", method = RequestMethod.GET)
	public void getWantList(Model model) throws Exception {
		// Model = Controller와 View 연결해주는 역할
		List<BoardDTO> want_list = null;
		want_list = service.want_list();

		model.addAttribute("list", want_list);
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

		model.addAttribute("view", dto);

		// 패키지 설계 댓글 조회
		List<ReplyDTO> want_reply = null;
		// want_reply = replyService.want_list(board_want_bno);
		model.addAttribute("reply", want_reply);
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

	// 자유 게시글 삭제
	@RequestMapping(value = "/want_delete", method = RequestMethod.GET)
	public String getWantDelete(@RequestParam("board_want_bno") int board_want_bno) throws Exception {
		service.want_delete(board_want_bno);

		return "redirect:/want_board/want_list";
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

		List<BoardDTO> want_list = null;
		want_list = service.want_listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType,
				keyword);

		model.addAttribute("list", want_list);
		model.addAttribute("page", page);
		model.addAttribute("select", num);
	}
}
