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
}
