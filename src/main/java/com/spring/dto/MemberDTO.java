package com.spring.dto;

import java.util.Date;

public class MemberDTO {
	//일반 유저 회원가입
	private int user_num;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_gender;
	private String user_birth;
	private String user_phone1;
	private String user_phone2;
	private String user_phone3;
	private String user_phoneNum;
	private String user_address;
	private String user_email;
	private int user_point;
	private Date user_joinDate;
	
	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}
	
	public String getUser_phone1() {
		return user_phone1;
	}

	public void setUser_phone1(String user_phone1) {
		this.user_phone1 = user_phone1;
	}

	public String getUser_phone2() {
		return user_phone2;
	}

	public void setUser_phone2(String user_phone2) {
		this.user_phone2 = user_phone2;
	}

	public String getUser_phone3() {
		return user_phone3;
	}

	public void setUser_phone3(String user_phone3) {
		this.user_phone3 = user_phone3;
	}

	public String getUser_phoneNum() {
		user_phoneNum = user_phone1 + user_phone2 + user_phone3;
		
		return user_phoneNum;
	}

	public void setUser_phoneNum(String user_phoneNum) {
		this.user_phoneNum = user_phoneNum;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	public int getUser_point() {
		return user_point;
	}

	public void setUser_point(int user_point) {
		this.user_point = user_point;
	}

	public Date getUser_joinDate() {
		return user_joinDate;
	}

	public void setUser_joinDate(Date user_joinDate) {
		this.user_joinDate = user_joinDate;
	}
	
	// 기업 회원 가입
	private int com_regiNum;
	private String com_id;
	private String com_pw;
	private String com_name;
	private String com_phone1;
	private String com_phone2;
	private String com_phone3;
	private String com_phoneNum;
	private String com_address;
	private String com_email;
	private Date com_joinDate;

	public int getCom_regiNum() {
		return com_regiNum;
	}

	public void setCom_regiNum(int com_regiNum) {
		this.com_regiNum = com_regiNum;
	}

	public String getCom_id() {
		return com_id;
	}

	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}

	public String getCom_pw() {
		return com_pw;
	}

	public void setCom_pw(String com_pw) {
		this.com_pw = com_pw;
	}

	public String getCom_name() {
		return com_name;
	}

	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	
	public String getCom_phone1() {
		return com_phone1;
	}

	public void setCom_phone1(String com_phone1) {
		this.com_phone1 = com_phone1;
	}

	public String getCom_phone2() {
		return com_phone2;
	}

	public void setCom_phone2(String com_phone2) {
		this.com_phone2 = com_phone2;
	}

	public String getCom_phone3() {
		return com_phone3;
	}

	public void setCom_phone3(String com_phone3) {
		this.com_phone3 = com_phone3;
	}

	public String getCom_phoneNum() {
		com_phoneNum = com_phone1 + com_phone2 + com_phone3;
		
		return com_phoneNum;
	}

	public void setCom_phoneNum(String com_phoneNum) {
		this.com_phoneNum = com_phoneNum;
	}

	public String getCom_address() {
		return com_address;
	}

	public void setCom_address(String com_address) {
		this.com_address = com_address;
	}

	public String getCom_email() {
		return com_email;
	}

	public void setCom_email(String com_email) {
		this.com_email = com_email;
	}

	public Date getCom_joinDate() {
		return com_joinDate;
	}

	public void setCom_joinDate(Date com_joinDate) {
		this.com_joinDate = com_joinDate;
	}
}
