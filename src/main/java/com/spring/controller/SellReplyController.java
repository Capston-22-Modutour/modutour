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
@RequestMapping("/sell_reply/*")
public class SellReplyController {

	@Inject
	private ReplyService replyService;
	// 자유 게시판 댓글 start
	// 댓글 조회

	// 댓글 작성
	@RequestMapping(value = "/sell_write", method = RequestMethod.POST)
	public String postWirte(ReplyDTO dto) throws Exception {

		replyService.sell_write(dto);

		return "redirect:/sell_board/sell_view?sell_bno=" + dto.getSell_bno();
	}
	
	// 댓글 수정 get
	@RequestMapping(value = "/sell_modify", method = RequestMethod.GET)
	public void getReplyModify(@RequestParam("sell_rno") int sell_rno, Model model) throws Exception {
		ReplyDTO dto = replyService.sell_view(sell_rno);

		model.addAttribute("view", dto);
	}
	
	// 댓글 수정 post
	@RequestMapping(value = "/sell_modify", method = RequestMethod.POST)
	public String postReplyUpdate(ReplyDTO dto) throws Exception {
		
		replyService.sell_modify(dto);
		
		return "redirect:/sell_board/sell_view?sell_bno=" + dto.getSell_bno();
	}
	
	// 댓글 삭제
	@RequestMapping(value = "/sell_delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("sell_rno") int sell_rno) throws Exception {
		
		replyService.sell_delete(sell_rno);

		return "redirect:/sell_board/sell_listPageSearch?num=1";
	}
}
