package com.example.ejercicioslistas;

import com.example.ejercicioslistas.entity.RestaurantEntity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailsActivity extends Activity {
	
	private RestaurantEntity entity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		validateExtras();
		
		if(entity!=null)
		{
			((TextView)findViewById(R.id.txtDName)).setText(entity.getName());
			//Log.v("CONSOLE", "1. error"+findViewById(R.id.txtRName));
			//Log.v("CONSOLE", "2. error "+entity.getName());
		}
	}

	private void validateExtras() {
		// TODO Auto-generated method stub
		if(getIntent()!=null)
		{
			Bundle bundle= getIntent().getExtras();
			if(bundle!=null)
			{
				entity = (RestaurantEntity)bundle.getSerializable("RESTAURANT");
			}
		}
		
	}

}
