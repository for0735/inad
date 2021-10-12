package com.inad.mgr.domain;

import lombok.Data;

@Data
public class BrExposInfo {
	String mgmBldrgstPk;					//관리_건축물대장_PK
	String regstrGbCd;						//대장_구분_코드
	String regstrGbCdNm;					//대장_구분_코드_명
	String regstrKindCd;					//대장_종류_코드
	String regstrKindCdNm;					//대장_종류_코드_명
	String platPlc;							//대지_위치
	String newPlatPlc;						//도로명_대지_위치
	String bldNm;							//건물_명
	String sigunguCd;						//시군구_코드
	String bjdongCd;						//법정동_코드
	String platGbCd;						//대지_구분_코드
	String bun;								//번
	String ji;								//지
	String splotNm;							//특수지_명
	String block;							//블록
	String lot;								//로트
	String naRoadCd;						//새주소_도로_코드
	String naBjdongCd;						//새주소_법정동_코드
	String naUgrndCd;						//새주소_지상지하_코드
	String naMainBun;						//새주소_본_번
	String naSubBun;						//새주소_부_번
	String dongNm;							//동_명
	String hoNm;							//호_명
	String flrGbCd;							//층_구분_코드
	String flrGbCdNm;						//층_구분_코드_명
	String flrNo;							//층_번호
	String crtnDay;							//생성_일자
	
}
