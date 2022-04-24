package com.spring.controller;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.dto.MemberDTO;
import com.spring.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	MemberService service;

	// signUp 메인
	@RequestMapping(value = "/signUpMain", method = RequestMethod.GET)
	public String signUpMain(Locale locale, Model model) {

		return "member/signUpMain";
	}

	// 회원가입 get
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public void getSignUp() throws Exception {
		logger.info("get signUp");
	}

	// 회원가입 post
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String postSignUp(MemberDTO dto) throws Exception {
		logger.info("post signUp");

		service.signUp(dto);

		return "redirect:/";
	}

	// 기업 회원가입 get
	@RequestMapping(value = "/signUp_com", method = RequestMethod.GET)
	public void getSignUp_com() throws Exception {

	}

	// 기업 회원가입 post
	@RequestMapping(value = "/signUp_com", method = RequestMethod.POST)
	public String postSignUp_com(MemberDTO dto) throws Exception {
		service.signUp_com(dto);

		return "redirect:/";
	}

	// 일반 회원 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value = "/memberIdCheck", method = RequestMethod.POST)
	public int postMemberIdCheck(HttpServletRequest req) throws Exception {

		String user_id = req.getParameter("user_id");
		MemberDTO memberIdCheck = service.memberIdCheck(user_id);

		int result = 0;

		if (memberIdCheck != null) {
			result = 1;
		}

		return result;
	}

	// 기업 회원 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value = "/companyIdCheck", method = RequestMethod.POST)
	public int postCompanyIdCheck(HttpServletRequest req) throws Exception {

		String com_id = req.getParameter("com_id");
		MemberDTO companyIdCheck = service.companyIdCheck(com_id);

		int result = 0;

		if (companyIdCheck != null) {
			result = 1;
		}

		return result;
	}

	// 일반 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberDTO dto, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		logger.info("post login");

		HttpSession session = req.getSession();

		MemberDTO login = service.login(dto);

		if (login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		} else {
			session.setAttribute("member", login);
		}

		return "redirect:/";
	}

	// 기업 로그인
	@RequestMapping(value = "/login_com", method = RequestMethod.POST)
	public String login_com(MemberDTO dto, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		logger.info("post login");

		HttpSession session = req.getSession();

		MemberDTO login_com = service.login_com(dto);

		if (login_com == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		} else {
			session.setAttribute("member", login_com);
		}

		return "redirect:/";
	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {

		session.invalidate();

		return "redirect:/";
	}

	// 회원정보 수정 get
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getModify() throws Exception {

	}

	// 회원정보 수정 post
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postModify(HttpSession session, MemberDTO dto) throws Exception {

		service.modify(dto);
		session.invalidate();

		return "redirect:/";
	}

	// 화원 탈퇴 get
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void getDelete() throws Exception {

	}

	// 화원 탈퇴 post
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String postDelete(HttpSession session, MemberDTO dto, RedirectAttributes rttr) throws Exception {
		MemberDTO member = (MemberDTO) session.getAttribute("member");

		String oldPass = member.getUser_pw();
		String newPass = dto.getUser_pw();

		if (!(oldPass.equals(newPass))) {
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/delete";
		}

		service.delete(dto);

		return "redirect:/";
	}
}
