package com.example.pinternalstorage.view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.example.pinternalstorage.HomeActivity;
import com.example.pinternalstorage.R;
import com.example.pinternalstorage.model.Data;
import com.example.pinternalstorage.model.NoteEntity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewNoteFragment extends Fragment {

	private EditText txtName, txtDesc;
	private Button btnSave;
	
	private NoteEntity entity;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 return inflater.inflate(R.layout.fragment_newnote, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		txtName =(EditText)getView().findViewById(R.id.txtNewNoteName);
		txtDesc =(EditText)getView().findViewById(R.id.txtNewNoteDesc);
		
		btnSave =(Button)getView().findViewById(R.id.btnSave);
		
		events();
	}

	private void events() {
		// TODO Auto-generated method stub
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(validate())
				{
					saveEntity();
					next();
				}
			}
		});
	}

	protected void next() {
		// TODO Auto-generated method stub
		Intent intent =new Intent(getActivity(), HomeActivity.class);
		getActivity().startActivity(intent);
	}

	protected void saveEntity() 
	{
		// TODO Auto-generated method stub
		saveInternalStorage();
		Data.getInstance().addNote(entity);
		Toast.makeText(getActivity(), "Se agreg˜ correctamente", Toast.LENGTH_SHORT).show();
		
	}

	private void saveInternalStorage() {
		// TODO Auto-generated method stub
		String fileName = "file_"+getDayPath();
		Log.v("CONSOLE", "fileName "+fileName);
		
		String  desc = entity.getDesc();
		String str =fileName+"--"+ entity.getName()+"--"+ entity.getDate()+
				"--"+entity.getDesc();
		try {
			FileOutputStream fos= getActivity().openFileOutput(fileName, Context.MODE_PRIVATE);
			//fos.write(desc.getBytes());
			fos.write(str.getBytes());
			fos.close();
			entity.setPath(fileName);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//ocurrio un error al guardar el archivo
		}
	}

	protected boolean validate() {
		// TODO Auto-generated method stub

		String name =txtName.getText().toString();
		String dateOfCreation= txtDesc.getText().toString();
		String desc =txtDesc.getText().toString();
		
		if(name.equals(""))
		{
			txtName.setError("Ingrese un valor");
			return false;
		}
		if(desc.equals(""))
		{
			txtDesc.setError("Ingrese un valor");
			return false;
		}
		
		entity=new NoteEntity();
		entity.setName(name);
		entity.setDesc(desc);
		entity.setDate(getDay());
		
		return true;
	}
	
	public String getDay()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}
	public String getDayPath()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}
	
	
}
