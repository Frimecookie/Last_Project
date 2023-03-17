package kr.project.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Pets {
	private int PET_NUM; //반려동물 고유번호
	private String PET_NAME; //반려동물 이름
	private String PET_PICTURE; //반려동물 사진
	private String USER_ID; // 사용자 아이디
	private int PET_CATE; // 반려동물 구분
	private int PET_AGE; // 반려동물 나이
	private String PET_GENDER; // 반려동물 성별
}
