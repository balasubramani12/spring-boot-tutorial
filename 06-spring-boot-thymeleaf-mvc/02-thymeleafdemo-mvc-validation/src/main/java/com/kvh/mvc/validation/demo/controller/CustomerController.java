package com.kvh.mvc.validation.demo.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.kvh.mvc.validation.demo.Customer;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class CustomerController {

    // add initbinder to convert trim input strings
    //resolve issue for validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor ste = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, ste);
    }
    @GetMapping("/showForm")
    public String showForm(Model theModel) {
        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult bindingResult) {
        
        System.out.println(bindingResult.toString()+"\n\n\n\n");
        if(bindingResult.hasErrors()){
            return "customer-form";
        }else{
            return "customer-confirmation";
        }
    }
    
    
}
