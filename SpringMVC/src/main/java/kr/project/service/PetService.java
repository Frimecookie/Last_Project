package kr.project.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.project.entity.Pets;
import kr.project.mapper.PetMapper;

@Service
public class PetService {
	
	@Autowired PetMapper mapper;
	
	public void insertPetData(HttpServletRequest req, String userId, Pets vo) {
		vo.setUSER_ID(userId);
		System.out.println(vo);
		mapper.register(vo);
	}

}
