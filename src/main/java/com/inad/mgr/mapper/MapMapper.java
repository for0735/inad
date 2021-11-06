package com.inad.mgr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.inad.mgr.domain.BrExposInfoArea;
import com.inad.mgr.domain.BrTitleInfo;
import com.inad.mgr.domain.CdInfo;

@Mapper
public interface MapMapper {
	public List<CdInfo> getCdInfoSmall(String[] argv) throws Exception;

	public List<CdInfo> getCdInfoBig(@Param("si") String si, @Param("gun") String gun, @Param("gu") String gu) throws Exception;

	public List<BrTitleInfo> getKind(@Param("addr") String addr, @Param("siCode") String siCode, @Param("bun") String bun,
			@Param("ji") String ji) throws Exception;

	public List<BrExposInfoArea> getKindZipHap(@Param("addr") String addr, @Param("siCode") String siCode, @Param("bun") String bun,
			@Param("ji") String ji) throws Exception;
}