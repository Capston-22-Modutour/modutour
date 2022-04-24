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
	
	//게시글 목록
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		//Model = Controller와 View 연결해주는 역할
		List<BoardDTO> list = null;
		list = service.list();
		
		model.addAttribute("list", list);
	}
	
	//게시글 작성 get
	@RequestMapping(value="/write", method = RequestMethod.GET)
	public void getWrite(HttpSession session, Model model) throws Exception {
		Object loginInfo = session.getAttribute("member");
		
		if(loginInfo == null) {
			model.addAttribute("msg", "login_error");
		}
	}
	
	//게시글 작성 post
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String postWrite(BoardDTO dto) throws Exception {
		service.write(dto);
		
		return "redirect:/board/list";
	}
	
	//게시글 조회
	@RequestMapping(value="/view", method = RequestMethod.GET)
	public void getView(@RequestParam("board_bno") int board_bno, Model model) throws Exception {
		BoardDTO dto = service.view(board_bno);
		
		model.addAttribute("view", dto);
		
		//댓글 조회
		List<ReplyDTO> reply = null;
		reply = replyService.list(board_bno);
		model.addAttribute("reply", reply);
	}
	
	//게시글 수정
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public void getModify(@RequestParam("board_bno") int board_bno, Model model) throws Exception {
		BoardDTO dto = service.view(board_bno);
		
		model.addAttribute("view", dto);
	}
	
	//게시글 수정
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String postModify(BoardDTO dto) throws Exception {
		service.modify(dto);

		return "redirect:/board/view?board_bno=" + dto.getBoard_bno();
	}
	
	//게시글 삭제
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("board_bno") int board_bno) throws Exception {
		service.delete(board_bno);
		
		return "redirect:/board/list";
	}
	
	//게시글 목록 + 페이징 추가
	@RequestMapping(value="/listPage", method = RequestMethod.GET)
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
	
	//게시글 목록 + 페이징 추가 + 검색
		@RequestMapping(value="/listPageSearch", method = RequestMethod.GET)
		public void getListPageSearch(Model model, @RequestParam("num") int num,
					@RequestParam(value = "searchType", required = false, defaultValue = "title") String searchType, 
					@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword
					) throws Exception {
			
			Page page = new Page();
			
			page.setNum(num);
			page.setCount(service.searchCount(searchType, keyword));
			
			//검색 타입과 검색어
			page.setSearchType(searchType);
			page.setKeyword(keyword);
			
			List<BoardDTO> list = null;
			list = service.listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
			
			model.addAttribute("list", list);
			model.addAttribute("page", page);
			model.addAttribute("select", num);
		}
}
