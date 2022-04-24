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

	private static String namespace = "com.spring.mappers.reply";

	// 댓글 조회
	@Override
	public List<ReplyDTO> list(int board_bno) throws Exception {
	    return sql.selectList(namespace + ".replyList", board_bno);
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
	public void delete(ReplyDTO dto) throws Exception {
	    sql.delete(namespace + ".replyDelete", dto);
	}
}
