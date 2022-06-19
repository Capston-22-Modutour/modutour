package com.spring.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.OrderDAO;
import com.spring.dto.BoardDTO;

@Service
public class OrderServiceImpl implements OrderService {

	@Inject
	private OrderDAO dao;
	
	// ------------------------------------
	// 구매
	@Override
	public void purchase(BoardDTO dto) throws Exception {
		dao.purchase(dto);
	}
	
	// 구매 중복 확인
	@Override
	public int purchaseCheck(int sell_bno, int user_num) throws Exception {
		return dao.purchaseCheck(sell_bno, user_num);
	}
	
	// 패키지 구매 시 패키지 인원 수 감소
	@Override
	public void updatePeople(BoardDTO dto) throws Exception {
		dao.updatePeople(dto);
	}

	// 패키지 낙찰 확인
	@Override
	public int packageCheck(int board_want_bno) throws Exception {
		return dao.packageCheck(board_want_bno);
	}
}
