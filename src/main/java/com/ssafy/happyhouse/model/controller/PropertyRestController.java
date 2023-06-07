package com.ssafy.happyhouse.model.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.Property;
import com.ssafy.happyhouse.model.service.PropertyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Slf4j
public class PropertyRestController {
	
	@Autowired
	private PropertyService propertyService;
	
	@GetMapping("/property/no/{no}")
	public ResponseEntity<Map<String, Object>> selectByNo(@PathVariable long no){
		try {
			return handleSuccess(propertyService.selectByNo(no));
		}catch(Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	@GetMapping("/property/aptcode/{aptCode}")
	public ResponseEntity<Map<String, Object>> selectByAptCode(@PathVariable long aptCode){
		try {
			return handleSuccess(propertyService.selectByAptCode(aptCode));
		}catch(Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	@GetMapping("/property/userid/{userId}")
	public ResponseEntity<Map<String, Object>> selectByUserId(@PathVariable String userId){
		try {
			return handleSuccess(propertyService.selectByUserId(userId));
		}catch(Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	@PostMapping("/property")
	public ResponseEntity<Map<String, Object>> insert(@RequestBody Property property){
		try {
			return handleSuccess(propertyService.insert(property));
		}catch(Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	@PutMapping("/property")
	public ResponseEntity<Map<String, Object>> update(@RequestBody Property property){
		try {
			return handleSuccess(propertyService.update(property));
		}catch(Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	@DeleteMapping("/property/{no}")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable long no){
		try {
			return handleSuccess(propertyService.delete(no));
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
