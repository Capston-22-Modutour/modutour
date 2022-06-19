package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.dto.BoardDTO;

@Service
public interface BoardService {
	
	// ----------------------------------------
	// 게시물 목록
	public List<BoardDTO> list() throws Exception;

	// 게시물 작성
	public void write(BoardDTO dto) throws Exception;

	// 게시물 조회, 조회수 증가
	public BoardDTO view(int board_bno) throws Exception;

	// 게시글 수정
	public void modify(BoardDTO dto) throws Exception;

	// 게시글 삭제
	public void delete(int board_bno) throws Exception;

	// 게시글 총 갯수
	public int count() throws Exception;

	// 게시글 목록 + 페이징
	public List<BoardDTO> listPage(int displayPost, int postNum) throws Exception;

	// 게시물 목록 + 페이징 + 검색
	public List<BoardDTO> listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception;

	// 게시물 총 갯수 + 검색 적용
	public int searchCount(String searchType, String keyword) throws Exception;

	// 게시글 추천관련
	public void updateLike(int board_bno) throws Exception;

	void updateLikeCancel(int board_bno) throws Exception;

	void insertLike(int board_bno, int user_num) throws Exception;

	void deleteLike(int board_bno, int user_num) throws Exception;

	int likeCheck(int board_bno, int user_num) throws Exception;

	void updateLikeCheck(int board_bno, int user_num) throws Exception;

	void updateLikeCheckCancel(int board_bno, int user_num) throws Exception;

}
