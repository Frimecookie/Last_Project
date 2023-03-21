package kr.project.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.project.entity.Users;
import kr.project.mapper.LoginMapper;

@Service
public class LoginService {

	@Autowired LoginMapper mapper;
	
	// 로그인 및 성공여부
	public boolean getLoginSession(String userId, String userPw, HttpSession session) {
		boolean isSuccess = false;
		Users userModel = mapper.loginCheck(userId, userPw);
		if(null != userModel) {
			session.setAttribute("mvo", userModel);
			session.setAttribute("userId", userId);
			isSuccess = true;
			System.out.println("로그인 성공");
			System.out.println(userModel);
		} else {
			System.out.println("로그인 실패");
		}
		return isSuccess;
	}
}