package com.example.preporterociudadano.entity;

import java.io.Serializable;

public class ErrorEntity implements Serializable {
	private int code;
	private String error;
	
	public ErrorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	 
	 
}
