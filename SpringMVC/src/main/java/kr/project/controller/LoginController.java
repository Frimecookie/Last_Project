package kr.project.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.project.service.LoginService;
import kr.project.utils.StringUtil;

@Controller
public class LoginController {

   @Autowired LoginService service;
   
   @RequestMapping(value = "/login.do", method = RequestMethod.POST)
   @ResponseBody
   public HashMap<String, Object> login(HttpServletRequest req, HttpServletResponse res, @RequestBody String body) throws IOException {
      HttpSession session = req.getSession();
      HashMap<String, Object> paramMap = StringUtil.convertStringToMap(body);
      String userId = paramMap.get("userId").toString();
      String userPw = paramMap.get("userPw").toString();
      String referer = paramMap.get("referer").toString();
      String pageNm = StringUtil.getBeforePage(referer);
      pageNm = "loginPage.do".equals(pageNm) ? "home.do" : pageNm;
      boolean isSuccess = service.getLoginSession(userId, userPw, session);
      
      HashMap<String, Object> resMap = new HashMap<String, Object>();
      resMap.put("isLogin", isSuccess);
      if(isSuccess) {
         resMap.put("code", "OK");
         resMap.put("msg", userId + "님 로그인 되었습니다.");
         resMap.put("referer", pageNm);
      } else {
         resMap.put("code", "FAIL");
         resMap.put("msg", "아이디 혹은 비밀번호가 틀렸습니다.\n다시 시도하여 주시기 바랍니다.");
      }
      return resMap;
   }
   
   @RequestMapping("/logout.do")
   public String logout(HttpServletRequest req, HttpSession session) {
      session.invalidate();
      String referer = req.getHeader("Referer");
      String pageNm = StringUtil.getBeforePage(referer);
      return "redirect:/" + pageNm;
   }
}