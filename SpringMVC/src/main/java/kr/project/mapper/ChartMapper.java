package kr.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.project.entity.Pets;

public interface ChartMapper {

	/* 동물 목록*/
	public List<Records> recordsList(@Param("CAMS_NUM") int CAMS_NUM);
	
	public void register(Pets vo);
}