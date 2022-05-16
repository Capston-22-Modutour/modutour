package com.spring.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dto.BoardDTO;
import com.spring.dto.Page;
import com.spring.dto.ReplyDTO;
import com.spring.service.BoardService;
import com.spring.service.ReplyService;

@Controller
@RequestMapping("/suggest_board/*")
public class SuggestBoardController {
	
	@Inject
	BoardService service;

	@Inject
	private ReplyService replyService;
	
	// 패키지 제안 게시글 목록
	@RequestMapping(value = "/suggest_list", method = RequestMethod.GET)
	public void getSuggestList(Model model) throws Exception {
		// Model = Controller와 View 연결해주는 역할
		List<BoardDTO> suggest_list = null;
		suggest_list = service.suggest_list();

		model.addAttribute("list", suggest_list);
	}

	// 패키지 제안 게시글 작성 get
	@RequestMapping(value = "/suggest_write", method = RequestMethod.GET)
	public void getSuggestWrite(HttpSession session, Model model) throws Exception {
		Object loginInfo = session.getAttribute("member");

		if (loginInfo == null) {
			model.addAttribute("msg", "login_error");
		}
	}

	// 패키지 제안 게시글 작성 post
	@RequestMapping(value = "/suggest_write", method = RequestMethod.POST)
	public String postSuggestWrite(BoardDTO dto) throws Exception {
		service.suggest_write(dto);

		return "redirect:/suggest_board/suggest_listPageSearch?num=1";
	}

	// 패키지 제안 게시글 조회
	@RequestMapping(value = "/suggest_view", method = RequestMethod.GET)
	public void getSuggestView(@RequestParam("suggest_bno") int suggest_bno, Model model) throws Exception {
		BoardDTO dto = service.suggest_view(suggest_bno);

		model.addAttribute("view", dto);

		// 패키지 설계 댓글 조회
		/*
		 * List<ReplyDTO> reply = null; reply = replyService.want_list(suggest_bno);
		 * model.addAttribute("reply", reply);
		 */
	}

	// 패키지 제안 게시글 수정
	@RequestMapping(value = "/suggest_modify", method = RequestMethod.GET)
	public void getSuggestModify(@RequestParam("suggest_bno") int suggest_bno, Model model) throws Exception {
		BoardDTO dto = service.suggest_view(suggest_bno);

		model.addAttribute("view", dto);
	}

	// 패키지 제안 게시글 수정
	@RequestMapping(value = "/suggest_modify", method = RequestMethod.POST)
	public String postSuggestModify(BoardDTO dto) throws Exception {
		service.suggest_modify(dto);

		return "redirect:/suggest_board/suggest_view?suggest_bno=" + dto.getSuggest_bno();
	}

	// 패키지 제안 게시글 삭제
	@RequestMapping(value = "/suggest_delete", method = RequestMethod.GET)
	public String getSuggestDelete(@RequestParam("suggest_bno") int suggest_bno) throws Exception {
		service.suggest_delete(suggest_bno);

		return "redirect:/suggest_board/suggest_listPageSearch?num=1";
	}

	// 패키지 제안 게시글 목록 + 페이징 추가 + 검색
	@RequestMapping(value = "/suggest_listPageSearch", method = RequestMethod.GET)
	public void getSuggestListPageSearch(Model model, @RequestParam("num") int num,
			@RequestParam(value = "searchType", required = false, defaultValue = "title") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword)
			throws Exception {

		Page page = new Page();

		page.setNum(num);
		page.setCount(service.suggest_searchCount(searchType, keyword));

		// 검색 타입과 검색어
		page.setSearchType(searchType);
		page.setKeyword(keyword);

		List<BoardDTO> want_list = null;
		want_list = service.suggest_listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType,
				keyword);

		model.addAttribute("list", want_list);
		model.addAttribute("page", page);
		model.addAttribute("select", num);
	}
	
	//게시물 추천 관련 메소드 get
	@ResponseBody
	@RequestMapping(value = "/suggest_updateLike", method = RequestMethod.GET)
	public void getSuggestUpdateLike() throws Exception {

	}
	
	// 게시물 추천 관련 메소드 post
	@ResponseBody
	@RequestMapping(value = "/suggest_updateLike", method = RequestMethod.POST)
	public int postSuggestUpdateLike(int suggest_bno, int user_num) throws Exception {

		int suggest_likeCheck = service.want_likeCheck(suggest_bno, user_num);
		if (suggest_likeCheck == 0) {
			// 좋아요 처음누름
			service.want_insertLike(suggest_bno, user_num); // like테이블 삽입
			service.want_updateLike(suggest_bno); // 게시판테이블 +1
			service.want_updateLikeCheck(suggest_bno, user_num);// like테이블 구분자 1
		} else if (suggest_likeCheck == 1) {
			service.want_updateLikeCheckCancel(suggest_bno, user_num); // like테이블 구분자0
			service.want_updateLikeCancel(suggest_bno); // 게시판테이블 - 1
			service.want_deleteLike(suggest_bno, user_num); // like테이블 삭제
		}
		return suggest_likeCheck;
	}
}
