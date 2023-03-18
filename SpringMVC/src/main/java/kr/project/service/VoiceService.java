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
    
    public void saveAudioFile(Voices audioFile) {
    	System.out.println(audioFile.getFile_Path());
		mapper.save(audioFile);
	}

	
}
