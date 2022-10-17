package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.dto.PointDTO;

@Service
public interface PointService {
	
	// 보유 포인트 확인
	public List<PointDTO> point_list(int user_num) throws Exception;
		
	// 포인트 적립
	public int point_input(PointDTO pointDTO) throws Exception;
	
	// 회원 보유 포인트 업데이트
	public int point_update(int user_num) throws Exception;

}
