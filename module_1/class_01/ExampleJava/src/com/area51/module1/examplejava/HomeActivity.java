package com.area51.module1.examplejava;

import com.area51.module1.examplejava.entity.BallEntity;
import com.area51.module1.examplejava.entity.BeachBall;
import com.area51.module1.examplejava.entity.SoccerBallEntity;
import com.area51.module1.examplejava.interfaces.IBall;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class HomeActivity extends Activity {

	public static String CONSOLE="console";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		//POO : Object Oriented Programming
		BallEntity ball1=new BallEntity();
		BallEntity  ball2 = new BallEntity(10, 20, 5f);
		
		ball1.setRadio(30);
		ball1.speedUp(30);
		String msg1=ball1.printStatus();
		
		
		ball2.speedDown(20);
		ball2.setRadio(-5);
		float momentum = ball2.momentum();
		String msg2 =ball2.printStatus();
		
		Log.v(CONSOLE, "msg1 "+msg1);
		Log.v(CONSOLE, "msg2 "+ msg2 + "momentum "+momentum);
		
		//Inheritance
		SoccerBallEntity sball1=new SoccerBallEntity();
		String msg3 = sball1.printStatus();
		
		Log.v(CONSOLE, "msg3 "+msg3);
		
		//Interfaces
		IBall ball4 = new BeachBall();
		ball4.momentum();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
