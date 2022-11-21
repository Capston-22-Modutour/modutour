package com.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;

@Repository
public interface WantBoardDAO {
	
	// 패키지 설계 게시물 번호 확인
	public int want_checkBoardBno() throws Exception;
	
	// 패키지 설계 게시물 목록
	public List<BoardDTO> want_list() throws Exception;

	// 패키지 설계 게시물 작성
	public void want_write(BoardDTO dto) throws Exception;
	// 설계 게시물 이미지
	public void want_writeImage(BoardDTO dto) throws Exception;

	// 패키지 설계 게시물 조회
	public BoardDTO want_view(int board_want_bno) throws Exception;
	
	// 설계 게시글 조회수 증가
	public void want_updateViewCnt(int board_want_bno) throws Exception;
	// 게시물 이미지 조회 
	public List<BoardDTO> want_viewImage(int board_want_bno) throws Exception;

	// 게시글 수정
	public void want_modify(BoardDTO dto) throws Exception;

	// 게시글 삭제
	public void want_delete(int board_want_bno) throws Exception;

	// 게시글 총 갯수
	public int want_count() throws Exception;

	// 패키지 설계 게시물 목록 + 페이징 + 검색
	public List<BoardDTO> want_listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception;
	
	// 자유 게시물 총 갯수 + 검색 적용
	public int want_searchCount(String searchType, String keyword) throws Exception;

	// 게시글 추천관련
	public void want_updateLike(int board_want_bno) throws Exception;

	void want_updateLikeCancel(int board_want_bno) throws Exception;

	void want_insertLike(int board_want_bno, int user_num) throws Exception;

	void want_deleteLike(int board_want_bno, int user_num) throws Exception;

	int want_likeCheck(int board_want_bno, int user_num) throws Exception;

	void want_updateLikeCheck(int board_want_bno, int user_num) throws Exception;

	void want_updateLikeCheckCancel(int board_want_bno, int user_num) throws Exception;
	
}
