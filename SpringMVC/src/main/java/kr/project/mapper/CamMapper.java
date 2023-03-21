package kr.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.project.entity.Cams;
import kr.project.entity.Pets;
import kr.project.entity.Records;

public interface CamMapper {

	/*위험물체 카운트 */
	public List<Records> recordsList(@Param("cams_num") int CAMS_NUM);
	
	
	public void register(Records vo);

	public void cams(String userId);
}