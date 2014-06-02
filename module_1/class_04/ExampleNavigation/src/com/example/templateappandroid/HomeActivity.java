package com.example.templateappandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actvity_a);
	}

	public void next_handler(View view)
	{
		Bundle bundle = new Bundle();
		bundle.putString("MYSTRING", "Hola Area51");
		bundle.putSerializable("MYENTITY", new UserEntity(100, 
				"Eduardo ", "Medina", "40898479"));
		
		Intent intent=new Intent(HomeActivity.this, ScreenBActivity.class);
		intent.putExtras(bundle);
		
		startActivity(intent);
		finish();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}

}
