package com.example.pinternalstorage;

import java.io.FileOutputStream;
import java.util.List;

import com.example.pinternalstorage.model.Data;
import com.example.pinternalstorage.model.NoteEntity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class HomeActivity extends Activity {

	private Button btnAddNotes;
	private ListView lstNotes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		Data.getInstance();
		app();
	}

	private void app() {
		// TODO Auto-generated method stub
		btnAddNotes= (Button)findViewById(R.id.btnAddNotes);
		lstNotes =(ListView)findViewById(R.id.lstNotes);
		
		btnAddNotes.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				createNote();
			}
		});
		

		populate();
	}

	private void populate() {
		// TODO Auto-generated method stub
		List<NoteEntity> objects= Data.getInstance().getNotes();
		String[] files = fileList();
		//http://developer.android.com/guide/topics/data/data-storage.html#filesInternal
		for (int i = 0; i < files.length; i++) 
		{
			Log.v("CONSOLE","fileLIst "+files[i]);
		}
		//Log.v("CONSOLE","fileLIst "+fileList());
		
		/*ArrayAdapter<NoteEntity> adapter = new ArrayAdapter<NoteEntity>(this,
				android.R.layout.simple_list_item_1, objects);
		lstNotes.setAdapter(adapter); */
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, files);
		lstNotes.setAdapter(adapter);
		lstNotes.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				//showDetailsNote(position);
				String aux=parent.getAdapter().getItem(position).toString();
				Log.v("CONSOLE",aux);
				
			}
			
		});
		
	}

	protected void showDetailsNote(int position) 
	{
		// TODO Auto-generated method stub
		
		NoteEntity entity = Data.getInstance().getNotes().get(position);
		if(entity!=null)
		{
			Intent intent=new Intent(this, NoteActivity.class);
			intent.putExtra("VIEW", NoteActivity.DETAILS_NOTE);
			intent.putExtra("ENTITY", entity);
			startActivity(intent);
		}

	}

	protected void createNote() {
		// TODO Auto-generated method stub
		Intent intent=new Intent(this, NoteActivity.class);
		intent.putExtra("VIEW", NoteActivity.NEW_NOTE);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
