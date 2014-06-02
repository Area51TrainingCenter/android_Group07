package com.example.pfragmentbycode.view;


import com.example.pfragmentbycode.R;
import com.example.pfragmentbycode.utils.ILog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MyFragment extends Fragment {

	
	//creado el fragment
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ILog.v("MyFragment onCreate");
	}
	
	//cargo mi layout
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return super.onCreateView(inflater, container, savedInstanceState);
		
		ILog.v("MyFragment onCreateView");
		
		View rootView = inflater.inflate(R.layout.myfragment_layout, container,false);
		
		return rootView;
	}
	
	//el fragment a sido incrustado al activity
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		ILog.v("MyFragment onActivityCreated");
	}
	
	public void  miSuperMetodo(String txt)
	{
		Toast.makeText(getActivity(),txt, Toast.LENGTH_LONG).show();
	}
}
