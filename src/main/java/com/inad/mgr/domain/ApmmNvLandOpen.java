package com.inad.mgr.domain;

import lombok.Data;

/* jimok Code
 * 01 : 전
 * 02 : 답
 * 03 : 과수원
 * 04 : 목장용지
 * 05 : 임야
 * 06 : 광천지
 * 07 : 염전
 * 08 : 대
 * 09 : 공장용지
 * 10 : 학교용지
 * 11 : 주차장
 * 12 : 주유소용지
 * 13 : 창고용지
 * 14 : 도로
 * 15 : 철도용지
 * 16 : 제방
 * 17 : 하천
 * 18 : 구거
 * 19 : 유지
 * 20 : 양어장
 * 21 : 수도용지
 * 22 : 공원
 * 23 : 체육용지
 * 24 : 유원지
 * 25 : 종교용지 
 * 26 : 사적지
 * 27 : 묘지
 * 28 : 잡종지
 */

/* spfc Code 
 * 11 : 제1종전용주거지역
 * 12 : 제2종전용주거지역
 * 13 : 제1종일반주거지역
 * 14 : 제2종일반주거지역
 * 15 : 제3종일반주거지역
 * 16 : 준주거지역
 * 21 : 중심상업지역
 * 22 : 일반상업지역
 * 23 : 근린상업지역
 * 24 : 유통상업지역
 * 31 : 전용공업지역
 * 32 : 일반공업지역
 * 33 : 준공업지역
 * 41 : 보전녹지지역
 * 42 : 생산녹지지역
 * 43 : 자연녹지지역
 * 44 : 개발제한구역
 * 51 : 용도미지정지역
 * 61 : 관리지역
 * 62 : 보전관리지역
 * 63 : 생산관리지역
 * 64 : 계획관리지역
 * 71 : 농림지역
 * 81 : 자연환경보전지역
 */

/* landUse Code
 * 100 ---------- 주거용
 * 110 : 단독
 * 120 : 연립
 * 130 : 다세대
 * 140 : 아파트
 * 150 : 주거나지
 * 160 : 주거기타
 * 200 ---------- 상업, 업무용
 * 210 : 상업용
 * 220 : 업무용
 * 230 : 상업나지
 * 240 : 상업기타
 * 300 ---------- 주, 상복합용
 * 310 : 주상용
 * 320 : 주상나지
 * 330 : 주상기타
 * 400 ---------- 공업용
 * 410 : 공업용
 * 420 : 공업나지
 * 430 : 공업기타
 * 440 : 태양광
 * 500 ---------- 전
 * 510 : 전
 * 520 : 과수원
 * 530 : 전기타
 * 540 : 전창고
 * 550 : 전축사
 * 600 ---------- 답
 * 610 : 답
 * 620 : 답기타
 * 630 : 답창고
 * 640 : 답축사
 * 700 ---------- 임야
 * 710 : 조림
 * 720 : 자연림
 * 730 : 토지임야
 * 740 : 목장용지
 * 750 : 임야기타
 * 800 ---------- 특수토지
 * 810 : 광천지
 * 820 : 광업용지
 * 830 : 염전
 * 831 : 양어․양식
 * 840 : 유원지
 * 841 : 야영
 * 850 : 공원묘지
 * 860 : 회원제
 * 861 : 대중제
 * 862 : 간이
 * 870 : 스키장
 * 880 : 경마장
 * 881 : 승마장
 * 890 : 터미널
 * 891 : 콘도
 * 892 : 공항
 * 893 : 휴게소
 * 894 : 매림
 * 895 : 발전소
 * 899 : 특수기타
 * 900 ---------- 공공용지 등
 * 910 : 도로 등
 * 920 : 하천 등
 * 930 : 공원 등
 * 940 : 운동장 등
 * 950 : 주차장 등
 * 960 : 위험시설
 * 970 : 유해․혐오시설
 * 990 : 기타
 */
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
	public String getStdmt() {
		return stdmt;
	}
	public void setStdmt(String stdmt) {
		this.stdmt = stdmt;
	}
	public String getPnu() {
		return pnu;
	}
	public void setPnu(String pnu) {
		this.pnu = pnu;
	}
	public String getLandSeqno() {
		return landSeqno;
	}
	public void setLandSeqno(String landSeqno) {
		this.landSeqno = landSeqno;
	}
	public String getSggCd() {
		return sggCd;
	}
	public void setSggCd(String sggCd) {
		this.sggCd = sggCd;
	}
	public String getLandLocCd() {
		return landLocCd;
	}
	public void setLandLocCd(String landLocCd) {
		this.landLocCd = landLocCd;
	}
	public String getLandGbn() {
		return landGbn;
	}
	public void setLandGbn(String landGbn) {
		this.landGbn = landGbn;
	}
	public String getBobn() {
		return bobn;
	}
	public void setBobn(String bobn) {
		this.bobn = bobn;
	}
	public String getBubn() {
		return bubn;
	}
	public void setBubn(String bubn) {
		this.bubn = bubn;
	}
	public String getAdmUmdCd() {
		return admUmdCd;
	}
	public void setAdmUmdCd(String admUmdCd) {
		this.admUmdCd = admUmdCd;
	}
	public String getPnilp() {
		return pnilp;
	}
	public void setPnilp(String pnilp) {
		this.pnilp = pnilp;
	}
	public String getJimok() {
		return jimok;
	}
	public void setJimok(String jimok) {
		this.jimok = jimok;
	}
	public String getParea() {
		return parea;
	}
	public void setParea(String parea) {
		this.parea = parea;
	}
	public String getSpfc1() {
		return spfc1;
	}
	public void setSpfc1(String spfc1) {
		this.spfc1 = spfc1;
	}
	public String getSpfc2() {
		return spfc2;
	}
	public void setSpfc2(String spfc2) {
		this.spfc2 = spfc2;
	}
	public String getLandUse() {
		return landUse;
	}
	public void setLandUse(String landUse) {
		this.landUse = landUse;
	}
	public String getGeoHl() {
		return geoHl;
	}
	public void setGeoHl(String geoHl) {
		this.geoHl = geoHl;
	}
	public String getGeoForm() {
		return geoForm;
	}
	public void setGeoForm(String geoForm) {
		this.geoForm = geoForm;
	}
	public String getRoadSide() {
		return roadSide;
	}
	public void setRoadSide(String roadSide) {
		this.roadSide = roadSide;
	}
	
}
