package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.OrderCompanyDAO;
import com.spring.dto.BoardDTO;

@Service
public class OrderCompanyServiceImpl implements OrderCompanyService {

	@Inject
	private OrderCompanyDAO dao;

	// 고객 구매 확인
	@Override
	public List<BoardDTO> purchaseCheckCompany(String com_name) throws Exception {
		return dao.purchaseCheckCompany(com_name);
	}

	//패키지 제안 입찰 목록 확인
	@Override
	public List<BoardDTO> SuggestCheckCompany(int com_regiNum) throws Exception {
		return dao.SuggestCheckCompany(com_regiNum);
	}
	
	//패키지 판매 입찰 목록 확인
	@Override
	public List<BoardDTO> SellCheckCompany(int com_regiNum) throws Exception {
		return dao.SellCheckCompany(com_regiNum);
	}
	
}
