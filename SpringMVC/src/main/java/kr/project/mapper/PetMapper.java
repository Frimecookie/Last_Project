package kr.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.project.entity.Pets;

public interface PetMapper {

	/* 동물 목록*/
	public List<Pets> petList(@Param("user_id") String userId);
	
	public Pets getPetData(@Param("pet_num") String pet_num);
	
	@Select("SELECT INTERNAL_IMGPATH FROM PETS WHERE PET_NUM = #{pet_num}")
	public String getCurrentImgPath(@Param("pet_num") String pet_num);
	
	public void register(Pets vo); //등록하기
	
	public void correct(Pets vo); //수정하기
	
	public int remove(@Param("pet_num") String pet_num);
}