package kr.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.project.entity.Questions;

public interface QuestionMapper {
	
	public List<Questions> qnaList(@Param("USER_ID") String userId);
	
	public void write(Questions vo);
}
