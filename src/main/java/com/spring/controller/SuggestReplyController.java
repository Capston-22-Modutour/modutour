package com.spring.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.ReplyDTO;
import com.spring.service.ReplyService;

@Controller
@RequestMapping("/suggest_reply/*")
public class SuggestReplyController {

	@Inject
	private ReplyService replyService;
	// 자유 게시판 댓글 start
	// 댓글 조회

	// 댓글 작성
	@RequestMapping(value = "/suggest_write", method = RequestMethod.POST)
	public String postWirte(ReplyDTO dto) throws Exception {

		replyService.suggest_write(dto);

		return "redirect:/suggest_board/suggest_view?suggest_bno=" + dto.getSuggest_bno();
	}
	
	// 댓글 수정 get
	@RequestMapping(value = "/suggest_modify", method = RequestMethod.GET)
	public void getReplyModify(@RequestParam("suggest_rno") int suggest_rno, Model model) throws Exception {
		ReplyDTO dto = replyService.suggest_view(suggest_rno);

		model.addAttribute("view", dto);
	}
	
	// 댓글 수정 post
	@RequestMapping(value = "/suggest_modify", method = RequestMethod.POST)
	public String postReplyUpdate(ReplyDTO dto) throws Exception {
		
		replyService.suggest_modify(dto);
		
		return "redirect:/suggest_board/suggest_view?suggest_bno=" + dto.getSuggest_bno();
	}
	
	// 댓글 삭제
	@RequestMapping(value = "/suggest_delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("suggest_rno") int suggest_rno) throws Exception {
		
		replyService.suggest_delete(suggest_rno);

		return "redirect:/suggest_board/suggest_listPageSearch?num=1";
	}
}
