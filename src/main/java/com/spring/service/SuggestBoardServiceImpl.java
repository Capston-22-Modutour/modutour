package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.SuggestBoardDAO;
import com.spring.dto.BoardDTO;

@Service
public class SuggestBoardServiceImpl implements SuggestBoardService {

	@Inject
	private SuggestBoardDAO dao;
	
	// ------------------------------------
	// 패지키 제안 게시물 목록
	@Override
	public List<BoardDTO> suggest_list() throws Exception {
		return dao.suggest_list();
	}

	// 패키지 제안 게시물 작성
	@Override
	public void suggest_write(BoardDTO dto) throws Exception {
		dao.suggest_write(dto);
	}

	// 패키지 제안 게시물 조회
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardDTO suggest_view(int suggest_bno) throws Exception {
		dao.suggest_updateViewCnt(suggest_bno);
		return dao.suggest_view(suggest_bno);
	}

	// 패키지 제안 게시물 조회수 증가
	@Override
	public void suggest_updateViewCnt(int suggest_bno) throws Exception {
		dao.suggest_updateViewCnt(suggest_bno);
	}

	// 패키지 제안 게시글 수정
	@Override
	public void suggest_modify(BoardDTO dto) throws Exception {
		dao.suggest_modify(dto);
	}

	// 패키지 제안 게시글 삭제
	@Override
	public void suggest_delete(int suggest_bno) throws Exception {
		dao.suggest_delete(suggest_bno);
	}

	// 패키지 제안 게시글 총 갯수
	@Override
	public int suggest_count() throws Exception {
		return dao.suggest_count();
	}

	// 패키지 제안 게시물 목록 + 페이징 + 검색
	@Override
	public List<BoardDTO> suggest_listPageSearch(int displayPost, int postNum, String searchType, String keyword)
			throws Exception {
		return dao.suggest_listPageSearch(displayPost, postNum, searchType, keyword);
	}

	// 패키지 제안 게시물 총 갯수 + 검색 적용
	@Override
	public int suggest_searchCount(String searchType, String keyword) throws Exception {
		return dao.suggest_searchCount(searchType, keyword);
	}
	
	// 패키지 설계 게시글 추천관련 메소드 구현
	@Override
	public void suggest_updateLike(int suggest_bno) throws Exception {
		dao.suggest_updateLike(suggest_bno);
	}

	@Override
	public void suggest_updateLikeCancel(int suggest_bno) throws Exception {
		dao.suggest_updateLikeCancel(suggest_bno);
	}

	@Override
	public void suggest_insertLike(int suggest_bno, int user_num) throws Exception {
		dao.suggest_insertLike(suggest_bno, user_num);
	}

	@Override
	public void suggest_deleteLike(int suggest_bno, int user_num) throws Exception {
		dao.suggest_deleteLike(suggest_bno, user_num);
	}
	
	@Override
	public int suggest_likeCheck(int suggest_bno, int user_num) throws Exception {
		return dao.suggest_likeCheck(suggest_bno, user_num);
	}

	@Override
	public void suggest_updateLikeCheck(int suggest_bno, int user_num) throws Exception {
		dao.suggest_updateLikeCheck(suggest_bno, user_num);
	}

	@Override
	public void suggest_updateLikeCheckCancel(int suggest_bno, int user_num) throws Exception {
		dao.suggest_updateLikeCheckCancel(suggest_bno, user_num);
	}
}