package com.spring.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sql;

	private static String namespace = "com.spring.mappers.board";

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

		HashMap data = new HashMap();

		data.put("searchType", searchType);
		data.put("keyword", keyword);

		return sql.selectOne(namespace + ".searchCount", data);
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
}
