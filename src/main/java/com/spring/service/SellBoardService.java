package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.dto.BoardDTO;

@Service
public interface SellBoardService {
	
	// ----------------------------------------
	// 패키지 판매 게시물 목록
	public List<BoardDTO> sell_list() throws Exception;

	// 패키지 판매 게시물 작성
	public void sell_write(BoardDTO dto) throws Exception;

	// 패키지 판매 게시물 조회
	public BoardDTO sell_view(int sell_bno) throws Exception;

	// 패키지 판매 게시글 조회수 증가
	public void sell_updateViewCnt(int sell_bno) throws Exception;

	// 패지키 판매 게시글 수정
	public void sell_modify(BoardDTO dto) throws Exception;

	// 패지키 판매 게시글 삭제
	public void sell_delete(int suggest_bno) throws Exception;

	// 패지키 판매 게시글 총 갯수
	public int sell_count() throws Exception;

	// 패키지 판매 게시글 목록 + 페이징 + 검색
	public List<BoardDTO> sell_listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception;

	// 패지키 판매 게시글 총 갯수 + 검색 적용
	public int sell_searchCount(String searchType, String keyword) throws Exception;
	
	// 게시글 추천관련
	public void sell_updateLike(int sell_bno) throws Exception;

	void sell_updateLikeCancel(int sell_bno) throws Exception;

	void sell_insertLike(int sell_bno, int user_num) throws Exception;

	void sell_deleteLike(int sell_bno, int user_num) throws Exception;

	int sell_likeCheck(int sell_bno, int user_num) throws Exception;

	void sell_updateLikeCheck(int sell_bno, int user_num) throws Exception;

	void sell_updateLikeCheckCancel(int sell_bno, int user_num) throws Exception;
	
}
