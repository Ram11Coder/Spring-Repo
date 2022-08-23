package com.employees.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employees.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
