package kr.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.project.entity.Records;

public interface RecordMapper {
	
	// 위험물체 저장 정보 불러오기
	@Select("select records_object, count(records_object) as cnt from records group by records_object")
	public List<Records> getRecList();

}
