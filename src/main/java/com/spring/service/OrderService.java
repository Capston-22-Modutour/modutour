package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.dto.BoardDTO;

@Service
public interface OrderService {
	
	//----------------------------------------
	// 구매
	public void purchase(BoardDTO dto) throws Exception;
	
	// 구매 중복 확인
	public int purchaseCheck(int sell_bno, int user_num) throws Exception;
	
	// 패키지 최초 인원수 확인
	public int checkPeopleCount(int suggest_bno) throws Exception;
	
	// 패키지 구매 시 패키지 인원 수 감소
	public void updatePeople(BoardDTO dto) throws Exception;
	
	// 패키지 낙찰 확인
	public int packageCheck(int board_want_bno) throws Exception;
}
