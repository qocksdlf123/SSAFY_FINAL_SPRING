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
@ApiModel(value = "Property(매물)", description = "매물 정보")
public class Property {
	@ApiModelProperty(value = "매물 번호")
	private long no;
	@ApiModelProperty(value = "아파트 번호")
	private long aptCode;
	@ApiModelProperty(value = "아파트 명")
	private String apartmentName;
	@ApiModelProperty(value = "매물 종류", allowableValues = "매매, 전세, 월세")
	private String type;
	@ApiModelProperty(value = "보증금")
	private int dealAmount;
	@ApiModelProperty(value = "월세")
	private int monthlyPay;
	@ApiModelProperty(value = "면적")
	private String area;
	@ApiModelProperty(value = "층 수")
	private String floor;
	@ApiModelProperty(value = "상세 설명")
	private String detail;
	@ApiModelProperty(value = "작성자 아이디")
	private String userId;
	@ApiModelProperty(value = "매물 작성 날짜")
	private String createdDate;
}
