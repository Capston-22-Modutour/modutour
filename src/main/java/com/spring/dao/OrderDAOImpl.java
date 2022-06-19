package com.spring.dao;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Inject
	private SqlSession sql;

	private static String namespace = "com.spring.mappers.boardMapper";
	private static String like_namespace = "com.spring.mappers.likeMapper";
	
	// ------------------------------------
	// 구매
	@Override
	public void purchase(BoardDTO dto) throws Exception {
		sql.insert(namespace + ".purchase", dto);
	}
	
	// 구매 중복 확인
	@Override
	public int purchaseCheck(int sell_bno, int user_num) throws Exception {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("user_num", user_num);
		data.put("sell_bno", sell_bno);
		
		return sql.selectOne(namespace + ".purchaseCheck", data);
	}
	
	// 패키지 구매 시 패키지 인원 수 감소
	@Override
	public void updatePeople(BoardDTO dto) throws Exception {
		sql.update(namespace + ".updatePeople", dto);
	}
	
	// 패키지 낙찰 확인
	public int packageCheck(int board_want_bno) throws Exception {
		return sql.selectOne(namespace + ".packageCheck", board_want_bno);
	}
}
