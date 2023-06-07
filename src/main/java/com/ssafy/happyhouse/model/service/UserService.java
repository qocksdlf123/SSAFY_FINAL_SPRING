package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.Alarm;
import com.ssafy.happyhouse.model.dto.User;

public interface UserService {
	
	public User login(String id, String password) throws SQLException;
	
	public User select(String id) throws SQLException;
	
	public boolean insert(User user) throws SQLException;
	
	public boolean update(User user) throws SQLException;
	
	public boolean delete(String id) throws SQLException;
	
	public List<Alarm> selectAlarm(String userId) throws SQLException;
}
