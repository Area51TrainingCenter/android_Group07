package com.example.touchexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;

public class Home2Activity extends Activity {
	
	private RelativeLayout container,container2;
	private int windowwidth=0;
	private int screencenter=0;
	protected int x_cord;
	protected int y_cord;
	private float angle=0;
    private float px=0;
    private float dx=0;
    private boolean active=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home2);
		
		container=(RelativeLayout)findViewById(R.id.container);
		container2=(RelativeLayout)findViewById(R.id.container2);
		
		windowwidth=getWindowManager().getDefaultDisplay().getWidth();
	
		screencenter=windowwidth/2;
		Log.v("CONSOLE","windowwidth "+windowwidth);
		
		//container2.setTranslationX(10);
		//container2.setRotation(90);
		events();
	}

	private void events() {
		// TODO Auto-generated method stub
		container.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
	               switch (event.getAction()) 
	                {
		                case MotionEvent.ACTION_DOWN:
		                	active=true;
		                    break;
		                case MotionEvent.ACTION_MOVE:
			   				 if(event.getX()>px)
							 {
								 Log.v("CONSOLE","DERECHA");
								// angle-=10;
							 }else if(event.getX()<px)
							 {
								 Log.v("CONSOLE","IZQUIERDA");
								 //angle+=10;
							 }
			   				px=event.getX();
			   				dx= event.getRawX()-screencenter;
			   				Log.v("CONSOLE", " x "+event.getX()+" raw "+event.getRawX());
			   				angle = (float)(5*dx*(Math.PI/180));
			   				if(active)
			   				{
			   					container2.setRotation(angle);
			   					container2.setTranslationX(dx);
			   				}
		                	break;
		                	
		                case MotionEvent.ACTION_UP:
		                	active=false;
		                    break;
	                }
	               return true;
			}
		});
	}

}
