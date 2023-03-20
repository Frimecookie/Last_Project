package kr.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.project.entity.Pets;
import kr.project.entity.Users;
import kr.project.mapper.PetMapper;
import kr.project.service.PetService;
import kr.project.utils.SessionUtil;

@Controller
public class PetController {
	
	@Autowired private PetMapper mapper;
	@Autowired PetService service;
	
	// 내 펫 정보 보기
	@RequestMapping("/petPage.do") 
	public String petList(HttpServletRequest req) {
		if(SessionUtil.isNoneSession(req)) {
			return "page/loginPage";
		}
		String userId = SessionUtil.getUserId(req);
		
		List<Pets> petList = mapper.petList(userId);
		System.out.println(petList);
		req.setAttribute("petlist", petList);
		
		return "page/petPage";
	}
	
	//펫 등록하기
	@RequestMapping(value = "/petPage_regi.do", method = RequestMethod.POST)
	public String register(HttpServletRequest req, Pets vo) {
		if(SessionUtil.isNoneSession(req)) {
			return "page/loginPage";
		}
		String userId = SessionUtil.getUserId(req);
		service.insertPetData(req, userId, vo);
		
		return "redirect:/petPage.do";
	}
	
	//수정 페이지 동물 목록
	@RequestMapping("/petPage_correct.do")
	public String petList_c(HttpServletRequest req) {
		if(SessionUtil.isNoneSession(req)) {
			return "page/loginPage";
		}
		String userId = SessionUtil.getUserId(req);
		
		List<Pets> petList = mapper.petList(userId);
		System.out.println(petList);
		req.setAttribute("petlist", petList);
		return "page/petPage_correct";
	}
	
	//수정 전 펫 정보 가져오기
	@RequestMapping(value="/petPage_correct_2.do", method=RequestMethod.GET)
	public String correct(HttpServletRequest req, Pets vo) {
		if(SessionUtil.isNoneSession(req)) {
			return "page/loginPage";
		}
		
		String petNum = String.valueOf(vo.getPET_NUM());
		Pets petData = service.getPetData(petNum);
		req.setAttribute("petData", petData);
		return "page/petPage_correct_2";
		
	}
	
	//수정 후 펫 정보 보내기
	@RequestMapping(value="/petPage_correct_2_update.do", method=RequestMethod.POST)
	public String correctPost(HttpServletRequest req, Pets vo) {
		String userId = SessionUtil.getUserId(req);
		service.updatePetData(req, userId, vo);
		
		return "redirect:/petPage_correct.do";
		
	}
	
	//펫 삭제하기
	@RequestMapping(value="/petPage_remove.do", method=RequestMethod.POST)
	public String remove(HttpServletRequest req, Pets vo) {
		String petNum = String.valueOf(vo.getPET_NUM());
		String resultMsg = "";
		if(service.removePetData(petNum)) {
			resultMsg = "삭제되었습니다.";
		} else {
			resultMsg = "실패하였습니다.\n다시 시도하여 주시기 바랍니다.";
		}
		req.setAttribute("resultMsg", resultMsg);
		return "redirect:/petPage_correct.do";
	}
}