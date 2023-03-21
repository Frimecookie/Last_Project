package kr.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.project.entity.Questions;
import kr.project.mapper.QuestionMapper;
import kr.project.service.QuestionService;
import kr.project.utils.SessionUtil;

@Controller
public class QnaController {

   @Autowired private QuestionMapper mapper;
   @Autowired QuestionService service;

   // 내 문의사항 목록 보기
   @RequestMapping("/qaPage.do")
   public String qnaList(HttpServletRequest req) {
      if (SessionUtil.isNoneSession(req)) {
         return "page/loginPage";
      }
      String userId = SessionUtil.getUserId(req);

      List<Questions> qnaList = mapper.qnaList(userId);
      req.setAttribute("qnalist", qnaList);

      return "page/qaPage";
   }

   // 게시판 글 작성
   @RequestMapping(value = "/qaPage_write.do", method = RequestMethod.POST)
   public String write(HttpServletRequest req, Questions vo) {
      String userId = SessionUtil.getUserId(req);
      service.insertQaData(req, userId, vo);

      return "redirect:/qaPage.do";
   }

   // 게시판 상세 정보
   @RequestMapping(value = "/qaPage_content.do", method = RequestMethod.GET)
   public String content(HttpServletRequest req) {
      if (SessionUtil.isNoneSession(req)) {
         return "page/loginPage";
      }
      String questions_num = (String) req.getParameter("QUESTIONS_NUM");
      Questions questionsData = service.getQaData(questions_num);
      req.setAttribute("questionsData", questionsData);

      return "page/qaPage_content";
   }

   // 게시판 수정
   @RequestMapping(value = "/qaPage_update.do", method = RequestMethod.GET)
   public String qaUpdate2(HttpServletRequest req) {
      if (SessionUtil.isNoneSession(req)) {
         return "page/loginPage";
      }
      int questions_num = Integer.parseInt(req.getParameter("QUESTIONS_NUM"));
      String questions_title = (String) (req.getParameter("QUESTIONS_TITLE"));
      String questions_content = (String) (req.getParameter("QUESTIONS_CONTENT"));

      req.setAttribute("questions_num", questions_num);
      req.setAttribute("questions_title", questions_title);
      req.setAttribute("questions_content", questions_content);
      return "page/qaPage_update";

   }

   // 게시판 수정
   @RequestMapping(value = "/qaPage_update.do", method = RequestMethod.POST)
   public String qaUpdate(HttpServletRequest req, Questions vo) {
      String userId = SessionUtil.getUserId(req);
      service.updateQaData(req, userId, vo);

      return "redirect:/qaPage.do";

   }

   // 게시판 삭제하기
   @RequestMapping(value = "/qaPage_remove.do", method = RequestMethod.POST)
   public String remove(HttpServletRequest req, Questions vo) {
      String questions_num = (String) req.getParameter("questions_num");
      String resultMsg = "";
      if (service.removeQnaData(questions_num)) {
         resultMsg = "삭제되었습니다.";
      } else {
         resultMsg = "실패하였습니다.\n다시 시도하여 주시기 바랍니다.";
      }
      req.setAttribute("resultMsg", resultMsg);
      return "redirect:/qaPage.do";
   }

}