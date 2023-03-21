package kr.project.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * 프론트엔드에 스크립트가 필요할 경우 사용
 * @author
 *
 */
public final class ScriptUtil {
	
	 // 인코딩과 콘텐츠 타입을 설정
    public static void init(HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
    }

    // 알림창
    public static void alert(HttpServletResponse response, String alertText) throws IOException {
        init(response);
        PrintWriter out = response.getWriter();
        out.println("<script>alert('" + alertText + "');</script> ");
        out.flush();
    }
    
    
    // 알림창이 뜬 후 다음 페이지로 이동
    public static void alertAndMovePage(HttpServletResponse response, String alertText, String nextPage) throws IOException {
        init(response);
        PrintWriter out = response.getWriter();
        out.println("<script>alert('" + alertText + "'); location.href='" + nextPage + "';</script> ");
        out.flush();
    }
 
    // 알림창이 뜬 후 이전 페이지로 이동
    public static void alertAndBackPage(HttpServletResponse response, String alertText) throws IOException {
        init(response);
        PrintWriter out = response.getWriter();
        out.println("<script>alert('" + alertText + "'); history.go(-1);</script>");
        out.flush();
    }
}

