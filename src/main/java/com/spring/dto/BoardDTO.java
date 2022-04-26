package com.spring.dto;

import java.util.Date;

public class BoardDTO {
	// 자유 게시판
	private int board_bno;
	private String board_title;
	private String board_content;
	private String board_writer;
	private Date board_regDate;
	private int board_viewCnt;
	private int board_like;
	
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
	public int getBoard_like() {
		return board_like;
	}
	public void setBoard_like(int board_like) {
		this.board_like = board_like;
	}
	
	//패키지 설계 게시판
	private int board_want_bno;
	private String board_want_title;
	private String board_want_destination;
	private String board_want_content;
	private String board_want_writer;
	private int board_want_people;
	private Date board_want_start;
	private Date board_want_end;
	private int board_want_viewCnt;
	private int board_want_like;
	private Date board_want_regDate;

	public int getBoard_want_bno() {
		return board_want_bno;
	}
	public void setBoard_want_bno(int board_want_bno) {
		this.board_want_bno = board_want_bno;
	}
	public String getBoard_want_title() {
		return board_want_title;
	}
	public void setBoard_want_title(String board_want_title) {
		this.board_want_title = board_want_title;
	}
	public String getBoard_want_destination() {
		return board_want_destination;
	}
	public void setBoard_want_destination(String board_want_destination) {
		this.board_want_destination = board_want_destination;
	}
	public String getBoard_want_content() {
		return board_want_content;
	}
	public void setBoard_want_content(String board_want_content) {
		this.board_want_content = board_want_content;
	}
	public String getBoard_want_writer() {
		return board_want_writer;
	}
	public void setBoard_want_writer(String board_want_writer) {
		this.board_want_writer = board_want_writer;
	}
	public int getBoard_want_people() {
		return board_want_people;
	}
	public void setBoard_want_people(int board_want_people) {
		this.board_want_people = board_want_people;
	}
	public Date getBoard_want_start() {
		return board_want_start;
	}
	public void setBoard_want_start(Date board_want_start) {
		this.board_want_start = board_want_start;
	}
	public Date getBoard_want_end() {
		return board_want_end;
	}
	public void setBoard_want_end(Date board_want_end) {
		this.board_want_end = board_want_end;
	}
	public int getBoard_want_viewCnt() {
		return board_want_viewCnt;
	}
	public void setBoard_want_viewCnt(int board_want_viewCnt) {
		this.board_want_viewCnt = board_want_viewCnt;
	}
	public int getBoard_want_like() {
		return board_want_like;
	}
	public void setBoard_want_like(int board_want_like) {
		this.board_want_like = board_want_like;
	}
	public Date getBoard_want_regDate() {
		return board_want_regDate;
	}
	public void setBoard_want_regDate(Date board_want_regDate) {
		this.board_want_regDate = board_want_regDate;
	}
	public void setBoard_regDate(Date board_regDate) {
		this.board_regDate = board_regDate;
	}
	
	
}
