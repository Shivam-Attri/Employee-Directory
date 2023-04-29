package com.shivam.Employee.Directory.service;

import com.shivam.Employee.Directory.Exception.EmployeeNotFoundException;
import com.shivam.Employee.Directory.Repository.EmployeeRepository;
import com.shivam.Employee.Directory.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result= employeeRepository.findById(id);
        if(!result.isPresent()){
            throw new EmployeeNotFoundException("Employee with id- "+id+" not found");
        }
        return result.get();
    }

    @Override
    @Transactional
    public Employee saveOrUpdate(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
