package kr.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping("/qaPage.do")  
	public String qnaList(HttpServletRequest req){
		String userId = SessionUtil.getUserId(req);
		List<Questions> qnaList = mapper.qnaList(userId);
		System.out.println(qnaList+"\n");
		req.setAttribute("qnalist", qnaList);
		return "page/qaPage";
	}
	
	@RequestMapping(value = "/qaPage_write.do", method = RequestMethod.POST)
	public String write(HttpServletRequest req, Questions vo) {
		String userId = SessionUtil.getUserId(req);
		service.insertQuaData(req, userId, vo);
		
		return "redirect:/qaPage.do";
	}
}
