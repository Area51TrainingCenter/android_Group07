package com.example.applistcompuesta.model;

import java.util.List;

import com.example.applistcompuesta.HomeActivity;
import com.example.applistcompuesta.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class UserAdapter extends ArrayAdapter<UserEntity> {

	private List<UserEntity> data;
	private Context context;
	
	public UserAdapter(Context _context, int resource, List<UserEntity> objects) {
		super(_context, resource, objects);
		// TODO Auto-generated constructor stub
		context=_context;
		data= objects;
		
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater=((HomeActivity)(context)).getLayoutInflater();
		View container= inflater.inflate(R.layout.item_user, null);
		
		//ui
		ImageView imguser =(ImageView)container.findViewById(R.id.imgUser);
		TextView txtUsername= (TextView)container.findViewById(R.id.txtNameUser);
		TextView txtAgeUser=  (TextView)container.findViewById(R.id.txtAgeUser);
		
		//data
		UserEntity entity = data.get(position);
		txtUsername.setText(entity.getName());
		txtAgeUser.setText(entity.getAge());
		
		return container;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}
	
	@Override
	public UserEntity getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

}
