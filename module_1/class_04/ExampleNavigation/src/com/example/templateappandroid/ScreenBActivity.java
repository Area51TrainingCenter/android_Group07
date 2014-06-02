package com.example.templateappandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ScreenBActivity extends Activity {
	
	private String myString=null;
	private UserEntity myUser=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		validateExtra();
		setContentView(R.layout.actvity_b);
		
		EditText txtID= (EditText)findViewById(R.id.txtID);
		EditText txtNAME= (EditText)findViewById(R.id.txtName);
		EditText txtLASTNAME= (EditText)findViewById(R.id.txtLastName);
		EditText txtDNI= (EditText)findViewById(R.id.txtDNI);
		
		txtID.setText(""+myUser.getId());
		txtNAME.setText(""+myUser.getName());
		txtLASTNAME.setText(""+myUser.getLastname());
		txtDNI.setText(""+myUser.getDni());
	}

	
	private void validateExtra() {
		// TODO Auto-generated method stub
		if(getIntent()!=null)
		{
			Bundle bundle= getIntent().getExtras();
			if(bundle!=null)
			{
				myString = bundle.getString("MYSTRING");
				myUser= (UserEntity)bundle.getSerializable("MYENTITY");
				if(myUser!=null && myString!=null)
				{
					Toast.makeText(this, "entity "+myUser.getDni()+
							"string "+myString, Toast.LENGTH_LONG).show();
				}
			}
		}
	}


	public void back_handler(View view)
	{
		Intent intent = new Intent(ScreenBActivity.this, HomeActivity.class);
		startActivity(intent);
		finish();
	}
	
	//bot+on físico
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		//super.onBackPressed();
		
		Intent intent = new Intent(ScreenBActivity.this, HomeActivity.class);
		startActivity(intent);
		finish();
	}
}
