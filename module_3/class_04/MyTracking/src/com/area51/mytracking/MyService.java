package com.area51.mytracking;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import com.area51.mytracking.entity.ErrorEntity;
import com.area51.mytracking.entity.ReportEntity;
import com.area51.mytracking.entity.SuccessEntity;
import com.area51.mytracking.utils.LocationUtils;
import com.area51.mytracking.utils.RESTConstant;
import com.area51.mytracking.utils.TrackMeSession;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

public class MyService extends Service       implements  LocationListener,GooglePlayServicesClient.ConnectionCallbacks,
GooglePlayServicesClient.OnConnectionFailedListener {
	
	IBinder mBinder = new LocalBinder();
    private LocationRequest mLocationRequest;
    private LocationClient mLocationClient;
    boolean mUpdatesRequested = false;
	
    public class LocalBinder extends Binder {
    	public MyService getServerInstance() {
    		return MyService.this;
    	}
    }
    
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
        // Create a new global location parameters object
        mLocationRequest = LocationRequest.create();

        /*
         * Set the update interval
         */
        mLocationRequest.setInterval(LocationUtils.UPDATE_INTERVAL_IN_MILLISECONDS);

        // Use high accuracy
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        // Set the interval ceiling to one minute
        mLocationRequest.setFastestInterval(LocationUtils.FAST_INTERVAL_CEILING_IN_MILLISECONDS);

        // Note that location updates are off until the user turns them on
        mUpdatesRequested = false;
        
        mLocationClient = new LocationClient(this, this, this);
        
		//mLocationClient.connect();
		 
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		TrackMeSession.trackingOff(getApplicationContext());
		
		Log.v("CONSOLE","SERVICE onDestroy");
        // If the client is connected
        if (mLocationClient.isConnected()) {
            stopPeriodicUpdates();
        }

        // After disconnect() is called, the client is considered "dead".
        mLocationClient.disconnect();
        mUpdatesRequested=false;
	}
	
	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		
		Log.v("CONSOLE","SERVICE onStartCommand");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
		String timeID = dateFormat.format(new Date());
		
		TrackMeSession.trackingON(getApplicationContext(), timeID);
        mUpdatesRequested = true;

       // if (servicesConnected()) {
           // startPeriodicUpdates();
        //}
        mLocationClient.connect();
		return super.onStartCommand(intent, flags, startId);
		
		
	}

	  private boolean servicesConnected() {

	        // Check that Google Play services is available
	        int resultCode =
	                GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);

	        // If Google Play services is available
	        if (ConnectionResult.SUCCESS == resultCode) {
	            // In debug mode, log the status
	           // Log.d(LocationUtils.APPTAG, getString(R.string.play_services_available));
	        	Log.v("CONSOLE","google play services ON");
	            // Continue
	            return true;
	        // Google Play services was not available for some reason
	        } else {
	           /* // Display an error dialog
	                ErrorDialogFragment errorFragment = new ErrorDialogFragment();
	                errorFragment.setDialog(dialog);
	                errorFragment.show(getSupportFragmentManager(), LocationUtils.APPTAG);
	            }*/
	        	Log.v("CONSOLE","google play services OFF");
	            return false;
	        }
	    }
	@Override
	public void onConnectionFailed(ConnectionResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnected(Bundle arg0) {
		// TODO Auto-generated method stub
        if (mUpdatesRequested) {
            startPeriodicUpdates();
        }
	}
	
    private void startPeriodicUpdates() {

        mLocationClient.requestLocationUpdates(mLocationRequest, this);
    }

	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
        Log.v("CONSOLE", " LAT LNG "+location.getLatitude()+" "+
        location.getLongitude());
        String androidId = Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID);
        String timeId = TrackMeSession.getCurrentTracking(getApplicationContext());
        ReportEntity entity= new ReportEntity();
        entity.setLat(""+location.getLatitude());
        entity.setLng(""+location.getLongitude());
        entity.setDeviceId(androidId);
        entity.setTimeId(timeId);
        
        sendReport(entity);
	}
	
	//----------------------------------------------------------------------------------------
    private void stopPeriodicUpdates() {
        mLocationClient.removeLocationUpdates(this);
    }

//---------------------------------------------------------------------------------------------
    protected void sendReport(ReportEntity entity) 
    {
		// TODO Auto-generated method stub
    	
		AsyncHttpClient client=new AsyncHttpClient();
		String url=RESTConstant.POST_REPORT;
		
		Header header1=new BasicHeader("X-Parse-Application-Id", RESTConstant.APP_ID);
		Header header2=new BasicHeader("X-Parse-REST-API-Key", RESTConstant.REST_API_KEY);
		Header header3=new BasicHeader("Content-Type", "application/json; charset=utf-8");
		Header[] headers={header1,header2,header3};
		
		
		JSONObject jsonParams = new JSONObject();
        try {
			jsonParams.put("lat", entity.getLat());
		    jsonParams.put("lng", entity.getLng());
		    jsonParams.put("deviceid", entity.getDeviceId());
		    jsonParams.put("timeid", entity.getTimeId());
		    
		    Log.v("CONSOLE", "lat "+entity.getLat()+" lng "+entity.getLng()+" deviceid "+entity.getDeviceId()+ "time id "+entity.getTimeId());
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 
        
        StringEntity aux=null;
		try {
			aux = new StringEntity(jsonParams.toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson= new GsonBuilder().serializeNulls().create();
		String json = gson.toJson(entity);
		Log.v("CONSOLE","json "+json);
		//progress.show();
		
		client.post(this, url, headers, aux, "application/json", new AsyncHttpResponseHandler()
		{
			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				super.onFinish();
				//progress.hide();
			}
			
			@Override
			@Deprecated
			public void onSuccess(String content) {
				// TODO Auto-generated method stub
				super.onSuccess(content);
				
				Log.v("CONSOLE","onSuccess "+content);
				
				ObjectMapper mapper=new ObjectMapper();
				mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				
				SuccessEntity result= null;
				try {
					result=mapper.readValue(content, SuccessEntity.class);
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				if(result!=null)
				{
					Log.v("CONSOLE","success "+result.getObjectId());
				}
			}
			
			@Override
			@Deprecated
			public void onFailure(Throwable error, String content) {
				// TODO Auto-generated method stub
				super.onFailure(error, content);
				Log.v("CONSOLE","onFailure "+content);
				ObjectMapper mapper=new ObjectMapper();
				mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				
				ErrorEntity result= null;
				try {
					result=mapper.readValue(content, ErrorEntity.class);
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				if(result!=null)
				{
					Log.v("CONSOLE",result.getCode()+" "+result.getError());
				}
				
				
			}
		});
		
	}
	
	

}
