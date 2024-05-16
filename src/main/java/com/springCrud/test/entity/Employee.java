package com.springCrud.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
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
@Table(name="EMP_INFO")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Size(max = 5, message = "Description too long!")
    private String name;
    @Email(message = "Invalid email. Try again.")
    private String email;
    private String mobile;
    
    @OneToOne
    Address address;
}