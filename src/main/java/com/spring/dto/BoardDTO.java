package com.spring.dto;

import java.util.Date;

public class BoardDTO {
	private int board_bno;
	private String board_title;
	private String board_content;
	private String board_writer;
	private Date board_regDate;
	private int board_viewCnt;
	private int board_like;
	private Date board_start;
	private Date board_end;
	
	public int getBoard_bno() {
		return board_bno;
	}
	public void setBoard_bno(int board_bno) {
		this.board_bno = board_bno;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public Date getBoard_regDate() {
		return board_regDate;
	}
	public void setBoard_regdate(Date board_regdate) {
		this.board_regDate = board_regDate;
	}
	public int getBoard_viewCnt() {
		return board_viewCnt;
	}
	public void setBoard_viewCnt(int board_viewCnt) {
		this.board_viewCnt = board_viewCnt;
	}
	
	
}
