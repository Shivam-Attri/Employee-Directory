package com.shivam.Employee.Directory.service;

import com.shivam.Employee.Directory.entity.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee employee);
    void update(Employee employee);
    void delete(int id);
}
