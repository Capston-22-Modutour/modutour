package com.spring.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.dto.MemberDTO;
import com.spring.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberCompanyController {

	@Inject
	MemberService service;

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

	// 기업 로그인
	@RequestMapping(value = "/login_com", method = RequestMethod.POST)
	public String login_com(MemberDTO dto, HttpServletRequest req, RedirectAttributes rttr) throws Exception {

		HttpSession session = req.getSession();

		MemberDTO login_com = service.login_com(dto);

		if (login_com == null) {
			session.setAttribute("company", null);
			rttr.addFlashAttribute("msg", false);
		} else {
			session.setAttribute("company", login_com);
			session.setAttribute("com_regiNum", login_com.getCom_regiNum());
			session.setAttribute("com_name", login_com.getCom_name());
		}

		return "redirect:/";
	}

	// 기업 로그아웃
	@RequestMapping(value = "/logout_company", method = RequestMethod.GET)
	public String logout_company(HttpSession session) throws Exception {

		session.invalidate();

		return "redirect:/";
	}

	// 기업 회원정보 수정 get
	@RequestMapping(value = "/modify_company", method = RequestMethod.GET)
	public void getModify_company() throws Exception {

	}

	// 기업 회원정보 수정 post
	@RequestMapping(value = "/modify_company", method = RequestMethod.POST)
	public String postModify_company(HttpSession session, MemberDTO dto) throws Exception {

		service.modify_com(dto);
		session.invalidate();

		return "redirect:/";
	}

	
	// 기업 화원 탈퇴 get
	@RequestMapping(value = "/delete_company", method = RequestMethod.GET)
	public void getDeleteCompany() throws Exception {

	}

	// 기업 화원 탈퇴 post
	@RequestMapping(value = "/delete_company", method = RequestMethod.POST)
	public String postDeleteCompany(HttpSession session, MemberDTO dto, RedirectAttributes rttr) throws Exception {
		MemberDTO member = (MemberDTO) session.getAttribute("company");

		String oldPass = member.getCom_pw();
		String newPass = dto.getCom_pw();

		if (!(oldPass.equals(newPass))) {
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/delete_company";
		}

		service.delete_com(dto);
		session.invalidate();

		return "redirect:/";
	}
}
