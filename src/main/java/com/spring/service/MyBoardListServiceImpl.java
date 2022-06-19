package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.MyBoardListDAO;
import com.spring.dto.BoardDTO;

@Service
public class MyBoardListServiceImpl implements MyBoardListService {

	@Inject
	private MyBoardListDAO dao;
	
	// ----------------------------------------
	//마이페이지 내가 쓴 커뮤니티 목록
	@Override
	public List<BoardDTO> my_list(String user_name) throws Exception {
		return dao.my_list(user_name);
	}
	
	//마이페이지 내가 쓴 패키지 설계 목록
	@Override
	public List<BoardDTO> my_package_list(String user_name) throws Exception {
		return dao.my_package_list(user_name);
	}
	
	//마이페이지 내가 쓴 여행후기 목록
	@Override
	public List<BoardDTO> my_review_list(int user_num) throws Exception {
		return dao.my_review_list(user_num);
	}
	
	// 내 구매 목록
	@Override
	public List<BoardDTO> my_pucharseList(Integer user_num) throws Exception {
		return dao.my_pucharseList(user_num);
	}
	
}
