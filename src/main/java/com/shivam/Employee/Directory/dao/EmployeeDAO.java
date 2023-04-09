package com.shivam.Employee.Directory.dao;

import com.shivam.Employee.Directory.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findById(int idd);
    Employee saveOrUpdate(Employee employee);
    void delete(int id);
}
