package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.TabDAO;
import com.spring.dto.TabDTO;

@Service
public class TabServiceImpl implements TabService {

	@Inject
	private TabDAO dao;
	
	// ----------------------------------------
	// suugest_bno 조회
	@Override
	public int TabInquireSuggestBno() throws Exception {
		return dao.TabInquireSuggestBno();
	}
	
	// 여행사 tab 작성 목록
	@Override
	public List<TabDTO> Tablist(int suggest_bno) throws Exception {
		return dao.Tablist(suggest_bno);
	}
		
	// 여행사 tab 작성
	@Override
	public void Tabwrite(TabDTO dto) throws Exception {
		dao.Tabwrite(dto);
	}

}
