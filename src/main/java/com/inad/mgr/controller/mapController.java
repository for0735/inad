package com.inad.mgr.controller;

import lombok.extern.slf4j.Slf4j;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inad.mgr.domain.ApmmNvLandOpen;
import com.inad.mgr.domain.BrExposInfoArea;
import com.inad.mgr.domain.BrTitleInfo;
import com.inad.mgr.domain.CdInfo;
import com.inad.mgr.domain.data.DataAlone;
import com.inad.mgr.domain.data.DataApt;
import com.inad.mgr.domain.data.DataLand;
import com.inad.mgr.domain.data.DataMulti;
import com.inad.mgr.domain.data.DataOffice;
import com.inad.mgr.service.MapService;
import com.inad.mgr.util.StringUtil;

@Slf4j
@Controller
@RequestMapping(value = "/map")
public class mapController {
	
	@Autowired
	private MapService mapService;
    
	// 메인
	@RequestMapping("/main")
	public String main(Model model) {
		
		return "map/map";
	}
	

	// 검색
	@RequestMapping(value="/search", method=RequestMethod.POST)
    public ModelAndView search(HttpServletRequest request, Model model, RedirectAttributes rttr, Principal prin) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		int result = 0;
		String addr = request.getParameter("addr"); 
		String[] addrList200 = request.getParameterValues("addrList200");
		//String[] addrList500 = request.getParameterValues("addrList500");
		
		//중복제거
        int length = StringUtil.remove_Duplicate_Elements(addrList200, addrList200.length);
        
		String[] addrArr = addr.split(" ");
		addrArr[0] = siNameReturn(addrArr[0]);
		
		String[][] addrArr200 = new String[length][];
		for(int i=0; i<length; i++) {
			String[] temp = addrList200[i].split(" ");
			addrArr200[i] = new String[temp.length];
			for(int j=0; j<temp.length; j++) {
				addrArr200[i][j] = temp[j];
			}
			addrArr200[i][0] = siNameReturn(addrArr200[i][0]);
		}
		
		//중복제거
		/*int length = StringUtil.remove_Duplicate_Elements(addrList500, addrList500.length);
		
		String[][] addrArr500 = new String[length][];
		for(int i=0; i<length; i++) {
			String[] temp = addrList500[i].split(" ");
			addrArr500[i] = new String[temp.length];
			for(int j=0; j<temp.length; j++) {
				addrArr500[i][j] = temp[j];
			}
			addrArr500[i][0] = siNameReturn(addrArr500[i][0]);
		}*/
		
		//System.out.println(Arrays.deepToString(addrArr200));
		
		
		
		// 여기서부터 계산할것 ==================================================================================
		Map<String, Object> addrMap = new HashMap<String, Object>();
		CdInfo cdInfo = findCdInfo(addrArr);
		
		addrMap = mapKind(addrArr, cdInfo);
		System.out.println("필지가뭔데? " + addrMap.get("mapKind").toString());
		
		
		// 여기서부터 가격산정
		String price = "";
		
