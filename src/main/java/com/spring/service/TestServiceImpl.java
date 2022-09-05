package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.TestDAO;
import com.spring.dto.TestDTO;

@Service
public class TestServiceImpl implements TestService {

	@Inject
	private TestDAO dao;
	
	// ----------------------------------------
	// 여행사 tab 작성 목록
	@Override
	public List<TestDTO> Testlist() throws Exception {
		return dao.Testlist();
	}
		
	// 여행사 tab 작성
	@Override
	public void Testwrite(TestDTO dto) throws Exception {
		dao.Testwrite(dto);
	}

}
