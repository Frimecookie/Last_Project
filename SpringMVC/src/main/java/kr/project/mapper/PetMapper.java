package kr.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.project.entity.Pets;

public interface PetMapper {

	/* 동물 목록*/
	public List<Pets> petList(@Param("USER_ID") String userId);
	
	public Pets getPetData(@Param("petNum") String petNum);
	
	@Select("SELECT INTERNAL_IMGPATH FROM PETS WHERE PET_NUM = #{petNum}")
	public String getCurrentImgPath(@Param("petNum") String petNum);
	
	public void register(Pets vo); //등록하기
	
	public void correct(Pets vo); //수정하기
	
	public int remove(@Param("petNum") String petNum);
}