		if(addrMap.get("mapKind").toString().equals("98") || addrMap.get("mapKind").toString().equals("99")) {
			// 비정상 코드
			mv.addObject("price", price);
		} else if(addrMap.get("mapKind").toString().equals("2")) { // 아파트
			List<BrExposInfoArea> br = (ArrayList<BrExposInfoArea>)addrMap.get("brExposInfoAreaList");
			BrExposInfoArea brExposInfoArea = new BrExposInfoArea();
			brExposInfoArea = br.get(0);
			
			addrMap = getAptPrice(addrMap, br.get(0).getArea());
			addrMap.put("brExposInfoArea", brExposInfoArea);
			System.out.println("가격은??? : " + addrMap.get("price").toString());
			
			mv.addObject("multiList", (ArrayList<DataApt>)addrMap.get("multiList"));
		} else if(addrMap.get("mapKind").toString().equals("4")) { // 오피스텔
			List<BrExposInfoArea> br = (ArrayList<BrExposInfoArea>)addrMap.get("brExposInfoAreaList");

			price = getOfficePrice(addrMap, br.get(0).getArea());
			System.out.println("가격은??? : " + price);
		} else if(addrMap.get("mapKind").toString().equals("3")) { // 연립다세대
			List<BrExposInfoArea> br = (ArrayList<BrExposInfoArea>)addrMap.get("brExposInfoAreaList");

			//price = getMultiPrice(addrMap, br.get(0).getArea(), addrArr200);
			System.out.println("가격은??? : " + price);
		} else if(addrMap.get("mapKind").toString().equals("0")) { // 토지
			price = getLandPrice(addrMap, addrArr200);
			System.out.println("가격은??? : " + price);
		} else if(addrMap.get("mapKind").toString().equals("1")) { // 단독다가구
			List<BrTitleInfo> br = (ArrayList<BrTitleInfo>)addrMap.get("brTitleInfoList");

			price = getAlonePrice(addrMap, br.get(0).getPlatArea(), addrArr200);
			System.out.println("가격은??? : " + price);
		} else if(addrMap.get("mapKind").toString().equals("5")) { // 구분상가
			price = getCommercialPrice(addrMap);
		}
		
		
		
		try {
			System.out.println(addr);
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.addObject("addrMap", addrMap);
		mv.addObject("landKind", addrMap.get("mapKind").toString());
		mv.addObject("price", price);
		mv.addObject("result", result);
		return mv;
	}
	
