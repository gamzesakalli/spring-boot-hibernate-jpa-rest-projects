package com.gamze.crudemployeeapp.service;

import com.gamze.crudemployeeapp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee employee);
    void deleteById(int theId);
}
