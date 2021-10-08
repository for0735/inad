package com.inad.mgr.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {
    @GetMapping("/")
    public String main(Model model) {
    	System.out.println("시작");
        return "main/index";
    }
}
