package kr.project.entity;

import lombok.Data;
import lombok.ToString;
import oracle.sql.TIMESTAMP;

@Data
@ToString
public class Voices {
	private String user_id;
	private int voice_num;
    private String file_path;
    private TIMESTAMP created_at;
	// 생성자, getter, setter 생략
	
}
