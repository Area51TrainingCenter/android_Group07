package com.isil.pfragments;

import java.io.Serializable;

import com.isil.pfragments.entity.UserEntity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class MyContainerFragment extends FragmentActivity {
	
	private int container=0 ;
	private FragmentManager fm;
	
	public void changeFragment()
	{
		Fragment _fragment =new MyFragment();
		
		FragmentTransaction ft=fm.beginTransaction();
		ft.replace(container, _fragment,"MyFragment" );
		ft.commit();
	}
	
	public void changeFragmentData()
	{
		Serializable entity=new UserEntity();
		
		Bundle data=new Bundle();
		data.putSerializable("ENTITY", entity);
		
		Fragment _fragment =new MyFragment();
		_fragment.setArguments(data);

		
		FragmentTransaction ft=fm.beginTransaction();
		ft.replace(container, (Fragment)_fragment,"MyFragment" );
		ft.commit();

	}

}
