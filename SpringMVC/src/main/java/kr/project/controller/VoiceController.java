package kr.project.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.project.entity.Voices;
import kr.project.mapper.VoiceMapper;
import kr.project.service.VoiceService;
import kr.project.utils.SessionUtil;

@Controller
public class VoiceController {
    
	@Autowired private VoiceMapper mapper;
	@Autowired VoiceService service;
	@Autowired private HttpServletRequest req;
	@Resource(name="uploadPath")String uploadPath;
	
	
	@RequestMapping("/myPage_voice.do")
	public String petList(HttpServletRequest req) {
		String u_Id = SessionUtil.getUserId(req);
		List<Voices> voiceList = mapper.voiceList(u_Id);
		System.out.println(voiceList);
		req.setAttribute("voiceList", voiceList);
		return "page/myPage_voice";
	}
	
	@RequestMapping("/uploadFile")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,HttpServletRequest req, Model model) {
	  // Save the file to disk
	  
	  Path filePath = Paths.get("/Project/src/main/webapp/resources/voice", file.getOriginalFilename());
	  String u_Id = SessionUtil.getUserId(req);
	  // Save the file path to the database
	  Voices audioFile = new Voices();
	  audioFile.setFile_Path(filePath.toString());
	  audioFile.setU_id(u_Id);
	  service.saveAudioFile(audioFile);

	  // Add a success message to the model
	  model.addAttribute("message", "File uploaded successfully");

	  return "redirect:/myPage_voice.do";
	}

}
