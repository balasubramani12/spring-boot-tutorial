package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // constructor injection
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String getAll(Model theModel) {
        // fetch all the employees from db
        List<Employee> theEmployees = employeeService.findAll();
        // add to the spring model
        theModel.addAttribute("employees", theEmployees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // Create the Employee
        Employee theEmployee = new Employee();
        // Add the prop to model
        theModel.addAttribute("employee", theEmployee);
        //return the addForm
        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {

        // Create the Employee
        Employee theEmployee = employeeService.findById(theId);
        // Add the prop to model
        theModel.addAttribute("employee", theEmployee);
        //return the addForm
        return "employees/employee-form";
    }

    @GetMapping("/deleteEmployee")
    public String removeEmployee(@RequestParam("employeeId") int theId, Model theModel) {

        // Create the Employee
        employeeService.deleteById(theId);        
        //return the addForm
        return "redirect:/employees/list";
    }

    @PostMapping("/save")
    public String addEmployee(@ModelAttribute("employee") Employee theEmployee) {
        
        employeeService.save(theEmployee);
        
        return "redirect:/employees/list";
    }


    
    
    
}

