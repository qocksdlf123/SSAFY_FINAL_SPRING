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
@ApiModel(value = "AptInfo(아파트 정보)", description = "아파트 명, 건축년도, 위치 정보, 도로명, 동코드, 주소(동 + 지번)")
public class AptInfo {
	@ApiModelProperty(value = "아파트 코드", example = "11110000000001")
	private long aptCode;
	@ApiModelProperty(value = "아파트 명", example = "광화문스페이스본(101동~105동)")
	private String apartmentName;
	@ApiModelProperty(value = "건축년도", example = "2008")
	private int buildYear;
	@ApiModelProperty(value = "경도", example = "126.968575235313")
	private String lng;
	@ApiModelProperty(value = "위도", example = "37.5746540320628")
	private String lat;
	@ApiModelProperty(value = "도로명", example = "사직로8길")
	private String roadName;
	@ApiModelProperty(value = "동코드", example = "1111011500")
	private String dongCode;
	@ApiModelProperty(value = "지번 주소", example = "사직동 9")
	private String address;
}
