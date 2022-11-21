package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.WantBoardDAO;
import com.spring.dto.BoardDTO;

@Service
public class WantBoardServiceImpl implements WantBoardService {

	@Inject
	private WantBoardDAO dao;
	
	public int want_checkBoardBno() throws Exception {
		return dao.want_checkBoardBno();
	}
	
	// 게시물 목록
	@Override
	public List<BoardDTO> want_list() throws Exception {
		return dao.want_list();
	}

	// 게시물 작성
	@Override
	public void want_write(BoardDTO dto) throws Exception {
		dao.want_write(dto);
	}
	// 설계 게시물 이미지
	public void want_writeImage(BoardDTO dto) throws Exception {
		dao.want_writeImage(dto);
	}

	// 게시물 조회, 조회수 증가
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardDTO want_view(int board_want_bno) throws Exception {
		dao.want_updateViewCnt(board_want_bno);
		return dao.want_view(board_want_bno);
	}
	// 게시물 이미지 조회 
	public List<BoardDTO> want_viewImage(int board_want_bno) throws Exception {
		return dao.want_viewImage(board_want_bno);
	}

	// 게시글 수정
	@Override
	public void want_modify(BoardDTO dto) throws Exception {
		dao.want_modify(dto);
	}

	// 게시글 삭제
	@Override
	public void want_delete(int board_want_bno) throws Exception {
		dao.want_delete(board_want_bno);
	}

	// 게시글 총 갯수
	@Override
	public int want_count() throws Exception {
		return dao.want_count();
	}

	// 게시물 목록 + 페이징 + 검색
	@Override
	public List<BoardDTO> want_listPageSearch(int displayPost, int postNum, String searchType, String keyword)
			throws Exception {
		return dao.want_listPageSearch(displayPost, postNum, searchType, keyword);
	}

	// 게시물 총 갯수
	@Override
	public int want_searchCount(String searchType, String keyword) throws Exception {
		return dao.want_searchCount(searchType, keyword);
	}

	// 패키지 설계 게시글 추천관련 메소드 구현
	@Override
	public void want_updateLike(int board_want_bno) throws Exception {
		dao.want_updateLike(board_want_bno);
	}

	@Override
	public void want_updateLikeCancel(int board_want_bno) throws Exception {
		dao.want_updateLikeCancel(board_want_bno);
	}

	@Override
	public void want_insertLike(int board_want_bno, int user_num) throws Exception {
		dao.want_insertLike(board_want_bno, user_num);
	}

	@Override
	public void want_deleteLike(int board_want_bno, int user_num) throws Exception {
		dao.want_deleteLike(board_want_bno, user_num);
	}

	@Override
	public int want_likeCheck(int board_want_bno, int user_num) throws Exception {
		return dao.want_likeCheck(board_want_bno, user_num);
	}

	@Override
	public void want_updateLikeCheck(int board_want_bno, int user_num) throws Exception {
		dao.want_updateLikeCheck(board_want_bno, user_num);
	}

	@Override
	public void want_updateLikeCheckCancel(int board_want_bno, int user_num) throws Exception {
		dao.want_updateLikeCheckCancel(board_want_bno, user_num);
	}

}
