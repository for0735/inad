package com.inad.mgr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.inad.mgr.domain.CdInfo;

@Mapper
public interface MapMapper {
	public List<CdInfo> getCdInfoSmall(String[] argv) throws Exception;

	public List<CdInfo> getCdInfoBig(String[] argv) throws Exception;
}