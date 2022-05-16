package com.spring.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.BoardDTO;
import com.spring.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MyPageController {
	
	@Inject
	BoardService service;

	// 마이페이지
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String myPage(Locale locale, Model model) {

		return "myPage";
	}
	
	// 마이페이지
	@RequestMapping(value = "/myPage_com", method = RequestMethod.GET)
	public String myPageCom(Locale locale, Model model) {

		return "myPage_com";
	}
	
	// 내가 쓴 자유게시글
	@RequestMapping(value = "/my_freepost", method = RequestMethod.GET)
	public String myFreePost(Model model) throws Exception {
		List<BoardDTO> list = null;
		list = service.my_list();

		model.addAttribute("list", list);
		
		return "my_freepost";
	}
	
	// 내가 쓴 패키지 설계
	@RequestMapping(value = "/my_packageplan", method = RequestMethod.GET)
	public String myPackagePlan(Locale locale, Model model) {

		return "my_packageplan";
	}

	// 내가 쓴 자유게시글
	@RequestMapping(value = "/my_post", method = RequestMethod.GET)
	public String myPost(Locale locale, Model model) {

		return "my_post";
	}
	
	// 내 구매목록
	@RequestMapping(value = "/my_purchase", method = RequestMethod.GET)
	public String myPurchase(Locale locale, Model model) {

		return "my_purchase";
	}
}