	// 시 네이밍 변경
	public String siNameReturn(String si) {
		//광역시로 변환 =========================================================================
		if(si.equals("서울")) {
			si = "서울특별시";
		} else if(si.equals("경기")) {
			si = "경기도";
		} else if(si.equals("부산")) {
			si = "부산광역시";
		} else if(si.equals("인천")) {
			si = "인천광역시";
		} else if(si.equals("대구")) {
			si = "대구광역시";
		} else if(si.equals("광주")) {
			si = "광주광역시";
		} else if(si.equals("울산")) {
			si = "울산광역시";
		} else if(si.equals("경남")) {
			si = "경상남도";
		} else if(si.equals("경북")) {
			si = "경상북도";
		} else if(si.equals("충북")) {
			si = "충청북도";
		} else if(si.equals("충남")) {
			si = "충청남도";
		} else if(si.equals("전남")) {
			si = "전라남도";
		} else if(si.equals("전북")) {
			si = "전라북도";
		} else if(si.equals("강원")) {
			si = "강원도";
		} 
		//================================================================================================
		
		return si;
	}
	
	
	// 필지종류구하기
	public Map<String, Object> mapKind(String[] argv, CdInfo cdInfo) throws Exception {
		
		/*
		 * 0 : 토지
		 * 1 : 토지건물
		 * 2 : 아파트
		 * 3 : 연립다세대
		 * 4 : 오피스텔
		 * 5 : 구분상가
		 * 98 : 가격산정안하기
		 * 99 : 오류
		 */
		
		List<BrTitleInfo> brTitleInfoList = new ArrayList<BrTitleInfo>();
		List<BrExposInfoArea> brExposInfoAreaList = new ArrayList<BrExposInfoArea>();
		List<ApmmNvLandOpen> apmmNvLandOpenList = new ArrayList<ApmmNvLandOpen>();
		Map<String, Object> addrMap = new HashMap<String, Object>();
		String mapKind = "";
		String addr = "";
		
		for(int i=0; i<argv.length-1; i++) {
			if(i!=0 && !argv[i].equals("산")) {
				addr = addr + " ";
			}
			
			if(!argv[i].equals("산")) {
				addr = addr + argv[i];
			}
		}
		
		addrMap.put("cdInfo", cdInfo);
		addrMap.put("addr", addr);
		addrMap.put("argv", argv);
		
		

		// 필지구해와야함...
		brTitleInfoList = mapService.getKind(argv, cdInfo, addr);
		if(brTitleInfoList.size() == 0) {
			addrMap.put("mapKind", "0");
			apmmNvLandOpenList = mapService.getKindLand(argv, cdInfo, addr);

			if(apmmNvLandOpenList.size()!=0) {
				addrMap.put("bun", apmmNvLandOpenList.get(0).getBobn());
				addrMap.put("ji", apmmNvLandOpenList.get(0).getBubn());				
			} else {
				addrMap.put("bun", "9999");
				addrMap.put("ji", "9999");	
			}
			System.out.println("이거토지임");
		} else if(brTitleInfoList.get(0).getRegstrGbCd().equals("1")){
			addrMap.put("mapKind", "1");
			addrMap.put("bun", brTitleInfoList.get(0).getBun());
			addrMap.put("ji", brTitleInfoList.get(0).getJi());
			System.out.println("이거토지건물임");
		} else if(brTitleInfoList.get(0).getRegstrGbCd().equals("2")) {
			//추가로직 동작
			brExposInfoAreaList = mapService.getKindZipHap(argv, cdInfo, addr);
			
			if(brExposInfoAreaList.size() == 0) {
				addrMap.put("mapKind", "98");
				System.out.println("집합인데 없어서 토지로 판단 가격산정(x)");
			} else if(brExposInfoAreaList.get(0).getMainPurpsCd().equals("02001")) {
				addrMap.put("mapKind", "2");
				addrMap.put("bun", brExposInfoAreaList.get(0).getBun());
				addrMap.put("ji", brExposInfoAreaList.get(0).getJi());
				System.out.println("이거아파트임");
			} else if(brExposInfoAreaList.get(0).getMainPurpsCd().equals("02002") || brExposInfoAreaList.get(0).getMainPurpsCd().equals("02003")
					|| brExposInfoAreaList.get(0).getMainPurpsCd().equals("02000")) {
				addrMap.put("mapKind", "3");
				addrMap.put("bun", brExposInfoAreaList.get(0).getBun());
				addrMap.put("ji", brExposInfoAreaList.get(0).getJi());
				System.out.println("이거연립다세대임");
			} else if(brExposInfoAreaList.get(0).getMainPurpsCd().equals("01000") || brExposInfoAreaList.get(0).getMainPurpsCd().equals("01001")
					|| brExposInfoAreaList.get(0).getMainPurpsCd().equals("01002") || brExposInfoAreaList.get(0).getMainPurpsCd().equals("01003")) {
				addrMap.put("mapKind", "1");
				addrMap.put("bun", brExposInfoAreaList.get(0).getBun());
				addrMap.put("ji", brExposInfoAreaList.get(0).getJi());
				System.out.println("이거토지건물인데...?");
			} else if(brExposInfoAreaList.get(0).getMainPurpsCd().equals("14200") || brExposInfoAreaList.get(0).getMainPurpsCd().equals("14202")) {
				addrMap.put("mapKind", "4");
				addrMap.put("bun", brExposInfoAreaList.get(0).getBun());
				addrMap.put("ji", brExposInfoAreaList.get(0).getJi());
				System.out.println("이거오피스텔임");
			} else {
				addrMap.put("mapKind", "5");
				addrMap.put("bun", brExposInfoAreaList.get(0).getBun());
				addrMap.put("ji", brExposInfoAreaList.get(0).getJi());
				System.out.println("이거구분상가임");
			}
		} else {
			addrMap.put("mapKind", "99");
			System.out.println("여기타면 비정상.....");
		}
		
		// 리스트 담아서 넘겨주기
		if(brTitleInfoList.size() == 0) {
			if(apmmNvLandOpenList.size() != 0) {
				addrMap.put("apmmNvLandOpenList", apmmNvLandOpenList);
			}
			// 아무것도 안함..
		} else if(brTitleInfoList.get(0).getRegstrGbCd().equals("1")){
			addrMap.put("brTitleInfoList", brTitleInfoList);
		} else if(brTitleInfoList.get(0).getRegstrGbCd().equals("2")) {
			if(brExposInfoAreaList.size() == 0) {
				// 아무것도 안함..
			} else {				
				addrMap.put("brExposInfoAreaList", brExposInfoAreaList);
			}
		} else {
			// 아무것도 안함..
		}
		
		
		return addrMap;
	}
	
