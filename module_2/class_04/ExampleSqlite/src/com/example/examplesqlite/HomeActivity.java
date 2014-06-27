package com.example.examplesqlite;

import java.util.List;

import com.example.examplesqlite.db.CRUDOperations;
import com.example.examplesqlite.db.MyDatabase;
import com.example.examplesqlite.entity.ContactEntity;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		app();
	}

	private void app() {
		// TODO Auto-generated method stub
		MyDatabase db = new MyDatabase(this);
		CRUDOperations crud = new CRUDOperations(db);
		
		crud.addContact(new ContactEntity("Eduardo Medina", "976052576"));
		/*
		crud.addContact(new ContactEntity("Jose Alfaro", "976052576"));
		crud.addContact(new ContactEntity("Carlos Perez", "976052576"));
		
		List<ContactEntity> lst = crud.getAllContacts();
		for (ContactEntity c: lst)
		{
			Log.v("CONSOLE","Contact item "+ c.getId()+" "+c.getName()+" "+c.getPhone_number());
		}*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
