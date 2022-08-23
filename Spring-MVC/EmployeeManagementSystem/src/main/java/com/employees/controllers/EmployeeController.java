package com.employees.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employees.entities.Employee;
import com.employees.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	@Autowired
	ServletContext sc;

	@RequestMapping("/createEmployee")
	public String createEmployee() {
		return "CreateEmployee";
	}

	@RequestMapping("/saveEmployess")
	public String saveEmployee(@ModelAttribute("employee") Employee employee, ModelMap modelmap) {
		Employee emp = employeeservice.createEmployee(employee);
		String msg = "New employee created with name : " + emp.getName();
		modelmap.addAttribute("msg", msg);
		return "CreateEmployee";
	}

	@RequestMapping("/getAllEmployees")
	public String getAllEmployees(ModelMap modelMap) {

		List<Employee> employees = employeeservice.getAllEmployees();

		modelMap.addAttribute("employees", employees);
		return "GetAllEmployees";
	}

	@RequestMapping("deleteEmployee")
	public String deleteEmployee(@RequestParam("id") int id, ModelMap modelMap) {
		employeeservice.deletEmployee(id);
		List<Employee> employees = employeeservice.getAllEmployees();
		modelMap.addAttribute("employees", employees);
		return "GetAllEmployees";
	}
	
	@RequestMapping("editEmployee")
	public String editEmployee(@RequestParam("id") int id, ModelMap modelMap) {
	Employee employee=employeeservice.getEmployee(id);
		modelMap.addAttribute("employee", employee);
		return "EditEmployee";
	}
	
	@RequestMapping("/updateEmployee")
	public String updateEmployee(@ModelAttribute("employee") Employee employee,ModelMap modelMap) {
		Employee emp = employeeservice.updateEmployee(employee);
		String msg = "Employee details updated with id : " + emp.getId();
		System.out.println(msg);
		List<Employee> employees = employeeservice.getAllEmployees();

		modelMap.addAttribute("employees", employees);
		return "GetAllEmployees";
	}
	
}
