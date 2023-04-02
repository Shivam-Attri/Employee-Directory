package com.shivam.Employee.Directory.rest;

import com.shivam.Employee.Directory.entity.Employee;
import com.shivam.Employee.Directory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    EmployeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }


    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }
}
