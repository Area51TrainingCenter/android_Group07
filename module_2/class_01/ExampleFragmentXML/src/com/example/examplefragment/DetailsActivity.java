package com.example.examplefragment;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DetailsActivity extends Activity {

	private ListView lstDev;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		app();
	}
	private void app() {
		// TODO Auto-generated method stub
		//data
		String[] data={"Python","Ruby","Go","DART","C++","C#",
				"Python","Ruby","Go","DART","C++","C#"};
		//lista
		lstDev=(ListView)findViewById(R.id.lstdev);
		
		
		//adapter
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				data);
		//setear1 adapter
		lstDev.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.details, menu);
		return true;
	}

}
