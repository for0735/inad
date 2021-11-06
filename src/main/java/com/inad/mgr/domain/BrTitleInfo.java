package com.inad.mgr.domain;

import lombok.Data;

@Data
public class BrTitleInfo {
	String mgmBldrgstPk;						//관리_건축물대장_PK
	String regstrGbCd;							//대장_구분_코드
	String regstrGbCdNm;						//대장_구분_코드_명
	String regstrKindCd;						//대장_종류_코드
	String regstrKindCdNm;						//대장_종류_코드_명
	String platPlc;								//대지_위치
	String newPlatPlc;							//도로명_대지_위치
	String bldNm;								//건물_명
	String sigunguCd;							//시군구_코드
	String bjdongCd;							//법정동_코드
	String platGbCd;							//대지_구분_코드
	String bun;									//번
	String ji;									//지
	String splotNm;								//특수지_명
	String block;								//블록
	String lot;									//로트
	String bylotCnt;							//외필지_수
	String naRoadCd;							//새주소_도로_코드
	String naBjdongCd;							//새주소_법정동_코드
	String naUgrndCd;							//새주소_지상지하_코드
	String naMainBun;							//새주소_본_번
	String naSubBun;							//새주소_부_번
	String dongNm;								//동_명
	String mainAtchGbCd;						//주_부속_구분_코드
	String mainAtchGbCdNm;						//주_부속_구분_코드_명
	String platArea;							//대지_면적(㎡)
	String archArea;							//연_면적(㎡)
	String bcRat;								//건폐_율(%)
	String totArea;								//연면적(㎡)
	String vlRatEstmTotArea;					//용적_률_산정_연면적(㎡)
	String vlRat;								//용적_률(%)
	String strctCd;								//구조_코드
	String strctCdNm;							//구조_코드_명
	String etcStrct;							//기타_구조
	String mainPurpsCd;							//주_용도_코드
	String mainPurpsCdNm;						//주_용도_코드_명
	String etcPurps;							//기타_용도
	String roofCd;								//지붕_코드
	String roofCdNm;							//지붕_코드_명
	String etcRoof;								//기타_지붕
	String hhldCnt;								//세대_수(세대)
	String fmlyCnt;								//가구_수(가구)
	String heit;								//높이(m)
	String grndFlrCnt;							//지상_층_수
	String ugrndFlrCnt;							//지하_층_수
	String rideUseElvtCnt;						//승용_승강기_수
	String emgenUseElvtCnt;						//비상용_승강기_수
	String atchBldCnt;							//부속_건축물_수
	String atchBldArea;							//부속_건축물_면적(㎡)
	String totDongTotArea;						//총_동_연면적(㎡)
	String indrMechUtcnt;						//옥내_기계식_대수(대)
	String indrMechArea;						//옥내_기계식_면적(㎡)
	String oudrMechUtcnt;						//옥외_기계식_대수(대)
	String oudrMechArea;						//옥외_기계식_면적(㎡)
	String indrAutoUtcnt;						//옥내_자주식_대수(대)
	String indrAutoArea;						//옥내_자주식_면적(㎡)
	String oudrAutoUtcnt;						//옥외_자주식_대수(대)
	String oudrAutoArea;						//옥외_자주식_면적(㎡)
	String pmsDay;								//허가_일
	String stcnsDay;							//착공_일
	String useAprDay;							//사용승인_일
	String pmsnoYear;							//허가번호_년
	String pmsnoKikCd;							//허가번호_기관_코드
	String pmsnoKikCdNm;						//허가번호_기관_코드_명
	String pmsnoGbCd;							//허가번호_구분_코드
	String pmsnoGbCdNm;							//허가번호_구분_코드_명
	String hoCnt;								//호_수(호)
	String engrGrade;							//에너지효율_등급
	String engrRat;								//에너지절감_율
	String engrEpi;								//에너지_EPI점수
	String gnBldGrade;							//친환경_건축물_등급
	String gnBldCert;							//친환경_건축물_인증점수
	String itgBldGrade;							//지능형_건축물_등급
	String itgBldCert;							//지능형_건축물_인증점수
	String crtnDay;								//생성_일자
	String rserthqkDsgnApplyYn;					//내진_설계_적용_여부
	String rserthqkAblty;						//내진_능력
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
	public String getBylotCnt() {
		return bylotCnt;
	}
	public void setBylotCnt(String bylotCnt) {
		this.bylotCnt = bylotCnt;
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
	public String getMainAtchGbCd() {
		return mainAtchGbCd;
	}
	public void setMainAtchGbCd(String mainAtchGbCd) {
		this.mainAtchGbCd = mainAtchGbCd;
	}
	public String getMainAtchGbCdNm() {
		return mainAtchGbCdNm;
	}
	public void setMainAtchGbCdNm(String mainAtchGbCdNm) {
		this.mainAtchGbCdNm = mainAtchGbCdNm;
	}
	public String getPlatArea() {
		return platArea;
	}
	public void setPlatArea(String platArea) {
		this.platArea = platArea;
	}
	public String getArchArea() {
		return archArea;
	}
	public void setArchArea(String archArea) {
		this.archArea = archArea;
	}
	public String getBcRat() {
		return bcRat;
	}
	public void setBcRat(String bcRat) {
		this.bcRat = bcRat;
	}
	public String getTotArea() {
		return totArea;
	}
	public void setTotArea(String totArea) {
		this.totArea = totArea;
	}
	public String getVlRatEstmTotArea() {
		return vlRatEstmTotArea;
	}
	public void setVlRatEstmTotArea(String vlRatEstmTotArea) {
		this.vlRatEstmTotArea = vlRatEstmTotArea;
	}
	public String getVlRat() {
		return vlRat;
	}
	public void setVlRat(String vlRat) {
		this.vlRat = vlRat;
	}
	public String getStrctCd() {
		return strctCd;
	}
	public void setStrctCd(String strctCd) {
		this.strctCd = strctCd;
	}
	public String getStrctCdNm() {
		return strctCdNm;
	}
	public void setStrctCdNm(String strctCdNm) {
		this.strctCdNm = strctCdNm;
	}
	public String getEtcStrct() {
		return etcStrct;
	}
	public void setEtcStrct(String etcStrct) {
		this.etcStrct = etcStrct;
	}
	public String getMainPurpsCd() {
		return mainPurpsCd;
	}
	public void setMainPurpsCd(String mainPurpsCd) {
		this.mainPurpsCd = mainPurpsCd;
	}
	public String getMainPurpsCdNm() {
		return mainPurpsCdNm;
	}
	public void setMainPurpsCdNm(String mainPurpsCdNm) {
		this.mainPurpsCdNm = mainPurpsCdNm;
	}
	public String getEtcPurps() {
		return etcPurps;
	}
	public void setEtcPurps(String etcPurps) {
		this.etcPurps = etcPurps;
	}
	public String getRoofCd() {
		return roofCd;
	}
	public void setRoofCd(String roofCd) {
		this.roofCd = roofCd;
	}
	public String getRoofCdNm() {
		return roofCdNm;
	}
	public void setRoofCdNm(String roofCdNm) {
		this.roofCdNm = roofCdNm;
	}
	public String getEtcRoof() {
		return etcRoof;
	}
	public void setEtcRoof(String etcRoof) {
		this.etcRoof = etcRoof;
	}
	public String getHhldCnt() {
		return hhldCnt;
	}
	public void setHhldCnt(String hhldCnt) {
		this.hhldCnt = hhldCnt;
	}
	public String getFmlyCnt() {
		return fmlyCnt;
	}
	public void setFmlyCnt(String fmlyCnt) {
		this.fmlyCnt = fmlyCnt;
	}
	public String getHeit() {
		return heit;
	}
	public void setHeit(String heit) {
		this.heit = heit;
	}
	public String getGrndFlrCnt() {
		return grndFlrCnt;
	}
	public void setGrndFlrCnt(String grndFlrCnt) {
		this.grndFlrCnt = grndFlrCnt;
	}
	public String getUgrndFlrCnt() {
		return ugrndFlrCnt;
	}
	public void setUgrndFlrCnt(String ugrndFlrCnt) {
		this.ugrndFlrCnt = ugrndFlrCnt;
	}
	public String getRideUseElvtCnt() {
		return rideUseElvtCnt;
	}
	public void setRideUseElvtCnt(String rideUseElvtCnt) {
		this.rideUseElvtCnt = rideUseElvtCnt;
	}
	public String getEmgenUseElvtCnt() {
		return emgenUseElvtCnt;
	}
	public void setEmgenUseElvtCnt(String emgenUseElvtCnt) {
		this.emgenUseElvtCnt = emgenUseElvtCnt;
	}
	public String getAtchBldCnt() {
		return atchBldCnt;
	}
	public void setAtchBldCnt(String atchBldCnt) {
		this.atchBldCnt = atchBldCnt;
	}
	public String getAtchBldArea() {
		return atchBldArea;
	}
	public void setAtchBldArea(String atchBldArea) {
		this.atchBldArea = atchBldArea;
	}
	public String getTotDongTotArea() {
		return totDongTotArea;
	}
	public void setTotDongTotArea(String totDongTotArea) {
		this.totDongTotArea = totDongTotArea;
	}
	public String getIndrMechUtcnt() {
		return indrMechUtcnt;
	}
	public void setIndrMechUtcnt(String indrMechUtcnt) {
		this.indrMechUtcnt = indrMechUtcnt;
	}
	public String getIndrMechArea() {
		return indrMechArea;
	}
	public void setIndrMechArea(String indrMechArea) {
		this.indrMechArea = indrMechArea;
	}
	public String getOudrMechUtcnt() {
		return oudrMechUtcnt;
	}
	public void setOudrMechUtcnt(String oudrMechUtcnt) {
		this.oudrMechUtcnt = oudrMechUtcnt;
	}
	public String getOudrMechArea() {
		return oudrMechArea;
	}
	public void setOudrMechArea(String oudrMechArea) {
		this.oudrMechArea = oudrMechArea;
	}
	public String getIndrAutoUtcnt() {
		return indrAutoUtcnt;
	}
	public void setIndrAutoUtcnt(String indrAutoUtcnt) {
		this.indrAutoUtcnt = indrAutoUtcnt;
	}
	public String getIndrAutoArea() {
		return indrAutoArea;
	}
	public void setIndrAutoArea(String indrAutoArea) {
		this.indrAutoArea = indrAutoArea;
	}
	public String getOudrAutoUtcnt() {
		return oudrAutoUtcnt;
	}
	public void setOudrAutoUtcnt(String oudrAutoUtcnt) {
		this.oudrAutoUtcnt = oudrAutoUtcnt;
	}
	public String getOudrAutoArea() {
		return oudrAutoArea;
	}
	public void setOudrAutoArea(String oudrAutoArea) {
		this.oudrAutoArea = oudrAutoArea;
	}
	public String getPmsDay() {
		return pmsDay;
	}
	public void setPmsDay(String pmsDay) {
		this.pmsDay = pmsDay;
	}
	public String getStcnsDay() {
		return stcnsDay;
	}
	public void setStcnsDay(String stcnsDay) {
		this.stcnsDay = stcnsDay;
	}
	public String getUseAprDay() {
		return useAprDay;
	}
	public void setUseAprDay(String useAprDay) {
		this.useAprDay = useAprDay;
	}
	public String getPmsnoYear() {
		return pmsnoYear;
	}
	public void setPmsnoYear(String pmsnoYear) {
		this.pmsnoYear = pmsnoYear;
	}
	public String getPmsnoKikCd() {
		return pmsnoKikCd;
	}
	public void setPmsnoKikCd(String pmsnoKikCd) {
		this.pmsnoKikCd = pmsnoKikCd;
	}
	public String getPmsnoKikCdNm() {
		return pmsnoKikCdNm;
	}
	public void setPmsnoKikCdNm(String pmsnoKikCdNm) {
		this.pmsnoKikCdNm = pmsnoKikCdNm;
	}
	public String getPmsnoGbCd() {
		return pmsnoGbCd;
	}
	public void setPmsnoGbCd(String pmsnoGbCd) {
		this.pmsnoGbCd = pmsnoGbCd;
	}
	public String getPmsnoGbCdNm() {
		return pmsnoGbCdNm;
	}
	public void setPmsnoGbCdNm(String pmsnoGbCdNm) {
		this.pmsnoGbCdNm = pmsnoGbCdNm;
	}
	public String getHoCnt() {
		return hoCnt;
	}
	public void setHoCnt(String hoCnt) {
		this.hoCnt = hoCnt;
	}
	public String getEngrGrade() {
		return engrGrade;
	}
	public void setEngrGrade(String engrGrade) {
		this.engrGrade = engrGrade;
	}
	public String getEngrRat() {
		return engrRat;
	}
	public void setEngrRat(String engrRat) {
		this.engrRat = engrRat;
	}
	public String getEngrEpi() {
		return engrEpi;
	}
	public void setEngrEpi(String engrEpi) {
		this.engrEpi = engrEpi;
	}
	public String getGnBldGrade() {
		return gnBldGrade;
	}
	public void setGnBldGrade(String gnBldGrade) {
		this.gnBldGrade = gnBldGrade;
	}
	public String getGnBldCert() {
		return gnBldCert;
	}
	public void setGnBldCert(String gnBldCert) {
		this.gnBldCert = gnBldCert;
	}
	public String getItgBldGrade() {
		return itgBldGrade;
	}
	public void setItgBldGrade(String itgBldGrade) {
		this.itgBldGrade = itgBldGrade;
	}
	public String getItgBldCert() {
		return itgBldCert;
	}
	public void setItgBldCert(String itgBldCert) {
		this.itgBldCert = itgBldCert;
	}
	public String getCrtnDay() {
		return crtnDay;
	}
	public void setCrtnDay(String crtnDay) {
		this.crtnDay = crtnDay;
	}
	public String getRserthqkDsgnApplyYn() {
		return rserthqkDsgnApplyYn;
	}
	public void setRserthqkDsgnApplyYn(String rserthqkDsgnApplyYn) {
		this.rserthqkDsgnApplyYn = rserthqkDsgnApplyYn;
	}
	public String getRserthqkAblty() {
		return rserthqkAblty;
	}
	public void setRserthqkAblty(String rserthqkAblty) {
		this.rserthqkAblty = rserthqkAblty;
	}
}
