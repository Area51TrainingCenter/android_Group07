package com.android.examples.ws.entity;

import java.io.Serializable;

import com.android.examples.ws.entity.base.BaseRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Eduardo José Medina Alfaro 
 * @email emedinaa@gmail.com
 *
 */
public class PromotionRequestEntity extends BaseRequest{

	@JsonProperty("Signatures")
	private SignaturesEntity Signatures=new SignaturesEntity();
	
	
	public PromotionRequestEntity(int idWeb, int idLang, SignaturesEntity signatures) {
		super();
		IdWeb = idWeb;
		IdLang = idLang;
		Signatures = signatures;
	}
	
	public PromotionRequestEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignaturesEntity getSignatures() {
		return Signatures;
	}

	public void setSignatures(SignaturesEntity signatures) {
		Signatures = signatures;
	}


	
}
