package kr.project.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Pets {
	private int pet_num; //반려동물 고유번호
	private String pet_name; //반려동물 이름
	private String pet_picture; //반려동물 사진
	private String user_id; // 사용자 아이디
	private int pet_cate; // 반려동물 구분
	private int pet_age; // 반려동물 나이
	private String pet_gender; // 반려동물 성별
	private String INTERNAL_IMGPATH; // 서버에 저장된 실제 이미지 경로
}
