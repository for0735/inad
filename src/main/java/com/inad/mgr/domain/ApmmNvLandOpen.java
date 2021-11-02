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
