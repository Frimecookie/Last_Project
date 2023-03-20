package kr.project.utils;

import javax.servlet.http.HttpServletRequest;

import kr.project.entity.Users;

public final class SessionUtil {
	
	public static boolean isNoneSession(HttpServletRequest req) {
		String userId = getUserId(req);
		if("".equals(userId)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static Users getMvo(HttpServletRequest req) {
		Object sessionMvo = req.getSession().getAttribute("mvo");
		Users userModel = null;
		if(null != sessionMvo) {
			userModel = (Users) sessionMvo;
		}
		return userModel;
	}
	
	public static String getUserId(HttpServletRequest req) {
		Object sessionMvo = req.getSession().getAttribute("mvo");
		Users userModel = null;
		String userId = "";
		if(null != sessionMvo) {
			userModel = (Users) sessionMvo;
			userId = userModel.getUSER_ID();
		}
		return userId;
	}
}