package com.example.appservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
	public static boolean process=true;
	private static int count =0;
	private static Thread thread;
	
	MediaPlayer mp;
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		 
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		Log.v("CONSOLE","SERVICE onDestroy");
		process=false;
		//thread.stop();
		mp.stop();
	}
	
	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		
		Toast.makeText(this,"startCommand",300);
		Log.v("CONSOLE","SERVICE onStartCommand");
		process=true;
		count=0;
		thread= new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				// TODO Auto-generated method stub
				while(process)
				{
					try {
						Thread.sleep(2000);
					} catch (Exception e) {
						// TODO: handle exception
					}
					count++;
					Log.v("CONSOLE","Thread..."+count);
					//Toast.makeText(getApplicationContext(), "OAAAAAA !", Toast.LENGTH_SHORT).show();
					
				}
				
			}
		});
		//thread.start();
        mp = MediaPlayer.create(getApplicationContext(), R.raw.snd);
        mp.setOnCompletionListener(new OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }

        }); 
        mp.setLooping(true);
        mp.start();
		
		return super.onStartCommand(intent, flags, startId);
		
		
	}
	
	

}
