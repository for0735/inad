package com.inad.mgr.service;

import java.util.List;

import com.inad.mgr.domain.CdInfo;

public interface MapService {
	//시, 군, 구 코드 가져오기 (세종시 국한)
	public List<CdInfo> getCdInfoSmall(String[] argv) throws Exception;

	//시, 군, 구 코드 가져오기
	public List<CdInfo> getCdInfoBig(String[] argv) throws Exception;
}
