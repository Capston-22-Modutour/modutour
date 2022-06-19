package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;

@Repository
public class OrderCompanyDAOImpl implements OrderCompanyDAO {

	@Inject
	private SqlSession sql;

	private static String namespace = "com.spring.mappers.boardMapper";
	
	// 고객 구매 확인
	@Override
	public List<BoardDTO> purchaseCheckCompany(String com_name) throws Exception {
		return sql.selectList(namespace + ".purchaseCheckCompany", com_name);
	}

	//패키지 제안 입찰 목록 확인
	@Override
	public List<BoardDTO> SuggestCheckCompany(int com_regiNum) throws Exception {
		return sql.selectList(namespace + ".SuggestCheckCompany", com_regiNum);
	}
	
	//패키지 판매 입찰 목록 확인
	@Override
	public List<BoardDTO> SellCheckCompany(int com_regiNum) throws Exception {
		return sql.selectList(namespace + ".SellCheckCompany", com_regiNum);
	}
		
}
