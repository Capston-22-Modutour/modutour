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
@RequestMapping("/want_reply/*")
public class WantReplyController {

	@Inject
	private ReplyService replyService;

	// 패키지 설계 게시판 댓글 start
	// 댓글 작성
	@RequestMapping(value = "/want_write", method = RequestMethod.POST)
	public String postWantWirte(ReplyDTO dto) throws Exception {

		replyService.want_write(dto);

		return "redirect:/want_board/want_view?board_want_bno=" + dto.getBoard_want_bno();
	}
	
	// 댓글 수정 get
	@RequestMapping(value = "/want_modify", method = RequestMethod.GET)
	public void getWantReplyModify(@RequestParam("board_reply_rno") int board_reply_rno, Model model) throws Exception {
		ReplyDTO dto = replyService.want_view(board_reply_rno);

		model.addAttribute("want_view", dto);
	}

	// 댓글 수정 post
	@RequestMapping(value = "/want_modify", method = RequestMethod.POST)
	public String postWantReplyUpdate(ReplyDTO dto) throws Exception {

		replyService.want_modify(dto);

		return "redirect:/want_board/want_view?board_want_bno=" + dto.getBoard_want_bno();
	}
	
	// 댓글 삭제
	@RequestMapping(value = "/want_delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("board_reply_rno") int board_reply_rno) throws Exception {
		
		replyService.want_delete(board_reply_rno);

		return "redirect:/want_board/want_listPageSearch?num=1";
	}
}
