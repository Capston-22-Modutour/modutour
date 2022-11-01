package com.spring.dto;

import java.util.Date;

public class PointDTO {
	
	//포인트
	private int user_num;
	private int sell_bno;
	private int point;
	private Date point_regDate;
	
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public int getSell_bno() {
		return sell_bno;
	}
	public void setSell_bno(int sell_bno) {
		this.sell_bno = sell_bno;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Date getPoint_regDate() {
		return point_regDate;
	}
	public void setPoint_regDate(Date point_regDate) {
		this.point_regDate = point_regDate;
	}
	
}
