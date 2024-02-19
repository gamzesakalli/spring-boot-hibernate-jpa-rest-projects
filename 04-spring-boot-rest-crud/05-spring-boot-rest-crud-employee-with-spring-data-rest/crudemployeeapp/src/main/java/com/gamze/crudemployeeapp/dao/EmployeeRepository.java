package com.gamze.crudemployeeapp.dao;

import com.gamze.crudemployeeapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //<Employee, Integer> entity type, primary key


}
