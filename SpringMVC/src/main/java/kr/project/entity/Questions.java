package kr.project.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Questions {
	private int QUESTIONS_NUM; // 질문 번호
	private String USER_ID; //유저 아이디
	private String QUESTIONS_TITLE; //질문 제목
	private String QUESTIONS_CONTENT; //질문 내용
	private Date QUESTIONS_DATE ; // 작성 일
}
