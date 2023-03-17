package kr.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.project.entity.Pets;
import kr.project.entity.Voice;
import kr.project.mapper.VoiceMapper;
import kr.project.service.VoiceService;
import kr.project.utils.SessionUtil;

@Controller
public class VoiceController {
    
	@Autowired private VoiceMapper mapper;
	@Autowired VoiceService service;
	
	@RequestMapping("/myPage_voice.do")
	public String petList(HttpServletRequest req) {
		String userId = SessionUtil.getUserId(req);
		List<Voice> voiceList = mapper.voiceList(userId);
		System.out.println(voiceList);
		req.setAttribute("voicelist", voiceList);
		return "page/myPage_voice";
	}
	
	@RequestMapping(value = "/myPage_voice.do")
	public String insertVoiceFile(HttpServletRequest req, Voice vo) {
		String userId = SessionUtil.getUserId(req);
		service.insertVoiceData(req, userId, vo);
		
		return "redirect:/voicePage.do";
		
	}
}
