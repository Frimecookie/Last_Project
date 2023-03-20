package kr.project.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import kr.project.entity.Voices;
import kr.project.mapper.VoiceMapper;
import kr.project.service.VoiceService;
import kr.project.utils.SessionUtil;

@Controller
public class VoiceController {

	@Autowired
	private VoiceMapper mapper;
	@Autowired
	VoiceService service;
	@Autowired
	private HttpServletRequest req;
	@Resource(name = "uploadPath")
	String uploadPath;

	@RequestMapping("/myPage_voice.do")
	public String voiceList(Model model) {
		if(SessionUtil.isNoneSession(req)) {
			return "page/loginPage";
		}
		String userId = SessionUtil.getUserId(req);
		List<Voices> voiceList = mapper.voiceList(userId);
//		System.out.println(voiceList);
		model.addAttribute("voiceList", voiceList);
		System.out.println("실행되었음");
		/*
		 * try { Thread.sleep(1000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		
		return "page/myPage_voice";
	}
	@RequestMapping("/voicedelete.do")
	public String voiceDelete(int voice_num) {
		System.out.println(voice_num);
		service.voicedelete(voice_num);
		return "redirect:/myPage_voice.do";
		
	}

	@RequestMapping("/uploadFile.do")
	public String handleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest req, Model model) {
		// Save the file to disk
		Path filePath = Paths.get("C:\\Users\\smhrd\\git\\Last_project\\SpringMVC\\src\\main\\webapp\\resources\\voice", file.getOriginalFilename());
		
		String userId = SessionUtil.getUserId(req);
		try {
			byte[] bytes = file.getBytes();
	        Files.createDirectories(filePath.getParent());
			Files.write(filePath, file.getBytes());
		} catch (IOException e) {
			// Handle the exception
			e.printStackTrace();
		}
		String serverPath = "http://localhost:8081/Project/resources/voice/"+file.getOriginalFilename();
		// Save the file path to the database
		Voices audioFile = new Voices();
		audioFile.setFile_path(serverPath);
		audioFile.setUser_id(userId);
		service.saveAudioFile(audioFile);

		// Add a success message to the model
		model.addAttribute("message", "File uploaded successfully");

		return "redirect:/myPage_voice.do";
	}

}
