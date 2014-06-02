package com.example.templateappandroid;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {

	private static final int DATE_DIALOG_ID = 1;
	private TextView lblSelectedBirthday;
	private EditText txtName,txtLastName,txtUsername,txtEmail,txtPassword;
	private Button btnSignUp;
	private RadioGroup rgSex;
	private RadioButton rbMale, rbFemale;
	private ImageView imgLogo;
	private CheckBox chkNotifications;
	private Spinner spLocation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_formulario);
		app();
	}

	private void app() {
		// TODO Auto-generated method stub
		lblSelectedBirthday = (TextView)findViewById(R.id.txtSelectedBirthday);
		imgLogo =(ImageView)findViewById(R.id.imgLogo);
		txtName =(EditText)findViewById(R.id.txtName);
		txtLastName =(EditText)findViewById(R.id.txtLastName);
		txtUsername =(EditText)findViewById(R.id.txtUsername);
		txtEmail =(EditText)findViewById(R.id.txtEmail);
		txtPassword =(EditText)findViewById(R.id.txtPassword);
		btnSignUp =(Button) findViewById(R.id.btnSignUp);
		rgSex =(RadioGroup) findViewById(R.id.rgSex);
		rbMale =(RadioButton) findViewById(R.id.rbMale);
		rbFemale =(RadioButton) findViewById(R.id.rbFemale);
		spLocation =(Spinner)findViewById(R.id.spLocation);
		chkNotifications =(CheckBox)findViewById(R.id.chkNotifications);
		
		events();
		
	}

	private void events() {
		// TODO Auto-generated method stub
		btnSignUp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(validateForm())
				{
					Toast.makeText(HomeActivity.this, "Send", Toast.LENGTH_LONG).show();
				}
			}
		});
		lblSelectedBirthday.setTag(null);
		lblSelectedBirthday.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(DATE_DIALOG_ID);
			}
		});
	}
	protected boolean validateForm() 
	{
		clearTxt();
		
		// TODO Auto-generated method stub
		String name = txtName.getText().toString().trim();
		String username = txtUsername.getText().toString().trim();
		String password = txtPassword.getText().toString().trim();
		String email = txtEmail.getText().toString().trim();
		String lastName = txtLastName.getText().toString().trim();
		String birthday = "";
		
		if(lblSelectedBirthday.getTag()!=null)
		birthday=lblSelectedBirthday.getText().toString();
		String location= spLocation.getSelectedItem().toString();
		int selectedId = rgSex.getCheckedRadioButtonId();
		String sex="M";
		if(selectedId!=-1)
		{
			switch (selectedId)
			{
				case R.id.rbMale:
				sex="M";
				break;
				case R.id.rbFemale:
				sex="F";
				break;
				default:
				break;
			}
		}
		int notifications=-1;
		if(chkNotifications.isChecked())
		{
			notifications=1;
		}

		//---------------------------------------------------------
		if(name.equals(""))
		{
			txtName.setError("Ingresa un nombre");
			txtName.requestFocus();
			showErrorToast("Ingresa un nombre");
			return false;
		}
		if(lastName.equals(""))
		{
			txtLastName.setError("Ingresa un Apellidos");
			txtLastName.requestFocus();
			showErrorToast("Ingresa un Apellidos");
			return false;
		}
		if(username.equals(""))
		{
			txtUsername.setError("Ingresa un Username");
			txtUsername.requestFocus();
			showErrorToast("Ingresa un Username");
			return false;
		}
		if(birthday.equals(""))
		{
			lblSelectedBirthday.setError("Error");
			showErrorToast("Ingresa una fecha");
			return false;
		}
		if(spLocation.getSelectedItemId()==-1)
		{
			showErrorToast("Seleccione un lugar");
			return false;
		}
		if(selectedId==-1)
		{
			showErrorToast("Seleccione un valor");
			return false;
		}
		if(!chkNotifications.isChecked())
		{
			return false;
		}
		return true;
	}

	public void showErrorToast(String msg)
	{
		Toast.makeText(HomeActivity.this, "Error "+msg, Toast.LENGTH_LONG).show();
	}
	public void clearTxt()
	{
		txtName.setError(null);
		txtLastName.setError(null);
	}
	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		//return super.onCreateDialog(id);
		switch (id) 
		{
			case DATE_DIALOG_ID:
				final Calendar c = Calendar.getInstance();
				int year = c.get(Calendar.YEAR);
				int month = c.get(Calendar.MONTH);
				int day = c.get(Calendar.DAY_OF_MONTH);
				
				return new DatePickerDialog(this, new OnDateSetListener() {
					
					@Override
					public void onDateSet(DatePicker view, int _year, int _month,
							int _day) {
						// TODO Auto-generated method stub
						String s= _day+"/"+(_month+1)+"/"+_year;
						lblSelectedBirthday.setText(s);
						lblSelectedBirthday.setTag(1);
					}
				}, year, month, day);
	
			default:
				break;
		}
		return null;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
