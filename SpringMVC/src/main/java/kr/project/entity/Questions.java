package kr.project.entity;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Questions {
	private int questions_num; // 질문 번호
	private String user_id; //유저 아이디
	private String questions_title; //질문 제목
	private String questions_content; //질문 내용
	private Date questions_date ; // 작성 일
}
