package com.spring.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login/*")
public class LoginController {
	// 로그인 메인
	@RequestMapping(value = "/loginMain", method = RequestMethod.GET)
	public String loginMain(Locale locale, Model model) {

		return "login/loginMain";
	}

	// get 유저 로그인
	@RequestMapping(value = "/login_member", method = RequestMethod.GET)
	public void getLogin_member(Locale locale, Model model) {

	}

	// post 유저 로그인
	@RequestMapping(value = "/login_member", method = RequestMethod.POST)
	public String postLogin_member(Locale locale, Model model) {

		return "login/login_member";
	}

	// get 기업 로그인
	@RequestMapping(value = "/login_company", method = RequestMethod.GET)
	public void getLogin_company(Locale locale, Model model) {

	}

	// post 기업 로그인
	@RequestMapping(value = "/login_company", method = RequestMethod.POST)
	public String postLogin_company(Locale locale, Model model) {

		return "login/login_company";
	}
}
