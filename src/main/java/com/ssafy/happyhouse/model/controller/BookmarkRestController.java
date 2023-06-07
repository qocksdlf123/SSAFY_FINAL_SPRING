package com.ssafy.happyhouse.model.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.Bookmark;
import com.ssafy.happyhouse.model.service.BookmarkService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Slf4j
public class BookmarkRestController {
	
	@Autowired
	private BookmarkService bookmarkService;
	
	// 관심매물 아이디별 가져오기
	@GetMapping("/bookmarkById/{userId}")       
	public ResponseEntity<Map<String, Object>> selectById(@PathVariable String userId) {
		try {
			List<Bookmark> list = bookmarkService.selectById(userId);
			log.debug("bookmarkService: {}", list.size());
			return handleSuccess(list);
		}catch (Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	
	// 특정 게시물 가져오기 + 조회수 증가
	@GetMapping("/bookmark/{bookmarkNo}")
	public ResponseEntity<Map<String, Object>> select(@PathVariable int bookmarkNo) {
		try {
			Bookmark selected = bookmarkService.select(bookmarkNo);
			log.debug("select: {}", selected);
			return handleSuccess(selected);
		}catch (Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	@GetMapping("/bookmark/rank")
	public ResponseEntity<Map<String, Object>> selectOrderBy(){
		try {
			return handleSuccess(bookmarkService.selectOrderBy());
		}catch(Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	@PostMapping("/bookmark")
	public ResponseEntity<Map<String, Object>> insert(@RequestBody Bookmark bookmark) {
		log.debug("insert: {}", bookmark);
		try {
			return handleSuccess(bookmarkService.insert(bookmark));
		}catch (Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	

	
	@DeleteMapping("/bookmark/{bookmarkNo}")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable int bookmarkNo) {
		log.debug("delete: {}", bookmarkNo);
		try {
			return handleSuccess(bookmarkService.delete(bookmarkNo));
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
