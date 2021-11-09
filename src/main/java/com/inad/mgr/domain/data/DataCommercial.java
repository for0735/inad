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
	public String getKindNm() {
		return kindNm;
	}
	public void setKindNm(String kindNm) {
		this.kindNm = kindNm;
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
	public String getNewPlatPlc() {
		return newPlatPlc;
	}
	public void setNewPlatPlc(String newPlatPlc) {
		this.newPlatPlc = newPlatPlc;
	}
	public String getMainPurpsArea() {
		return mainPurpsArea;
	}
	public void setMainPurpsArea(String mainPurpsArea) {
		this.mainPurpsArea = mainPurpsArea;
	}
	public String getMainPurpsCdNm() {
		return mainPurpsCdNm;
	}
	public void setMainPurpsCdNm(String mainPurpsCdNm) {
		this.mainPurpsCdNm = mainPurpsCdNm;
	}
	public String getRoadConditions() {
		return roadConditions;
	}
	public void setRoadConditions(String roadConditions) {
		this.roadConditions = roadConditions;
	}
	public String getTotArea() {
		return totArea;
	}
	public void setTotArea(String totArea) {
		this.totArea = totArea;
	}
	public String getPlatArea() {
		return platArea;
	}
	public void setPlatArea(String platArea) {
		this.platArea = platArea;
	}
	public String getTradePrice() {
		return tradePrice;
	}
	public void setTradePrice(String tradePrice) {
		this.tradePrice = tradePrice;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
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
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String getUseAprDay() {
		return useAprDay;
	}
	public void setUseAprDay(String useAprDay) {
		this.useAprDay = useAprDay;
	}
}
