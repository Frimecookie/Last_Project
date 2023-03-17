package kr.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.project.entity.Pets;
import kr.project.mapper.PetMapper;
import kr.project.service.PetService;
import kr.project.utils.SessionUtil;

@Controller
public class PetController {
	
	@Autowired private PetMapper mapper;
	@Autowired PetService service;
	
	@RequestMapping("/petPage.do")
	public String petList(HttpServletRequest req) {
		String userId = SessionUtil.getUserId(req);
		List<Pets> petList = mapper.petList(userId);
		System.out.println(petList);
		req.setAttribute("petlist", petList);
		return "page/petPage";
	}
	
	
	@RequestMapping(value = "/petPage_regi.do", method = RequestMethod.POST)
	public String register(HttpServletRequest req, Pets vo) {
		String userId = SessionUtil.getUserId(req);
		service.insertPetData(req, userId, vo);
		
		return "redirect:/petPage.do";
	}
	
}