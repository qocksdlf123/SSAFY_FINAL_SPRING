package com.ssafy.happyhouse.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "User(공통 속성)", description = "모든 유저가 가져야 할 공통 속성: 아이디, 비번, 이름, 이메일, 등급")
public class User {
	@ApiModelProperty(value = "유저 아이디", example = "ssafy")
	private String id;
	@ApiModelProperty(value = "유저 비밀번호", example = "ssafy")
	private String password;
	@ApiModelProperty(value = "유저 이름", example = "김싸피")
	private String name;
	@ApiModelProperty(value = "유저 이메일", example = "ssafy@ssafy.com")
	private String email;
	@ApiModelProperty(value = "주소",  example = "서울시 중랑구 망우로 134")
	private String address;
	@ApiModelProperty(value = "유저 등급", allowableValues = "관리자, 회원, 공인중개사", example = "관리자")
	private String level;
	@ApiModelProperty(value = "토큰")
	private String token;
	@ApiModelProperty(value = "공인중개사 등록 번호")
	private String registerNumber;
}
