package kr.project.utils;

import javax.servlet.http.HttpServletRequest;

public final class SessionUtil {
	
	public static String getUserId(HttpServletRequest req) {
		String userId = req.getSession().getAttribute("userId").toString();
		if(null == userId || "".equals(userId)) {
			userId = "";
		}
		return userId;
	}
}