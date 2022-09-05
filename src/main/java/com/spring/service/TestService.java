package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.dto.TestDTO;

@Service
public interface TestService {
	
	// ----------------------------------------
	// 여행사 작성 tab 목록 출력
	public List<TestDTO> Testlist() throws Exception;
	
	// 여행사 tab 작성
	public void Testwrite(TestDTO dto) throws Exception;

}
