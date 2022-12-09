package com.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.model.Customer;

@Component
public class CustomerInfoValidation {

	public void validate(Object target, Errors errors) {
		Customer customer = (Customer) target;
		ValidationUtils.rejectIfEmpty(errors, "name", "NotEmpty.customerForm.name");
		ValidationUtils.rejectIfEmpty(errors, "phone_Number", "NotEmpty.customerForm.phone_Number");
	}

}
