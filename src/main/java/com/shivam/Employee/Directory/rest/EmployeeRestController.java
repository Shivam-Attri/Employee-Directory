package com.shivam.Employee.Directory.rest;

import com.shivam.Employee.Directory.Exception.EmployeeNotFoundException;
import com.shivam.Employee.Directory.entity.Employee;
import com.shivam.Employee.Directory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee dbEmployee=employeeService.saveOrUpdate(employee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        if(employeeService.findById(employee.getId())==null){
            throw new EmployeeNotFoundException("Employee with id- "+employee.getId()+" not found");
        }
        Employee dbEmployee=employeeService.saveOrUpdate(employee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
        Employee employee=employeeService.findById(employeeId);
        if(employee==null){
            throw new EmployeeNotFoundException("Employee with id- "+employeeId+" not found");
        }
         employeeService.delete(employeeId);
    }
}
