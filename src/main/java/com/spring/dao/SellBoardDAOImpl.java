package com.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;

@Repository
public class SellBoardDAOImpl implements SellBoardDAO {

	@Inject
	private SqlSession sql;

	private static String namespace = "com.spring.mappers.boardMapper";
	private static String like_namespace = "com.spring.mappers.likeMapper";
	
	// ------------------------------------
	// 패지키 판매 게시물 목록
	@Override
	public List<BoardDTO> sell_list() throws Exception {
		return sql.selectList(namespace + ".sell_list");
	}

	// 패키지 판매 게시물 작성
	@Override
	public void sell_write(BoardDTO dto) throws Exception {
		sql.insert(namespace + ".sell_write", dto);
	}

	// 패키지 판매 게시물 조회
	@Override
	public BoardDTO sell_view(int sell_bno) throws Exception {
		return sql.selectOne(namespace + ".sell_view", sell_bno);
	}

	// 패키지 판매 게시물 조회수 증가
	@Override
	public void sell_updateViewCnt(int sell_bno) throws Exception {
		sql.update(namespace + ".sell_updateViewCnt", sell_bno);
	}

	// 패키지 판매 게시글 수정
	@Override
	public void sell_modify(BoardDTO dto) throws Exception {
		sql.update(namespace + ".sell_modify", dto);
	}

	// 패키지 판매 게시글 삭제
	@Override
	public void sell_delete(int sell_bno) throws Exception {
		sql.delete(namespace + ".sell_delete", sell_bno);
	}

	// 패키지 판매 게시글 총 갯수
	@Override
	public int sell_count() throws Exception {
		return sql.selectOne(namespace + ".sell_count");
	}

	// 패키지 판매 게시물 목록 + 페이징 + 검색
	@Override
	public List<BoardDTO> sell_listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception {

		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("displayPost", displayPost);
		data.put("postNum", postNum);

		data.put("searchType", searchType);
		data.put("keyword", keyword);

		return sql.selectList(namespace + ".sell_listPageSearch", data);
	}

	// 패키지 판매 게시물 총 갯수 + 검색 적용
	@Override
	public int sell_searchCount(String searchType, String keyword) throws Exception {

		HashMap data = new HashMap();

		data.put("searchType", searchType);
		data.put("keyword", keyword);

		return sql.selectOne(namespace + ".sell_searchCount", data);
	}
	
	// 게시글 추천관련 메소드 구현
	public void sell_updateLike(int sell_bno) throws Exception {
		sql.update(like_namespace + ".sell_updateLike", sell_bno);
	}

	@Override
	public void sell_updateLikeCancel(int sell_bno) throws Exception {
		sql.update(like_namespace + ".sell_updateLikeCancel", sell_bno);
	}

	@Override
	public void sell_insertLike(int sell_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("sell_bno", sell_bno);
		data.put("user_num", user_num);

		sql.insert(like_namespace + ".sell_insertLike", data);
	}

	@Override
	public void sell_deleteLike(int board_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("sell_bno", board_bno);
		data.put("user_num", user_num);
		sql.delete(like_namespace + ".sell_deleteLike", data);
	}

	@Override
	public int sell_likeCheck(int sell_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("user_num", user_num);
		data.put("sell_bno", sell_bno);
		
		return sql.selectOne(like_namespace + ".sell_likeCheck", data);
	}

	@Override
	public void sell_updateLikeCheck(int sell_bno, int user_num) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("user_num", user_num);
		data.put("sell_bno", sell_bno);
		sql.update(like_namespace + ".sell_updateLikeCheck", data);
	}

	@Override
	public void sell_updateLikeCheckCancel(int sell_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("user_num", user_num);
		data.put("sell_bno", sell_bno);
		sql.update(like_namespace + ".sell_updateLikeCheckCancel", data);
	}
	
}
