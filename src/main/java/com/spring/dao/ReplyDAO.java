package com.spring.dao;

import java.util.List;

import com.spring.dto.ReplyDTO;

public interface ReplyDAO {
	
	//댓글 목록
	public List<ReplyDTO> review_list(int review_bno) throws Exception;
			
	// 댓글 조회
	public ReplyDTO review_view(int review_rno) throws Exception;

	//댓글 작성
	public void review_write(ReplyDTO dto) throws Exception;

	//댓글 수정
	public void review_modify(ReplyDTO dto) throws Exception;

	//댓글 삭제
	public void review_delete(int review_rno) throws Exception;
		
	//------------------------------------
	// 댓글 목록
	public List<ReplyDTO> list(int board_bno) throws Exception;

	// 댓글 작성
	public void write(ReplyDTO dto) throws Exception;

	// 댓글 조회
	public ReplyDTO view(int reply_rno) throws Exception;

	// 댓글 수정
	public void modify(ReplyDTO dto) throws Exception;

	// 댓글 삭제
	public void delete(int reply_rno) throws Exception;

	// -------------
	// 패키지 설계 댓글 목록
	public List<ReplyDTO> want_list(int board_want_bno) throws Exception;

	// 댓글 조회
	public ReplyDTO want_view(int board_reply_rno) throws Exception;

	// 패키지 설계 댓글 조회
	public void want_write(ReplyDTO dto) throws Exception;

	// 패키지 설계 댓글 수정
	public void want_modify(ReplyDTO dto) throws Exception;

	// 패키지 설계 댓글 삭제
	public void want_delete(int board_reply_rno) throws Exception;
}
