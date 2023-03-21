package kr.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.project.entity.Pets;

public interface PetMapper {

	/* 사용자가 등록한 동물 정보 */
	public List<Pets> petList(@Param("user_id") String userId);
	
	// 동물 정보 
	public Pets getPetData(@Param("pet_num") String pet_num);
	
	// 동물 업로드 이미지 가져오기 
	@Select("SELECT INTERNAL_IMGPATH FROM PETS WHERE PET_NUM = #{pet_num}")
	public String getCurrentImgPath(@Param("pet_num") String pet_num);
	
	// 등록하기
	public void register(Pets vo); 
	
	// 수정하기
	public void correct(Pets vo); 
	
	// 동물정보 삭제 
	public int remove(@Param("pet_num") String pet_num);
}