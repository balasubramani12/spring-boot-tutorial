package com.kvh.springboot.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.kvh.springboot.thymeleafdemo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;
    
    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showStudentForm(Model theModel){
        // Student Model
        theModel.addAttribute("student", new Student());
        //Drop-Down Model
        theModel.addAttribute("countries", countries);
        //Radio Model
        theModel.addAttribute("languages", languages);
        //Checkbox Model
        theModel.addAttribute("systems", systems);
        
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent) {
        
        // To see result in console;
        System.out.println("Student Full Name: "+ theStudent.getFirstName()+" "+theStudent.getLastName());

        return "student-confirmation";
    }
    
}
