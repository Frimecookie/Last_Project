package kr.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import kr.project.entity.Voices;

public interface VoiceMapper {

	public List<Voices> voiceList(@Param("USER_ID") String userId);
	
	public void save(Voices audioFile);
	
	@Delete("delete from voices where VOICE_NUM = #{voice_num}")
	public void voicedelete(int voice_num);
}