package com.example.apppractica04.restaurant;

import com.example.apppractica04.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RestaurantFragmentMap extends Fragment {

	//-37.813187,144.962980
	private static final LatLng USMP_LOCATION =new LatLng(49.257874, -123.130770);//(-37.813187,144.962980);//-37.813187,144.962980);//-12.097732703403762, -76.95024665000005);
	private MapView mapView;
	private GoogleMap map;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_restaurant_map, container,false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
        mapView=(MapView)getView().findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        

        try {
				MapsInitializer.initialize(getActivity());
				map=mapView.getMap();
				//setup();
			} catch (GooglePlayServicesNotAvailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        setup();
	}
	
	private void setup() {
		// TODO Auto-generated method stub
		//map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		 map.setMyLocationEnabled(true);
		 
	        
	        CameraPosition cameraPosition = new CameraPosition.Builder()
	        .target(USMP_LOCATION) // Sets the center of the map to
	                                    // Golden Gate Bridge
	        .zoom(16)                   // Sets the zoom
	        .bearing(90) // Sets the orientation of the camera to east
	        .tilt(60)    // Sets the tilt of the camera to 30 degrees
	        .build();    // Creates a CameraPosition from the builder
	        
	        CameraUpdate cameraUpdate=CameraUpdateFactory.newCameraPosition(
	    	        cameraPosition);
		    map.animateCamera(cameraUpdate);
		    
	        map.addMarker(new MarkerOptions()
	        .position(USMP_LOCATION)
	        .title("Restaurante XXX"));
	        
	     // Instantiates a new CircleOptions object and defines the center and radius
	        CircleOptions circleOptions = new CircleOptions()
	            .center(new LatLng(USMP_LOCATION.latitude,USMP_LOCATION.longitude))
	            .radius(800);
	            // In meters

	        // Get back the mutable Circle
	        Circle circle = map.addCircle(circleOptions);
	}
}
