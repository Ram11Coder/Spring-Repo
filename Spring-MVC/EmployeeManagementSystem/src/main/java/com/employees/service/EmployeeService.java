package com.employees.service;

import java.util.List;

import com.employees.entities.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee updateEmployee(Employee employee);

	Employee getEmployee(int id);

	void deletEmployee(int id);
}
