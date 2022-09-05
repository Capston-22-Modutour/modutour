package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.TestDTO;

@Repository
public class TestDAOImpl implements TestDAO {

	@Inject
	private SqlSession sql;

	private static String namespace = "com.spring.mappers.testMapper";
	
	// ----------------------------------------
	// 여행사 작성 tab 목록
	@Override
	public List<TestDTO> Testlist() throws Exception {
		return sql.selectList(namespace + ".Testlist");
	}
	
	// 여행사 tab 작성
	@Override
	public void Testwrite(TestDTO dto) throws Exception {
		sql.insert(namespace + ".Testwrite", dto);
	}


}
