package com.devsuperior.bds02.controllers.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.bds02.services.exceptions.DataBaseException;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError();
		err.setError("Não encontrado");
		err.setMessage(e.getMessage());
		err.setStatus(status.value());

		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<StandardErrorNumberFormat> numberFormatException (NumberFormatException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardErrorNumberFormat err = new StandardErrorNumberFormat();
		err.setMessage("Formato invalido para o parametro ID");
		err.setStatus(status.value());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> dataBaseException(DataBaseException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError();
		err.setError("Integridade violada");
		err.setMessage(e.getMessage());
		err.setStatus(status.value());

		return ResponseEntity.status(status).body(err);
	}
}
