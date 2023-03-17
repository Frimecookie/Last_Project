package kr.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
	
	@RequestMapping("/{filename}")
	public String home(@PathVariable String filename) {
		return "page/" + filename;
	}
	@RequestMapping(value = "/module/{filename}")
	public String sub(@PathVariable String module, @PathVariable String filename) {
		return "page/" + module + "/" + filename;
	}
}
