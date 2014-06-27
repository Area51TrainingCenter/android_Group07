package com.android.examples.ws;

import java.util.List;

import com.android.examples.ws.entity.PromotionEntity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PromotionAdapter extends ArrayAdapter<PromotionEntity> {

	private Context context;
	private List<PromotionEntity> data;
	
	public PromotionAdapter(Context _context, int resource,
			List<PromotionEntity> objects) {
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
	public PromotionEntity getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		convertView = LayoutInflater.from(context).inflate(
				R.layout.item_promotion, null);
		TextView txtTitle = (TextView)convertView.findViewById(R.id.txtTitle);
		TextView txtDesc = (TextView)convertView.findViewById(R.id.txtDesc);
		TextView txtUrl = (TextView)convertView.findViewById(R.id.txtUrl);
		
		PromotionEntity entity = data.get(position);
		txtTitle.setText(entity.Title);
		txtDesc.setText(entity.Descripcion);
		txtUrl.setText(entity.URL);
		
		return convertView;
		
		
		
		
		
	}

}
