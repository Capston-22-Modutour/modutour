package com.spring.dto;

import java.util.Date;

public class ReplyDTO {
	private int reply_rno;
	private int board_bno;
	private String reply_writer;
	private String reply_content;
	private Date reply_regDate;
	
	public int getReply_rno() {
		return reply_rno;
	}
	public void setReply_rno(int reply_rno) {
		this.reply_rno = reply_rno;
	}
	public int getBoard_bno() {
		return board_bno;
	}
	public void setBoard_bno(int board_bno) {
		this.board_bno = board_bno;
	}
	public String getReply_writer() {
		return reply_writer;
	}
	public void setReply_writer(String reply_writer) {
		this.reply_writer = reply_writer;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public Date getReply_regDate() {
		return reply_regDate;
	}
	public void setReply_regDate(Date reply_regDate) {
		this.reply_regDate = reply_regDate;
	}
	
	
}
