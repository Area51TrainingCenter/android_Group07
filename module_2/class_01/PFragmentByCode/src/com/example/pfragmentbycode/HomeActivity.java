package com.example.pfragmentbycode;


import java.io.Serializable;

import com.example.pfragmentbycode.entity.UserEntity;
import com.example.pfragmentbycode.utils.ILog;
import com.example.pfragmentbycode.view.MyFragment;
import com.example.pfragmentbycode.view.MySecondFragment;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;

public class HomeActivity extends FragmentActivity {

	private int container=0 ;
	private FragmentManager fm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		container= R.id.container;
		fm = getSupportFragmentManager();
		ILog.v("container "+container);
		
		//changeFragment(new MyFragment());
		UserEntity user=new UserEntity();
		user.setName("Eduardo ");
		user.setLastname("Medina");
		user.setDni("40898479");
		
		changeFragmentData(new MySecondFragment(),user); 
	}
	
	public void changeFragment(Fragment _fragment)
	{
		FragmentTransaction ft=fm.beginTransaction();
		ft.replace(container, _fragment,"MyFragment" );
		ft.commit();
	}
	
	public void changeFragmentData(Fragment _fragment, Serializable _entity)
	{
		Serializable entity=new UserEntity();
		
		Bundle data=new Bundle();
		data.putSerializable("ENTITY", entity);
		_fragment.setArguments(data);

		FragmentTransaction ft=fm.beginTransaction();
		ft.replace(container, (Fragment)_fragment,"MyFragment" );
		ft.commit();

	}
	 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
