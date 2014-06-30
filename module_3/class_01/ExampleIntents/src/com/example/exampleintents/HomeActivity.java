package com.example.exampleintents;

import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);


	}
	
	public void click_handler(View view)
	{
		switch (view.getId()) 
		{
			case R.id.btnBrowser:
					intentBrowser();
				break;
			case R.id.btnPhone:
					intentPhone();
				break;
			case R.id.btnMaps:
					intentMaps();
				break;
			case R.id.btnShare:
					shareOptions();
				break;
					
			default:
				break;
		}
	}

	private void shareOptions() {

		Intent intent=new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_SUBJECT, "Este es un mensaje");
		intent.putExtra(Intent.EXTRA_SUBJECT, "Nuevo Correo");
		intent.putExtra(Intent.EXTRA_TEXT, "https://google.com.pe");

		//startActivity(Intent.createChooser(intent, "Hola Area51"));
		startActivity(Intent.createChooser(intent, "Hola Area51"));
		
		
	}

	private void intentMaps() {
		// TODO Auto-generated method stub
		//location();
		routing();
	}

	private void location() 
	{

		Double latitude=-12.073449;
		Double longitude=-76.948551;
	    String format = "geo:0,0?q=" + Double.toString(latitude) + "," + Double.toString(longitude) +"?z=8" +
	    "(La Molina)";
	    Uri uri = Uri.parse(format); 
	    Intent intent = new Intent(Intent.ACTION_VIEW, uri);

		Log.v("CONSOLE","mensaje "+intent);
		if(intent!=null)
		{
			startActivity(intent);
		}
	}
	
	private void routing() 
	{
		String  latitude1="-12.07337";
		String  longitude1="-76.954583";

		String  latitude2="-12.073449";
		String  longitude2="-76.948551";

		String format = "http://maps.google.com/maps?saddr=" +latitude1+","+longitude1+"&daddr="+
	   latitude2+","+longitude2;

	    Uri uri = Uri.parse(format); 
	    Intent intent = new Intent(Intent.ACTION_VIEW, uri);

	    intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
	    startActivity(intent);
	}

	private void intentPhone2()
	{
	    Intent intent= new Intent(Intent.ACTION_CALL);
	    String phone1= "tel:"+"976052576";
	    intent.setData(Uri.parse(phone1));
	    try
	    {
	    		startActivity(intent);
	    }catch(ActivityNotFoundException e)
	    {
	    	
	    }
	}
	private void intentPhone() {
		// TODO Auto-generated method stub
		String phone ="tel:976052576";
		Intent i = new Intent(android.content.Intent.ACTION_VIEW, 
	            Uri.parse(phone));
	    startActivity(i);

	}

	private void intentBrowser() {
		// TODO Auto-generated method stub
		Intent i = new Intent(Intent.ACTION_VIEW, 
		Uri.parse("http://google.com"));
		startActivity(i); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}



}
