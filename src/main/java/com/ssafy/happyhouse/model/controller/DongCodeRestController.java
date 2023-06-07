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

import com.ssafy.happyhouse.model.dto.DongCode;
import com.ssafy.happyhouse.model.service.DongCodeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Slf4j
public class DongCodeRestController {
	
	@Autowired
	private DongCodeService dongCodeService;
	
	// code가 주어지면 조건에 맞게 결과값 리턴
	@GetMapping("/dongcode/{code}")
	public ResponseEntity<Map<String, Object>> selectLike(@PathVariable String code){
		try {
			List<DongCode> list = dongCodeService.selectLike(code);
			log.debug("selectLike: {}", list.size());
			return handleSuccess(list);
		}catch (Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	// 동코드가 주어지면 단일 정보 반환
	@GetMapping("/dongcode/one/{dongCode}")
	public ResponseEntity<Map<String, Object>> selectEquals(@PathVariable String dongCode){
		try {
			DongCode selected = dongCodeService.selectEquals(dongCode);
			log.debug("selectEquals: {}", selected);
			return handleSuccess(selected);
		}catch (Exception e) {
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
