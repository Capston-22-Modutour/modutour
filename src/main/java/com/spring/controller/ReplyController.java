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
@RequestMapping("/reply/*")
public class ReplyController {

	@Inject
	private ReplyService replyService;
	// 자유 게시판 댓글 start
	// 댓글 조회

	// 댓글 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWirte(ReplyDTO dto) throws Exception {

		replyService.write(dto);

		return "redirect:/board/view?board_bno=" + dto.getBoard_bno();
	}
	
	// 댓글 수정 get
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getReplyModify(@RequestParam("reply_rno") int reply_rno, Model model) throws Exception {
		ReplyDTO dto = replyService.view(reply_rno);

		model.addAttribute("view", dto);
	}
	
	// 댓글 수정 post
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postReplyUpdate(ReplyDTO dto) throws Exception {
		
		replyService.modify(dto);
		
		return "redirect:/board/view?board_bno=" + dto.getBoard_bno();
	}
	
	// 댓글 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("reply_rno") int reply_rno) throws Exception {
		
		replyService.delete(reply_rno);

		return "redirect:/board/listPageSearch?num=1";
	}
}
