package com.inad.mgr.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inad.mgr.util.HttpClient;

@Slf4j
@Controller
@RequestMapping(value = "/stock")
public class stockController {
	
	final static String apiKey = "1b24a7be119ac5ab8df1299727a3d2e282197273";
    
	@RequestMapping("/main")
	public String main(Model model) {
		
		return "stock/stock";
	}
	
	// 검색
	@RequestMapping(value="/getCrtfc", method=RequestMethod.POST)
    public ModelAndView getCrtfc(HttpServletRequest request, Model model, RedirectAttributes rttr, Principal prin) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		HttpClient.useByteBuffer();
		
		return mv;
	}
			
}
