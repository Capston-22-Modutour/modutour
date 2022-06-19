package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.dto.BoardDTO;

@Service
public interface ReviewBoardService {
	
	// ----------------------------------------
	// 리뷰 게시물 목록
	public List<BoardDTO> review_list() throws Exception;

	// 리뷰 게시물 작성
	public void review_write(BoardDTO dto) throws Exception;

	// 리뷰 게시물 조회, 조회수 증가
	public BoardDTO review_view(int review_bno) throws Exception;

	// 리뷰 게시글 수정
	public void review_modify(BoardDTO dto) throws Exception;

	// 리뷰 게시글 삭제
	public void review_delete(int review_bno) throws Exception;

	// 리뷰 게시글 총 갯수
	public int review_count() throws Exception;

	// 리뷰 게시물 목록 + 페이징 + 검색
	public List<BoardDTO> review_listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception;

	// 리뷰 게시물 총 갯수 + 검색 적용
	public int review_searchCount(String searchType, String keyword) throws Exception;

	// 게시글 추천관련
	public void review_updateLike(int review_bno) throws Exception;

	void review_updateLikeCancel(int review_bno) throws Exception;

	void review_insertLike(int review_bno, int user_num) throws Exception;

	void review_deleteLike(int review_bno, int user_num) throws Exception;

	int review_likeCheck(int review_bno, int user_num) throws Exception;

	void review_updateLikeCheck(int review_bno, int user_num) throws Exception;

	void review_updateLikeCheckCancel(int review_bno, int user_num) throws Exception;

}
