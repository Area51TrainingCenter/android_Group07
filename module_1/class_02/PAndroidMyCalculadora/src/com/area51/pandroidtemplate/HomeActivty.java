package com.area51.pandroidtemplate;

import com.area51.pandroidtemplate.model.BallEntity;
import com.area51.pandroidtemplate.model.BeachBall;
import com.area51.pandroidtemplate.model.IBall;
import com.area51.pandroidtemplate.model.SocceBall;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivty extends Activity {
	
	private EditText txtValor1, txtValor2, txtResultado;
	private Button btnSumar, btnRestar, btnDividir, btnMultiplicar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		//app();
		caluladora();
	}

	private void app() {
		// TODO Auto-generated method stub
		
		BallEntity ball= new BallEntity(20, 10, 5f);
		String msg =ball.printStatus();
		float momentum = ball.momentum();
		
		Log.v("CONSOLE", msg);
		Log.v("CONSOLE", "momentum "+momentum);
		
		IBall ball2 = new BeachBall();
		Log.v("CONSOLE", ball2.printStatus());
		IBall ball3 = new SocceBall();
		Log.v("CONSOLE", ball3.printStatus());
		
		
	}
	private void caluladora()
	{
		
		//UI
		txtValor1 = (EditText)findViewById(R.id.txtValor1);
		txtValor2 = (EditText)findViewById(R.id.txtValor2);
		txtResultado = (EditText)findViewById(R.id.txtResultado);
		
		btnSumar = (Button)findViewById(R.id.btnSumar);
		btnRestar = (Button)findViewById(R.id.btnRestar);
		btnMultiplicar = (Button)findViewById(R.id.btnMultiplicar);
		btnDividir = (Button)findViewById(R.id.btnDividir);
		
		
		
		//EVENTS
		btnSumar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.v("CONSOLE", "SUMA PE");
				int valor1 = Integer.parseInt(txtValor1.getText().toString());
				int valor2 = Integer.parseInt(txtValor2.getText().toString());
				
				int suma =valor1+valor2;
				
				//devolver valor
				txtResultado.setText(String.valueOf(suma));
				Toast.makeText(HomeActivty.this, "Resultado "+suma, Toast.LENGTH_LONG).show();
				
			}
		});
				
				
	}

}
