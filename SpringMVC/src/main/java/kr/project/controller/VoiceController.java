package kr.project.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	
	@RequestMapping("/myPage_voice.do")
	public String petList(HttpServletRequest req) {
		String userId = SessionUtil.getUserId(req);
		List<Voices> voiceList = mapper.voiceList(userId);
		System.out.println(voiceList);
		req.setAttribute("voiceList", voiceList);
		return "page/myPage_voice";
	}
	
	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file, Voices voice) throws IOException {
		  // process the uploaded file here
		  // you can use the commons-io library to write the file to disk, like so:
		  String filePath = "/path/to/save/directory/" + file.getOriginalFilename();
		  FileUtils.writeByteArrayToFile(new File(filePath), file.getBytes());
		  
		  saveFileDetails(file.getOriginalFilename(), filePath);
		  
		  // save the file path in a database or file system
		  saveFilePath(filePath);

		  return "uploadForm";
		}

	private void saveFilePath(String filePath) {
		  // save the file path in a database or file system
		  // for example, you could write the path to a text file like this:
		  try {
		    FileWriter writer = new FileWriter("filePaths.txt", true);
		    writer.write(filePath + "\n");
		    writer.close();
		  } catch (IOException e) {
		    e.printStackTrace();
		  }
		}
	private void saveFileDetails(String fileName, String filePath) {
		  // create a connection to the database
		  try {
		    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "username", "password");

		    // create a prepared statement to insert the file details into the database
		    PreparedStatement statement = connection.prepareStatement("INSERT INTO file_details (file_name, file_path) VALUES (?, ?)");
		    statement.setString(1, fileName);
		    statement.setString(2, filePath);
		    statement.executeUpdate();

		    // close the statement and connection
		    statement.close();
		    connection.close();
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
		}
}
