package com.kvh.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class HelloWorldController {
    // to show html form
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }
    // need a controller method to process html
    
    @PostMapping("/processForm")
    public String processForm( ) {
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsDoTwo(HttpServletRequest request, Model model ) {
        //read the request parameter from the HTML form
        String theName = request.getParameter("studentName");
        //convert the data to all caps
        theName = theName.toUpperCase();
        // create the message
        String result = "YoYo!, "+ theName;
        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
    @RequestMapping("/processFormVersionThree")
    public String reqMethod(@RequestParam("studentName") String theName, Model model) {
        
        theName = theName.toUpperCase();
        // create the message
        String result = "Dear Friend, "+ theName;
        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
    
    
}
