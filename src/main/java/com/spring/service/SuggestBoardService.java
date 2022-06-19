package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.dto.BoardDTO;

@Service
public interface SuggestBoardService {
	
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
	
	// 게시글 추천관련
	public void suggest_updateLike(int suggest_bno) throws Exception;

	void suggest_updateLikeCancel(int suggest_bno) throws Exception;

	void suggest_insertLike(int suggest_bno, int user_num) throws Exception;

	void suggest_deleteLike(int suggest_bno, int user_num) throws Exception;

	int suggest_likeCheck(int suggest_bno, int user_num) throws Exception;

	void suggest_updateLikeCheck(int suggest_bno, int user_num) throws Exception;

	void suggest_updateLikeCheckCancel(int suggest_bno, int user_num) throws Exception;
	
}
