package com.gamze.crudemployeeapp.dao;

import com.gamze.crudemployeeapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //<Employee, Integer> entity type, primary key


}
