package com.spring.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	// 댓글 수정

	// 댓글 삭제
	// 자유 게시판 댓글 end

	// 패키지 설계 게시판 댓글 start
	// 댓글 작성
	@RequestMapping(value = "/want_write", method = RequestMethod.POST)
	public String postWantWirte(ReplyDTO dto) throws Exception {

		replyService.want_write(dto);

		return "redirect:/want_board/want_view?board_want_bno=" + dto.getBoard_want_bno();
	}
}
