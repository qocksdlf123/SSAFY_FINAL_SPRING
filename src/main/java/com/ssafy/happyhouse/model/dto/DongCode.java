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
@ApiModel(value = "DongCode(동코드)", description = "동코드와 시도, 구군, 동, 전체 명칭")
public class DongCode {
	@ApiModelProperty(value = "동코드", example = "1111010100")
	private String dongCode;
	@ApiModelProperty(value = "시도 명칭", example = "서울특별시", notes = "앞 두자리")
	private String sidoName;
	@ApiModelProperty(value = "구군 명칭", example = "종로구", notes = "그 뒤 세자리")
	private String gugunName;
	@ApiModelProperty(value = "동 명칭", example = "청운동", notes = "그 뒤 다섯자리")
	private String dongName;
	@ApiModelProperty(value = "전체 명칭", example = "서울특별시 종로구 청운동")
	private String fullName;
}
