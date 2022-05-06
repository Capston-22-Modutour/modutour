package com.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;
import com.spring.dto.LikeDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sql;

	private static String namespace = "com.spring.mappers.boardMapper";
	private static String like_namespace = "com.spring.mappers.likeMapper";

	// 자유 게시물 목록
	@Override
	public List<BoardDTO> list() throws Exception {
		return sql.selectList(namespace + ".list");
	}

	// 자유 게시물 작성
	@Override
	public void write(BoardDTO dto) throws Exception {
		sql.insert(namespace + ".write", dto);
	}

	// 자유 게시물 조회
	@Override
	public BoardDTO view(int board_bno) throws Exception {
		return sql.selectOne(namespace + ".view", board_bno);
	}
	
	// 자유 게시글 조회수 증가
	@Override
	public void updateViewCnt(int board_bno) throws Exception {
		sql.update(namespace + ".updateViewCnt", board_bno);
	}
	
	// 자유 게시글 수정
	@Override
	public void modify(BoardDTO dto) throws Exception {
		sql.update(namespace + ".modify", dto);
	}

	// 자유 게시글 삭제
	@Override
	public void delete(int board_bno) throws Exception {
		sql.delete(namespace + ".delete", board_bno);
	}

	// 자유 게시글 총 갯수
	@Override
	public int count() throws Exception {
		return sql.selectOne(namespace + ".count");
	}

	@Override
	public List<BoardDTO> listPage(int displayPost, int postNum) throws Exception {
		HashMap<String, Integer> data = new HashMap<String, Integer>();

		data.put("displayPost", displayPost);
		data.put("postNum", postNum);

		return sql.selectList(namespace + ".listPage", data);
	}

	// 자유 게시물 목록 + 페이징 + 검색
	@Override
	public List<BoardDTO> listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception {

		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("displayPost", displayPost);
		data.put("postNum", postNum);

		data.put("searchType", searchType);
		data.put("keyword", keyword);

		return sql.selectList(namespace + ".listPageSearch", data);
	}

	// 자유 게시물 총 갯수 + 검색 적용
	@Override
	public int searchCount(String searchType, String keyword) throws Exception {

		HashMap<String, Object> data = new HashMap();

		data.put("searchType", searchType);
		data.put("keyword", keyword);

		return sql.selectOne(namespace + ".searchCount", data);
	}

	// 게시글 추천관련 메소드 구현
	public void updateLike(int board_bno) throws Exception {
		sql.update(like_namespace + ".updateLike", board_bno);
	}

	@Override
	public void updateLikeCancel(int board_bno) throws Exception {
		sql.update(like_namespace + ".updateLikeCancel", board_bno);
	}

	@Override
	public void insertLike(int board_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("board_bno", board_bno);
		data.put("user_num", user_num);
		
		sql.insert(like_namespace + ".insertLike", data);
	}

	@Override
	public void deleteLike(int board_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("board_bno", board_bno);
		data.put("user_num", user_num);
		sql.delete(like_namespace + ".deleteLike", data);
	}

	@Override
	public int likeCheck(int board_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("user_num", user_num);
		data.put("board_bno", board_bno);
		
		return sql.selectOne(like_namespace + ".likeCheck", data);
	}

	@Override
	public void updateLikeCheck(int board_bno, int user_num) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("user_num", user_num);
		data.put("board_bno", board_bno);
		sql.update(like_namespace + ".updateLikeCheck", data);
	}

	@Override
	public void updateLikeCheckCancel(int board_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("user_num", user_num);
		data.put("board_bno", board_bno);
		sql.update(like_namespace + ".updateLikeCheckCancel", data);
	}
		
	
	// ------------------------------------
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
	public List<BoardDTO> want_listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception {

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
		sql.update(namespace + ".want_modify", dto);
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
	public List<BoardDTO> suggest_listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception {

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
}
