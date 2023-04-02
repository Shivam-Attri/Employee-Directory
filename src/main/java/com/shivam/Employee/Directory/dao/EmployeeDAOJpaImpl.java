package com.shivam.Employee.Directory.dao;

import com.shivam.Employee.Directory.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl  implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query=entityManager.createQuery("from Employee",Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    @Transactional
    public void update(Employee employee) {
        //TDB
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(findById(id));
    }
}
