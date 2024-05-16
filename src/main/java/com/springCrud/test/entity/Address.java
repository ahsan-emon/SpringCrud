package com.springCrud.test.entity;

import com.springCrud.test.custom.annotation.PrimeNumber;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="ADDRESS_INFO")
public class Address {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String address;
    @PrimeNumber
    private int isPrimeNo;
}
