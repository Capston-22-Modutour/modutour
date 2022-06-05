package com.spring.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.BoardDTO;
import com.spring.service.BoardService;

@Controller
public class HomeController {

	@Inject
	BoardService service;
	
	// 메인 화면 '/' 입력 시 메인화면으로 이동
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model) throws Exception {
		
		// 여행후기 베스트 게시글 목록
		List<BoardDTO> rvlist = null;
		rvlist = service.review_bestList();
		
		// 여행후기 베스트 게시글 목록
		List<BoardDTO> wtlist = null;
		wtlist = service.board_want_bestList();
		
		// 패키지 판매 베스트 게시글 목록
		List<BoardDTO> selist = null;
		selist = service.sell_bestList();

		model.addAttribute("rvlist", rvlist);
		model.addAttribute("wtlist", wtlist);
		model.addAttribute("selist", selist);
		
		return "index";
	}
}
