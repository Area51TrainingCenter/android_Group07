package com.example.examplemultimedia;

import java.io.File;
import java.io.IOException;

import com.example.examplemultimedia.photo.AlbumStorageDirFactory;
import com.example.examplemultimedia.photo.BaseAlbumDirFactory;
import com.example.examplemultimedia.photo.FroyoAlbumDirFactory;
import com.example.examplemultimedia.photo.IntentUtils;
import com.example.examplemultimedia.utils.ImageUtils;
import com.example.examplemultimedia.utils.ImageUtils2;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeActivity extends Activity {
	static final  int RESULT_LOAD_IMAGE = 100;
	static final  int RESULT_TAKE_IMAGE = 101;
	
	private Button btnTakePhoto, btnChoosePhoto;
	private ImageView imgPhoto;
	String picturePath="";
	private AlbumStorageDirFactory mAlbumStorageDirFactory;
	private String mCurrentPhotoPath;
	private Uri mCurrentPhotoUri=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		appCamera();
		
		btnTakePhoto = (Button)findViewById(R.id.btnTakePhoto);
		btnChoosePhoto = (Button)findViewById(R.id.btnChoosePhoto);
		imgPhoto = (ImageView)findViewById(R.id.imgPhoto);
		

		btnTakePhoto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				takePhoto();
			}
		});
		btnChoosePhoto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				photoGallery();
			}
		});
	}
	
	protected void photoGallery() {
		Intent i = new Intent(Intent.ACTION_PICK,
				android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		
		startActivityForResult(i, RESULT_LOAD_IMAGE);
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data!=null) 
		{
			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };

			Cursor cursor = getContentResolver().query(selectedImage,
					filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			picturePath = cursor.getString(columnIndex);
			cursor.close();
			
			
			Log.v("CONSOLE", "picturePath "+picturePath);
			/*Bitmap bmp = ImageUtils.decodeSampledBitmapFromFile(picturePath, 200, 200);//BitmapFactory.decodeFile(picturePath);
			Bitmap bmp2 = ImageUtils.rotateImage(bmp,picturePath);
			imgPhoto.setImageBitmap(bmp2); */
			
			//no hacer en casa
			//Bitmap bmpError = BitmapFactory.decodeFile(picturePath);
			Bitmap bmp = ImageUtils.decodeSampledBitmapFromFile(picturePath, 400, 200);
			Bitmap bmp2 = ImageUtils.rotateImage(bmp,picturePath);
			imgPhoto.setImageBitmap(bmp2);
			//bmp.recycle();
		}
		Log.v("CONSOLE", "requestCode "+requestCode+" resultCode "+resultCode +" data "+
		data);
		if(requestCode == RESULT_TAKE_IMAGE && resultCode==RESULT_OK)
		{

			mCurrentPhotoUri=handleBigCameraPhoto();
			
			Log.v("CONSOLE","mCurrentPhotoUri "+ mCurrentPhotoUri+" path "+mCurrentPhotoPath);
			//showPhoto(mCurrentPhotoPath);
			Bitmap bmp3 = ImageUtils.decodeSampledBitmapFromFile(mCurrentPhotoPath, 200, 200);
			Log.v("CONSOLE","bmp3 "+bmp3);
			Bitmap bmp2 = ImageUtils.rotateImage(bmp3,mCurrentPhotoPath);
			imgPhoto.setImageBitmap(bmp2);
			
		}
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
      

    	private void takePhoto() 
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
    		

    		if(IntentUtils.isIntentAvailable(this, MediaStore.ACTION_IMAGE_CAPTURE))
    		{
    			
    			startActivityForResult(takePhotoIntent, RESULT_TAKE_IMAGE);
    		}else
    		{
    			Toast.makeText(this, "Error Camera", Toast.LENGTH_LONG).show();

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
		    this.sendBroadcast(mediaScanIntent);
		    
		    return contentUri;
	}
    	
	 
}
