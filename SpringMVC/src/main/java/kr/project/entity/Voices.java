package kr.project.entity;

import lombok.Data;
import lombok.ToString;
import oracle.sql.TIMESTAMP;

@Data
@ToString
public class Voices {
	private String USER_ID;
	private int VOICE_NUM;
    private String FILE_PATH;
    private TIMESTAMP CREATED_AT;
	// 생성자, getter, setter 생략
	
}
