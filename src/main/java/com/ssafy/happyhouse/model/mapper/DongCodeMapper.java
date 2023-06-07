package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.DongCode;

@Mapper
public interface DongCodeMapper {
	public List<DongCode> selectLike(String dongCode) throws SQLException;
	
	public DongCode selectEquals(String dongCode) throws SQLException;
}
