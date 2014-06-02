package com.example.examplefragment;

import com.example.examplefragment.view.FragmentDetailsLanguage;
import com.example.examplefragment.view.FragmentListLanguage;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;

public class ExampleFragment extends FragmentActivity
implements OnCompleteDetails{

	FragmentListLanguage flst;
	FragmentDetailsLanguage fdetails;
	
	FragmentManager fm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		fm=getSupportFragmentManager();
		
		fdetails=(FragmentDetailsLanguage)fm.findFragmentById(R.id.fragment1);
		flst=(FragmentListLanguage)fm.findFragmentById(R.id.fragment2);
		
		fdetails.setActivityParent(this);
		flst.setActivityParent(this);
		
	}

	@Override
	public void setText(String title, String desc) {
		// TODO Auto-generated method stub
		if(fdetails!=null){
			fdetails.setText(title,desc);
		}
	}

}
