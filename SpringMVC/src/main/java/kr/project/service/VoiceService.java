package kr.project.service;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.project.entity.Voice;
import kr.project.mapper.VoiceMapper;

@Service
public class VoiceService {
	
    @Autowired
    private VoiceMapper mapper;

    public void insertVoiceData(HttpServletRequest req, String userId, Voice vo) {
    		vo.setUSER_ID(userId);
    		System.out.println(vo);
    		mapper.insertVoiceFile(vo);
    }
}