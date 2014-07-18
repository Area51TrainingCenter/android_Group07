package com.example.touchexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class HomeActivity extends Activity {

	/**
	 * Referencias 
	 * http://developer.android.com/training/graphics/opengl/touch.html
	 * http://developer.android.com/guide/topics/ui/ui-events.html
	 * 
	 */
	private MyView view;
	private MyCircleView view2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_home);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        		WindowManager.LayoutParams.FLAG_FULLSCREEN);  
        
        /*
		view=new MyView(this);
    	setContentView(view);
    	view.requestFocus(); */
    	
		view2=new MyCircleView(this);
    	setContentView(view2);
    	view2.requestFocus();
	}
}
