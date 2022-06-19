package com.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;

@Repository
public class SuggestBoardDAOImpl implements SuggestBoardDAO {

	@Inject
	private SqlSession sql;

	private static String namespace = "com.spring.mappers.boardMapper";
	private static String like_namespace = "com.spring.mappers.likeMapper";
	
	// ------------------------------------
	// 패지키 제안 게시물 목록
	@Override
	public List<BoardDTO> suggest_list() throws Exception {
		return sql.selectList(namespace + ".suggest_list");
	}

	// 패키지 제안 게시물 작성
	@Override
	public void suggest_write(BoardDTO dto) throws Exception {
		sql.insert(namespace + ".suggest_write", dto);
	}

	// 패키지 제안 게시물 조회
	@Override
	public BoardDTO suggest_view(int suggest_bno) throws Exception {
		return sql.selectOne(namespace + ".suggest_view", suggest_bno);
	}

	// 패키지 제안 게시물 조회수 증가
	@Override
	public void suggest_updateViewCnt(int suggest_bno) throws Exception {
		sql.update(namespace + ".suggest_updateViewCnt", suggest_bno);
	}

	// 패키지 제안 게시글 수정
	@Override
	public void suggest_modify(BoardDTO dto) throws Exception {
		sql.update(namespace + ".suggest_modify", dto);
	}

	// 패키지 제안 게시글 삭제
	@Override
	public void suggest_delete(int suggest_bno) throws Exception {
		sql.delete(namespace + ".suggest_delete", suggest_bno);
	}

	// 패키지 제안 게시글 총 갯수
	@Override
	public int suggest_count() throws Exception {
		return sql.selectOne(namespace + ".suggest_count");
	}

	// 패키지 제안 게시물 목록 + 페이징 + 검색
	@Override
	public List<BoardDTO> suggest_listPageSearch(int displayPost, int postNum, String searchType, String keyword)
			throws Exception {

		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("displayPost", displayPost);
		data.put("postNum", postNum);

		data.put("searchType", searchType);
		data.put("keyword", keyword);

		return sql.selectList(namespace + ".suggest_listPageSearch", data);
	}

	// 패키지 제안 게시물 총 갯수 + 검색 적용
	@Override
	public int suggest_searchCount(String searchType, String keyword) throws Exception {

		HashMap data = new HashMap();

		data.put("searchType", searchType);
		data.put("keyword", keyword);

		return sql.selectOne(namespace + ".suggest_searchCount", data);
	}
	
	// 게시글 추천관련 메소드 구현
	public void suggest_updateLike(int suggest_bno) throws Exception {
		sql.update(like_namespace + ".suggest_updateLike", suggest_bno);
	}

	@Override
	public void suggest_updateLikeCancel(int suggest_bno) throws Exception {
		sql.update(like_namespace + ".suggest_updateLikeCancel", suggest_bno);
	}

	@Override
	public void suggest_insertLike(int suggest_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("suggest_bno", suggest_bno);
		data.put("user_num", user_num);

		sql.insert(like_namespace + ".suggest_insertLike", data);
	}

	@Override
	public void suggest_deleteLike(int suggest_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("suggest_bno", suggest_bno);
		data.put("user_num", user_num);
		sql.delete(like_namespace + ".suggest_deleteLike", data);
	}

	@Override
	public int suggest_likeCheck(int suggest_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("user_num", user_num);
		data.put("suggest_bno", suggest_bno);

		return sql.selectOne(like_namespace + ".review_likeCheck", data);
	}

	@Override
		public void suggest_updateLikeCheck(int suggest_bno, int user_num) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("user_num", user_num);
		data.put("suggest_bno", suggest_bno);
		sql.update(like_namespace + ".suggest_updateLikeCheck", data);
	}

	@Override
	public void suggest_updateLikeCheckCancel(int suggest_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("user_num", user_num);
		data.put("suggest_bno", suggest_bno);
		sql.update(like_namespace + ".suggest_updateLikeCheckCancel", data);
	}

}
