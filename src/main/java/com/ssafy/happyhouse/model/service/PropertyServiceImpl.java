package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.Property;
import com.ssafy.happyhouse.model.mapper.PropertyMapper;

@Service
public class PropertyServiceImpl implements PropertyService{
	
	@Autowired
	private PropertyMapper propertyMapper;

	@Override
	public Property selectByNo(long no) throws SQLException {
		return propertyMapper.selectByNo(no);
	}

	@Override
	public List<Property> selectByAptCode(long aptCode) throws SQLException {
		return propertyMapper.selectByAptCode(aptCode);
	}

	@Override
	public List<Property> selectByUserId(String userId) throws SQLException {
		return propertyMapper.selectByUserId(userId);
	}

	@Override
	public boolean insert(Property property) throws SQLException {
		return propertyMapper.insert(property) == 1;
	}

	@Override
	public boolean update(Property property) throws SQLException {
		return propertyMapper.update(property) == 1;
	}

	@Override
	public boolean delete(long no) throws SQLException {
		return propertyMapper.delete(no) == 1;
	}

}
