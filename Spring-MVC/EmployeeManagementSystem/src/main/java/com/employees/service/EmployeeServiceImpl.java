package com.employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.entities.Employee;
import com.employees.repos.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public Employee createEmployee(Employee employee) {
		Employee emp = employeeRepo.save(employee);
		return emp;
	}

	@Override
	public void deletEmployee(int id) {
		employeeRepo.deleteById(id);
	}

	@Override
	public Employee getEmployee(int id) {
		
		return employeeRepo.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee emp = employeeRepo.save(employee);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeRepo.findAll();
		return employees;
	}
}
