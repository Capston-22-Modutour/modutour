package com.spring.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DateDTO {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date search_start;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date currentDate;
	
	public Date getSearch_start() {
		return search_start;
	}
	public void setSearch_start(Date search_start) {
		this.search_start = search_start;
	}
	public Date getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	
}
