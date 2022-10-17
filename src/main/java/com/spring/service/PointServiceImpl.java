package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.PointDAO;
import com.spring.dto.PointDTO;

@Service
public class PointServiceImpl implements PointService {

	@Inject
	private PointDAO dao;
	
	// 보유 포인트 확인
	@Override
	public List<PointDTO> point_list(int user_num) throws Exception {
		return dao.point_list(user_num);
	}

	// 포인트 적립
	@Override
	public int point_input(PointDTO pointDTO) throws Exception {
		return dao.point_input(pointDTO);
	}

	// 회원 보유 포인트 업데이트
	@Override
	public int point_update(int user_num) throws Exception {
		return dao.point_update(user_num);
	}
	
	// 포인트 사용
	
}
