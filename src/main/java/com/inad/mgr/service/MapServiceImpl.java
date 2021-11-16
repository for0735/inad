package com.inad.mgr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inad.mgr.domain.BrExposInfoArea;
import com.inad.mgr.domain.BrTitleInfo;
import com.inad.mgr.domain.CdInfo;
import com.inad.mgr.domain.data.DataAlone;
import com.inad.mgr.domain.data.DataApt;
import com.inad.mgr.domain.data.DataMulti;
import com.inad.mgr.domain.data.DataOffice;
import com.inad.mgr.mapper.MapMapper;
import com.inad.mgr.util.StringUtil;

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

		String si = argv[0];
		String gun = argv[1];
		String gu = "";
		
		if(argv[argv.length-1].equals("산")) {
			gu = argv[argv.length-3];
		}else {
			gu = argv[argv.length-2];
		}
		
		return mapMapper.getCdInfoBig(si, gun, gu); 
	}

	@Override
	public List<BrTitleInfo> getKind(String[] argv, CdInfo cdInfo, String addr) throws Exception {
		
		StringUtil stringUtil = new StringUtil();

		String siCode = "";
		String bun = "";
		String ji = "";
		
		siCode = cdInfo.getSigunguCd();
		String bunJi = argv[argv.length-1];
		
		if(bunJi.contains("-")) {
			String[] temp = bunJi.split("-");
			bun = stringUtil.getJiBun(temp[0]);
			ji = stringUtil.getJiBun(temp[1]);
		} else {
			bun = stringUtil.getJiBun(bunJi);
			ji = "0000";
		}
		
		return mapMapper.getKind(addr, siCode, bun, ji);
	}

	@Override
	public List<BrExposInfoArea> getKindZipHap(String[] argv, CdInfo cdInfo, String addr) throws Exception {
		StringUtil stringUtil = new StringUtil();

		String siCode = "";
		String bun = "";
		String ji = "";
		
		siCode = cdInfo.getSigunguCd();
		String bunJi = argv[argv.length-1];
		
		if(bunJi.contains("-")) {
			String[] temp = bunJi.split("-");
			bun = stringUtil.getJiBun(temp[0]);
			ji = stringUtil.getJiBun(temp[1]);
		} else {
			bun = stringUtil.getJiBun(bunJi);
			ji = "0000";
		}
		
		return mapMapper.getKindZipHap(addr, siCode, bun, ji);
	}

	@Override
	public List<DataApt> getAptPrice(Map addrMap) throws Exception {

		return mapMapper.getAptPrice(addrMap);
	}

	@Override
	public List<DataOffice> getOfficePrice(Map addrMap) throws Exception {

		return mapMapper.getOfficePrice(addrMap);
	}

	@Override
	public List<DataMulti> getMultiPrice(Map addrMap) throws Exception {
		
		return mapMapper.getMultiPrice(addrMap);
	}

	@Override
	public List<DataAlone> getAlonePrice(Map addrMap) throws Exception {

		return mapMapper.getAlonePrice(addrMap);
	}
	
}
