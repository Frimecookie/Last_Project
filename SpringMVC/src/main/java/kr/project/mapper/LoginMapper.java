package kr.project.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.project.entity.Users;

public interface LoginMapper {

	// 로그인
	@Select("SELECT * FROM USERS WHERE USER_ID = #{userId} AND USER_PW = #{userPw}")
	public Users loginCheck(@Param("userId") String userId, @Param("userPw") String userPw);
}
