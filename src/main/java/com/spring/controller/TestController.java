package com.spring.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.TabDTO;
import com.spring.service.TabService;

@Controller
public class TestController {
	
	@Inject
	TabService service;
	
	// 내가 쓴 여행후기
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String myReviewPost(HttpServletRequest request , Model model) throws Exception {
		
		List<TabDTO> list = null;
		
		HttpSession session = request.getSession();
		session.getAttribute("member");
		System.out.println("===============시작================");
		
		//int suggest_bno = (Integer)session.getAttribute("suggest_bno");
		int suggest_bno = 3;
		list = service.Tablist(suggest_bno);
		
		System.out.println("번호 : " + suggest_bno);
		
		list = service.Tablist(suggest_bno);
		model.addAttribute("list", list);
		
		return "/test";
	}
	
}
