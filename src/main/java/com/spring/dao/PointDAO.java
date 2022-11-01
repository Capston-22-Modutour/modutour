package com.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.dto.PointDTO;

@Repository
public interface PointDAO {
	
	// 보유 포인트 확인
	public List<PointDTO> pointList(int user_num) throws Exception;
	
	// 사용 포인트 확인
	public List<PointDTO> pointUseList(int user_num) throws Exception;
	
	// 포인트 적립
	public int accumulatePoint(PointDTO pointDTO) throws Exception;
	
	// 포인트 사용
	public int usePoint(PointDTO pointDTO) throws Exception;
	
	// 포인트 사용 확인
	public int usePointCheck(PointDTO pointDTO) throws Exception;
	
	// 회원 보유 포인트 업데이트
	public int pointUpdate(int user_num) throws Exception;
	
}
