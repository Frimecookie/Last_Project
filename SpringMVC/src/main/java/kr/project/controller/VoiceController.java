package kr.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.project.entity.Voices;
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
		List<Voices> voiceList = mapper.voiceList(userId);
		System.out.println(voiceList);
		req.setAttribute("voiceList", voiceList);
		return "page/myPage_voice";
	}
	
	@RequestMapping(value = "/voiceselect.do")
	public String insertVoiceFile(HttpServletRequest req, Voices vo) {
		String userId = SessionUtil.getUserId(req);
		service.insertVoiceData(req, userId, vo);
		
		return "redirect:/voicePage.do";
		
	}
}
