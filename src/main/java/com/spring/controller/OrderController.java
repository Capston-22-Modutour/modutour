package com.spring.controller;



import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.BoardDTO;
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
		int point = Integer.parseInt(request.getParameter("point"));
		
		System.out.println("===========================");
		
		if(point == 0) {
			System.out.println("0이다");
		} else {
			System.out.println("포인트 사용했다");
		}
		
		System.out.println("게시글 번호 : " + sell_bno + " 유저번호 : " + user_num + " 패키지 가격 : " + boardDTO.getOrder_price()*boardDTO.getOrder_people() + " 사용포인트 : " + point);
		
		int peopleCnt = boardDTO.getOrder_people(); //구매 인원수
		
		PointDTO pointDTO = new PointDTO();
		pointDTO.setUser_num(user_num);
		pointDTO.setSell_bno(sell_bno);
		pointDTO.setPoint(point);
		
		int price = boardDTO.getOrder_price();
		
		if(peopleCnt >= 20) { 
			System.out.println("20명 이상 구매!!!!");
		  
			boardDTO.setOrder_price(((price * peopleCnt) - ((price * peopleCnt) / 10)) - point); //패키지*인원수 가격에 포인트를 뺀 최종 가격
			  
			System.out.println("최종 가격 : " + boardDTO.getOrder_price()); 
		} else {
			System.out.println("20명 미만 구매!!!!");
			  
			boardDTO.setOrder_price((price * peopleCnt) - point); //패키지*인원수 가격에 포인트를 뺀 최종 가격
			  
			System.out.println("최종 가격 : " + boardDTO.getOrder_price());
		}
		 
		
		int purchased = service.purchaseCheck(sell_bno, user_num);
		System.out.println("구매여부 : " + purchased);
		
		//boardDTO.setOrder_price((boardDTO.getOrder_price() * peopleCnt) - pointDTO.getPoint()); //패키지*인원수 가격에 포인트를 뺀 최종 가격
		
		//System.out.println("최종가격 : " + boardDTO.getOrder_price());
		if (purchased == 0) { // 구매 기록이 없을 시 order_data 추가
			
			service.purchase(boardDTO); //구매
			service.updatePeople(boardDTO); //판매 인원수 수정
			
			if(pointDTO.getPoint() == 0) { // 포인트 사용 X
				pointDTO.setPoint((boardDTO.getOrder_price()/20)); //포인트 적립 = 패키지 가격의 5% * 인원수
				pointService.accumulatePoint(pointDTO); //member_point 테이블에 포인트 적립 => 포인트 적립 내역 확인용
				System.out.println("포인트 적립  : " + pointDTO.getPoint());
			} else { // 포인트 사용 O
				int use_point = pointDTO.getPoint();
				
				pointDTO.setPoint(use_point); //포인트 사용
				System.out.println("포인트 사용 : " + pointDTO.getPoint());
				pointService.usePoint(pointDTO);
			}
			
			pointService.pointUpdate(user_num); //member_user 테이블 회원 포인트 업데이트 => 포인트 적립, 사용
		} else {
			System.out.println("경고 이미 구매했다");
		}
		
		return "redirect:/sell_board/sell_view?sell_bno=" + boardDTO.getSell_bno();
	}
}
