package kr.project.entity;

import lombok.Data;
import lombok.ToString;
import oracle.sql.TIMESTAMP;

@Data
public class Voices {
	private String u_id;
	private Integer voice_num;
    private String file_Path;
    private TIMESTAMP createdAt;
	// 생성자, getter, setter 생략
	
}
