package com.area51.mytracking;

import java.io.IOException;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class HomeActivity extends FragmentActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		Log.v("CONSOLE","1 onStart");
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.v("CONSOLE","2 onResume");


		
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.v("CONSOLE","onPause");
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.v("CONSOLE","onStop");

	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void play_handler(View view)
	{
		Intent i=new Intent(this, MyService.class);
		//si.putExtras(extras);
		startService(i);
	}
	
	public void stop_handler(View view)
	{
		Intent i=new Intent(this, MyService.class);
		stopService(i);
		
	}


}
