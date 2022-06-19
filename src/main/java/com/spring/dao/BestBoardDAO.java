package com.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;

@Repository
public interface BestBoardDAO {
	
	// 리뷰 베스트 목록
	public List<BoardDTO> review_bestList() throws Exception;
		
	// 패키지 설계 베스트 목록
	public List<BoardDTO> board_want_bestList() throws Exception;
	
	// 패키지 판매 베스트 목록
	public List<BoardDTO> sell_bestList() throws Exception;
	
}
