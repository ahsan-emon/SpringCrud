package com.springCrud.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springCrud.test.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	Employee findByName(String name);
}
