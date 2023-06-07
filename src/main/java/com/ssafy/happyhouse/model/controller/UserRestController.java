package com.ssafy.happyhouse.model.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import com.ssafy.happyhouse.model.dto.User;
import com.ssafy.happyhouse.model.service.UserService;
import com.ssafy.happyhouse.util.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Slf4j
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtutil;
	
	// 로그인
	@PostMapping("/user/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user){
		log.debug("login 시작");
		try {
			User selected = userService.login(user.getId(), user.getPassword());
			ResponseEntity<Map<String, Object>> usermap = null;
			if(selected != null ) {
				usermap = handleSuccess(selected);
				String accessToken = jwtutil.createAuthToken(selected.getId(),selected.getLevel());
				usermap.getBody().put("userid", accessToken);
			}
			return usermap;
		} catch (Exception e) {
			e.printStackTrace();
			return handleException(e);
			
		}
	}
	
	// 로그아웃
	@GetMapping("/user/logout")
	public ResponseEntity<Map<String, Object>> logout(){
		log.debug("logout 시작");
		return handleSuccess(null);
	}
	
	//토큰인증
	@GetMapping("/user/info")
	public ResponseEntity<Map<String,Object>> tokenCheck(HttpServletRequest request){
		String jwt = request.getHeader("accessToken");
		byte[] key = jwtutil.generateKey();
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwt);
			return handleSuccess("success");
		}catch(Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	// 유저 정보 가져오기
	@GetMapping("/user/{id}")
	public ResponseEntity<Map<String, Object>> select(@PathVariable String id){
		try {
			User selected = userService.select(id);
			log.debug("select: {}", selected);
			return handleSuccess(selected);
		}catch (Exception e){
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	// 유저 정보 등록하기
	@PostMapping("/user")
	public ResponseEntity<Map<String, Object>> regist(@RequestBody User user){
		log.debug("insert: {}", user);
		try {
			return handleSuccess(userService.insert(user));
		} catch (Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	// 유저 정보 수정하기
	@PutMapping("/user")
	public ResponseEntity<Map<String, Object>> update(@RequestBody User user){
		log.debug("update: {}", user);
		try {
			return handleSuccess(userService.update(user));
		}catch(Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	// 유저 정보 삭제하기
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable String id){
		log.debug("delete: {}", id);
		try {
			return handleSuccess(userService.delete(id));
		}catch(Exception e) {
			e.printStackTrace();
			return handleException(e);
		}
	}
	
	// 유저 알람 가져옥
	@GetMapping("/user/alarm/{userId}")
	public ResponseEntity<Map<String, Object>> selectAlarm(@PathVariable String userId){
		try {
			return handleSuccess(userService.selectAlarm(userId));
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
