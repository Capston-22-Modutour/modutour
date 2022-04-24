package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.dao.ReplyDAO;
import com.spring.dto.ReplyDTO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyDAO dao;

	//댓글 조회
	@Override
	public List<ReplyDTO> list(int board_bno) throws Exception {
	    return dao.list(board_bno);
	}
	
	//댓글 작성
	@Override
	public void write(ReplyDTO dto) throws Exception {
	    dao.write(dto);
	}
	
	//댓글 수정
	@Override
	public void modify(ReplyDTO dto) throws Exception {
	    dao.modify(dto);
	}

	//댓글 삭제
	@Override
	public void delete(ReplyDTO dto) throws Exception {
	    dao.delete(dto);
	}	
}
