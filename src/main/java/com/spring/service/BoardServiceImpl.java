package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.BoardDAO;
import com.spring.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	// 커뮤니티 게시물 번호 확인
	@Override
	public int checkBoardBno() throws Exception {
		return dao.checkBoardBno();
	}
		
	// 게시물 목록
	@Override
	public List<BoardDTO> list() throws Exception {
		return dao.list();
	}

	// 게시물 작성
	@Override
	public void write(BoardDTO dto) throws Exception {
		dao.write(dto);
	}
	// 게시물 이미지
	@Override
	public void writeImage(BoardDTO dto) throws Exception {
		dao.writeImage(dto);
	}

	// 게시물 조회, 조회수 증가
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardDTO view(int board_bno) throws Exception {
		dao.updateViewCnt(board_bno);
		return dao.view(board_bno);
	}
	// 게시물 이미지 조회 
	@Override
	public List<BoardDTO> viewImage(int board_bno) throws Exception {
		return dao.viewImage(board_bno);
	}

	// 게시글 수정
	@Override
	public void modify(BoardDTO dto) throws Exception {
		dao.modify(dto);
	}

	// 게시글 삭제
	@Override
	public void delete(int board_bno) throws Exception {
		dao.delete(board_bno);
	}

	// 게시글 총 갯수
	@Override
	public int count() throws Exception {
		return dao.count();
	}

	// 게시글 목록 + 페이징
	@Override
	public List<BoardDTO> listPage(int displayPost, int postNum) throws Exception {
		return dao.listPage(displayPost, postNum);
	}

	// 게시물 목록 + 페이징 + 검색
	@Override
	public List<BoardDTO> listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception {
		return dao.listPageSearch(displayPost, postNum, searchType, keyword);
	}

	// 게시물 총 갯수
	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
		return dao.searchCount(searchType, keyword);
	}

	// 게시글 추천관련 메소드 구현
	@Override
	public void updateLike(int board_bno) throws Exception {
		dao.updateLike(board_bno);
	}

	@Override
	public void updateLikeCancel(int board_bno) throws Exception {
		dao.updateLikeCancel(board_bno);
	}

	@Override
	public void insertLike(int board_bno, int user_num) throws Exception {
		dao.insertLike(board_bno, user_num);
	}

	@Override
	public void deleteLike(int board_bno, int user_num) throws Exception {
		dao.deleteLike(board_bno, user_num);
	}

	@Override
	public int likeCheck(int board_bno, int user_num) throws Exception {
		return dao.likeCheck(board_bno, user_num);
	}

	@Override
	public void updateLikeCheck(int board_bno, int user_num) throws Exception {
		dao.updateLikeCheck(board_bno, user_num);
	}

	@Override
	public void updateLikeCheckCancel(int board_bno, int user_num) throws Exception {
		dao.updateLikeCheckCancel(board_bno, user_num);
	}
}
