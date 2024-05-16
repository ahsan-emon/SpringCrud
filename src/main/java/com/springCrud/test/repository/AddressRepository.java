package com.springCrud.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springCrud.test.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
