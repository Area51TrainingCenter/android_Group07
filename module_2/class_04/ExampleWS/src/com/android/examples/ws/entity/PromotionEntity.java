package com.android.examples.ws.entity;

import java.io.Serializable;

/**
 * 
 * @author Eduardo
 * http://developer.android.com/sdk/index.html
 * Windows > Preferences > Java > Code Style > Code Templates > Comments
 */

public class PromotionEntity implements Serializable {

	public String Descripcion;
	public String URL ;
	public String ImageURL ;
	public String Title;
	public int Type;
	
	

	public PromotionEntity(String descripcion, String uRL, String imageURL,
			String title, int type) {
		super();
		Descripcion = descripcion;
		URL = uRL;
		ImageURL = imageURL;
		Title = title;
		Type = type;
	}
	
	public PromotionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Descripcion "+Descripcion+" URL "+URL+
				"ImageURL "+ImageURL+"Title "+Title+" Type "+Type;
	}


	
}
