package kr.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.project.entity.Pets;

public interface PetMapper {

	/* 동물 목록*/
	public List<Pets> petList(@Param("USER_ID") String userId);
	
	public void register(Pets vo);
}