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
	public List<PointDTO> pointList(int user_num) throws Exception {
		return dao.pointList(user_num);
	}
	
	// 사용 포인트 확인
	@Override
	public List<PointDTO> pointUseList(int user_num) throws Exception {
		return dao.pointUseList(user_num);
	}

	// 포인트 적립
	@Override
	public int accumulatePoint(PointDTO pointDTO) throws Exception {
		return dao.accumulatePoint(pointDTO);
	}
	
	// 포인트 사용
	@Override
	public int usePoint(PointDTO pointDTO) throws Exception {
		return dao.usePoint(pointDTO);
	}
	
	// 포인트 사용 확인
	public int usePointCheck(PointDTO pointDTO) throws Exception {
		return dao.usePointCheck(pointDTO);
	}

	// 회원 보유 포인트 업데이트
	@Override
	public int pointUpdate(int user_num) throws Exception {
		return dao.pointUpdate(user_num);
	}

}
