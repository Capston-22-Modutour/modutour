package com.spring.controller;



import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.BoardDTO;
import com.spring.dto.MemberDTO;
import com.spring.dto.PointDTO;
import com.spring.service.OrderService;
import com.spring.service.PointService;


@Controller
@RequestMapping("/order/*")
public class OrderController {

	@Inject
	OrderService service;
	
	@Inject
	PointService pointService;
	
	// 구매 내역 get
	@RequestMapping(value = "/purchase", method = RequestMethod.GET)
	public void getPurchase(HttpSession session, Model model) throws Exception {
		
	}

	// 구매 내역 post
	@RequestMapping(value = "/purchase", method = RequestMethod.POST)
	public String postPurchase(HttpServletRequest request, BoardDTO boardDTO, Model model) throws Exception {
		
		HttpSession session = request.getSession();
		session.getAttribute("member");
				
		Integer user_num = (Integer)session.getAttribute("user_num");
		
		int sell_bno = Integer.parseInt(request.getParameter("sell_bno"));
		System.out.println("게시글 번호 : " + sell_bno + " 유저번호 : " + user_num);
		
		int peopleCnt = boardDTO.getOrder_people(); //구매 인원수
		
		MemberDTO memberDTO = new MemberDTO();
		PointDTO pointDTO = new PointDTO();
		pointDTO.setUser_num(user_num);
		pointDTO.setPoint((boardDTO.getOrder_price()/20) * peopleCnt); //포인트 적립 = 패키지 가격의 5% * 인원수
		
		int purchased = service.purchaseCheck(sell_bno, user_num);
		System.out.println("구매여부 : " + purchased);
		
		if (purchased == 0) { // 구매 기록이 없을 시 order_data 추가
			service.purchase(boardDTO); //구매
			service.updatePeople(boardDTO); //판매 인원수 수정
			pointService.point_input(pointDTO); //member_point 테이블에 포인트 적립 => 포인트 적립 내역 확인용
			pointService.point_update(user_num); //member_user 테이블 회원 포인트 업데이트 => 포인트 적립, 사용
		} else {
			System.out.println("경고 이미 구매했다");
		}
		
		return "redirect:/sell_board/sell_view?sell_bno=" + boardDTO.getSell_bno();
	}
}
