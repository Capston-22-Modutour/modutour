package com.spring.controller;

import javax.inject.Inject;
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
	public String postPurchase(BoardDTO dto) throws Exception {
		
		service.purchase(dto);

		return "redirect:/sell_board/sell_listPageSearch?num=1";
	}
}
