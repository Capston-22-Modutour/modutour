package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.TabDTO;

@Repository
public class TabDAOImpl implements TabDAO {

	@Inject
	private SqlSession sql;

	private static String namespace = "com.spring.mappers.tabMapper";
	
	// ----------------------------------------
	//suugest_bno 조회
	@Override
	public int TabInquireSuggestBno() throws Exception {
		return sql.selectOne(namespace + ".TabInquireSuggestBno");
	}
	
	// 여행사 작성 tab 목록
	@Override
	public List<TabDTO> Tablist(int suggest_bno) throws Exception {
		return sql.selectList(namespace + ".Tablist", suggest_bno);
	}
	
	// 여행사 tab 작성
	@Override
	public void Tabwrite(TabDTO dto) throws Exception {
		sql.insert(namespace + ".Tabwrite", dto);
	}


}
