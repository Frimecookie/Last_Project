package kr.project.entity;

import lombok.Data;
import lombok.ToString;
import oracle.sql.TIMESTAMP;

@Data
@ToString
public class Voices {
	private String user_id; //사용자 id
	private int voice_num; // 음성파일 번호
    private String file_path; // 음성파일 경로 
    private TIMESTAMP created_at; // 생성시간 
	
}