	// 시코드구하기
	public CdInfo findCdInfo(String[] argv) throws Exception {
		CdInfo cdInfo = new CdInfo();
		List<CdInfo> cdInfoList = new ArrayList<CdInfo>();
		if(argv.length <= 3 || argv[2].equals("산")) {
			//세종시 주소일 경우 검색법
			cdInfoList = mapService.getCdInfoSmall(argv);
		} else {
			//평소 주소일경우 검색
			cdInfoList = mapService.getCdInfoBig(argv);
		}
		cdInfo = cdInfoList.get(0);
		
		return cdInfo;
	}
	
	// 아파트 가격산정
	public Map<String, Object> getAptPrice(Map<String, Object> addrMap, String area) throws Exception {
		String price = "";
		List<DataApt> dataAptList = new ArrayList<DataApt>();
		dataAptList = mapService.getAptPrice(addrMap);
		
		long temp = 0;
		List<Float> tempF = new ArrayList<Float>();
		float areaF = Float.parseFloat(area);
		for(int i=0; i<dataAptList.size(); i++) {
			if(areaF-10 < Float.parseFloat(dataAptList.get(i).getTotArea()) && Float.parseFloat(dataAptList.get(i).getTotArea()) < areaF+10) {
				int tradePrice = Integer.parseInt(dataAptList.get(i).getTradePrice());
				float totArea = Float.parseFloat(dataAptList.get(i).getTotArea());
				
				tempF.add(tradePrice/totArea);
			}
		}
		
		float sum = 0.0f;
		for(int i=0; i<tempF.size(); i++) {
			sum = sum + tempF.get(i);
			System.out.println(tempF.get(i));
		}
		
		System.out.println("--------------------------");
		System.out.println(sum);
		System.out.println(Math.round(sum));
		System.out.println(tempF.size());
		System.out.println((Math.round(sum/tempF.size() * areaF)));
		addrMap.put("price", Integer.toString((Math.round(sum/tempF.size() * areaF))) + "0000");
		addrMap.put("multiSPrice", Integer.toString((Math.round(sum/tempF.size()))) + "0000");
		addrMap.put("multiList", dataAptList);
		
		return addrMap;
	}
	
	// 오피스텔 가격산정
	public String getOfficePrice(Map<String, Object> addrMap, String area) throws Exception {
		String price = "";
		List<DataOffice> dataOfficeList = new ArrayList<DataOffice>();
		dataOfficeList = mapService.getOfficePrice(addrMap);
		
		long temp = 0;
		List<Float> tempF = new ArrayList<Float>();
		float areaF = Float.parseFloat(area);
		for(int i=0; i<dataOfficeList.size(); i++) {
			if(areaF-10 < Float.parseFloat(dataOfficeList.get(i).getTotArea()) && Float.parseFloat(dataOfficeList.get(i).getTotArea()) < areaF+10) {
				int tradePrice = Integer.parseInt(dataOfficeList.get(i).getTradePrice());
				float totArea = Float.parseFloat(dataOfficeList.get(i).getTotArea());
				
				tempF.add(tradePrice/totArea);
			}
		}
		
		float sum = 0.0f;
		for(int i=0; i<tempF.size(); i++) {
			sum = sum + tempF.get(i);
			System.out.println(tempF.get(i));
		}
		
		System.out.println("--------------------------");
		System.out.println(sum);
		System.out.println(Math.round(sum));
		System.out.println(tempF.size());
		System.out.println((Math.round(sum/tempF.size() * areaF)));
		price = Integer.toString((Math.round(sum/tempF.size() * areaF))) + "0000";
		
		return price;
	}
	
