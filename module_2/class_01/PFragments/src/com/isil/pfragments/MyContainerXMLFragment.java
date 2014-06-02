package com.isil.pfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class MyContainerXMLFragment extends FragmentActivity {

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        MyFragment fg= (MyFragment)getSupportFragmentManager().findFragmentById(R.id.fragment1);
        fg.showInfo("Hola Mundo");
	}
}
