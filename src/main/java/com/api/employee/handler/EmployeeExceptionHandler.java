package com.api.employee.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.employee.errortype.ErrorType;
import com.api.employee.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorType>showError(RuntimeException e){
		return new ResponseEntity<ErrorType>(new ErrorType(e.getMessage(),
				"NO_EMPLOYEE_FOUND",
				"DATA NOT FOUND FOR THE GIVEN ID",
				"Employee"),HttpStatus.NOT_FOUND);
	}
}
