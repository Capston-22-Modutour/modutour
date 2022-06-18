package com.spring.controller;



import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.BoardDTO;
import com.spring.service.BoardService;


@Controller
@RequestMapping("/order/*")
public class OrderController {

	@Inject
	BoardService service;

	// 구매 내역 get
	@RequestMapping(value = "/purchase", method = RequestMethod.GET)
	public void getPurchase(HttpSession session, Model model) throws Exception {
		
	}

	// 구매 내역 post
	@RequestMapping(value = "/purchase", method = RequestMethod.POST)
	public String postPurchase(HttpServletRequest request, BoardDTO boardDTO, Model model) throws Exception {
		
		int sell_bno = Integer.parseInt(request.getParameter("sell_bno"));
		int user_num = Integer.parseInt(request.getParameter("user_num"));
		System.out.println("게시글 번호 : " + sell_bno + " 유저번호 : " + user_num);
		
		int purchased = service.purchaseCheck(sell_bno, user_num);
		System.out.println("구매여부 : " + purchased);
		
		if (purchased == 0) { // 구매 기록이 없을 시 order_data 추가
			service.purchase(boardDTO);
		} else {
			System.out.println("경고 이미 구매했다");
		}
		
		return "redirect:/sell_board/sell_view?sell_bno=" + boardDTO.getSell_bno();
	}
}
