package com.example.applistcompuesta;

import com.example.applistcompuesta.model.ProductEntity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class ProductActivity extends Activity {

	private ProductEntity entity=null;
	private EditText txtID,txtName, txtPrice, txtDesc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		txtID = (EditText)findViewById(R.id.txtPID);
		txtName = (EditText)findViewById(R.id.txtPNAME);
		txtPrice = (EditText)findViewById(R.id.txtPPRICE);
		txtDesc = (EditText)findViewById(R.id.txtPDESC);
		
		validateExtra();
		
		//----------------------
		if(entity!=null)
		{
			txtID.setText(""+entity.getId());
			txtName.setText(entity.getName());
			txtPrice.setText("S/. "+entity.getPrice());
			txtDesc.setText(entity.getDesc());
		}
		
		
	}

	private void validateExtra() {
		// TODO Auto-generated method stub
		if(getIntent()!=null)
		{
			Bundle extras =getIntent().getExtras();
			if(extras!=null)
			{
				entity = (ProductEntity)extras.getSerializable("PRODUCT");
				
			}
		}
	}
}
