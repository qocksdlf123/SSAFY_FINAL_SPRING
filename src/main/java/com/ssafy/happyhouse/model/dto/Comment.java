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
@ApiModel(value = "Comment(댓글)", description = "댓글: 등급별 관리")
public class Comment {
	@ApiModelProperty(value = "댓글 번호")
	private int commentNo;
	@ApiModelProperty(value = "글 번호")
	private int articleNo;
	@ApiModelProperty(value = "작성자 아이디", example = "ssafy")
	private String userId;
	@ApiModelProperty(value = "작성자 이름", example = "김싸피")
	private String userName;
	@ApiModelProperty(value = "글 내용", example = "test내용", notes = "varchar(2000)")
	private String content;
	@ApiModelProperty(value = "글 작성 시간")
	private String registerTime;
}
