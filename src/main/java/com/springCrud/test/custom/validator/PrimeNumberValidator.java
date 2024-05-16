package com.springCrud.test.custom.validator;

import com.springCrud.test.custom.annotation.PrimeNumber;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumber, Integer> {

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if (value == null) {
            return true; // Consider null values as valid; use @NotNull for non-null validation
        }
        return isPrime(value);
	}
	private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
