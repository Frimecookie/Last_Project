package kr.project.utils;

import javax.servlet.http.HttpServletRequest;

import kr.project.entity.Users;

public final class SessionUtil {
	
	//사용자가 로그인 했는지(세션이 활성화 되는지) 확인
	public static boolean isNoneSession(HttpServletRequest req) {
		String userId = getUserId(req);
		if("".equals(userId)) {
			return true;
		} else {
			return false;
		}
	}
	
	//세션에 저장된 사용자의 정보를 불러옴
	public static Users getMvo(HttpServletRequest req) {
		Object sessionMvo = req.getSession().getAttribute("mvo");
		Users userModel = null;
		if(null != sessionMvo) {
			userModel = (Users) sessionMvo;
		}
		return userModel;
	}
	
	//현재 로그인 된 사용자의 ID를 가져옴
	public static String getUserId(HttpServletRequest req) {
		Object sessionMvo = req.getSession().getAttribute("mvo");
		Users userModel = null;
		String userId = "";
		if(null != sessionMvo) {
			userModel = (Users) sessionMvo;
			userId = userModel.getUser_id();
		}
		return userId;
	}
}