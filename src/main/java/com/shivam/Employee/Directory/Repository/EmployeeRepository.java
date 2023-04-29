package com.shivam.Employee.Directory.Repository;

import com.shivam.Employee.Directory.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
