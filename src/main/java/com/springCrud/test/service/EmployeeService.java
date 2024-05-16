package com.springCrud.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.springCrud.test.entity.Address;
import com.springCrud.test.entity.Employee;
import com.springCrud.test.repository.AddressRepository;
import com.springCrud.test.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	@Autowired
	private AddressRepository addressRepository;
	@Transactional(isolation = Isolation.REPEATABLE_READ)
	public Employee saveEmployee(Employee employee, Address address) {
		addressRepository.save(address);
		employee.setAddress(address);
		try {
            Thread.sleep(2000); // 2 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
		return repository.save(employee);
	}
	public List<Employee> saveEmployees(List<Employee> employees){
		return repository.saveAll(employees);
	}
//	@Transactional(readOnly = true)
	public List<Employee> getEmployees(){
		Employee employee = new Employee();
		employee.setName("Efrad");
		employee.setEmail("efrad@gmail.com");
		employee.setMobile("4646849");
		repository.save(employee);
		System.out.println("Here is the new employee :"+employee);
		return repository.findAll();
	}
	public Employee getEmployeeById(int id) {
		return repository.findById(id).orElse(null);
	}
	public Employee getEmployeeByName(String name) {
		return repository.findByName(name);
	}
	public Employee updateEmployee(Employee employee) {
		Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
		
		existingEmployee.setName(employee.getName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setMobile(employee.getMobile());
		return repository.save(existingEmployee);
	}
	public String deleteEmployee(int id) {
		repository.deleteById(id);
		return "Employee removed! "+id;
	}
}
