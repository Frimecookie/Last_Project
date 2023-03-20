package kr.project.mapper;

import org.apache.ibatis.annotations.Update;

import kr.project.entity.Users;

public interface MyMapper {

	public Users getUserInfo(String user_id);
	
	@Update("update users set user_pnum = #{user_pnum} where user_id = #{user_id}")
	public void pnumUpdate(Users vo);
}
