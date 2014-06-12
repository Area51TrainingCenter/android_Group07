package com.example.ejercicioslistas;

import java.util.ArrayList;
import java.util.List;

import com.example.ejercicioslistas.entity.RestaurantEntity;
import com.example.ejercicioslistas.restaurant.RestaurantAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class RestaurantActivity extends Activity {
	
	private ListView lstRestaurants;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_restaurant);
		
		//1. Listview OK
		//2. Item Layout, Entity
		//3. Data
		//3. Adapter
		//4. Setear Adapter a ListView
		
		//listview
		lstRestaurants= (ListView)findViewById(R.id.lstRestaurants);
		
		//data
		List<RestaurantEntity> data = new ArrayList<RestaurantEntity>();
		
		data.add(new RestaurantEntity(100, "Don Lucho", "Chatarra", 100,
				"Aqui voy a engordar mas rapido"));
		
		data.add(new RestaurantEntity(101, "Tia Veneno", "Chatarra", 50,
				"Aqui muerte segura"));
		
		data.add(new RestaurantEntity(102, "Pescado Happy", "Sano", 200,
				"Aqui vivirè màs años"));
		
		data.add(new RestaurantEntity(100, "Don Lucho", "Chatarra", 100,
				"Aqui voy a engordar mas rapido"));
		
		data.add(new RestaurantEntity(101, "Tia Veneno", "Chatarra", 50,
				"Aqui muerte segura"));
		
		data.add(new RestaurantEntity(102, "Pescado Happy", "Sano", 200,
				"Aqui vivirè màs años"));
		//adapter
		RestaurantAdapter adapter = new RestaurantAdapter(this,R.layout.item_layout,data);
	
		//setear adapter a listview
		lstRestaurants.setAdapter(adapter);
		
		//events
		lstRestaurants.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				RestaurantEntity current = (RestaurantEntity)parent.getAdapter().getItem(position);
				nextDetails(current);
				
			}
		});
		
		
		
		
	}
	protected void nextDetails(RestaurantEntity current) {
		// TODO Auto-generated method stub
		
		Bundle bundle = new Bundle();
		bundle.putSerializable("RESTAURANT", current);
		
		Intent intent= new Intent(this,DetailsActivity.class);
		intent.putExtras(bundle);
		startActivity(intent);
		
		
		
	}

}
