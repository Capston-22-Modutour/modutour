package com.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;

@Repository
public class WantBoardDAOImpl implements WantBoardDAO {

	@Inject
	private SqlSession sql;

	private static final String namespace = "com.spring.mappers.boardMapper";
	private static final String like_namespace = "com.spring.mappers.likeMapper";
	
	// 패키지 설계 게시물 번호 확인
	public int want_checkBoardBno() throws Exception {
		return sql.selectOne(namespace + ".want_checkBoardBno");
	}
		
	// 패키지 설계 게시물 목록
	@Override
	public List<BoardDTO> want_list() throws Exception {
		return sql.selectList(namespace + ".want_list");
	}

	// 패키지 설계 게시물 작성
	@Override
	public void want_write(BoardDTO dto) throws Exception {
		sql.insert(namespace + ".want_write", dto);
	}
	// 설계 게시물 이미지
	public void want_writeImage(BoardDTO dto) throws Exception {
		sql.insert(namespace +".want_writeImage", dto);
	}

	// 패키지 설계 게시물 조회
	@Override
	public BoardDTO want_view(int board_want_bno) throws Exception {
		return sql.selectOne(namespace + ".want_view", board_want_bno);
	}

	// 패키지 설계 게시물 조회수 증가
	@Override
	public void want_updateViewCnt(int board_want_bno) throws Exception {
		sql.update(namespace + ".want_updateViewCnt", board_want_bno);
	}
	// 게시물 이미지 조회 
	public List<BoardDTO> want_viewImage(int board_want_bno) throws Exception {
		return sql.selectList(namespace + ".want_viewImage", board_want_bno);
	}

	// 패키지 설계 게시글 수정
	@Override
	public void want_modify(BoardDTO dto) throws Exception {
		sql.update(namespace + ".want_modify", dto);
	}

	// 패키지 설계 게시글 삭제
	@Override
	public void want_delete(int board_want_bno) throws Exception {
		sql.delete(namespace + ".want_delete", board_want_bno);
	}

	// 패키지 설계 게시글 총 갯수
	@Override
	public int want_count() throws Exception {
		return sql.selectOne(namespace + ".want_count");
	}

	// 패키지 설계 게시물 목록 + 페이징 + 검색
	@Override
	public List<BoardDTO> want_listPageSearch(int displayPost, int postNum, String searchType, String keyword)
			throws Exception {

		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("displayPost", displayPost);
		data.put("postNum", postNum);

		data.put("searchType", searchType);
		data.put("keyword", keyword);

		return sql.selectList(namespace + ".want_listPageSearch", data);
	}

	// 패키지 설계 게시물 총 갯수 + 검색 적용
	@Override
	public int want_searchCount(String searchType, String keyword) throws Exception {

		HashMap data = new HashMap();

		data.put("searchType", searchType);
		data.put("keyword", keyword);

		return sql.selectOne(namespace + ".want_searchCount", data);
	}

	// 게시글 추천관련 메소드 구현
	public void want_updateLike(int board_want_bno) throws Exception {
		sql.update(like_namespace + ".want_updateLike", board_want_bno);
	}

	@Override
	public void want_updateLikeCancel(int board_want_bno) throws Exception {
		sql.update(like_namespace + ".want_updateLikeCancel", board_want_bno);
	}

	@Override
	public void want_insertLike(int board_want_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("board_want_bno", board_want_bno);
		data.put("user_num", user_num);

		sql.insert(like_namespace + ".want_insertLike", data);
	}

	@Override
	public void want_deleteLike(int board_want_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("board_want_bno", board_want_bno);
		data.put("user_num", user_num);
		sql.delete(like_namespace + ".want_deleteLike", data);
	}

	@Override
	public int want_likeCheck(int board_want_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("user_num", user_num);
		data.put("board_want_bno", board_want_bno);

		return sql.selectOne(like_namespace + ".want_likeCheck", data);
	}

	@Override
	public void want_updateLikeCheck(int board_want_bno, int user_num) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("user_num", user_num);
		data.put("board_want_bno", board_want_bno);
		sql.update(like_namespace + ".want_updateLikeCheck", data);
	}

	@Override
	public void want_updateLikeCheckCancel(int board_want_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("user_num", user_num);
		data.put("board_want_bno", board_want_bno);
		sql.update(like_namespace + ".want_updateLikeCheckCancel", data);
	}

}
