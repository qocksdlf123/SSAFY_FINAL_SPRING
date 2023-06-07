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
@ApiModel(value = "Stats(통계 정보)", description = "한 아파트의 년 기준 매매가 평균 데이터")
public class Stats {
	@ApiModelProperty(value = "아파트 코드")
	private long aptCode;
	@ApiModelProperty(value = "년도")
	private int dealYear;
	@ApiModelProperty(value = "평균매매가")
	private long average;
}