	// 연립다세대 가격산정
	public String getMultiPrice(Map<String, Object> addrMap, String area, String[][] addrArr) throws Exception {
		String price = "";
		List<DataMulti> dataMultiList = new ArrayList<DataMulti>();
		
		//실거래 리스트 가져오기
		//가져온 주소를 바탕으로 연립다세대만 뽑아냄. 그래서 addrMap에 추가
		System.out.println("배열의길이" + addrArr.length);
		for(int i=0; i<addrArr.length; i++) {
			System.out.println(i);
			System.out.println(Arrays.deepToString(addrArr[i]));
			CdInfo tempCdInfo = findCdInfo(addrArr[i]);
			
			
			addrMap = mapKind(addrArr[i], tempCdInfo);
			
			if(addrMap.get("mapKind").toString().equals("3")) {
				List<DataMulti> tempDataMultiList = new ArrayList<DataMulti>();
				
				tempDataMultiList = mapService.getMultiPrice(addrMap);
				
				System.out.println("사이즈  " + tempDataMultiList.size());
				for(int j=0; j<tempDataMultiList.size(); j++) {
					dataMultiList.add(tempDataMultiList.get(j));
				}
			}
		}
		
		long temp = 0;
		List<Float> tempF = new ArrayList<Float>();
		float areaF = Float.parseFloat(area);
		for(int i=0; i<dataMultiList.size(); i++) {
			if(areaF-15 < Float.parseFloat(dataMultiList.get(i).getTotArea()) && Float.parseFloat(dataMultiList.get(i).getTotArea()) < areaF+15) {
				int tradePrice = Integer.parseInt(dataMultiList.get(i).getTradePrice());
				float totArea = Float.parseFloat(dataMultiList.get(i).getTotArea());
				
				tempF.add(tradePrice/totArea);
			}
		}
		
		float sum = 0.0f;
		for(int i=0; i<tempF.size(); i++) {
			sum = sum + tempF.get(i);
			System.out.println(tempF.get(i));
		}
		
		System.out.println("--------------------------");
		System.out.println(sum);
		System.out.println(Math.round(sum));
		System.out.println(tempF.size());
		System.out.println((Math.round(sum/tempF.size() * areaF)));
		price = Integer.toString((Math.round(sum/tempF.size() * areaF))) + "0000";
		
		return price;
	}
	
	// 토지 가격산정
	public String getLandPrice(Map<String, Object> addrMap, String[][] addrArr) throws Exception {
		String price = "";
		List<ApmmNvLandOpen> br = (ArrayList<ApmmNvLandOpen>)addrMap.get("apmmNvLandOpenList");
		List<DataLand> dataLandList = new ArrayList<DataLand>();
		
		ApmmNvLandOpen apmm = new ApmmNvLandOpen();
		apmm = br.get(0);
		
		//실거래 리스트 가져오기
		//가져온 주소를 바탕으로 연립다세대만 뽑아냄. 그래서 addrMap에 추가
		System.out.println("배열의길이" + addrArr.length);
		for(int i=0; i<addrArr.length; i++) {
			System.out.println(i);
			System.out.println(Arrays.deepToString(addrArr[i]));
			if(Arrays.deepToString(addrArr[i]).equals("")) {
				continue;
			}
			CdInfo tempCdInfo = findCdInfo(addrArr[i]);
			
			
			addrMap = mapKind(addrArr[i], tempCdInfo);
			
			if(addrMap.get("mapKind").toString().equals("0")) {
				List<DataLand> tempDataLandList = new ArrayList<DataLand>();
				
				tempDataLandList = mapService.getLandPrice(addrMap);
				
				System.out.println("사이즈  " + tempDataLandList.size());
				for(int j=0; j<tempDataLandList.size(); j++) {
					// 용도지역은 완전일치, 이용상황은 조건부일치
					if(apmm.getSpfc1().equals(tempDataLandList.get(j).getMainPurpsAreaCd()) || apmm.getSpfc2().equals(tempDataLandList.get(j).getMainPurpsAreaCd())) {
						List<ApmmNvLandOpen> tempBr = (ArrayList<ApmmNvLandOpen>)addrMap.get("apmmNvLandOpenList");
						
						if(tempBr.size() != 0 && StringUtil.BLandUse(apmm.getLandUse(), tempBr.get(0).getLandUse())) {
							dataLandList.add(tempDataLandList.get(j));
						}
					}
				}				
			}
		}
		
		long temp = 0;
		float areaF = Float.parseFloat(apmm.getParea());
		List<Float> tempF = new ArrayList<Float>();
		for(int i=0; i<dataLandList.size(); i++) {
			int tradePrice = Integer.parseInt(dataLandList.get(i).getTradePrice());
			float totArea = Float.parseFloat(dataLandList.get(i).getAgreementArea());
			
			tempF.add(tradePrice/totArea);
		}
		
		float sum = 0.0f;
		for(int i=0; i<tempF.size(); i++) {
			sum = sum + tempF.get(i);
			System.out.println(tempF.get(i));
		}
		
		System.out.println("--------------------------");
		System.out.println(sum);
		System.out.println(Math.round(sum));
		System.out.println(tempF.size());
		System.out.println((Math.round(sum/tempF.size() * areaF)));
		price = Integer.toString((Math.round(sum/tempF.size() * areaF))) + "0000";
		
		return price;
	}
	
