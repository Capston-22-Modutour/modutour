package com.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;

@Repository
public class ReviewBoardDAOImpl implements ReviewBoardDAO {

	@Inject
	private SqlSession sql;

	private static String namespace = "com.spring.mappers.boardMapper";
	private static String like_namespace = "com.spring.mappers.likeMapper";
	
	// 커뮤니티 게시물 번호 확인
	@Override
	public int review_checkBoardBno() throws Exception {
		return sql.selectOne(namespace + ".review_checkBoardBno");
	}
		
	// 여행후기 게시물 목록
	@Override
	public List<BoardDTO> review_list() throws Exception {
		return sql.selectList(namespace + ".review_list");
	}

	// 여행후기 게시물 작성
	@Override
	public void review_write(BoardDTO dto) throws Exception {
		sql.insert(namespace + ".review_write", dto);
	}
	// 자유 게시물 이미지 삽입
	@Override
	public void review_writeImage(BoardDTO dto) throws Exception {
		sql.insert(namespace + ".review_writeImage", dto);
	}

	// 여행후기 게시물 조회
	@Override
	public BoardDTO review_view(int review_bno) throws Exception {
		return sql.selectOne(namespace + ".review_view", review_bno);
	}
	// 게시물 이미지 조회
	@Override
	public List<BoardDTO> review_viewImage(int review_bno) throws Exception {
		return sql.selectList(namespace + ".review_viewImage", review_bno);
	}

	// 여행후기 게시글 조회수 증가
	@Override
	public void review_updateViewCnt(int review_bno) throws Exception {
		sql.update(namespace + ".review_updateViewCnt", review_bno);
	}

	// 여행후기 게시글 수정
	@Override
	public void review_modify(BoardDTO dto) throws Exception {
		sql.update(namespace + ".review_modify", dto);
	}

	// 여행후기 게시글 삭제
	@Override
	public void review_delete(int review_bno) throws Exception {
		sql.delete(namespace + ".review_delete", review_bno);
	}

	// 여행후기 게시글 총 갯수
	@Override
	public int review_count() throws Exception {
		return sql.selectOne(namespace + ".review_count");
	}

	// 여행후기 게시물 목록 + 페이징 + 검색
	@Override
	public List<BoardDTO> review_listPageSearch(int displayPost, int postNum, String searchType, String keyword)
			throws Exception {

		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("displayPost", displayPost);
		data.put("postNum", postNum);

		data.put("searchType", searchType);
		data.put("keyword", keyword);

		return sql.selectList(namespace + ".review_listPageSearch", data);
	}

	// 여행후기 게시물 총 갯수 + 검색 적용
	@Override
	public int review_searchCount(String searchType, String keyword) throws Exception {

		HashMap<String, Object> data = new HashMap();

		data.put("searchType", searchType);
		data.put("keyword", keyword);

		return sql.selectOne(namespace + ".review_searchCount", data);
	}

	// 게시글 추천관련 메소드 구현
	public void review_updateLike(int review_bno) throws Exception {
		sql.update(like_namespace + ".review_updateLike", review_bno);
	}

	@Override
	public void review_updateLikeCancel(int review_bno) throws Exception {
		sql.update(like_namespace + ".review_updateLikeCancel", review_bno);
	}

	@Override
	public void review_insertLike(int review_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("review_bno", review_bno);
		data.put("user_num", user_num);

		sql.insert(like_namespace + ".review_insertLike", data);
	}

	@Override
	public void review_deleteLike(int review_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("review_bno", review_bno);
		data.put("user_num", user_num);
		sql.delete(like_namespace + ".review_deleteLike", data);
	}

	@Override
	public int review_likeCheck(int review_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("user_num", user_num);
		data.put("review_bno", review_bno);

		return sql.selectOne(like_namespace + ".review_likeCheck", data);
	}

	@Override
	public void review_updateLikeCheck(int review_bno, int user_num) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("user_num", user_num);
		data.put("review_bno", review_bno);
		sql.update(like_namespace + ".review_updateLikeCheck", data);
	}

	@Override
	public void review_updateLikeCheckCancel(int review_bno, int user_num) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("user_num", user_num);
		data.put("review_bno", review_bno);
		sql.update(like_namespace + ".review_updateLikeCheckCancel", data);
	}

}
