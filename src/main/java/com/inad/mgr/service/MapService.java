package com.inad.mgr.service;

import java.util.List;
import java.util.Map;

import com.inad.mgr.domain.BrExposInfoArea;
import com.inad.mgr.domain.BrTitleInfo;
import com.inad.mgr.domain.CdInfo;
import com.inad.mgr.domain.data.DataApt;
import com.inad.mgr.domain.data.DataMulti;
import com.inad.mgr.domain.data.DataOffice;

public interface MapService {
	//시, 군, 구 코드 가져오기 (세종시 국한)
	public List<CdInfo> getCdInfoSmall(String[] argv) throws Exception;

	//시, 군, 구 코드 가져오기
	public List<CdInfo> getCdInfoBig(String[] argv) throws Exception;
	
	//필지종류 구하기
	public List<BrTitleInfo> getKind(String[] argv, CdInfo cdInfo, String addr) throws Exception;

	//필지종류 구하기(집합일경우)
	public List<BrExposInfoArea> getKindZipHap(String[] argv, CdInfo cdInfo, String addr) throws Exception;
	
	//------------------------------- 가격산정로직 -----------------------------------------------
	//아파트 가격산정
	public List<DataApt> getAptPrice(Map addrMap) throws Exception;
	
	//아파트 가격산정
	public List<DataOffice> getOfficePrice(Map addrMap) throws Exception;
	
	//연립다세대 가격산정
	public List<DataMulti> getMultiPrice(Map addrMap) throws Exception;
}
