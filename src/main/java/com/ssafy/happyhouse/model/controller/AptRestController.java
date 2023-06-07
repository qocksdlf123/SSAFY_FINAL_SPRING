package com.ssafy.happyhouse.model.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.AptInfo;
import com.ssafy.happyhouse.model.dto.Stats;
import com.ssafy.happyhouse.model.service.AptService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Slf4j
public class AptRestController {
	
	@Autowired
	private AptService aptService;
	
	// dongCode like로 비교
	@GetMapping("/apt/{dongCode}")
	public ResponseEntity<Map<String, Object>> selectApt(@PathVariable String dongCode){
		try {
			List<AptInfo> list = aptService.selectApt(dongCode);
			log.debug("selectApt: {}", list.size());
			return handleSuccess(list);
		}catch (Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	// 통계정보 가져오기
	@GetMapping("/apt/stats/{aptCode}")
	public ResponseEntity<Map<String, Object>> selectStats(@PathVariable long aptCode){
		try {
			return handleSuccess(aptService.selectStats(aptCode));
		}catch(Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	
	
	// 작업 성공시 리턴 객체
	private ResponseEntity<Map<String, Object>> handleSuccess(Object data){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("success", true);
		resultMap.put("data", data);
		return new ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.OK);
	}
	
	// 작업 실패시 리턴 객체
	private ResponseEntity<Map<String, Object>> handleException(Exception e){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("success", false);
		resultMap.put("data", e.getMessage());
		return new ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
