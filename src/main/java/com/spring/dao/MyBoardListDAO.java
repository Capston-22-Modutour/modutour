package com.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;

@Repository
public interface MyBoardListDAO {
	
	// ----------------------------------------
	// 내가 쓴 커뮤니티 목록
	public List<BoardDTO> my_list(String user_name) throws Exception;
	
	// 내가 쓴 여행후기 목록
	public List<BoardDTO> my_review_list(int user_num) throws Exception;
	
	// 내가 쓴 패키지 설계 목록
	public List<BoardDTO> my_package_list(String user_name) throws Exception;
	
	// 내 구매목록
	public List<BoardDTO> my_pucharseList(Integer user_num) throws Exception;
	
}
