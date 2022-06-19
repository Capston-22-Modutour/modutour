package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.SellBoardDAO;
import com.spring.dto.BoardDTO;

@Service
public class SellBoardServiceImpl implements SellBoardService {

	@Inject
	private SellBoardDAO dao;
	
	// ------------------------------------
	// 패지키 판매 게시물 목록
	@Override
	public List<BoardDTO> sell_list() throws Exception {
		return dao.sell_list();
	}

	// 패키지 판매 게시물 작성
	@Override
	public void sell_write(BoardDTO dto) throws Exception {
		dao.sell_write(dto);
	}

	// 패키지 판매 게시물 조회
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardDTO sell_view(int sell_bno) throws Exception {
		dao.sell_updateViewCnt(sell_bno);
		return dao.sell_view(sell_bno);
	}

	// 패키지 판매 게시물 조회수 증가
	@Override
	public void sell_updateViewCnt(int sell_bno) throws Exception {
		dao.sell_updateViewCnt(sell_bno);
	}

	// 패키지 판매 게시글 수정
	@Override
	public void sell_modify(BoardDTO dto) throws Exception {
		dao.sell_modify(dto);
	}

	// 패키지 판매 게시글 삭제
	@Override
	public void sell_delete(int sell_bno) throws Exception {
		dao.sell_delete(sell_bno);
	}

	// 패키지 판매 게시글 총 갯수
	@Override
	public int sell_count() throws Exception {
		return dao.sell_count();
	}

	// 패키지 판매 게시물 목록 + 페이징 + 검색
	@Override
	public List<BoardDTO> sell_listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception {
		return dao.sell_listPageSearch(displayPost, postNum, searchType, keyword);
	}

	// 패키지 판매 게시물 총 갯수 + 검색 적용
	@Override
	public int sell_searchCount(String searchType, String keyword) throws Exception {
		return dao.sell_searchCount(searchType, keyword);
	}
	
	// 게시글 추천관련 메소드 구현
	@Override
	public void sell_updateLike(int sell_bno) throws Exception {
		dao.sell_updateLike(sell_bno);
	}

	@Override
	public void sell_updateLikeCancel(int sell_bno) throws Exception {
		dao.sell_updateLikeCancel(sell_bno);
	}

	@Override
	public void sell_insertLike(int sell_bno, int user_num) throws Exception {
		dao.sell_insertLike(sell_bno, user_num);
	}

	@Override
	public void sell_deleteLike(int sell_bno, int user_num) throws Exception {
		dao.sell_deleteLike(sell_bno, user_num);
	}

	@Override
	public int sell_likeCheck(int sell_bno, int user_num) throws Exception {
		return dao.sell_likeCheck(sell_bno, user_num);
	}

	@Override
	public void sell_updateLikeCheck(int sell_bno, int user_num) throws Exception {
		dao.sell_updateLikeCheck(sell_bno, user_num);
	}

	@Override
	public void sell_updateLikeCheckCancel(int sell_bno, int user_num) throws Exception {
		dao.sell_updateLikeCheckCancel(sell_bno, user_num);
	}
	
}
