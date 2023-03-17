package kr.project.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.project.entity.Questions;
import kr.project.mapper.QuestionMapper;

@Service
public class QuestionService {
	
	@Autowired QuestionMapper mapper;
	
	public void insertQuaData(HttpServletRequest req, String userId, Questions vo) {
		vo.setUSER_ID(userId);
		System.out.println(vo);
		mapper.write(vo);
	}
	
}
