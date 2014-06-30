package com.example.apppractica04.restaurant;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.apppractica04.R;
import com.example.apppractica04.entity.RestaurantEntity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class RestaurantFragment extends BaseFragment {
	
	private ListView lstRestaurant;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		return inflater.inflate(R.layout.fragment_restaurant, container,false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		lstRestaurant=(ListView)getView().findViewById(R.id.lstRestaurant);
		Log.v("CONSOLE"," "+lstRestaurant);
		RestaurantEntity[] obj = {
			new RestaurantEntity("Cocinero", "Vegetariano", "2543298", "Las Palmera 232",
					"Sin descripción"),
			new RestaurantEntity("Cocinero", "Vegetariano", "2543298", "Las Palmera 232",
							"Sin descripción"),
			new RestaurantEntity("Cocinero", "Vegetariano", "2543298", "Las Palmera 232",
									"Sin descripción"),
			new RestaurantEntity("Cocinero", "Vegetariano", "2543298", "Las Palmera 232",
											"Sin descripción"),
		};
		List<RestaurantEntity> objects =Arrays.asList(obj);
		Log.v("CONSOLE"," "+objects);
		
		RestaurantAdapter adapter=new RestaurantAdapter(getActivity(), 
				R.layout.item_restaurant,objects );
		
		lstRestaurant.setAdapter(adapter); 
	}

}
