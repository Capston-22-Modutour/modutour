package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ReviewBoardDAO;
import com.spring.dto.BoardDTO;

@Service
public class ReviewBoardServiceImpl implements ReviewBoardService {

	@Inject
	private ReviewBoardDAO dao;
	
	// 커뮤니티 게시물 번호 확인
	@Override
	public int review_checkBoardBno() throws Exception {
		return dao.review_checkBoardBno();
	}
		
	// 게시물 목록
	@Override
	public List<BoardDTO> review_list() throws Exception {
		return dao.review_list();
	}

	// 게시물 작성
	@Override
	public void review_write(BoardDTO dto) throws Exception {
		dao.review_write(dto);
	}
	// 게시물 이미지 삽입
	@Override
	public void review_writeImage(BoardDTO dto) throws Exception {
		dao.review_writeImage(dto);
	}

	// 게시물 조회, 조회수 증가
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardDTO review_view(int review_bno) throws Exception {
		dao.review_updateViewCnt(review_bno);
		return dao.review_view(review_bno);
	}
	// 게시물 이미지 조회 
	@Override
	public List<BoardDTO> review_viewImage(int review_bno) throws Exception {
		return dao.review_viewImage(review_bno);
	}

	// 게시글 수정
	@Override
	public void review_modify(BoardDTO dto) throws Exception {
		dao.review_modify(dto);
	}

	// 게시글 삭제
	@Override
	public void review_delete(int review_bno) throws Exception {
		dao.review_delete(review_bno);
	}

	// 게시글 총 갯수
	@Override
	public int review_count() throws Exception {
		return dao.review_count();
	}

	// 게시물 목록 + 페이징 + 검색
	@Override
	public List<BoardDTO> review_listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception {
		return dao.review_listPageSearch(displayPost, postNum, searchType, keyword);
	}

	// 게시물 총 갯수
	@Override
	public int review_searchCount(String searchType, String keyword) throws Exception {
		return dao.review_searchCount(searchType, keyword);
	}

	// 패키지 설계 게시글 추천관련 메소드 구현
	@Override
	public void review_updateLike(int review_bno) throws Exception {
		dao.review_updateLike(review_bno);
	}

	@Override
	public void review_updateLikeCancel(int review_bno) throws Exception {
		dao.review_updateLikeCancel(review_bno);
	}

	@Override
	public void review_insertLike(int review_bno, int user_num) throws Exception {
		dao.review_insertLike(review_bno, user_num);
	}

	@Override
	public void review_deleteLike(int review_bno, int user_num) throws Exception {
		dao.review_deleteLike(review_bno, user_num);
	}

	@Override
	public int review_likeCheck(int review_bno, int user_num) throws Exception {
		return dao.review_likeCheck(review_bno, user_num);
	}

	@Override
	public void review_updateLikeCheck(int review_bno, int user_num) throws Exception {
		dao.review_updateLikeCheck(review_bno, user_num);
	}

	@Override
	public void review_updateLikeCheckCancel(int review_bno, int user_num) throws Exception {
		dao.review_updateLikeCheckCancel(review_bno, user_num);
	}
	
}
