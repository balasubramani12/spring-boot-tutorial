package com.bsm.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DemoController {
    @GetMapping("/")
    public String getHome() {
        return "home";
    }
    @GetMapping("/leaders")
    public String showLeaderPage() {
        return "leaders";
    }
    @GetMapping("/systems")
    public String showAdminPage() {
        return "admins";
    }
    
    
}
