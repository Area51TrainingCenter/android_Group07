package com.example.examplefragment;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ExampleListActivity extends Activity {

	private ListView lstDev;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_example_list);
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
	public void next(View view)
	{
		startActivity(new Intent(this,DetailsActivity.class));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.example_list, menu);
		return true;
	}

}
