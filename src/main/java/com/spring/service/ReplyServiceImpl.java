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
	
	// 댓글 목록
	@Override
	public List<ReplyDTO> review_list(int review_bno) throws Exception {
		return dao.review_list(review_bno);
	}

	// 댓글 조회
	@Override
	public ReplyDTO review_view(int review_rno) throws Exception {
		return dao.review_view(review_rno);
	}

	// 댓글 작성
	@Override
	public void review_write(ReplyDTO dto) throws Exception {
		dao.review_write(dto);
	}

	// 댓글 수정
	@Override
	public void review_modify(ReplyDTO dto) throws Exception {
		dao.review_modify(dto);
	}

	// 댓글 삭제
	@Override
	public void review_delete(int review_rno) throws Exception {
		dao.review_delete(review_rno);
	}

	// -------------
	// 댓글 목록
	@Override
	public List<ReplyDTO> list(int board_bno) throws Exception {
		return dao.list(board_bno);
	}

	// 댓글 조회
	@Override
	public ReplyDTO view(int reply_rno) throws Exception {
		return dao.view(reply_rno);
	}

	// 댓글 작성
	@Override
	public void write(ReplyDTO dto) throws Exception {
		dao.write(dto);
	}

	// 댓글 수정
	@Override
	public void modify(ReplyDTO dto) throws Exception {
		dao.modify(dto);
	}

	// 댓글 삭제
	@Override
	public void delete(int reply_rno) throws Exception {
		dao.delete(reply_rno);
	}

	// -------------
	// 패키지 요청 댓글 목록
	@Override
	public List<ReplyDTO> want_list(int board_want_bno) throws Exception {
		return dao.want_list(board_want_bno);
	}
	
	// 댓글 조회
	@Override
	public ReplyDTO want_view(int board_reply_rno) throws Exception {
		return dao.want_view(board_reply_rno);
	}

	// 패키지 댓글 작성
	@Override
	public void want_write(ReplyDTO dto) throws Exception {
		dao.want_write(dto);
	}

	// 패키지 댓글 수정
	@Override
	public void want_modify(ReplyDTO dto) throws Exception {
		dao.want_modify(dto);
	}

	// 패키지 댓글 삭제
	@Override
	public void want_delete(int board_reply_rno) throws Exception {
		dao.want_delete(board_reply_rno);
	}
	
	// -------------
	// 패키지 제안 댓글 목록
	@Override
	public List<ReplyDTO> suggest_list(int suggest_bno) throws Exception {
		return dao.suggest_list(suggest_bno);
	}
		
	// 댓글 조회
	@Override
	public ReplyDTO suggest_view(int suggest_rno) throws Exception {
		return dao.suggest_view(suggest_rno);
	}

	// 패키지 댓글 작성
	@Override
	public void suggest_write(ReplyDTO dto) throws Exception {
		dao.suggest_write(dto);
	}

	// 패키지 댓글 수정
	@Override
	public void suggest_modify(ReplyDTO dto) throws Exception {
		dao.suggest_modify(dto);
	}

	// 패키지 댓글 삭제
	@Override
	public void suggest_delete(int suggest_rno) throws Exception {
		dao.suggest_delete(suggest_rno);
	}

	// ------------
	// 패키지 판매 댓글 목록
	@Override
	public List<ReplyDTO> sell_list(int sell_bno) throws Exception {
		return dao.sell_list(sell_bno);
	}
		
	// 댓글 조회
	@Override
	public ReplyDTO sell_view(int sell_rno) throws Exception {
		return dao.sell_view(sell_rno);
	}

	// 패키지 댓글 작성
	@Override
	public void sell_write(ReplyDTO dto) throws Exception {
		dao.sell_write(dto);
	}

	// 패키지 댓글 수정
	@Override
	public void sell_modify(ReplyDTO dto) throws Exception {
		dao.sell_modify(dto);
	}

	// 패키지 댓글 삭제
	@Override
	public void sell_delete(int sell_rno) throws Exception {
		dao.sell_delete(sell_rno);
	}
}
