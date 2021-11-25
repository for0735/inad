package com.inad.mgr.service;

import java.util.List;
import java.util.Map;

import com.inad.mgr.domain.ApmmNvLandOpen;
import com.inad.mgr.domain.BrExposInfoArea;
import com.inad.mgr.domain.BrTitleInfo;
import com.inad.mgr.domain.CdInfo;
import com.inad.mgr.domain.data.DataAlone;
import com.inad.mgr.domain.data.DataApt;
import com.inad.mgr.domain.data.DataCommercial;
import com.inad.mgr.domain.data.DataLand;
import com.inad.mgr.domain.data.DataMulti;
import com.inad.mgr.domain.data.DataOffice;

public interface MapService {
	//시, 군, 구 코드 가져오기 (세종시 국한)
	public List<CdInfo> getCdInfoSmall(String[] argv) throws Exception;

	//시, 군, 구 코드 가져오기
	public List<CdInfo> getCdInfoBig(String[] argv) throws Exception;
	
	//필지종류 구하기
	public List<BrTitleInfo> getKind(String[] argv, CdInfo cdInfo, String addr) throws Exception;
	
	//필지종류 구하기(토지일경우)
	public List<ApmmNvLandOpen> getKindLand(String[] argv, CdInfo cdInfo, String addr) throws Exception;

	//필지종류 구하기(집합일경우)
	public List<BrExposInfoArea> getKindZipHap(String[] argv, CdInfo cdInfo, String addr) throws Exception;
	
	//------------------------------- 가격산정로직 -----------------------------------------------
	//아파트 가격산정
	public List<DataApt> getAptPrice(Map addrMap) throws Exception;
	
	//아파트 가격산정
	public List<DataOffice> getOfficePrice(Map addrMap) throws Exception;
	
	//연립다세대 가격산정
	public List<DataMulti> getMultiPrice(Map addrMap) throws Exception;
	
	//구분상가 가격산정
	public List<DataCommercial> getCommercialPrice(Map addrMap) throws Exception;
	
	//단독다가구 가격산정
	public List<DataAlone> getAlonePrice(Map addrMap) throws Exception;
	
	//토지 가격산정
	public List<DataLand> getLandPrice(Map addrMap) throws Exception;
}
