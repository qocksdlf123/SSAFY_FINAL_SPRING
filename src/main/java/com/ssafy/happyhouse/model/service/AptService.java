package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.AptInfo;
import com.ssafy.happyhouse.model.dto.Stats;

public interface AptService {
	
	public List<AptInfo> selectApt(String code) throws SQLException;
	
	public List<Stats> selectStats(long aptCode) throws SQLException;

}
