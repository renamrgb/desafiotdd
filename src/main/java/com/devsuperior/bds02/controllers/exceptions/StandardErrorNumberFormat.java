package com.devsuperior.bds02.controllers.exceptions;

import java.io.Serializable;

public class StandardErrorNumberFormat implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String message;
	
	
	public StandardErrorNumberFormat() {
		
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
