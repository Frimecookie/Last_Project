package kr.project.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.project.entity.Voice;

public interface VoiceMapper {
	
	public List<Voice> voiceList(@Param("USER_ID") String userId);
	
	public void insertVoiceFile(Voice vo);

}