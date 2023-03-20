package kr.project.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Records {
	private int records_num; // 기록 번호
	private int cams_num; // 카메라 고유번호
	private Date records_date; // 발생 일시
	private String records_object; // 접근 물체
	private int cnt;
}
