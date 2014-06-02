package com.example.pfragmentbycode.view;

import com.example.pfragmentbycode.R;
import com.example.pfragmentbycode.entity.UserEntity;
import com.example.pfragmentbycode.utils.ILog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class MySecondFragment extends Fragment {


	private TextView txt;
	private ListView lst;
	private UserEntity entity;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.mysecondfragment_layout, container,false);
		
		return rootView;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		txt=(TextView)getView().findViewById(R.id.txt);
		lst = (ListView)getView().findViewById(R.id.lst);
		
		validateExtra();
	}
	
	private void validateExtra() {
		// TODO Auto-generated method stub
		if (getArguments()!=null)
		{
			entity = (UserEntity)getArguments().getSerializable("ENTITY");
			ILog.v("Entity "+entity);
		}
	}
}
