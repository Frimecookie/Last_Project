package kr.project.entity;

import lombok.Data;

@Data
public class Cams {
	private int cams_num; //카메라 고유 번
	private String user_id; //유전 아이디
	private String cams_url; //경로
}
