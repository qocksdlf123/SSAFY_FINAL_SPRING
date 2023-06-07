package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.AptInfo;
import com.ssafy.happyhouse.model.dto.Stats;

@Mapper
public interface AptMapper {
	
	public List<AptInfo> selectApt(String dongCode) throws SQLException;
	
	public List<Stats> selectStats(long aptCode) throws SQLException;
}
