package com.example.ejercicioslistas.restaurant;

import java.util.List;

import com.example.ejercicioslistas.R;
import com.example.ejercicioslistas.entity.RestaurantEntity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class RestaurantAdapter extends ArrayAdapter<RestaurantEntity> {

	private List<RestaurantEntity> data;
	private Context context;
	
	public RestaurantAdapter(Context _context, int resource,
			List<RestaurantEntity> objects) {
		super(_context, resource, objects);
		// TODO Auto-generated constructor stub
		context=_context;
		data= objects;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}
	
	@Override
	public RestaurantEntity getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		// TODO Auto-generated method stub
		View container =convertView;
		container = LayoutInflater.from(context).inflate(R.layout.item_layout, null);
		TextView txtName = (TextView)container.findViewById(R.id.txtRName);
		TextView txtCategory= (TextView)container.findViewById(R.id.txtRCategory);
		TextView txtReviews = (TextView)container.findViewById(R.id.txtRReviews);
		TextView txtDistance = (TextView)container.findViewById(R.id.txtRDistance);
		
		RestaurantEntity entity= data.get(position);
		String name = (entity.getName()==null)?(""):(entity.getName());
		String category = entity.getCategory();
		String reviews = 110+ "REVIEWS";//entity.get;
		
		String distance = entity.getDistance()+ "m";//entity.get;
		
		//setear valores
		txtName.setText(name);
		txtCategory.setText(category);
		txtReviews.setText(reviews);
		txtDistance.setText(distance);
		
		return container;
	}
	
	
	
	
	
	
	
	
	
	
	

}
