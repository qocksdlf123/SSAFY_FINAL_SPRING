package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.Property;

public interface PropertyService {
	
public Property selectByNo(long no) throws SQLException;
	
	public List<Property> selectByAptCode(long aptCode) throws SQLException;
	
	public List<Property> selectByUserId(String userId) throws SQLException;
	
	public boolean insert(Property property) throws SQLException;
	
	public boolean update(Property property) throws SQLException;
	
	public boolean delete(long no) throws SQLException;
}
