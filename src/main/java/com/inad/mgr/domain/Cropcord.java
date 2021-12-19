package com.inad.mgr.domain;

import lombok.Data;

@Data
public class Cropcord {
	String corpCode;			//고유번호
	String corpName;			//정식명칭
	String stockCode;			//종목코드
	String modifyDate;			//최종변경일자
	String isOfs;				//재무제표여부 False 0 / True 1
	
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getIsOfs() {
		return isOfs;
	}
	public void setIsOfs(String isOfs) {
		this.isOfs = isOfs;
	}
	
	
	
}
