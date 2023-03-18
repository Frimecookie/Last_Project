package kr.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import kr.project.entity.Voices;

public interface VoiceMapper {

	public List<Voices> voiceList(@Param("U_ID") String u_Id);
	
	public void save(Voices audioFile);
}