package com.spring.dao;

import java.util.List;

import com.spring.dto.ReplyDTO;

public interface ReplyDAO {
	
	//댓글 조회
	public List<ReplyDTO> list(int board_bno) throws Exception;

	// 댓글 조회
	public void write(ReplyDTO dto) throws Exception;

	// 댓글 수정
	public void modify(ReplyDTO dto) throws Exception;

	// 댓글 삭제
	public void delete(ReplyDTO dto) throws Exception;
	
	// -------------
	// 패키지 설계 댓글 조회
	public List<ReplyDTO> want_list(int board_want_bno) throws Exception;

	// 패키지 설계 댓글 조회
	public void want_write(ReplyDTO dto) throws Exception;

	// 패키지 설계 댓글 수정
	public void want_modify(ReplyDTO dto) throws Exception;

	// 패키지 설계 댓글 삭제
	public void want_delete(ReplyDTO dto) throws Exception;
}
