package com.inad.mgr.domain;

import lombok.Data;

@Data
public class ApmmNvLandOpen {
	String stdmt;					//기준월
	String pnu;						//필지고유번호
	String landSeqno;				//토지일련번호
	String sggCd;					//시군구코드
	String landLocCd;				//토지소재지코드
	String landGbn;					//토지구분
	String bobn;					//본번
	String bubn;					//부번
	String admUmdCd;				//행정읍면동코드
	String pnilp;					//개별공시지가
	String jimok;					//지목
	String parea;					//면적
	String spfc1;					//용도지역1
	String spfc2;					//용도지역2
	String landUse;					//토지이용상황
	String geoHl;					//지형고저
	String geoForm;					//지형형상
	String roadSide;				//도로접면
	
}
