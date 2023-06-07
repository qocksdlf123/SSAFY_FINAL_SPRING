package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.AptInfo;
import com.ssafy.happyhouse.model.dto.Stats;
import com.ssafy.happyhouse.model.mapper.AptMapper;

@Service
public class AptServiceImpl implements AptService{
	
	@Autowired
	private AptMapper aptMapper;
	
	@Override
	public List<AptInfo> selectApt(String code) throws SQLException {
		String dongCode = code;
		if(code.substring(5, 10).equals("00000")) {
			dongCode = code.substring(0, 5) + "%";
		}
		return aptMapper.selectApt(dongCode);
	}

	@Override
	public List<Stats> selectStats(long aptCode) throws SQLException {
		return aptMapper.selectStats(aptCode);
	}

}
