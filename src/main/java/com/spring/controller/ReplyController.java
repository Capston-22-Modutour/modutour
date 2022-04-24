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
	
	//댓글 조회
	
	
	//댓글 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWirte(ReplyDTO dto) throws Exception {
	    
		replyService.write(dto);
	    
	    return "redirect:/board/view?board_bno=" + dto.getBoard_bno();
	}
	
	//댓글 수정
	
	
	//댓글 삭제
}
