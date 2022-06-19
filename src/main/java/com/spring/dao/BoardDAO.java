package com.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;

@Repository
public interface BoardDAO {
	
	// ----------------------------------------
	// 자유 게시물 목록
	public List<BoardDTO> list() throws Exception;

	// 자유 게시물 작성
	public void write(BoardDTO dto) throws Exception;

	// 자유 게시물 조회
	public BoardDTO view(int board_bno) throws Exception;
	
	// 자유 게시글 조회수 증가
	public void updateViewCnt(int board_bno) throws Exception;
	
	// 자유 게시글 수정
	public void modify(BoardDTO dto) throws Exception;

	// 자유 게시글 삭제
	public void delete(int board_bno) throws Exception;

	// 자유 게시글 총 갯수
	public int count() throws Exception;

	// 자유 게시글 목록 + 페이징
	public List<BoardDTO> listPage(int displayPost, int postNum) throws Exception;

	// 자유 게시물 목록 + 페이징 + 검색
	public List<BoardDTO> listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception;

	// 자유 게시물 총 갯수 + 검색 적용
	public int searchCount(String searchType, String keyword) throws Exception;
	
	// 게시글 추천관련
	public void updateLike(int board_bno) throws Exception;
	
	public void updateLikeCancel(int board_bno) throws Exception;

	public void insertLike(int board_bno, int user_num) throws Exception;

	public void deleteLike(int board_bno, int user_num) throws Exception;

	public int likeCheck(int board_bno, int user_num) throws Exception;

	public void updateLikeCheck(int board_bno, int user_num) throws Exception;

	public void updateLikeCheckCancel(int board_bno, int user_num) throws Exception;
		
}
