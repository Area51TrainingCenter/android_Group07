package com.android.examples.ws.entity.base;

import java.io.Serializable;

public class BaseRequest implements Serializable {

	protected int IdWeb =7;
	protected int IdLang=1;
	protected ErrorsEntity Errors=null;
	
	public BaseRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdWeb() {
		return IdWeb;
	}

	public void setIdWeb(int idWeb) {
		IdWeb = idWeb;
	}

	public int getIdLang() {
		return IdLang;
	}

	public void setIdLang(int idLang) {
		IdLang = idLang;
	}

	public ErrorsEntity getErrors() {
		return Errors;
	}

	public void setErrors(ErrorsEntity errors) {
		Errors = errors;
	}
	
	
	
}
