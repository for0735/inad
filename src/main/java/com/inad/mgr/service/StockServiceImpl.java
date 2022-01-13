package com.inad.mgr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inad.mgr.domain.Cropcord;
import com.inad.mgr.mapper.StockMapper;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockMapper stockMapper;

	@Override
	public List<Cropcord> getListCropcord() throws Exception {

		return stockMapper.getListCropcord();
	}
	
	@Override
	public List<Cropcord> getSearchListCropcord(String search, int limit, int cntPerPage) throws Exception {
		
		return stockMapper.getSearchListCropcord(search, limit, cntPerPage);
	}

	@Override
	public void setIsOfs(String cropcord) throws Exception {

		stockMapper.setIsOfs(cropcord);		
	}
	
	@Override
	public void setIsNotOfs(String cropcord) throws Exception {
		
		stockMapper.setIsNotOfs(cropcord);		
	}

	
	
	@Override
	public int countCrop(String search) {
		return stockMapper.countCrop(search);
	}
}
