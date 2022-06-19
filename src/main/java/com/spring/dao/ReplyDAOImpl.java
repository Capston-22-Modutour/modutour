package com.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.ReplyDTO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	@Inject
	private SqlSession sql;

	private static String namespace = "com.spring.mappers.replyMapper";

	// 댓글 목록
	@Override
	public List<ReplyDTO> review_list(int review_bno) throws Exception {
	    return sql.selectList(namespace + ".review_replyList", review_bno);
	}
		
	// 댓글 조회
	@Override
	public ReplyDTO review_view(int review_rno) throws Exception {
		return sql.selectOne(namespace + ".review_view", review_rno);
	}	
		
	// 댓글 작성
	@Override
	public void review_write(ReplyDTO dto) throws Exception {
	    sql.insert(namespace + ".review_replyWrite", dto);
	}

	// 댓글 수정
	@Override
	public void review_modify(ReplyDTO dto) throws Exception {
	    sql.update(namespace + ".review_replyModify", dto);
	}

	// 댓글 삭제
	@Override
	public void review_delete(int review_rno) throws Exception {
	    sql.delete(namespace + ".replyDelete", review_rno);
	}
		
	//--------------
	// 댓글 목록
	@Override
	public List<ReplyDTO> list(int board_bno) throws Exception {
	    return sql.selectList(namespace + ".replyList", board_bno);
	}
	
	// 댓글 조회
	@Override
	public ReplyDTO view(int reply_rno) throws Exception {
		return sql.selectOne(namespace + ".view", reply_rno);
	}	
	
	// 댓글 작성
	@Override
	public void write(ReplyDTO dto) throws Exception {
	    sql.insert(namespace + ".replyWrite", dto);
	}

	// 댓글 수정
	@Override
	public void modify(ReplyDTO dto) throws Exception {
	    sql.update(namespace + ".replyModify", dto);
	}

	// 댓글 삭제
	@Override
	public void delete(int reply_rbno) throws Exception {
	    sql.delete(namespace + ".replyDelete", reply_rbno);
	}
	
	//--------------
	//패키지 설계 댓글 목록
	@Override
	public List<ReplyDTO> want_list(int board_want_bno) throws Exception {
		return sql.selectList(namespace + ".want_replyList", board_want_bno);
	}
	
	// 댓글 조회
	@Override
	public ReplyDTO want_view(int board_reply_rno) throws Exception {
		return sql.selectOne(namespace + ".want_view", board_reply_rno);
	}

	//패키지 댓글 작성
	@Override
	public void want_write(ReplyDTO dto) throws Exception {
		sql.insert(namespace + ".want_replyWrite", dto);
	}

	//패키지 댓글 수정
	@Override
	public void want_modify(ReplyDTO dto) throws Exception {
		sql.update(namespace + ".want_replyModify", dto);
	}

	//패키지 댓글 삭제
	@Override
	public void want_delete(int board_reply_rno) throws Exception {
		sql.delete(namespace + ".want_replyDelete", board_reply_rno);
	}
	
	//--------------
	//패키지 제안 댓글 목록
	@Override
	public List<ReplyDTO> suggest_list(int suggest_bno) throws Exception {
		return sql.selectList(namespace + ".suggest_replyList", suggest_bno);
	}
	
	// 댓글 조회
	@Override
	public ReplyDTO suggest_view(int suggest_rno) throws Exception {
		return sql.selectOne(namespace + ".suggest_view", suggest_rno);
	}

	//패키지 댓글 작성
	@Override
	public void suggest_write(ReplyDTO dto) throws Exception {
		sql.insert(namespace + ".suggest_replyWrite", dto);
	}

	//패키지 댓글 수정
	@Override
	public void suggest_modify(ReplyDTO dto) throws Exception {
		sql.update(namespace + ".suggest_replyModify", dto);
	}

	//패키지 댓글 삭제
	@Override
	public void suggest_delete(int suggest_rno) throws Exception {
		sql.delete(namespace + ".suggest_replyDelete", suggest_rno);
	}
	
	//--------------
	//패키지 판매 댓글 목록
	@Override
	public List<ReplyDTO> sell_list(int sell_bno) throws Exception {
		return sql.selectList(namespace + ".sell_replyList", sell_bno);
	}
		
	// 댓글 조회
	@Override
	public ReplyDTO sell_view(int sell_rno) throws Exception {
		return sql.selectOne(namespace + ".sell_view", sell_rno);
	}

	//패키지 댓글 작성
	@Override
	public void sell_write(ReplyDTO dto) throws Exception {
		sql.insert(namespace + ".sell_replyWrite", dto);
	}

	//패키지 댓글 수정
	@Override
	public void sell_modify(ReplyDTO dto) throws Exception {
		sql.update(namespace + ".sell_replyModify", dto);
	}

	//패키지 댓글 삭제
	@Override
	public void sell_delete(int sell_rno) throws Exception {
		sql.delete(namespace + ".sell_replyDelete", sell_rno);
	}
}