	// 구분상가 가격산정
	public String getCommercialPrice(Map<String, Object> addrMap) {
		String price = "";
		
		
		
		return price;
	}
	
	// 단독다가구 가격산정
	public String getAlonePrice(Map<String, Object> addrMap, String area, String[][] addrArr) throws Exception {
		String price = "";
		List<DataAlone> dataAloneList = new ArrayList<DataAlone>();
		
		//실거래 리스트 가져오기
		//가져온 주소를 바탕으로 연립다세대만 뽑아냄. 그래서 addrMap에 추가
		System.out.println("배열의길이" + addrArr.length);
		for(int i=0; i<addrArr.length; i++) {
			System.out.println(i);
			System.out.println(Arrays.deepToString(addrArr[i]));
			if(Arrays.deepToString(addrArr[i]).equals("")) {
				continue;
			}
			CdInfo tempCdInfo = findCdInfo(addrArr[i]);
			
			
			addrMap = mapKind(addrArr[i], tempCdInfo);
			
			if(addrMap.get("mapKind").toString().equals("1")) {
				List<DataAlone> tempDataAloneList = new ArrayList<DataAlone>();
				
				tempDataAloneList = mapService.getAlonePrice(addrMap);
				
				System.out.println("사이즈  " + tempDataAloneList.size());
				for(int j=0; j<tempDataAloneList.size(); j++) {
					dataAloneList.add(tempDataAloneList.get(j));
				}
			}
		}
		
		long temp = 0;
		List<Float> tempF = new ArrayList<Float>();
		float areaF = Float.parseFloat(area);
		for(int i=0; i<dataAloneList.size(); i++) {
			if(areaF-15 < Float.parseFloat(dataAloneList.get(i).getTotArea()) && Float.parseFloat(dataAloneList.get(i).getTotArea()) < areaF+15) {
				int tradePrice = Integer.parseInt(dataAloneList.get(i).getTradePrice());
				float totArea = Float.parseFloat(dataAloneList.get(i).getTotArea());
				
				tempF.add(tradePrice/totArea);
			}
		}
		
		float sum = 0.0f;
		for(int i=0; i<tempF.size(); i++) {
			sum = sum + tempF.get(i);
			System.out.println(tempF.get(i));
		}
		
		System.out.println("--------------------------");
		System.out.println(sum);
		System.out.println(Math.round(sum));
		System.out.println(tempF.size());
		System.out.println((Math.round(sum/tempF.size() * areaF)));
		price = Integer.toString((Math.round(sum/tempF.size() * areaF))) + "0000";
		
		return price;
	}
}
