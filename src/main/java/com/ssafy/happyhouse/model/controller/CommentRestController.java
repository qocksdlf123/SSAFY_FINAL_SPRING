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
import com.ssafy.happyhouse.model.dto.Comment;
import com.ssafy.happyhouse.model.service.BoardService;
import com.ssafy.happyhouse.model.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Slf4j
public class CommentRestController {
	
	@Autowired
	private CommentService commentService;
	
	// 게시판 댓글 가져오기
	@GetMapping("/commentBoard/{articleNo}")       
	public ResponseEntity<Map<String, Object>> selectByBoard(@PathVariable int articleNo) {
		try {
			List<Comment> list = commentService.selectByBoard(articleNo);
			log.debug("selectByBoard: {}", list.size());
			return handleSuccess(list);
		}catch (Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	
	// 특정 게시물 가져오기 + 조회수 증가
	@GetMapping("/comment/{commentNo}")
	public ResponseEntity<Map<String, Object>> select(@PathVariable int commentNo) {
		try {
			Comment selected = commentService.select(commentNo);
			log.debug("select: {}", selected);
			return handleSuccess(selected);
		}catch (Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	@PostMapping("/comment")
	public ResponseEntity<Map<String, Object>> insert(@RequestBody Comment comment) {
		log.debug("insert: {}", comment);
		try {
			return handleSuccess(commentService.insert(comment));
		}catch (Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	@PutMapping("/comment")
	public ResponseEntity<Map<String, Object>> update(@RequestBody Comment comment) {
		log.debug("update: {}", comment);
		try {
			return handleSuccess(commentService.update( comment));
		}catch (Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	@DeleteMapping("/comment/{commnetNo}")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable int commnetNo) {
		log.debug("delete: {}", commnetNo);
		try {
			return handleSuccess(commentService.delete(commnetNo));
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
