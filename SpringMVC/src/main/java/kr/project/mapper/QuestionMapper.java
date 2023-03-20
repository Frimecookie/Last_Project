package kr.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.project.entity.Questions;

public interface QuestionMapper {
	
	public List<Questions> qnaList(@Param("USER_ID") String userId);
	
	public Questions getQaData(@Param("questionsNum") String questionsNum);
	
	public void write(Questions vo);
	
	public void modify(Questions vo);
	
	public int remove(@Param("questionsNum") String questionsNum);
}
