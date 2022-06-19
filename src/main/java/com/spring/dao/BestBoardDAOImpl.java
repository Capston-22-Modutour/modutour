package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;

@Repository
public class BestBoardDAOImpl implements BestBoardDAO {

	@Inject
	private SqlSession sql;

	private static String namespace = "com.spring.mappers.boardMapper";
	
	// 여행후기 베스트 목록
	@Override
	public List<BoardDTO> review_bestList() throws Exception {
		return sql.selectList(namespace + ".review_bestList");
	}
	
	// 패키지 설계 베스트 목록
	@Override
	public List<BoardDTO> board_want_bestList() throws Exception {
		return sql.selectList(namespace + ".board_want_bestList");
	}
	
	// 패키지 판매 베스트 목록
	@Override
	public List<BoardDTO> sell_bestList() throws Exception {
		return sql.selectList(namespace + ".sell_bestList");
	}
		
}
