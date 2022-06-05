package com.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.BoardDAO;
import com.spring.dto.BoardDTO;
import com.spring.dto.LikeDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	// 여행후기 베스트 목록
	@Override
	public List<BoardDTO> review_bestList() throws Exception {
		return dao.review_bestList();
	}
	
	// 패키지 설계 베스트 목록
	@Override
	public List<BoardDTO> board_want_bestList() throws Exception {
		return dao.board_want_bestList();
	}
	
	// 패키지 판매 베스트 목록
	@Override
	public List<BoardDTO> sell_bestList() throws Exception {
		return dao.sell_bestList();
	}

	// ----------------------------------------
	//마이페이지 내가 쓴 커뮤니티 목록
	@Override
	public List<BoardDTO> my_list(String user_name) throws Exception {
		return dao.my_list(user_name);
	}
	
	//마이페이지 내가 쓴 패키지 설계 목록
	@Override
	public List<BoardDTO> my_package_list(String user_name) throws Exception {
		return dao.my_package_list(user_name);
	}
	
	// 내 구매 목록
	@Override
	public List<BoardDTO> my_pucharseList(Integer user_num) throws Exception {
		return dao.my_pucharseList(user_num);
	}
	
	// ----------------------------------------
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

	// 게시물 조회, 조회수 증가
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardDTO view(int board_bno) throws Exception {
		dao.updateViewCnt(board_bno);
		return dao.view(board_bno);
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

	// -------------------------------------
	// 게시물 목록
	@Override
	public List<BoardDTO> want_list() throws Exception {
		return dao.want_list();
	}

	// 게시물 작성
	@Override
	public void want_write(BoardDTO dto) throws Exception {
		dao.want_write(dto);
	}

	// 게시물 조회, 조회수 증가
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardDTO want_view(int board_want_bno) throws Exception {
		dao.want_updateViewCnt(board_want_bno);
		return dao.want_view(board_want_bno);
	}

	// 게시글 수정
	@Override
	public void want_modify(BoardDTO dto) throws Exception {
		dao.want_modify(dto);
	}

	// 게시글 삭제
	@Override
	public void want_delete(int board_want_bno) throws Exception {
		dao.want_delete(board_want_bno);
	}

	// 게시글 총 갯수
	@Override
	public int want_count() throws Exception {
		return dao.want_count();
	}

	// 게시물 목록 + 페이징 + 검색
	@Override
	public List<BoardDTO> want_listPageSearch(int displayPost, int postNum, String searchType, String keyword)
			throws Exception {
		return dao.want_listPageSearch(displayPost, postNum, searchType, keyword);
	}

	// 게시물 총 갯수
	@Override
	public int want_searchCount(String searchType, String keyword) throws Exception {
		return dao.want_searchCount(searchType, keyword);
	}

	// 패키지 설계 게시글 추천관련 메소드 구현
	@Override
	public void want_updateLike(int board_want_bno) throws Exception {
		dao.want_updateLike(board_want_bno);
	}

	@Override
	public void want_updateLikeCancel(int board_want_bno) throws Exception {
		dao.want_updateLikeCancel(board_want_bno);
	}

	@Override
	public void want_insertLike(int board_want_bno, int user_num) throws Exception {
		dao.want_insertLike(board_want_bno, user_num);
	}

	@Override
	public void want_deleteLike(int board_want_bno, int user_num) throws Exception {
		dao.want_deleteLike(board_want_bno, user_num);
	}

	@Override
	public int want_likeCheck(int board_want_bno, int user_num) throws Exception {
		return dao.want_likeCheck(board_want_bno, user_num);
	}

	@Override
	public void want_updateLikeCheck(int board_want_bno, int user_num) throws Exception {
		dao.want_updateLikeCheck(board_want_bno, user_num);
	}

	@Override
	public void want_updateLikeCheckCancel(int board_want_bno, int user_num) throws Exception {
		dao.want_updateLikeCheckCancel(board_want_bno, user_num);
	}

	// -------------------------------------
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

	// 게시물 조회, 조회수 증가
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardDTO review_view(int review_bno) throws Exception {
		dao.review_updateViewCnt(review_bno);
		return dao.review_view(review_bno);
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
	
	// ------------------------------------
	// 패지키 판매 게시물 목록
	@Override
	public List<BoardDTO> sell_list() throws Exception {
		return dao.sell_list();
	}

	// 패키지 판매 게시물 작성
	@Override
	public void sell_write(BoardDTO dto) throws Exception {
		dao.sell_write(dto);
	}

	// 패키지 판매 게시물 조회
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardDTO sell_view(int sell_bno) throws Exception {
		dao.sell_updateViewCnt(sell_bno);
		return dao.sell_view(sell_bno);
	}

	// 패키지 판매 게시물 조회수 증가
	@Override
	public void sell_updateViewCnt(int sell_bno) throws Exception {
		dao.sell_updateViewCnt(sell_bno);
	}

	// 패키지 판매 게시글 수정
	@Override
	public void sell_modify(BoardDTO dto) throws Exception {
		dao.sell_modify(dto);
	}

	// 패키지 판매 게시글 삭제
	@Override
	public void sell_delete(int sell_bno) throws Exception {
		dao.sell_delete(sell_bno);
	}

	// 패키지 판매 게시글 총 갯수
	@Override
	public int sell_count() throws Exception {
		return dao.sell_count();
	}

	// 패키지 판매 게시물 목록 + 페이징 + 검색
	@Override
	public List<BoardDTO> sell_listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception {
		return dao.sell_listPageSearch(displayPost, postNum, searchType, keyword);
	}

	// 패키지 판매 게시물 총 갯수 + 검색 적용
	@Override
	public int sell_searchCount(String searchType, String keyword) throws Exception {
		return dao.sell_searchCount(searchType, keyword);
	}
	
	// 게시글 추천관련 메소드 구현
	@Override
	public void sell_updateLike(int sell_bno) throws Exception {
		dao.sell_updateLike(sell_bno);
	}

	@Override
	public void sell_updateLikeCancel(int sell_bno) throws Exception {
		dao.sell_updateLikeCancel(sell_bno);
	}

	@Override
	public void sell_insertLike(int sell_bno, int user_num) throws Exception {
		dao.sell_insertLike(sell_bno, user_num);
	}

	@Override
	public void sell_deleteLike(int sell_bno, int user_num) throws Exception {
		dao.sell_deleteLike(sell_bno, user_num);
	}

	@Override
	public int sell_likeCheck(int sell_bno, int user_num) throws Exception {
		return dao.sell_likeCheck(sell_bno, user_num);
	}

	@Override
	public void sell_updateLikeCheck(int sell_bno, int user_num) throws Exception {
		dao.sell_updateLikeCheck(sell_bno, user_num);
	}

	@Override
	public void sell_updateLikeCheckCancel(int sell_bno, int user_num) throws Exception {
		dao.sell_updateLikeCheckCancel(sell_bno, user_num);
	}
	
	// ------------------------------------
	// 일반 회원 가입
	@Override
	public void purchase(BoardDTO dto) throws Exception {
		dao.purchase(dto);
	}
}
