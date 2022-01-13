package com.inad.mgr.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inad.mgr.domain.Cropcord;
import com.inad.mgr.domain.StockCrt;
import com.inad.mgr.service.StockService;
import com.inad.mgr.util.HttpClient;
import com.inad.mgr.util.PagingVO;

@Slf4j
@Controller
@RequestMapping(value = "/stock")
public class stockController {
	
	final static String HOST_URL = "https://opendart.fss.or.kr/api/fnlttSinglAcntAll.json";
	final static String HOST_URL1 = "https://opendart.fss.or.kr/api/fnlttSinglAcntAll.json?crtfc_key=1b24a7be119ac5ab8df1299727a3d2e282197273&corp_code=00258801&bsns_year=2020&reprt_code=11011&fs_div=OFS";
	//메인 API 키
	final static String apiKey = "1b24a7be119ac5ab8df1299727a3d2e282197273";
	
	@Autowired
	private StockService stockService;
    
	@RequestMapping("/main")
	public String main(Model model) {
		
		model.addAttribute("nowPage", 1);
		//풀지말것
		//setIsOfs();
		
		return "stock/stock";
	}
	
	// 초기 기업 리스트 가져오기
	@RequestMapping(value="/getCrtfc", method=RequestMethod.POST)
    public ModelAndView getCrtfc(HttpServletRequest request, Model model, RedirectAttributes rttr, Principal prin) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		int result = 0;
		
		//HttpClient.useByteBuffer();
		List<Cropcord> cropcordList = new ArrayList<Cropcord>();
		
		cropcordList = stockService.getListCropcord();
		
		result = 1;
		
		mv.addObject("result", result);
		mv.addObject("cropcordList", cropcordList);
		
