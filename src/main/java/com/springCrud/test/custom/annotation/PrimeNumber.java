package com.springCrud.test.custom.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.springCrud.test.custom.validator.PrimeNumberValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = PrimeNumberValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PrimeNumber {
	String message() default "must be a prime number";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
