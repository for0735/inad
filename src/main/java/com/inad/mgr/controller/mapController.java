package com.inad.mgr.controller;

import lombok.extern.slf4j.Slf4j;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inad.mgr.domain.CdInfo;
import com.inad.mgr.service.MapService;

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
		String[] addrArr = addr.split(" ");
		
		//광역시로 변환
		if(addrArr[0].equals("서울")) {
			addrArr[0] = "서울특별시";
		} else if(addrArr[0].equals("경기")) {
			addrArr[0] = "경기도";
		} else if(addrArr[0].equals("부산")) {
			addrArr[0] = "부산광역시";
		} else if(addrArr[0].equals("인천")) {
			addrArr[0] = "인천광역시";
		} else if(addrArr[0].equals("대구")) {
			addrArr[0] = "대구광역시";
		} else if(addrArr[0].equals("광주")) {
			addrArr[0] = "광주광역시";
		} else if(addrArr[0].equals("울산")) {
			addrArr[0] = "울산광역시";
		} else if(addrArr[0].equals("경남")) {
			addrArr[0] = "경상남도";
		} else if(addrArr[0].equals("경북")) {
			addrArr[0] = "경상북도";
		} else if(addrArr[0].equals("충북")) {
			addrArr[0] = "충청북도";
		} else if(addrArr[0].equals("충남")) {
			addrArr[0] = "충청남도";
		} else if(addrArr[0].equals("전남")) {
			addrArr[0] = "전라남도";
		} else if(addrArr[0].equals("전북")) {
			addrArr[0] = "전라북도";
		} else if(addrArr[0].equals("강원")) {
			addrArr[0] = "강원도";
		} 
		
		for(int i=0; i<addrArr.length; i++) {
			System.out.println(addrArr[i]);
		}
		
		// 여기서부터 계산할것
		String mapKind = "";
		String siCode = "";
		String hangCode = "";
		
		siCode = findSiCode(addrArr);
		mapKind = mapKind(addrArr, siCode);
		
		System.out.println("필지가뭔데? " + mapKind);
		
		try {
			System.out.println(addr);
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.addObject("result", result);
		return mv;
	}
	
	
	public String mapKind(String[] argv, String siCode) {
		String addr = "";
		for(int i=0; i<argv.length-1; i++) {
			if(i!=0 || !argv[i].equals("산")) {
				addr = addr + " ";
			}
			
			if(!argv[i].equals("산")) {
				addr = addr + argv[i];
			}
		}
		
		System.out.println("검색주소 + " + addr);
		
		return "";
	}
	
	public String findSiCode(String[] argv) throws Exception {
		String siCode = "";
		List<CdInfo> cdInfo = new ArrayList<CdInfo>();
		if(argv.length <= 3 || argv[2].equals("산")) {
			//세종시 주소일 경우 검색법
			cdInfo = mapService.getCdInfoSmall(argv);
		} else {
			//평소 주소일경우 검색
			cdInfo = mapService.getCdInfoBig(argv);
		}
		siCode = cdInfo.get(0).getSigunguCd();
		System.out.println("너의 시코드?" + siCode);
		
		return siCode;
	}
}
