package com.inad.mgr.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {
    @GetMapping("/")
    public String main(Model model) {
    	System.out.println("시작");
        return "main/index";
    }
   
    //@CrossOrigin(origins = "*")
    @ResponseBody
	@RequestMapping(value = "/index", produces = "application/json; charset=utf8")
	public String index(@RequestBody Map<String, Object> param) {
		
    	System.out.println("json테스트");
    	System.out.println(param);
		return "iii";
	}
}
