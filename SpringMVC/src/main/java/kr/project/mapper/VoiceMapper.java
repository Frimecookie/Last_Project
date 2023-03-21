package kr.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import kr.project.entity.Voices;

public interface VoiceMapper {
	
	// voice리스트 가져오기 
	public List<Voices> voiceList(@Param("user_id") String userId);
	
	// 음성파일 저장하기
	public void save(Voices audioFile);
	
	// 음성파일 삭제하기
	@Delete("delete from voices where VOICE_NUM = #{voice_num}")
	public void voicedelete(int voice_num);
}	