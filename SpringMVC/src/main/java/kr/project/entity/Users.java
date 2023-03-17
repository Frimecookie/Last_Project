package kr.project.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Users {
	private String USER_ID; // 사용자 아이디
	private String USER_PW; // 사용자 비밀번호
	private String USER_NAME; //사용자 이름
	private String USER_PNUM; //사용자 전화번호
}
