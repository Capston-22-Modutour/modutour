package com.spring.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dto.BoardDTO;
import com.spring.dto.MemberDTO;
import com.spring.dto.Page;
import com.spring.dto.ReplyDTO;
import com.spring.service.BoardService;
import com.spring.service.ReplyService;

@Controller
@RequestMapping("/sell_board/*")
public class SellBoardController {
	
	@Inject
	BoardService service;

	@Inject
	private ReplyService replyService;
	
	// 패키지 설계 게시글 목록
	@RequestMapping(value = "/sell_list", method = RequestMethod.GET)
	public void getSellList(Model model) throws Exception {
		// Model = Controller와 View 연결해주는 역할
		List<BoardDTO> sell_list = null;
		sell_list = service.sell_list();

		model.addAttribute("list", sell_list);
	}

	// 패키지 설계 게시글 작성 get
	@RequestMapping(value = "/sell_write", method = RequestMethod.GET)
	public void getSellWrite(HttpSession session, Model model) throws Exception {
		Object loginInfo = session.getAttribute("member");

		if (loginInfo == null) {
			model.addAttribute("msg", "login_error");
		}
	}

	// 패키지 설계 게시글 작성 post
	@RequestMapping(value = "/sell_write", method = RequestMethod.POST)
	public String postSellWrite(HttpServletRequest request, BoardDTO dto) throws Exception {
		
		service.sell_write(dto);

		return "redirect:/sell_board/sell_listPageSearch?num=1";
	}

	// 패키지 설계 게시글 조회
	@RequestMapping(value = "/sell_view", method = RequestMethod.GET)
	public void getSellView(@RequestParam("sell_bno") int sell_bno,	HttpServletRequest request, Model model) throws Exception {
		
		HttpSession session = request.getSession();
		//session.getAttribute("member");
		
		if(session.getAttribute("member") != null) {
			int user_num = (Integer)session.getAttribute("user_num");
			int purchased = service.purchaseCheck(sell_bno, user_num);
			
			System.out.println("유저번호 : " + user_num + " 게시글번호 : " + sell_bno + " 구매여부 : " + purchased);
			
			model.addAttribute("purchased", purchased);
			
		} else if (session.getAttribute("company") != null){ 
			
		}
		
		BoardDTO dto = service.sell_view(sell_bno);
		
		model.addAttribute("view", dto);
		

		// 패키지 설계 댓글 조회
		List<ReplyDTO> reply = null;
		reply = replyService.sell_list(sell_bno);
		model.addAttribute("reply", reply);
	}

	// 패키지 설계 게시글 수정
	@RequestMapping(value = "/sell_modify", method = RequestMethod.GET)
	public void getSellModify(@RequestParam("sell_bno") int sell_bno, Model model) throws Exception {
		BoardDTO dto = service.sell_view(sell_bno);

		model.addAttribute("view", dto);
	}

	// 패키지 설계 게시글 수정
	@RequestMapping(value = "/sell_modify", method = RequestMethod.POST)
	public String postSellModify(BoardDTO dto) throws Exception {
		service.sell_modify(dto);

		return "redirect:/sell_board/sell_view?sell_bno=" + dto.getSell_bno();
	}

	// 패키지 설계 게시글 삭제
	@RequestMapping(value = "/sell_delete", method = RequestMethod.GET)
	public String getSellDelete(@RequestParam("sell_bno") int sell_bno) throws Exception {
		service.sell_delete(sell_bno);

		return "redirect:/sell_board/sell_listPageSearch?num=1";
	}

	// 패키지 설계 게시글 목록 + 페이징 추가 + 검색
	@RequestMapping(value = "/sell_listPageSearch", method = RequestMethod.GET)
	public void getSellListPageSearch(Model model, @RequestParam("num") int num,
			@RequestParam(value = "searchType", required = false, defaultValue = "title") String searchType,
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword)
			throws Exception {

		Page page = new Page();

		page.setNum(num);
		page.setCount(service.sell_searchCount(searchType, keyword));

		// 검색 타입과 검색어
		page.setSearchType(searchType);
		page.setKeyword(keyword);

		List<BoardDTO> sell_list = null;
		sell_list = service.sell_listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);

		model.addAttribute("list", sell_list);
		model.addAttribute("page", page);
		model.addAttribute("select", num);
	}
	
	//게시물 추천 관련 메소드 get
	@ResponseBody
	@RequestMapping(value = "/sell_updateLike", method = RequestMethod.GET)
	public void getSellUpdateLike() throws Exception {

	}
	
	// 게시물 추천 관련 메소드 post
	@ResponseBody
	@RequestMapping(value = "/sell_updateLike", method = RequestMethod.POST)
	public int postSellUpdateLike(int sell_bno, int user_num) throws Exception {

		int sell_likeCheck = service.sell_likeCheck(sell_bno, user_num);
		if (sell_likeCheck == 0) {
			// 좋아요 처음누름
			service.sell_insertLike(sell_bno, user_num); // like테이블 삽입
			service.sell_updateLike(sell_bno); // 게시판테이블 +1
			service.sell_updateLikeCheck(sell_bno, user_num);// like테이블 구분자 1
		} else if (sell_likeCheck == 1) {
			service.sell_updateLikeCheckCancel(sell_bno, user_num); // like테이블 구분자0
			service.sell_updateLikeCancel(sell_bno); // 게시판테이블 - 1
			service.sell_deleteLike(sell_bno, user_num); // like테이블 삭제
		}
		return sell_likeCheck;
	}
}
