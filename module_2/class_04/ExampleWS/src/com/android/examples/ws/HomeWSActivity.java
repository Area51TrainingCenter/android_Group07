package com.android.examples.ws;

import java.io.IOException;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import com.android.examples.ws.entity.PromotionRequestEntity;
import com.android.examples.ws.entity.PromotionEntity;
import com.android.examples.ws.entity.PromotionResultEntity;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class HomeWSActivity extends ActionBarActivity {

	/*
	 * (non-Javadoc)
	 * @see android.support.v7.app.ActionBarActivity#onCreate(android.os.Bundle)
	 * 
	 * http://stackoverflow.com/questions/11969071/android-os-networkonmainthreadexception-for-webservice-ksoap
	 * 
	 */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		private static final String NAMESPACE = "http://ws.cdyne.com/WeatherWS/";
		private static final String URL ="http://wsf.cdyne.com/WeatherWS/Weather.asmx?WSDL";
		private static final String METHOD_NAME = "GetWeatherInformation";
		private static final String SOAP_ACTION ="http://ws.cdyne.com/WeatherWS/GetWeatherInformation";

		
		private SoapObject request=null;
		private SoapSerializationEnvelope envelope=null;
		private SoapPrimitive  resultsRequestSOAP=null;
		
		Gson gson ;
		private Button btnSend;
		
		public PlaceholderFragment() 
		{
			
		}
		

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_home, container,
					false);
			return rootView;
		}
		
		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onActivityCreated(savedInstanceState);
			btnSend = (Button)getView().findViewById(R.id.btnWS);
			
			btnSend.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					/*String json = {"IdWeb":7,"IdLang":1,"Signatures":{"IdWeb":7,"IdLang":1,"IP":"127.0.0.1","K
						eyAccess":"123456"}}; */
					PromotionRequestEntity entity = new PromotionRequestEntity();
					Gson gson = new Gson();
					String json = gson.toJson(entity);
					//Log.v("CONSOLE", "json "+json );
					
					
					request = new SoapObject(NAMESPACE, METHOD_NAME);
					//request.addProperty("pStrOtaPromotionsRQ", json);
					envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
					envelope.dotNet=true;
					envelope.setOutputSoapObject(request);
					
					HttpTransportSE transporte = new HttpTransportSE(URL);
					try {	
						//Hace la llamada al ws
						transporte.call(SOAP_ACTION, envelope);

						//Se crea un objeto SoapPrimitive y se obtiene la respuesta 
						//de la peticion
						//resultsRequestSOAP = (SoapPrimitive)envelope.getResponse();
						
						request = (SoapObject)envelope.getResponse();
						
						String  strJSON = request.toString();
						
						Log.v("CONSOLA","str: "+strJSON);
						
					   int elementCount = request.getPropertyCount();
					   for(int i = 0;i<elementCount;i++)
					   {
						   PropertyInfo pi = new PropertyInfo();
						   request.getPropertyInfo(i, pi);
						   Log.v("CONSOLA", request.getProperty(i).toString());
						   
					   }
						
						/*
						//PromotionResult data = gson.fromJson(strJSON, PromotionResult.class);
						 ObjectMapper mapper = new ObjectMapper();
						 mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
						 
						 PromotionResultEntity data = mapper.readValue(strJSON, PromotionResultEntity.class);
						 
						//Log.v("CONSOLA","strJSON: "+data.Promotions.Promotion);
						List<PromotionEntity> lst = data.Promotions.Promotion;
						
						for (int i = 0; i < lst.size(); i++)
						{
							Log.v("CONSOLA","promotion: "+lst.get(i).toString());
						}*/

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						Log.v("CONSOLA","IOException: "+e.toString());
					} catch (XmlPullParserException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						Log.v("CONSOLA","XmlPullParserException "+e.toString());
					}
	
					
				}
			});
		}
	}

	
	/*
	 * 06-21 08:51:21.065: V/CONSOLA(1661): IOException: SoapFault - faultcode: 'soap:Client' faultstring: 'Server did not recognize the value of HTTP Header SOAPAction: http://tempuri.org/GetWeatherInformation.' faultactor: 'null' detail: org.kxml2.kdom.Node@41bd4850

	 */
}
