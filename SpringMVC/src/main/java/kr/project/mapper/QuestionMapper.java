package kr.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.project.entity.Questions;

public interface QuestionMapper {
   
	// 문의 목록 불러오기
   public List<Questions> qnaList(@Param("user_id") String userId);
   
    // 사용자 문의 목록
   public Questions getQaData(@Param("questions_num") String questions_num);
   
   // 문의글 작성 
   public void write(Questions vo);
   
   // 문의글 수정 
   public void modify(Questions vo);
   
   // 문의글 삭제 
   public int remove(@Param("questions_num") String questionsNum);
}