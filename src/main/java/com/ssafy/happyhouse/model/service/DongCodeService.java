package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.DongCode;

public interface DongCodeService {
	
	public List<DongCode> selectLike(String code) throws SQLException;
	
	public DongCode selectEquals(String dongCode) throws SQLException;
}
