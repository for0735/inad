package com.inad.mgr.domain;

import lombok.Data;

@Data
public class CdInfo {
	String sigunguCd;					//시군구_코드
	String bjdongCd;					//법정동_코드
	String hangCd;						//행정동_코드
	String si;							//시
	String gun;							//군
	String gu1;							//구1
	String gu2;							//구2
	String regStart;					//적용시작일
	String regEnd;						//적용만료일
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
	public String getHangCd() {
		return hangCd;
	}
	public void setHangCd(String hangCd) {
		this.hangCd = hangCd;
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
	public String getGu1() {
		return gu1;
	}
	public void setGu1(String gu1) {
		this.gu1 = gu1;
	}
	public String getGu2() {
		return gu2;
	}
	public void setGu2(String gu2) {
		this.gu2 = gu2;
	}
	public String getRegStart() {
		return regStart;
	}
	public void setRegStart(String regStart) {
		this.regStart = regStart;
	}
	public String getRegEnd() {
		return regEnd;
	}
	public void setRegEnd(String regEnd) {
		this.regEnd = regEnd;
	}
	
	
}
