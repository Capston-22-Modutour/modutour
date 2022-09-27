package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.dto.TabDTO;

@Service
public interface TabService {
	
	// ----------------------------------------
	//suugest_bno 조회
	public int TabInquireSuggestBno() throws Exception;
	
	// 여행사 작성 tab 목록 출력
	public List<TabDTO> Tablist(int suggest_bno) throws Exception;
	
	// 여행사 tab 작성
	public void Tabwrite(TabDTO dto) throws Exception;

}
