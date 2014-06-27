package com.android.examples.ws.entity;

import java.io.Serializable;

public class SignaturesEntity implements Serializable {

	private int IdWeb=7;
	private int IdLang =1;
	private String IP ="127.0.0.1";
	private String KeyAccess ="123456";
	
	public SignaturesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public SignaturesEntity(int idWeb, int idLang, String iP, String keyAccess) {
		super();
		IdWeb = idWeb;
		IdLang = idLang;
		IP = iP;
		KeyAccess = keyAccess;
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

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public String getKeyAccess() {
		return KeyAccess;
	}

	public void setKeyAccess(String keyAccess) {
		KeyAccess = keyAccess;
	}
	
	
	
}
