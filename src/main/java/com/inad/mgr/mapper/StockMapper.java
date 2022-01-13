package com.inad.mgr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.inad.mgr.domain.ApmmNvLandOpen;
import com.inad.mgr.domain.BrExposInfoArea;
import com.inad.mgr.domain.BrTitleInfo;
import com.inad.mgr.domain.CdInfo;
import com.inad.mgr.domain.Cropcord;
import com.inad.mgr.domain.data.DataAlone;
import com.inad.mgr.domain.data.DataApt;
import com.inad.mgr.domain.data.DataCommercial;
import com.inad.mgr.domain.data.DataLand;
import com.inad.mgr.domain.data.DataMulti;
import com.inad.mgr.domain.data.DataOffice;

@Mapper
public interface StockMapper {
	public List<Cropcord> getListCropcord() throws Exception;
	public List<Cropcord> getSearchListCropcord(@Param("search")String search, @Param("limit")int start, @Param("cntPerPage")int end) throws Exception;
	public void setIsOfs(@Param("cropcord") String cropcord) throws Exception;
	public void setIsNotOfs(@Param("cropcord") String cropcord) throws Exception;
	public int countCrop(@Param("search")String search);
}