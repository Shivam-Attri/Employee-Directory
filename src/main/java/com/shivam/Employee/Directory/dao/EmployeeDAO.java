package com.shivam.Employee.Directory.dao;

import com.shivam.Employee.Directory.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findById(int idd);
    void save(Employee employee);
    void update(Employee employee);
    void delete(int id);
}
