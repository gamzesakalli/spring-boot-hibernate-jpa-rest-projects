package com.gamze.crudemployeeapp.dao;

import com.gamze.crudemployeeapp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee employee);
    void deleteById(int theId);
}
