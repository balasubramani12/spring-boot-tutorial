package com.kvh.restdemo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/test")
public class DemoRestController {

    // add "/hello" endpoint to test;
    @GetMapping("/hello")
    public String sayHello() {
        return "Helloworld! ... Status Up ...";
    }
    

}
