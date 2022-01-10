package com.inad.mgr.domain;

import lombok.Data;

@Data
public class StockCrt {
	String corpCode;			//고유번호
	String corpName;			//정식명칭(회사명)
	String stockCode;			//종목코드
	String pdcp;				//전일종가
	String fpp;					//적정매수가
	String ratio;				//비율
	String fsp;					//적정매도가
	String opinion;				//의견
	String oopinion;			//기타의견
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
	public String getPdcp() {
		return pdcp;
	}
	public void setPdcp(String pdcp) {
		this.pdcp = pdcp;
	}
	public String getFpp() {
		return fpp;
	}
	public void setFpp(String fpp) {
		this.fpp = fpp;
	}
	public String getRatio() {
		return ratio;
	}
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	public String getFsp() {
		return fsp;
	}
	public void setFsp(String fsp) {
		this.fsp = fsp;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public String getOopinion() {
		return oopinion;
	}
	public void setOopinion(String oopinion) {
		this.oopinion = oopinion;
	}
	
	
}
