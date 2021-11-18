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
	public String getMgmBldrgstPk() {
		return mgmBldrgstPk;
	}
	public void setMgmBldrgstPk(String mgmBldrgstPk) {
		this.mgmBldrgstPk = mgmBldrgstPk;
	}
	public String getRegstrGbCd() {
		return regstrGbCd;
	}
	public void setRegstrGbCd(String regstrGbCd) {
		this.regstrGbCd = regstrGbCd;
	}
	public String getRegstrGbCdNm() {
		return regstrGbCdNm;
	}
	public void setRegstrGbCdNm(String regstrGbCdNm) {
		this.regstrGbCdNm = regstrGbCdNm;
	}
	public String getRegstrKindCd() {
		return regstrKindCd;
	}
	public void setRegstrKindCd(String regstrKindCd) {
		this.regstrKindCd = regstrKindCd;
	}
	public String getRegstrKindCdNm() {
		return regstrKindCdNm;
	}
	public void setRegstrKindCdNm(String regstrKindCdNm) {
		this.regstrKindCdNm = regstrKindCdNm;
	}
	public String getPlatPlc() {
		return platPlc;
	}
	public void setPlatPlc(String platPlc) {
		this.platPlc = platPlc;
	}
	public String getNewPlatPlc() {
		return newPlatPlc;
	}
	public void setNewPlatPlc(String newPlatPlc) {
		this.newPlatPlc = newPlatPlc;
	}
	public String getBldNm() {
		return bldNm;
	}
	public void setBldNm(String bldNm) {
		this.bldNm = bldNm;
	}
	public String getSigunguCd() {
		return sigunguCd;
	}
	public void setSigunguCd(String sigunguCd) {
		this.sigunguCd = sigunguCd;
	}
	public String getBjdongCd() {
		return bjdongCd;
	}
	public void setBjdongCd(String bjdongCd) {
		this.bjdongCd = bjdongCd;
	}
	public String getPlatGbCd() {
		return platGbCd;
	}
	public void setPlatGbCd(String platGbCd) {
		this.platGbCd = platGbCd;
	}
	public String getBun() {
		return bun;
	}
	public void setBun(String bun) {
		this.bun = bun;
	}
	public String getJi() {
		return ji;
	}
	public void setJi(String ji) {
		this.ji = ji;
	}
	public String getSplotNm() {
		return splotNm;
	}
	public void setSplotNm(String splotNm) {
		this.splotNm = splotNm;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public String getLot() {
		return lot;
	}
	public void setLot(String lot) {
		this.lot = lot;
	}
	public String getNaRoadCd() {
		return naRoadCd;
	}
	public void setNaRoadCd(String naRoadCd) {
		this.naRoadCd = naRoadCd;
	}
	public String getNaBjdongCd() {
		return naBjdongCd;
	}
	public void setNaBjdongCd(String naBjdongCd) {
		this.naBjdongCd = naBjdongCd;
	}
	public String getNaUgrndCd() {
		return naUgrndCd;
	}
	public void setNaUgrndCd(String naUgrndCd) {
		this.naUgrndCd = naUgrndCd;
	}
	public String getNaMainBun() {
		return naMainBun;
	}
	public void setNaMainBun(String naMainBun) {
		this.naMainBun = naMainBun;
	}
	public String getNaSubBun() {
		return naSubBun;
	}
	public void setNaSubBun(String naSubBun) {
		this.naSubBun = naSubBun;
	}
	public String getDongNm() {
		return dongNm;
	}
	public void setDongNm(String dongNm) {
		this.dongNm = dongNm;
	}
	public String getHoNm() {
		return hoNm;
	}
	public void setHoNm(String hoNm) {
		this.hoNm = hoNm;
	}
	public String getFlrGbCd() {
		return flrGbCd;
	}
	public void setFlrGbCd(String flrGbCd) {
		this.flrGbCd = flrGbCd;
	}
	public String getFlrGbCdNm() {
		return flrGbCdNm;
	}
	public void setFlrGbCdNm(String flrGbCdNm) {
		this.flrGbCdNm = flrGbCdNm;
	}
	public String getFlrNo() {
		return flrNo;
	}
	public void setFlrNo(String flrNo) {
		this.flrNo = flrNo;
	}
	public String getCrtnDay() {
		return crtnDay;
	}
	public void setCrtnDay(String crtnDay) {
		this.crtnDay = crtnDay;
	}
	
}
