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
@RequestMapping("/review_reply/*")
public class ReviewReplyController {

	@Inject
	private ReplyService replyService;
	// 자유 게시판 댓글 start
	// 댓글 조회

	// 댓글 작성
	@RequestMapping(value = "/review_write", method = RequestMethod.POST)
	public String postWirte(ReplyDTO dto) throws Exception {

		replyService.review_write(dto);

		return "redirect:/review/review_view?review_bno=" + dto.getReview_bno();
	}
	
	// 댓글 수정 get
	@RequestMapping(value = "/review_modify", method = RequestMethod.GET)
	public void getReplyModify(@RequestParam("reivew_rno") int reivew_rno, Model model) throws Exception {
		ReplyDTO dto = replyService.review_view(reivew_rno);

		model.addAttribute("view", dto);
	}
	
	// 댓글 수정 post
	@RequestMapping(value = "/review_modify", method = RequestMethod.POST)
	public String postReplyUpdate(ReplyDTO dto) throws Exception {
		
		replyService.review_modify(dto);
		
		return "redirect:/review/review_view?review_bno=" + dto.getReview_bno();
	}
	
	// 댓글 삭제
	@RequestMapping(value = "/review_delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("review_rno") int review_rno) throws Exception {
		
		replyService.review_delete(review_rno);

		return "redirect:/review/review_listPageSearch?num=1";
	}
}
