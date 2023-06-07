package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.Property;

@Mapper
public interface PropertyMapper {
	public Property selectByNo(long no) throws SQLException;
	
	public List<Property> selectByAptCode(long aptCode) throws SQLException;
	
	public List<Property> selectByUserId(String userId) throws SQLException;
	
	public int insert(Property property) throws SQLException;
	
	public int update(Property property) throws SQLException;
	
	public int delete(long no) throws SQLException;
}
