package kr.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import kr.project.entity.Voices;

public interface VoiceMapper {

	public List<Voices> voiceList(@Param("USER_ID") String userId);
	
	public void insertVoiceFile(Voices vo);
}