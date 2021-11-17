package com.inad.mgr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.inad.mgr.domain.ApmmNvLandOpen;
import com.inad.mgr.domain.BrExposInfoArea;
import com.inad.mgr.domain.BrTitleInfo;
import com.inad.mgr.domain.CdInfo;
import com.inad.mgr.domain.data.DataAlone;
import com.inad.mgr.domain.data.DataApt;
import com.inad.mgr.domain.data.DataLand;
import com.inad.mgr.domain.data.DataMulti;
import com.inad.mgr.domain.data.DataOffice;

@Mapper
public interface MapMapper {
	public List<CdInfo> getCdInfoSmall(String[] argv) throws Exception;

	public List<CdInfo> getCdInfoBig(@Param("si") String si, @Param("gun") String gun, @Param("gu") String gu) throws Exception;

	public List<BrTitleInfo> getKind(@Param("addr") String addr, @Param("siCode") String siCode, @Param("bun") String bun,
			@Param("ji") String ji) throws Exception;
	
	public List<ApmmNvLandOpen> getKindLand(@Param("siCode") String siCode, @Param("bjdongCd") String bjdongCd, @Param("bun") String bun,
			@Param("ji") String ji) throws Exception;

	public List<BrExposInfoArea> getKindZipHap(@Param("addr") String addr, @Param("siCode") String siCode, @Param("bun") String bun,
			@Param("ji") String ji) throws Exception;
	
	public List<DataApt> getAptPrice(Map addrMap) throws Exception;
	public List<DataOffice> getOfficePrice(Map addrMap) throws Exception;
	public List<DataMulti> getMultiPrice(Map addrMap) throws Exception;
	public List<DataAlone> getAlonePrice(Map addrMap) throws Exception;
	public List<DataLand> getLandPrice(Map addrMap) throws Exception;
}