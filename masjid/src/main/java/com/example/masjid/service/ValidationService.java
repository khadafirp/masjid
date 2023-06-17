package com.example.masjid.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.validation.Validator;
//import org.springframework.validation.Validator;
//import jakarta.validation.ConstraintValidation;

@Service
public class ValidationService {

	@Autowired
	private Validator validator;
	
	public void validate(Object request) {
		Set<ConstraintViolation<Object>> constrainViolation = validator.validate(request);
		if(constrainViolation.size() != 0) {
			throw new javax.validation.ConstraintViolationException(constrainViolation);
		}
	}
}
