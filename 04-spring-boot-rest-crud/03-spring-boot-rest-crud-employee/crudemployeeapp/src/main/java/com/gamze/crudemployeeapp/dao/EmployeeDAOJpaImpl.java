package com.gamze.crudemployeeapp.dao;

import com.gamze.crudemployeeapp.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //define field for entitymanager
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // set up constructor injection


    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee", Employee.class);
        //execute query and get result list
        List<Employee> employees = theQuery.getResultList();
        // return the results
        return employees;

    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee=entityManager.find(Employee.class,theId);
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        //güncellenmiş çalışanı döndürür
        Employee updatedEmployee= entityManager.merge(employee);
        return updatedEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee theEmployee= entityManager.find(Employee.class, theId);
        entityManager.remove(theEmployee);

    }
}
