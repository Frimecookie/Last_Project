package kr.project.entity;

import lombok.Data;
import lombok.ToString;
import oracle.sql.TIMESTAMP;

@Data
@ToString
public class Voice {
	private String USER_ID;
	private Integer VOICE_NUM;
    private String filePath;
    private TIMESTAMP createdAt;
	// 생성자, getter, setter 생략
	
}
