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
@ApiModel(value = "News(부동산 뉴스)", description = "부동산 뉴스 가져오기")
public class News {
	@ApiModelProperty(value = "기사 사진 링크")
	private String imgSrc;
	@ApiModelProperty(value = "기사 제목")
	private String title;
	@ApiModelProperty(value = "기사 링크")
	private String link;
	@ApiModelProperty(value = "기사 설명")
	private String description;
}
