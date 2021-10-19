package com.inad.mgr.domain.data;

import lombok.Data;

@Data
public class DataOffice {
	String platPlc;									//시군구
	String si;										//시
	String gun;										//군
	String gu;										//구
	String oldBunJi;								//번지
	String bun;										//본번
	String ji;										//부번
	String bldNm;									//단지명
	String totArea;									//전용면적
	String contractYM;								//계약년월
	String contractDate;							//계약일
	String tradePrice;								//거래금액(만원)
	String floor;									//층
	String useAprDay;								//건축년도
	String newPlatPlc;								//도로명
}