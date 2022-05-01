package com.spring.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.spring.dto.MemberDTO;

@Service
public class MemberDAOImpl implements MemberDAO {

	// mybatis
	@Inject
	private SqlSession sql;

	// mapper
	private static String namespcae = "com.spring.mappers.memberMapper";

	// 일반 회원 가입
	@Override
	public void signUp(MemberDTO dto) throws Exception {
		sql.insert(namespcae + ".signUp", dto);
	}

	// 기업 회원 가입
	@Override
	public void signUp_com(MemberDTO dto) throws Exception {
		sql.insert(namespcae + ".signUp_com", dto);
	}

	// 일반 로그인
	@Override
	public MemberDTO login(MemberDTO dto) throws Exception {
		return sql.selectOne(namespcae + ".login", dto);
	}

	// 기업 로그인
	@Override
	public MemberDTO login_com(MemberDTO dto) throws Exception {
		return sql.selectOne(namespcae + ".login_com", dto);
	}

	// 일반 회원정보 수정
	@Override
	public void modify(MemberDTO dto) throws Exception {
		sql.update(namespcae + ".modify", dto);
	}

	// 기업 회원정보 수정
	@Override
	public void modify_com(MemberDTO dto) throws Exception {
		sql.update(namespcae + ".modify_com", dto);
	}

	// 일반 회원 탈퇴
	@Override
	public void delete(MemberDTO dto) throws Exception {
		sql.delete(namespcae + ".delete", dto);
	}
	
	// 기업 회원 탈퇴
	@Override
	public void delete_com(MemberDTO dto) throws Exception {
		sql.delete(namespcae + ".delete_com", dto);
	}

	// 일반 회원 아이디 중복 체크
	@Override
	public MemberDTO memberIdCheck(String user_id) throws Exception {
		return sql.selectOne(namespcae + ".memberIdCheck", user_id);
	}

	// 기업 회원 아이디 중복 체크
	@Override
	public MemberDTO companyIdCheck(String com_id) throws Exception {
		return sql.selectOne(namespcae + ".companyIdCheck", com_id);
	}
}
