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
	public String getPlatPlc() {
		return platPlc;
	}
	public void setPlatPlc(String platPlc) {
		this.platPlc = platPlc;
	}
	public String getSi() {
		return si;
	}
	public void setSi(String si) {
		this.si = si;
	}
	public String getGun() {
		return gun;
	}
	public void setGun(String gun) {
		this.gun = gun;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getSigunguCd() {
		return sigunguCd;
	}
	public void setSigunguCd(String sigunguCd) {
		this.sigunguCd = sigunguCd;
	}
	public String getHangCd() {
		return hangCd;
	}
	public void setHangCd(String hangCd) {
		this.hangCd = hangCd;
	}
	public String getOldBunJi() {
		return oldBunJi;
	}
	public void setOldBunJi(String oldBunJi) {
		this.oldBunJi = oldBunJi;
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
	public String getJimok() {
		return jimok;
	}
	public void setJimok(String jimok) {
		this.jimok = jimok;
	}
	public String getJimokCd() {
		return jimokCd;
	}
	public void setJimokCd(String jimokCd) {
		this.jimokCd = jimokCd;
	}
	public String getMainPurpsArea() {
		return mainPurpsArea;
	}
	public void setMainPurpsArea(String mainPurpsArea) {
		this.mainPurpsArea = mainPurpsArea;
	}
	public String getMainPurpsAreaCd() {
		return mainPurpsAreaCd;
	}
	public void setMainPurpsAreaCd(String mainPurpsAreaCd) {
		this.mainPurpsAreaCd = mainPurpsAreaCd;
	}
	public String getRoadConditions() {
		return roadConditions;
	}
	public void setRoadConditions(String roadConditions) {
		this.roadConditions = roadConditions;
	}
	public String getContractYM() {
		return contractYM;
	}
	public void setContractYM(String contractYM) {
		this.contractYM = contractYM;
	}
	public String getContractDate() {
		return contractDate;
	}
	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}
	public String getAgreementArea() {
		return agreementArea;
	}
	public void setAgreementArea(String agreementArea) {
		this.agreementArea = agreementArea;
	}
	public String getTradePrice() {
		return tradePrice;
	}
	public void setTradePrice(String tradePrice) {
		this.tradePrice = tradePrice;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
}
