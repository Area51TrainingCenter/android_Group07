package com.example.preporterociudadano;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.preporterociudadano.entity.ErrorEntity;
import com.example.preporterociudadano.entity.ReportEntity;
import com.example.preporterociudadano.entity.SuccessEntity;
import com.example.preporterociudadano.photo.AlbumStorageDirFactory;
import com.example.preporterociudadano.photo.BaseAlbumDirFactory;
import com.example.preporterociudadano.photo.FroyoAlbumDirFactory;
import com.example.preporterociudadano.photo.IntentUtils;
import com.example.preporterociudadano.utils.ImageUtils;
import com.example.preporterociudadano.utils.ImageUtils2;
import com.example.preporterociudadano.utils.RESTConstant;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import org.codehaus.jackson.map.DeserializationConfig;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class FormReporteFragment extends Fragment {
	static final  int RESULT_TAKE_IMAGE = 101;
	
	private MapView mapView;
	private GoogleMap map;
	Marker marker;
	private Button takePhoto,btnReportar;
	private ImageView imgPhoto;
	
	private AlbumStorageDirFactory mAlbumStorageDirFactory;
	private String mCurrentPhotoPath;
	private Uri mCurrentPhotoUri=null;
	private LatLng currentPoint=null;
	private String currentLat=null;
	private String currentLng=null;
	private ProgressDialog progress;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_formreporte, container,false);
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		appCamera();
		
		progress=new ProgressDialog(getActivity());
		progress.setCancelable(false);
		progress.setMessage("Cargando...");
		 takePhoto =(Button)getView().findViewById(R.id.btnTakePhoto);
		 btnReportar =(Button)getView().findViewById(R.id.btnReportar);
		 imgPhoto =(ImageView)getView().findViewById(R.id.imgPhoto);
		 imgPhoto.setTag(null);
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
	     CameraUpdate update = CameraUpdateFactory.newLatLngZoom(
	    		 new LatLng(-12.1419364,-77.000214),15)  ;
	     map.setMyLocationEnabled(true);
	     map.moveCamera(update);
	     
	     map.setOnMapLongClickListener(new OnMapLongClickListener() {
			
			@Override
			public void onMapLongClick(LatLng latlng) {
				// TODO Auto-generated method stub
				addUserMarker(latlng);
			}
		});
	     
	    takePhoto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				takeImageReport();
			}
		});
	    
	    btnReportar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ReportEntity entity = new ReportEntity();
				
				if((currentLat!=null && currentLng!=null) || imgPhoto.getTag()!=null)
				{
					//String.valueOf(currentPoint.latitude)
					entity.setLat(""+currentLat);
					entity.setLng(""+currentLng);
					//entity.setLocation(currentPoint);
					
				Log.v("CONSOLE",entity.toString());
					sendReport(entity);
				
				}else
				{
					Toast.makeText(getActivity(), "Horror !",
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	protected void sendReport(ReportEntity entity) {
		// TODO Auto-generated method stub
		AsyncHttpClient client=new AsyncHttpClient();
		String url=RESTConstant.POST_REPORT;
		
		Header header1=new BasicHeader("X-Parse-Application-Id", RESTConstant.APP_ID);
		Header header2=new BasicHeader("X-Parse-REST-API-Key", RESTConstant.REST_API_KEY);
		Header header3=new BasicHeader("Content-Type", "application/json; charset=utf-8");
		Header[] headers={header1,header2,header3};
		
		/*HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("lat", entity.getLat());
		paramMap.put("lng", entity.getLng()); */		
		//RequestParams params = new RequestParams(paramMap);
		//RequestParams params = new RequestParams();
		//params.add("lat", entity.getLat());
		//params.add("lng", entity.getLng());
		
		//client.post(getActivity(), url, headers, params, null, new HttpResp)
		//Gson gson =new Gson();
		
		JSONObject jsonParams = new JSONObject();
        try {
			jsonParams.put("lat", entity.getLat());
		    jsonParams.put("lng", entity.getLng());
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
		progress.show();
		//aux=null;
		
		client.post(getActivity(), url, headers, aux, "application/json", new AsyncHttpResponseHandler()
		{
			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				super.onFinish();
				progress.hide();
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

	private void appCamera() {
		// TODO Auto-generated method stub
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
			mAlbumStorageDirFactory = new FroyoAlbumDirFactory();
		} else {
			mAlbumStorageDirFactory = new BaseAlbumDirFactory();
		}
		
		Log.v("CONSOLE","mAlbumStorageDirFactory "+mAlbumStorageDirFactory);
	}
	protected void addUserMarker(LatLng latlng) {
		// TODO Auto-generated method stub
		if(marker!=null)
		{
			marker.remove();
			//currentPoint=null;
			currentLat=null;
			currentLng=null;
		}
		
		 marker= map.addMarker(new MarkerOptions()
	        .position(latlng)
	        .title("Incidencia"));
		// currentPoint= latlng;
		 
			currentLat=""+latlng.latitude;
			currentLng=""+latlng.longitude;
	}
	
	private void takeImageReport() 
	{

		Intent takePhotoIntent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		File f = null;
		try {
			f = ImageUtils2.setUpPhotoFile(mAlbumStorageDirFactory,"examplephoto");
			mCurrentPhotoPath = f.getAbsolutePath();
			takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
			
		} catch (IOException e) {
			e.printStackTrace();
			f = null;
			mCurrentPhotoPath = null;
		}
		

		if(IntentUtils.isIntentAvailable(getActivity(), MediaStore.ACTION_IMAGE_CAPTURE))
		{
			
			startActivityForResult(takePhotoIntent, RESULT_TAKE_IMAGE);
		}else
		{
			Toast.makeText(getActivity(), "Error Camera", Toast.LENGTH_LONG).show();

		}
		
	}
	
	private Uri handleBigCameraPhoto() 
	{
		Uri uri=null;
		if (mCurrentPhotoPath != null) 
		{

			uri=galleryAddPic();
		}
		return uri;
	}
	private Uri galleryAddPic() {

		Intent mediaScanIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
		File f = new File(mCurrentPhotoPath);
	    Uri contentUri = Uri.fromFile(f);
	    mediaScanIntent.setData(contentUri);
	    getActivity().sendBroadcast(mediaScanIntent);
	    
	    return contentUri;
}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode == RESULT_TAKE_IMAGE && resultCode==getActivity().RESULT_OK)
		{

			mCurrentPhotoUri=handleBigCameraPhoto();
			
			Log.v("CONSOLE","mCurrentPhotoUri "+ mCurrentPhotoUri+" path "+mCurrentPhotoPath);
			//showPhoto(mCurrentPhotoPath);
			Bitmap bmp3 = ImageUtils.decodeSampledBitmapFromFile(mCurrentPhotoPath, 100, 100);
			Log.v("CONSOLE","bmp3 "+bmp3);
			Bitmap bmp2 = ImageUtils.rotateImage(bmp3,mCurrentPhotoPath);
			imgPhoto.setImageBitmap(bmp2);
			imgPhoto.setTag("Hola");
			
		}
	}

}
