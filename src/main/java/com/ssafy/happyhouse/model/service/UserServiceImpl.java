package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.Alarm;
import com.ssafy.happyhouse.model.dto.User;
import com.ssafy.happyhouse.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(String id, String password) throws SQLException {
		User selected = userMapper.select(id);
		if(selected == null || !selected.getPassword().equals(password)) {
			return null;
		}
		return selected;
	}
	
	
	// ---------------- 기본 CRUD -------------------
	@Override
	public boolean insert(User user) throws SQLException {
		return userMapper.insert(user) == 1;
	}

	@Override
	public boolean update(User user) throws SQLException {
		return userMapper.update(user) == 1;
	}

	@Override
	public boolean delete(String id) throws SQLException {
		return userMapper.delete(id) == 1;
	}

	@Override
	public User select(String id) throws SQLException {
		return userMapper.select(id);
	}
	// ---------------- 기본 CRUD: END -------------------


	@Override
	public List<Alarm> selectAlarm(String userId) throws SQLException {
		return userMapper.selectAlarm(userId);
	}

}
