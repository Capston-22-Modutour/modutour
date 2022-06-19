package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.BestBoardDAO;
import com.spring.dto.BoardDTO;

@Service
public class BestBoardServiceImpl implements BestBoardService {

	@Inject
	private BestBoardDAO dao;
	
	// 여행후기 베스트 목록
	@Override
	public List<BoardDTO> review_bestList() throws Exception {
		return dao.review_bestList();
	}
	
	// 패키지 설계 베스트 목록
	@Override
	public List<BoardDTO> board_want_bestList() throws Exception {
		return dao.board_want_bestList();
	}
	
	// 패키지 판매 베스트 목록
	@Override
	public List<BoardDTO> sell_bestList() throws Exception {
		return dao.sell_bestList();
	}

}
