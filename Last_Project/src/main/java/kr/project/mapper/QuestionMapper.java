package kr.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.project.entity.Questions;

public interface QuestionMapper {
   
   public List<Questions> qnaList(@Param("user_id") String userId);
   
   public Questions getQaData(@Param("questions_num") String questions_num);
   
   public void write(Questions vo);
   
   public void modify(Questions vo);
   
   public int remove(@Param("questions_num") String questions_num);
}