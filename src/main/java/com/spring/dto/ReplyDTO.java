package com.spring.dto;

import java.util.Date;

public class ReplyDTO {
	
	private int review_rno;
	private int review_bno;
	private String review_writer;
	private String review_content;
	private Date review_regDate;
	
	public int getReview_rno() {
		return review_rno;
	}
	public void setReview_rno(int review_rno) {
		this.review_rno = review_rno;
	}
	public int getReview_bno() {
		return review_bno;
	}
	public void setReview_bno(int review_bno) {
		this.review_bno = review_bno;
	}
	public String getReview_writer() {
		return review_writer;
	}
	public void setReview_writer(String review_writer) {
		this.review_writer = review_writer;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public Date getReview_regDate() {
		return review_regDate;
	}
	public void setReview_regDate(Date review_regDate) {
		this.review_regDate = review_regDate;
	}

	//--------------------------------------------
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
	
	//--------------------------------------------
	private int board_reply_rno;
	private int board_want_bno;
	private String board_want_reply_writer;
	private String board_want_reply_content;
	private Date board_want_reply_regDate;

	public int getBoard_reply_rno() {
		return board_reply_rno;
	}
	public void setBoard_reply_rno(int board_reply_rno) {
		this.board_reply_rno = board_reply_rno;
	}
	public int getBoard_want_bno() {
		return board_want_bno;
	}
	public void setBoard_want_bno(int board_want_bno) {
		this.board_want_bno = board_want_bno;
	}
	public String getBoard_want_reply_writer() {
		return board_want_reply_writer;
	}
	public void setBoard_want_reply_writer(String board_want_reply_writer) {
		this.board_want_reply_writer = board_want_reply_writer;
	}
	public String getBoard_want_reply_content() {
		return board_want_reply_content;
	}
	public void setBoard_want_reply_content(String board_want_reply_content) {
		this.board_want_reply_content = board_want_reply_content;
	}
	public Date getBoard_want_reply_regDate() {
		return board_want_reply_regDate;
	}
	public void setBoard_want_reply_regDate(Date board_want_reply_regDate) {
		this.board_want_reply_regDate = board_want_reply_regDate;
	}
	
	private int sell_rno;
	private int sell_bno;
	private String sell_writer;
	private String sell_content;
	private Date sell_regDate;

	public int getSell_rno() {
		return sell_rno;
	}
	public void setSell_rno(int sell_rno) {
		this.sell_rno = sell_rno;
	}
	public int getSell_bno() {
		return sell_bno;
	}
	public void setSell_bno(int sell_bno) {
		this.sell_bno = sell_bno;
	}
	public String getSell_writer() {
		return sell_writer;
	}
	public void setSell_writer(String sell_writer) {
		this.sell_writer = sell_writer;
	}
	public String getSell_content() {
		return sell_content;
	}
	public void setSell_content(String sell_content) {
		this.sell_content = sell_content;
	}
	public Date getSell_regDate() {
		return sell_regDate;
	}
	public void setSell_regDate(Date sell_regDate) {
		this.sell_regDate = sell_regDate;
	}
}
