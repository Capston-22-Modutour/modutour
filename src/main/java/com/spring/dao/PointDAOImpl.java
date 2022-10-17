package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.PointDTO;

@Repository
public class PointDAOImpl implements PointDAO {
	
	@Inject
	private SqlSession sql;

	private static String namespace = "com.spring.mappers.pointMapper";

	// 보유 포인트 확인
	@Override
	public List<PointDTO> point_list(int user_num) throws Exception {
		return sql.selectList(namespace + ".checkMyPoint", user_num);
	}

	// 포인트 적립
	@Override
	public int point_input(PointDTO pointDTO) throws Exception {
		return sql.insert(namespace + ".insertPoint", pointDTO);
	}
	
	// 회원 보유 포인트 업데이트
	@Override
	public int point_update(int user_num) throws Exception {
		return sql.update(namespace + ".updatePoint", user_num);
	}

	// 포인트 사용
	@Override
	public int point_output(PointDTO pointDTO) throws Exception {
		return sql.update(namespace + ".usePoint");
	}

}
