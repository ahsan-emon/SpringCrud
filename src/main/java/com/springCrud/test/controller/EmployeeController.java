package com.springCrud.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springCrud.test.container.EmployeeAddressRequest;
import com.springCrud.test.entity.Address;
import com.springCrud.test.entity.Employee;
import com.springCrud.test.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody EmployeeAddressRequest employeeAddressRequest) {
		Employee employee = employeeAddressRequest.getEmployee();
		Address address = employeeAddressRequest.getAddress();
		return service.saveEmployee(employee, address);
	}
	@PostMapping("/addEmployees")
	public List<Employee> addEmployees(@RequestBody List<Employee> employees) {
		return service.saveEmployees(employees);
	}
	@GetMapping("/employees")
	public List<Employee> findAllEmployees(){
		return service.getEmployees();
	}
	@GetMapping("/emloyeeById/{id}")
	public Employee findEmployeeById(@PathVariable("id") int id) {
		return service.getEmployeeById(id);
	}
	@GetMapping("/emloyeeByName/{name}")
	public Employee findEmployeeByName(@PathVariable("name") String name) {
		return service.getEmployeeByName(name);
	}
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		return service.deleteEmployee(id);
	}
}
