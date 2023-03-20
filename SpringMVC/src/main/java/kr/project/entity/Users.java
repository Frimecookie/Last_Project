package kr.project.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Users {
	private String user_id; // 사용자 아이디
	private String user_pw; // 사용자 비밀번호
	private String user_name; //사용자 이름
	private String user_pnum; //사용자 전화번호
}
