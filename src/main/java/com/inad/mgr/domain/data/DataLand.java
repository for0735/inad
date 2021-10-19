package com.inad.mgr.domain.data;

import lombok.Data;

@Data
public class DataLand {
	String platPlc;									//시군구
	String si;										//시
	String gun;										//군
	String gu;										//구
	String sigunguCd;								//시군구코드
	String hangCd;									//행정동코드
	String oldBunJi;								//번지
	String bun;										//본번
	String ji;										//부번
	String jimok;									//지목
	String jimokCd;									//지목(코드)
	String mainPurpsArea;							//용도지역
	String mainPurpsAreaCd;							//용도지역(코드)
	String roadConditions;							//도로조건
	String contractYM;								//계약년월
	String contractDate;							//계약일
	String agreementArea;							//계약면적
	String tradePrice;								//거래금액(만원)
	String classification;							//지분구분
}
