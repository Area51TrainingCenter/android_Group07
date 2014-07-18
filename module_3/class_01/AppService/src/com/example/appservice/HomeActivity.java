package com.example.appservice;

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

	MediaPlayer mp;
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

        mp = MediaPlayer.create(HomeActivity.this, R.raw.snd);
        mp.setOnCompletionListener(new OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }

        }); 
		
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
		if(mp!=null)
		{
			if(mp.isPlaying())
			{
				mp.pause();
			}
		}
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
		//Intent i=new Intent(this, MyService.class);
		//i.putExtras(extras);
		//startService(i);
        //mp.start();
		new MyAsyncTask().execute(null,null);
	}
	
	public void stop_handler(View view)
	{
		Intent i=new Intent(this, MyService.class);
		stopService(i);
		/*
		if(mp.isPlaying())
		{
			mp.stop();
		} */
		/*if(mp.isPlaying()){
			mp.stop();
			}else
			{
			mp.reset();
			
			//AssetFileDescriptor afd = this.getAssets().open(R.raw.snd);
			AssetFileDescriptor afd = this.getResources().openRawResourceFd(R.raw.snd);
			try {
				mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength() );
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				mp.start();
			}
			*/
		
	}


}
