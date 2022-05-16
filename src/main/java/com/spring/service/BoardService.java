package com.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.dto.BoardDTO;
import com.spring.dto.LikeDTO;

public interface BoardService {
	// 내가 쓴 커뮤니티 목록
	public List<BoardDTO> my_list() throws Exception;
	
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

	// ----------------------------------------
	// 패키지 설계 게시물 목록
	public List<BoardDTO> want_list() throws Exception;

	// 패키지 설계 게시물 작성
	public void want_write(BoardDTO dto) throws Exception;

	// 패키지 설계 게시물 조회, 조회수 증가
	public BoardDTO want_view(int board_want_bno) throws Exception;

	// 패키지 설계 게시글 수정
	public void want_modify(BoardDTO dto) throws Exception;

	// 패키지 설계 게시글 삭제
	public void want_delete(int board_want_bno) throws Exception;

	// 패키지 설계 게시글 총 갯수
	public int want_count() throws Exception;

	// 패키지 설계 게시물 목록 + 페이징 + 검색
	public List<BoardDTO> want_listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception;

	// 패키지 설계 게시물 총 갯수 + 검색 적용
	public int want_searchCount(String searchType, String keyword) throws Exception;

	// 게시글 추천관련
	public void want_updateLike(int board_want_bno) throws Exception;

	void want_updateLikeCancel(int board_want_bno) throws Exception;

	void want_insertLike(int board_want_bno, int user_num) throws Exception;

	void want_deleteLike(int board_want_bno, int user_num) throws Exception;

	int want_likeCheck(int board_want_bno, int user_num) throws Exception;

	void want_updateLikeCheck(int board_want_bno, int user_num) throws Exception;

	void want_updateLikeCheckCancel(int board_want_bno, int user_num) throws Exception;

	// ----------------------------------------
	// 리뷰 게시물 목록
	public List<BoardDTO> review_list() throws Exception;

	// 리뷰 게시물 작성
	public void review_write(BoardDTO dto) throws Exception;

	// 리뷰  게시물 조회, 조회수 증가
	public BoardDTO review_view(int review_bno) throws Exception;

	// 리뷰  게시글 수정
	public void review_modify(BoardDTO dto) throws Exception;

	// 리뷰  게시글 삭제
	public void review_delete(int review_bno) throws Exception;

	// 리뷰  게시글 총 갯수
	public int review_count() throws Exception;

	// 리뷰  게시물 목록 + 페이징 + 검색
	public List<BoardDTO> review_listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception;

	// 리뷰  게시물 총 갯수 + 검색 적용
	public int review_searchCount(String searchType, String keyword) throws Exception;

	// 게시글 추천관련
	public void review_updateLike(int review_bno) throws Exception;

	void review_updateLikeCancel(int review_bno) throws Exception;

	void review_insertLike(int review_bno, int user_num) throws Exception;

	void review_deleteLike(int review_bno, int user_num) throws Exception;

	int review_likeCheck(int review_bno, int user_num) throws Exception;

	void review_updateLikeCheck(int review_bno, int user_num) throws Exception;

	void review_updateLikeCheckCancel(int review_bno, int user_num) throws Exception;

	// ----------------------------------------
	// 패키지 제안 게시물 목록
	public List<BoardDTO> suggest_list() throws Exception;

	// 패키지 제안 게시물 작성
	public void suggest_write(BoardDTO dto) throws Exception;

	// 패키지 제안 게시물 조회
	public BoardDTO suggest_view(int suggest_bno) throws Exception;

	// 패키지 제안 게시글 조회수 증가
	public void suggest_updateViewCnt(int suggest_bno) throws Exception;

	// 패지키 제안 게시글 수정
	public void suggest_modify(BoardDTO dto) throws Exception;

	// 패지키 제안 게시글 삭제
	public void suggest_delete(int suggest_bno) throws Exception;

	// 패지키 제안 게시글 총 갯수
	public int suggest_count() throws Exception;

	// 패키지 제안 게시글 목록 + 페이징 + 검색
	public List<BoardDTO> suggest_listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception;

	// 패지키 제안 게시글 총 갯수 + 검색 적용
	public int suggest_searchCount(String searchType, String keyword) throws Exception;
}
