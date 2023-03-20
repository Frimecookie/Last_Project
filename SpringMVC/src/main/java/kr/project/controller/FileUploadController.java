package kr.project.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.project.service.FileUploadService;

@Controller
@RequestMapping("/file")
public class FileUploadController {
	
	@Autowired FileUploadService service;
	
	@RequestMapping(value = "/uploadImgFile.do", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> uploadImgFile(MultipartHttpServletRequest req) {
		return service.uploadFile(req);
	}
}