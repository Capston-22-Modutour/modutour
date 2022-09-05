package com.spring.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.BoardDTO;
import com.spring.dto.TestDTO;
import com.spring.service.BestBoardService;
import com.spring.service.TestService;

@Controller
public class HomeController {

	@Inject
	BestBoardService service;
	
	@Inject
	TestService testService;
	
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
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Locale locale, Model model) throws Exception {
		
		// Model = Controller와 View 연결해주는 역할
		List<TestDTO> list = null;
		list = testService.Testlist();
		
		model.addAttribute("list", list);
		
		return "/test";
	}
	
	@RequestMapping(value = "/test/write", method = RequestMethod.POST)
	public String postWrite(TestDTO dto) throws Exception {
		
		System.out.println(dto);

		testService.Testwrite(dto);

		return "redirect:/test";
	}
	
}
