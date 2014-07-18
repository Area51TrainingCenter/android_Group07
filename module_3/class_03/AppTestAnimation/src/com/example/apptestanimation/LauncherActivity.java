package com.example.apptestanimation;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

@SuppressLint("NewApi")
public class LauncherActivity extends Activity {

	private RelativeLayout container;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		
		container=(RelativeLayout)findViewById(R.id.container);
		int x=0;
		int y=0;
		int r=200;
		for (int i = 0; i < 10; i++)
		{
	        final Button btn = new Button(this);
	        btn.setLayoutParams(new LayoutParams(10, 10));
	       // btn.setBackgroundColor(getResources().getColor(R.color.color_2));
	        /*btn.setBackgroundDrawable(getResources().getDrawable(
	                R.drawable.like_btn))*/
	        //imageLike.setX(20);
	        //imageLike.setY(80);
	        //y=5*Math.sin(i);
	       // x=200+(int)(r*Math.cos(360*i)-5);
	        x=50*i;
	        y=100+20*i*i;
	       // y=200+(int)(r*Math.sin(360*i)-5);
	        
	        btn.setLayoutParams(getLayout(x, y));
	        //btn.setLayoutParams(getLayout(i, 80*i));
	        btn.setAlpha(0.8f);
	        container.addView(btn);
		}
	}
	
	public RelativeLayout.LayoutParams getLayout(int x, int y)
	{
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT); //The WRAP_CONTENT parameters can be replaced by an absolute width and height or the FILL_PARENT option)
		params.leftMargin = x; //Your X coordinate
		params.topMargin = y; //Your Y coordinate

		return params;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.launcher, menu);
		return true;
	}

}
