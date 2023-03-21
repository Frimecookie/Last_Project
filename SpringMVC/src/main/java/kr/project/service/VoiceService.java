package kr.project.service;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.project.entity.Pets;
import kr.project.entity.Voices;
import kr.project.mapper.VoiceMapper;
import kr.project.utils.SessionUtil;

@Service
public class VoiceService {
	
    @Autowired
    private VoiceMapper mapper;
    
    // 음성파일 저장 
    public void saveAudioFile(Voices audioFile) {
    	System.out.println(audioFile.getFile_path());
		mapper.save(audioFile);
	}
    
    // 음성파일 삭제 
    public void voicedelete(int voice_num) {
    	mapper.voicedelete(voice_num);
    }
}