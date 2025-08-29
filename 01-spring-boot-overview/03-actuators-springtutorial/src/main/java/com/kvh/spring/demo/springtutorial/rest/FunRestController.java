package com.kvh.spring.demo.springtutorial.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController{
    @GetMapping("/")
    public String sayHello() {
        return coachName;
    }
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;
    
}