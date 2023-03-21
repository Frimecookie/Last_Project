package kr.project.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.project.entity.Pets;
import kr.project.mapper.PetMapper;

@Service
public class PetService {
	
	@Autowired PetMapper mapper;
	
	public void insertPetData(HttpServletRequest req, String userId, Pets vo) {
		vo.setUser_id(userId);
		System.out.println(vo);
		mapper.register(vo);
	}
	
	public void updatePetData(HttpServletRequest req, String userId, Pets vo) {
		vo.setUser_id(userId);
		System.out.println("vo : "+vo);
		Pets pvo = (Pets) req.getAttribute("vo");
		System.out.println("pvo : "+pvo.toString());
		String pet_num = String.valueOf(vo.getPet_num());
		// 이전 이미지를 지우는 로직 시작
		String imgPath = vo.getINTERNAL_IMGPATH();	// 새로 들어온 이미지패스
		String preImgPath = mapper.getCurrentImgPath(pet_num);	// 기존에 있던 이미지 패스
		
		// 새로 들어온 이미지패스와 기존 이미지 패스가 다르다면 기존 이미지를 삭제 한다.
		if(!imgPath.equals(preImgPath)) {
			File imgFile = new File(preImgPath);
			if(imgFile.exists()) {	// 해당 경로에 파일이 있다면
				imgFile.delete();	// 삭제
			}
		}
		
		// 수정 실행
		mapper.correct(vo);
	}
	
	public Pets getPetData(String pet_num) {
		return mapper.getPetData(pet_num);
	}
	
	public boolean removePetData(String pet_num) {
		String imgPath = mapper.getCurrentImgPath(pet_num);
		
		// 로직이 잘못되어 이미지파일이 null 이라면 이미지파일 체크는 그냥 패스하고 바로 데이터를 삭제한다.
		if(null != imgPath) {
			File imgFile = new File(imgPath);
			
			// 데이터를 지우기전에 먼저 이미지파일이 있는지 확인한다.
			if(imgFile.exists()) {
				if(!imgFile.delete()) {	// 이미지 파일이 삭제 되지 않았다면 데이터도 삭제 하지말고 그냥 false를 리턴한다.
					return false;
				}
			}
		}
		
		// 이미지 파일이 삭제 되었다면 데이터도 삭제한다.
		int delCnt = mapper.remove(pet_num);
		if(delCnt > 0) {
			return true;
		} else {
			return false;
		}
	}
}
