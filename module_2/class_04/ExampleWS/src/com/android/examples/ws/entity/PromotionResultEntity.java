package com.android.examples.ws.entity;

import java.io.Serializable;
import java.util.List;

import com.android.examples.ws.entity.base.BaseRequest;
import com.android.examples.ws.entity.base.ErrorsEntity;

public class PromotionResultEntity implements Serializable {
	
	public PromotionsEntity Promotions =null;
	public String IdWeb ;
	public String IdLang;
	public ErrorsEntity Errors=null;

	public PromotionResultEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
