package com.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;

@Repository
public interface OrderCompanyDAO {
	
	// 고객 구매  확인
	public List<BoardDTO> purchaseCheckCompany(String com_name) throws Exception;
	
	// 패키지 제안 입찰 목록 확인
	public List<BoardDTO> SuggestCheckCompany(int com_regiNum) throws Exception;
		
	// 패키지 판매 입찰 목록 확인
	public List<BoardDTO> SellCheckCompany(int com_regiNum) throws Exception;
}
