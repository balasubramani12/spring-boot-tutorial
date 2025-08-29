package com.empolyee.springboot.cruddemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empolyee.springboot.cruddemo.dao.EmployeeDAO;
import com.empolyee.springboot.cruddemo.entity.Employee;
import com.empolyee.springboot.cruddemo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    public EmployeeRestController(EmployeeService employeeService, ObjectMapper theObjectMapper){
            this.employeeService = employeeService;
            this.objectMapper = theObjectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - "+ employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        // also just in case they pass an id in JSON ... set id to 0 <this makes insertion instead of deletion>
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee putEmployee(@RequestBody Employee theEmployee) {
        
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayLoad){
        // fetch the employee
        Employee tempEmployee = employeeService.findById(employeeId);
        // throw if employee not found
        if(tempEmployee==null){
            throw new RuntimeException("Employee with id "+employeeId+" not found!");
        }
        // throw exception if updation contains id
        if(patchPayLoad.containsValue("id")){
            throw new RuntimeException("Employee updation failed ...");
        }
        Employee patchedEmployee = apply(patchPayLoad, tempEmployee);

        return employeeService.save(patchedEmployee);
    }

    private Employee apply(Map<String, Object> patchPayLoad, Employee tempEmployee) {
        // Convert employee object to a JSON object node
        ObjectNode employeeNode = objectMapper.convertValue(tempEmployee, ObjectNode.class);

        // Convert the patchPayload map to a JSON object node
        ObjectNode patchNode = objectMapper.convertValue(patchPayLoad, ObjectNode.class);
        
        // Merge the patch updates into employee node
        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }
    
    // add delete mapping for employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        List<Employee> employeeList = employeeService.findAll();
        if(employeeId < 0 || employeeId >= employeeList.size()){
            throw new RuntimeException("Employee has not found ...");
        }
        employeeService.deleteById(employeeId);
        return "Employee has been removed";
    }
   
   
    
}
