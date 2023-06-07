package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.Alarm;
import com.ssafy.happyhouse.model.dto.User;

@Mapper
public interface UserMapper {
	
	public User select(String id) throws SQLException;
	
	public int insert(User user) throws SQLException;
	
	public int update(User user) throws SQLException;
	
	public int delete(String id) throws SQLException;
	
	public List<Alarm> selectAlarm(String userId) throws SQLException;
}
