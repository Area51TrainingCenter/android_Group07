package com.example.examplefragment.view;

import com.example.examplefragment.OnCompleteDetails;
import com.example.examplefragment.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentDetailsLanguage extends Fragment {

	
	private OnCompleteDetails aparent;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_details_language, container,false);
	}
	
	public void setText(String title, String desc)
	{
		TextView txtTitle=(TextView)getView().findViewById(R.id.txtTile);
		TextView txtDesc=(TextView)getView().findViewById(R.id.txtDesc);
		
		txtTitle.setText(title);
		txtDesc.setText(desc);
	}
	
	public void setActivityParent(OnCompleteDetails parent)
	{
		aparent=parent;
	}
}
