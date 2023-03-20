package kr.project.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.project.entity.Questions;
import kr.project.mapper.QuestionMapper;

@Service
public class QuestionService {
	
	@Autowired QuestionMapper mapper;
	
	public void insertQaData(HttpServletRequest req, String userId, Questions vo) {
		vo.setUSER_ID(userId);
		System.out.println(vo);
		mapper.write(vo);
	}
	
	public void updateQaData(HttpServletRequest req, String userId, Questions vo) {
		vo.setUSER_ID(userId);
		System.out.println(vo);
		String questionsNum = String.valueOf(vo.getQUESTIONS_NUM());
		mapper.modify(vo);
	}
	
	public Questions getQaData(String questionsNum) {
		return mapper.getQaData(questionsNum);
	}
	
	public boolean removeQnaData(String questionsNum) {
		
		int delCnt = mapper.remove(questionsNum);
		if(delCnt > 0) {
			return true;
		} else {
			return false;
		}
	}
}
