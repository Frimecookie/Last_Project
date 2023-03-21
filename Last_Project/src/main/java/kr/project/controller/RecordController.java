package kr.project.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import kr.project.entity.Records;
import kr.project.mapper.RecordMapper;

@Controller
public class RecordController {

	@Autowired
	private RecordMapper mapper;
	
	@RequestMapping("/eventPage.do")
	public String cntDngr(Model model) {
		List<Records> recList = mapper.getRecList();
		
		Gson gson = new Gson();
		JsonArray jArray = new JsonArray();
		
		Iterator<Records> it = recList.iterator();
		while(it.hasNext()) {
			Records cur = it.next();
			JsonObject object = new JsonObject();
			String rec_object = cur.getRecords_object();
			int rec_freq = cur.getCnt();
			
			object.addProperty("rec_object", rec_object);
			object.addProperty("rec_freq", rec_freq);
			jArray.add(object);
		}
		
		String json = gson.toJson(jArray);
		model.addAttribute("json", json);
		
		return "page/eventPage";
	}
	
	
//	@GetMapping("/myPage.do")
//	public String getUserInfo(String user_id, Model model) {
//		Users vo = mapper.getUserInfo(user_id);
//		model.addAttribute("userInfo", vo);
//		return "page/myPage";
//	}
}
