package kr.project.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Records {
	private int RECORDS_NUM; // 기록 번호
	private int CAMS_NUM; // 카메라 고유번호
	private Date RECORDS_DATE; // 발생 일시
	private String RECORDS_OBJECT; // 접근 물체
}
