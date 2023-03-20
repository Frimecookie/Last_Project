package kr.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.project.entity.Users;
import kr.project.mapper.MyMapper;
import kr.project.utils.SessionUtil;

@Controller
public class MyController {

	@Autowired
	private MyMapper mapper;
	
	@GetMapping("/myPage.do")
	public String getUserInfo(HttpServletRequest req, String user_id, Model model) {
		System.out.println("asdasd");
		if(SessionUtil.isNoneSession(req)) {
			return "page/loginPage";
		}
		Users vo = mapper.getUserInfo(user_id);
		System.out.println("디비접근");
		model.addAttribute("userInfo", vo);
		System.out.println(vo);
		return "page/myPage";
	}
	
	@PostMapping("/pnumUpdate.do")
	public String pnumUpdate(Users vo) {
		mapper.pnumUpdate(vo);
		return "redirect:/home.do";
	}

}
