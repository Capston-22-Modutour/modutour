package com.spring.service;

import java.util.List;

import com.spring.dto.ReplyDTO;

public interface ReplyService {
	
	//댓글 조회
	public List<ReplyDTO> list(int board_bno) throws Exception;

	//댓글 조회
	public void write(ReplyDTO dto) throws Exception;

	//댓글 수정
	public void modify(ReplyDTO dto) throws Exception;

	//댓글 삭제
	public void delete(ReplyDTO dto) throws Exception;
}
