package com.spring.service;

import com.spring.dto.MemberDTO;

public interface MemberService {

	// 일반 회원 가입
	public void signUp(MemberDTO dto) throws Exception;

	// 기업 회원 가입
	public void signUp_com(MemberDTO dto) throws Exception;

	// 일반 로그인
	public MemberDTO login(MemberDTO dto) throws Exception;

	// 기업 로그인
	public MemberDTO login_com(MemberDTO dto) throws Exception;

	// 일반 회원정보 수정
	public void modify(MemberDTO dto) throws Exception;
	
	// 기업 회원정보 수정
	public void modify_com(MemberDTO dto) throws Exception;

	// 회원 탈퇴
	public void delete(MemberDTO dto) throws Exception;

	// 일반 회원 아이디 중복 체크
	public MemberDTO memberIdCheck(String user_id) throws Exception;

	// 기업 회원 아이디 중복 체크
	public MemberDTO companyIdCheck(String com_id) throws Exception;
}
