package com.jsp.boot_user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.boot_user.util.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandlerForUser {
	@ExceptionHandler(java.sql.SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> SQLIntegrityConstraintViolationException(
			java.sql.SQLIntegrityConstraintViolationException e) {
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStateCode(HttpStatus.BAD_REQUEST.value());
		rs.setData(e.getMessage());
		rs.setMessage("can't perform operation");
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<ResponseStructure<String>> UserNotFound(UserNotFound e) {
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStateCode(HttpStatus.BAD_REQUEST.value());
		rs.setData(e.getMessage());
		rs.setMessage("can't perform operation");
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.BAD_REQUEST);
	}
}
