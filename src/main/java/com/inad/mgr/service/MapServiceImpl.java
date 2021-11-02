package com.inad.mgr.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inad.mgr.domain.CdInfo;
import com.inad.mgr.mapper.MapMapper;

@Service
public class MapServiceImpl implements MapService {

	@Autowired
	private MapMapper mapMapper;
	
	@Override
	public List<CdInfo> getCdInfoSmall(String[] argv) throws Exception {
		
		return mapMapper.getCdInfoSmall(argv); 
	}

	@Override
	public List<CdInfo> getCdInfoBig(String[] argv) throws Exception {

		return mapMapper.getCdInfoBig(argv); 
	}
	
}
