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
   
   // 문의글 등록 
   public void insertQaData(HttpServletRequest req, String userId, Questions vo) {
      vo.setUser_id(userId);
      System.out.println(vo);
      mapper.write(vo);
   }
   
   // 문의글 수정
   public void updateQaData(HttpServletRequest req, String userId, Questions vo) {
      vo.setUser_id(userId);
      System.out.println(vo);
      String questions_num = String.valueOf(vo.getQuestions_num());
      mapper.modify(vo);
   }
   
   // 문의글 불러오기 
   public Questions getQaData(String questions_num) {
      return mapper.getQaData(questions_num);
   }
   
   // 문의글 삭제 
   public boolean removeQnaData(String questions_num) {
      
      int delCnt = mapper.remove(questions_num);
      if(delCnt > 0) {
         return true;
      } else {
         return false;
      }
   }
}