		return mv;
	}
	
	// 페이징으로 검색한 리스트 가져올것
	@RequestMapping(value="/getSearchCrtfc", method=RequestMethod.POST)
	public ModelAndView getSearchCrtfc(HttpServletRequest request, Model model, RedirectAttributes rttr, Principal prin) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		String nowPage = request.getParameter("nowPage");
		String cntPerPage = request.getParameter("cntPerPage");
		String search = request.getParameter("search");
		int result = 0;
		int total = stockService.countCrop(search);
		
		//HttpClient.useByteBuffer();
		List<Cropcord> cropcordList = new ArrayList<Cropcord>();
		PagingVO vo = new PagingVO();
		
		//계산하기
		// 페이징 처리
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		cropcordList = stockService.getSearchListCropcord(search ,vo.getEnd()-vo.getCntPerPage(), vo.getCntPerPage());
		
		List<StockCrt> stockCrtList = new ArrayList<StockCrt>();
		stockCrtList = mainCulStork(cropcordList);
		
		result = 1;
		
		mv.addObject("result", result);
		mv.addObject("paging", vo);
		mv.addObject("total", total);
		mv.addObject("cropcordList", cropcordList);
		mv.addObject("stockCrtList", stockCrtList);
		
		return mv;
	}
	
	// API가져와서 계산하기
	@RequestMapping(value="/getCrtApi", method=RequestMethod.POST)
    public ModelAndView getCrtApi(HttpServletRequest request, Model model, RedirectAttributes rttr, Principal prin) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		int result = 0;
		
		String cropCord = request.getParameter("cropCord"); 
		String cropJson = "";
		
		HttpURLConnection conn = null;
		JSONObject responseJson = null;
		
		URL url = new URL(HOST_URL + "?crtfc_key=" + apiKey + "&corp_code=" + cropCord + "&bsns_year=2020&reprt_code=11011&fs_div=OFS");
		
		conn = (HttpURLConnection)url.openConnection();
		conn.setConnectTimeout(5000);
		conn.setReadTimeout(5000);
		conn.setRequestMethod("GET");
		//conn.setDoOutput(true);
		
		int responseCode = conn.getResponseCode();
		if (responseCode == 400 || responseCode == 401 || responseCode == 500 ) {
			System.out.println(responseCode + " Error!");
		} else {
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = "";
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			cropJson = sb.toString();
		}
		
		result = 1;
		
		mv.addObject("result", result);
		mv.addObject("cropJson", cropJson);
		
		return mv;
	}
	
	
	//재무제표 여부 표시 API
	/* 재무제표가 존제하면 DB에 isOfs 1을 표현. 
	 * 모든 회사를 돌기때문에 갱신시에만 사용하면 된다. (총 10만번 돔)
	 * 전자공시 DART는 API요청을 하루에 1만건만 허용
	 * 분당 1000회 제한. 반드시 숙지후 사용할것.
	 */
	public void setIsOfs() {
		List<Cropcord> cropcordList = new ArrayList<Cropcord>();

        try {
        	int j=0;
        	
        	while(true) {
        		
        		cropcordList = stockService.getListCropcord();
            	
            	for(int i=0; i<100; i++) {
            		System.out.println(cropcordList.get(i).getCorpCode() + cropcordList.get(i).getCorpName() + cropcordList.get(i).getStockCode() + cropcordList.get(i).getModifyDate());
            	}
            	        	
            	// api 돌리기
            	for(int i=0; i<1000; i++) {
            		HttpURLConnection conn = null;
            		JSONObject responseJson = null;
            		
            		URL url = new URL(HOST_URL + "?crtfc_key=9a8fc6c316f957142b271baf6a6d79485dc8bf5f&corp_code=" + cropcordList.get(i).getCorpCode() + "&bsns_year=2020&reprt_code=11011&fs_div=OFS");
            		
            		conn = (HttpURLConnection)url.openConnection();
            		conn.setConnectTimeout(5000);
            		conn.setReadTimeout(5000);
            		conn.setRequestMethod("GET");
            		//conn.setDoOutput(true);
            		
            		int responseCode = conn.getResponseCode();
            		if (responseCode == 400 || responseCode == 401 || responseCode == 500 ) {
            			System.out.println(responseCode + " Error!");
            		} else {
            			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            			StringBuilder sb = new StringBuilder();
            			String line = "";
            			while ((line = br.readLine()) != null) {
            				sb.append(line);
            			}
            			responseJson = new JSONObject(sb.toString());
            			System.out.println(responseJson.get("status").toString() + " " + cropcordList.get(i).getCorpName());
            			if(responseJson.get("status").toString().equals("000")) {
            				System.out.println("찍히넹?");
            				stockService.setIsOfs(cropcordList.get(i).getCorpCode());
            			} else if(responseJson.get("status").toString().equals("013")) {
            				stockService.setIsNotOfs(cropcordList.get(i).getCorpCode());
            			} else {
            				System.out.println("더 이상 api를 받아올 수 없습니다.");
            				System.out.println("반환코드 : " + responseJson.get("status").toString());
            				return;
            			}
            		}
            	}
        		
        		j++;
        		Thread.sleep(70000);
        		
        		if(j>=10) {
        			break;
        		}
        	}
        	
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("not JSON Format response");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	//페이징 처리된 주식 리스트 계산하기
	public List<StockCrt> mainCulStork(List<Cropcord> cropcordList) throws Exception{
		List<StockCrt> stockCrtList = new ArrayList<StockCrt>();
		
		for(int i=0; i<cropcordList.size(); i++) {
			StockCrt stockCrt = new StockCrt();
			
			stockCrt.setCorpCode(cropcordList.get(i).getCorpCode());
			stockCrt.setCorpName(cropcordList.get(i).getCorpName());
			stockCrt.setStockCode(cropcordList.get(i).getStockCode());
			stockCrt.setPdcp("");
			stockCrt.setFpp("");
			stockCrt.setRatio("");
			stockCrt.setFsp("");
			stockCrt.setOpinion("");
			stockCrt.setOopinion("");
			
			stockCrtList.add(stockCrt);
		}
		
		return stockCrtList;
	}
}
