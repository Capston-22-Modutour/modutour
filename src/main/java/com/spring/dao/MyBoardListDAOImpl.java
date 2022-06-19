package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;

@Repository
public class MyBoardListDAOImpl implements MyBoardListDAO {

	@Inject
	private SqlSession sql;

	private static String namespace = "com.spring.mappers.boardMapper";
	
	// ----------------------------------------
	// 마이페이지 내가 쓴 커뮤니티 목록
	@Override
	public List<BoardDTO> my_list(String user_name) throws Exception {
		return sql.selectList(namespace + ".my_list", user_name);
	}
	
	// 마이페이지 내가 쓴 여행후기 목록
	@Override
	public List<BoardDTO> my_review_list(int user_num) throws Exception {
		return sql.selectList(namespace + ".my_review_list", user_num);
	}

	// 마이페이지 내가 쓴 패키지 설계 목록
	@Override
	public List<BoardDTO> my_package_list(String user_name) throws Exception {
		return sql.selectList(namespace + ".my_package_list", user_name);
	}
	
	//내 구매내역
	@Override
	public List<BoardDTO> my_pucharseList(Integer user_num) throws Exception {
		return sql.selectList(namespace + ".my_pucharseList", user_num);
	}
	
}
