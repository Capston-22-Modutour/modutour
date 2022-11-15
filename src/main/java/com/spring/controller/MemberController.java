package com.spring.controller;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	}

	// 회원가입 post
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String postSignUp(MemberDTO dto) throws Exception {

		service.signUp(dto);

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

	// 일반 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberDTO dto, HttpServletRequest req, RedirectAttributes rttr) throws Exception {

		HttpSession session = req.getSession();

		MemberDTO login = service.login(dto);
		
		if (login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		} else {
			session.setAttribute("member", login);
			session.setAttribute("user_num", login.getUser_num());
			session.setAttribute("user_name", login.getUser_name());
		}

		return "redirect:/";
	}

	// 일반 로그아웃
	@RequestMapping(value = "/logout_member", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {

		session.invalidate();

		return "redirect:/";
	}

	// 일반 회원정보 수정 get
	@RequestMapping(value = "/modify_member", method = RequestMethod.GET)
	public void getModify() throws Exception {
		
	}

	// 일반 회원정보 수정 post
	@RequestMapping(value = "/modify_member", method = RequestMethod.POST)
	public String postModify_member(HttpSession session, MemberDTO dto) throws Exception {

		MemberDTO member = (MemberDTO) session.getAttribute("member");
		
		dto.setUser_id(member.getUser_id());
		
		service.modify(dto);
		session.invalidate();

		return "redirect:/";
	}

	// 일반 화원 탈퇴 get
	@RequestMapping(value = "/delete_member", method = RequestMethod.GET)
	public void getDelete() throws Exception {

	}

	// 일반 화원 탈퇴 post
	@RequestMapping(value = "/delete_member", method = RequestMethod.POST)
	public String postDelete(HttpSession session, MemberDTO dto, RedirectAttributes rttr) throws Exception {
		MemberDTO member = (MemberDTO) session.getAttribute("member");

		String oldPass = member.getUser_pw();
		String newPass = dto.getUser_pw();

		if (!(oldPass.equals(newPass))) {
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/delete_member";
		}

		service.delete(dto);
		session.invalidate();
		
		return "redirect:/";
	}
}
