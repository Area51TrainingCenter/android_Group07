package com.example.apppractica04.restaurant;

import java.util.List;

import com.example.apppractica04.R;
import com.example.apppractica04.entity.RestaurantEntity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class RestaurantAdapter extends ArrayAdapter<RestaurantEntity> 
{
	private Context context;
	private List<RestaurantEntity> data;
	
	public RestaurantAdapter(Context _context, int resource,
			List<RestaurantEntity> objects) {
		super(_context, resource, objects);
		// TODO Auto-generated constructor stub
		context = _context;
		data = objects;
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
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v = convertView;
		ViewHolder holder;
		
		if(v==null)
		{
			holder =new ViewHolder();
			LayoutInflater inflater = LayoutInflater.from(context);
			v= inflater.inflate(R.layout.item_restaurant, parent, false);
			
			holder.txtName = (TextView)v.findViewById(R.id.txtName);
			holder.txtCategory = (TextView)v.findViewById(R.id.txtCategory);
			holder.txtPhone = (TextView)v.findViewById(R.id.txtPhone);
			holder.txtAddress = (TextView)v.findViewById(R.id.txtAddress);
			v.setTag(holder);
		}else
		{
			holder = (ViewHolder) v.getTag();
		}
		RestaurantEntity entity = data.get(position);
		
		if(entity!=null)
		{
			holder.txtName.setText(entity.getName());
			holder.txtPhone.setText(entity.getPhone());
			holder.txtCategory.setText(entity.getCategory());
			holder.txtAddress.setText(entity.getAddress());
		}
		return v;
	}
	
	static class ViewHolder
	{
		TextView txtName;
		TextView txtCategory;
		TextView txtPhone;
		TextView txtAddress;
	}
	

}
