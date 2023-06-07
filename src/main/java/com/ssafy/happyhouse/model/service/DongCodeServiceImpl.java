package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.DongCode;
import com.ssafy.happyhouse.model.mapper.DongCodeMapper;

@Service
public class DongCodeServiceImpl implements DongCodeService{
	
	@Autowired
	private DongCodeMapper dongCodeMapper;
	
	@Override
	public List<DongCode> selectLike(String code) throws SQLException {
		// where like 조건을 위한 처리
		StringBuilder convertedCode = new StringBuilder();
		String sidoCode = code.substring(0, 2);
		String gugunCode = code.substring(2, 5);
		String dongCode = code.substring(5);
		int startIdx = 1;
		
		if(sidoCode.equals("00")) {
			convertedCode.append("%00000000");
			startIdx = 0;
		}else if(gugunCode.equals("000")){
			convertedCode.append(sidoCode).append('%').append(dongCode);
		}else if(dongCode.equals("00000")) {
			convertedCode.append(sidoCode).append(gugunCode).append('%');
		}else {
			convertedCode.append(code);
		}
		
		List<DongCode> list = dongCodeMapper.selectLike(convertedCode.toString());
		
		return list.subList(startIdx, list.size());
	}

	@Override
	public DongCode selectEquals(String dongCode) throws SQLException {
		return dongCodeMapper.selectEquals(dongCode);
	}

}
