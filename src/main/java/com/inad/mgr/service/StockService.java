package com.inad.mgr.service;

import java.util.List;
import java.util.Map;

import com.inad.mgr.domain.Cropcord;

public interface StockService {
	//리스트 가져오기
	public List<Cropcord> getListCropcord() throws Exception;
	
	//재무제표 있는상태로 변환
	public void setIsOfs(String cropcord) throws Exception;
	
	//재무제표 없는상태로 변환
	public void setIsNotOfs(String cropcord) throws Exception;
}
