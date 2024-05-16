package com.springCrud.test.container;

import com.springCrud.test.entity.Address;
import com.springCrud.test.entity.Employee;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeAddressRequest {
	private Employee employee;
	private Address address;
}