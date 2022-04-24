package com.spring.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;

	// 일반 회원 가입
	@Override
	public void signUp(MemberDTO dto) throws Exception {
		dao.signUp(dto);
	}

	// 기업 회원 가입
	@Override
	public void signUp_com(MemberDTO dto) throws Exception {
		dao.signUp_com(dto);
	}

	// 일반 로그인
	@Override
	public MemberDTO login(MemberDTO dto) throws Exception {
		return dao.login(dto);
	}

	// 기업 로그인
	@Override
	public MemberDTO login_com(MemberDTO dto) throws Exception {
		return dao.login_com(dto);
	}

	// 회원정보 수정
	@Override
	public void modify(MemberDTO dto) throws Exception {
		dao.modify(dto);
	}

	// 회원 탈퇴
	@Override
	public void delete(MemberDTO dto) throws Exception {
		dao.delete(dto);
	}

	// 일반 회원 아이디 중복 체크
	@Override
	public MemberDTO memberIdCheck(String user_id) throws Exception {
		return dao.memberIdCheck(user_id);
	}

	// 기업 회원 아이디 중복 체크
	@Override
	public MemberDTO companyIdCheck(String com_id) throws Exception {
		return dao.companyIdCheck(com_id);
	}
}
