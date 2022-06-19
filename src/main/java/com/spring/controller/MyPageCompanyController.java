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

import com.spring.dto.BoardDTO;
import com.spring.service.OrderCompanyService;

@Controller
public class MyPageCompanyController {
	
	@Inject
	OrderCompanyService service;

	// 마이페이지
	@RequestMapping(value = "/myPage_com", method = RequestMethod.GET)
	public String myPageCom(Locale locale, Model model) {

		return "/mypage_company/myPage_com";
	}
	
	// 주문
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String order(HttpServletRequest request, Model model) throws Exception {
		
		// 구매 내역
		List<BoardDTO> list = null;
				
		HttpSession session = request.getSession();
		session.getAttribute("company");
					
		String com_name = (String)session.getAttribute("com_name");
				
		list = service.purchaseCheckCompany(com_name);

		model.addAttribute("list", list);
		
		return "/mypage_company/order";
	}

	// 판매 입찰 목록
	@RequestMapping(value = "/sale_list", method = RequestMethod.GET)
	public String sale_list(HttpServletRequest request, Model model) throws Exception {
		
		// 구매 내역
		List<BoardDTO> list = null;
										
		HttpSession session = request.getSession();
		session.getAttribute("company");
											
		int com_regiNum = (Integer)session.getAttribute("com_regiNum");
								
		list = service.SellCheckCompany(com_regiNum);
		
		model.addAttribute("list", list);
		
		return "/mypage_company/sale_list";
	}

	// 패키지 제안 목록
	@RequestMapping(value = "/package_offer_list", method = RequestMethod.GET)
	public String package_offer_list(HttpServletRequest request, Model model) throws Exception {
		
		// 구매 내역
		List<BoardDTO> list = null;
												
		HttpSession session = request.getSession();
		session.getAttribute("company");
													
		int com_regiNum = (Integer)session.getAttribute("com_regiNum");
										
		list = service.SuggestCheckCompany(com_regiNum);
				
		model.addAttribute("list", list);
		
		return "/mypage_company/package_offer_list";
	}

}
