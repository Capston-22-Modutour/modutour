package com.spring.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.BoardDTO;
import com.spring.dto.PointDTO;
import com.spring.service.BoardService;
import com.spring.service.MyBoardListService;
import com.spring.service.PointService;

@Controller
public class MyPageController {
	
	@Inject
	BoardService pageService;
	
	@Inject
	MyBoardListService service;
	
	@Inject
	PointService pointService;

	// 마이페이지
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String myPage(Locale locale, Model model) {

		return "/mypage/myPage";
	}
	
	// 내가 쓴 커뮤니티 게시글
	@RequestMapping(value = "/my_freepost", method = RequestMethod.GET)
	public String myFreePost(HttpServletRequest request, Model model) throws Exception {
		
		List<BoardDTO> list = null;
		
		HttpSession session = request.getSession();
		session.getAttribute("member");
		
		String user_name = (String)session.getAttribute("user_name");
		
		list = service.my_list(user_name);

		model.addAttribute("list", list);
		
		return "/mypage/my_freepost";
	}
	
	// 내가 쓴 여행후기
	@RequestMapping(value = "/my_reviewpost", method = RequestMethod.GET)
	public String myReviewPost(HttpServletRequest request , Model model) throws Exception {
		
		List<BoardDTO> list = null;
		
		HttpSession session = request.getSession();
		session.getAttribute("member");
		
		int user_num = (Integer)session.getAttribute("user_num");
		
		list = service.my_review_list(user_num);
		model.addAttribute("list", list);
			
		return "/mypage/my_reviewpost";
	}
	
	// 내가 쓴 패키지 설계
	@RequestMapping(value = "/my_packageplan", method = RequestMethod.GET)
	public String myPackagePlan(HttpServletRequest request , Model model) throws Exception {
		
		List<BoardDTO> list = null;
		
		HttpSession session = request.getSession();
		session.getAttribute("member");
		
		String user_name = (String)session.getAttribute("user_name");
		
		list = service.my_package_list(user_name);

		model.addAttribute("list", list);
		
		return "/mypage/my_packageplan";
	}

	// 내가 쓴 자유게시글
	@RequestMapping(value = "/my_post", method = RequestMethod.GET)
	public String myPost(Locale locale, Model model) {

		return "/mypage/my_post";
	}
	
	// 내 구매목록
	@RequestMapping(value = "/my_purchase", method = RequestMethod.GET)
	public String myPurchase(HttpServletRequest request, Model model) throws Exception {
		
		// 구매 내역
		List<BoardDTO> list = null;
		
		HttpSession session = request.getSession();
		session.getAttribute("member");
			
		Integer user_num = (Integer)session.getAttribute("user_num");
		
		list = service.my_pucharseList(user_num);

		model.addAttribute("list", list);
		
		return "/mypage/my_purchase";
	}
	
	// 내 포인트목록
	@RequestMapping(value = "/my_point", method = RequestMethod.GET)
	public String myPoint(HttpServletRequest request, Model model) throws Exception {
		
		HttpSession session = request.getSession();
		session.getAttribute("member");
				
		Integer user_num = (Integer)session.getAttribute("user_num");
		
		// 구매 내역
		List<PointDTO> list = null;
		List<PointDTO> useList = null;
			
		list = pointService.pointList(user_num);
		useList = pointService.pointUseList(user_num);

		model.addAttribute("list", list);
		model.addAttribute("useList", useList);
		
		return "/mypage/my_point";
	}
	
}
