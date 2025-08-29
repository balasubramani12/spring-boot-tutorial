package com.empolyee.springboot.cruddemo.service;

import java.util.List;
import com.empolyee.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
    //get all employee
    List<Employee> findAll();
    // get an single employee by Id
    Employee findById(int id);
    
    // update a new employee
    Employee save(Employee theEmployee);

    // delete existing employee
    void deleteById(int id);
}
