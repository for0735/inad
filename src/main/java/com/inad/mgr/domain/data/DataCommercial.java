package com.inad.mgr.domain.data;

import lombok.Data;

@Data
public class DataCommercial {
	String platPlc;							//시군구
	String si;								//시
	String gun;								//군
	String gu;								//구
	String kindNm;							//유형
	String oldBunJi;						//지번
	String bun;								//본번
	String ji;								//부번
	String newPlatPlc;						//도로명
	String mainPurpsArea;					//용도지역
	String mainPurpsCdNm;					//건축물주용도
	String roadConditions;					//도로조건
	String totArea;							//전용/연면적
	String platArea;						//대지면적
	String tradePrice;						//거래금액(만원)
	String floor;							//층
	String contractYM;						//계약년월
	String contractDate;					//계약일
	String classification;					//지분구분
	String useAprDay;						//건축년도
}
