package kr.project.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.project.service.LoginService;
import kr.project.utils.ScriptUtil;
import kr.project.utils.StringUtil;

@Controller
public class LoginController {

	@Autowired LoginService service;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		String referer = req.getParameter("referer");

		boolean isSuccess = service.getLoginSession(userId, userPw, session);
		if(isSuccess) {
			return "redirect:/home";
		} else {
			ScriptUtil.alert(res, "아이디 혹은 비밀번호가 틀렸습니다.\\n다시 시도하여 주십시오.");
			return "redirect:/loginPage.do";
		}
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest req, HttpSession session) {
		session.invalidate();
		String referer = req.getHeader("Referer");
		String pageNm = StringUtil.getBeforePage(referer);
		return "redirect:/" + pageNm;
	}
}