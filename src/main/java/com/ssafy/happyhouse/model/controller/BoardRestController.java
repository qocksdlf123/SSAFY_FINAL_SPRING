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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.Board;
import com.ssafy.happyhouse.model.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Slf4j
public class BoardRestController {
	
	@Autowired
	private BoardService boardService;
	
	// 전체 게시글 가져오기
	@GetMapping("/board")
	public ResponseEntity<Map<String, Object>> selectAll() {
		try {
			List<Board> list = boardService.selectAll();
			log.debug("selectAll: {}", list.size());
			return handleSuccess(list);
		}catch (Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	@GetMapping("/boardBySubject")
	public ResponseEntity<Map<String, Object>> selectBySubject(@RequestParam  String subject) {
		try {
			List<Board> list = boardService.selectBySubject(subject);
			log.debug("selectBySubject: {}", list.size());
			return handleSuccess(list);
		}catch (Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	@GetMapping("/boardById")
	public ResponseEntity<Map<String, Object>> selectById(@RequestParam String id) {
		try {
			List<Board> list = boardService.selectById(id);
			log.debug("selectById: {}", list.size());
			return handleSuccess(list);
		}catch (Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	// 특정 게시물 가져오기 + 조회수 증가
	@GetMapping("/board/{articleNo}")
	public ResponseEntity<Map<String, Object>> select(@PathVariable int articleNo) {
		try {
			Board selected = boardService.select(articleNo);
			log.debug("select: {}", selected);
			return handleSuccess(selected);
		}catch (Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	@PostMapping("/board")
	public ResponseEntity<Map<String, Object>> insert(@RequestBody Board board) {
		log.debug("insert: {}", board);
		try {
			return handleSuccess(boardService.insert(board));
		}catch (Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	@PutMapping("/board")
	public ResponseEntity<Map<String, Object>> update(@RequestBody Board board) {
		log.debug("update: {}", board);
		try {
			return handleSuccess(boardService.update(board));
		}catch (Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	@DeleteMapping("/board/{articleNo}")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable int articleNo) {
		log.debug("delete: {}", articleNo);
		try {
			return handleSuccess(boardService.delete(articleNo));
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
