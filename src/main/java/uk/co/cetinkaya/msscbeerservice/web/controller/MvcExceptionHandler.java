package uk.co.cetinkaya.msscbeerservice.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class MvcExceptionHandler {
	
	public ResponseEntity<List> validationErrorHandler(ConstraintViolationException ex) {
		List<String> errorsList = new ArrayList<>(ex.getConstraintViolations().size());
		
		ex.getConstraintViolations().forEach(error -> errorsList.add(error.toString()));
		
		return new ResponseEntity<>(errorsList, HttpStatus.BAD_REQUEST);
	}

}
