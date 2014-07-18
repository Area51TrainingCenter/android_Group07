/**
 * 
 */
package com.example.preporterociudadano.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.preporterociudadano.photo.AlbumStorageDirFactory;



import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * @author emedinaa
 *
 */
public class ImageUtils2 {

	public static final String JPEG_FILE_PREFIX = "IMG_";
	public static final String JPEG_FILE_SUFFIX = ".jpg";
	
	public static Bitmap transformROTATE(Bitmap $bitmap, float $angle)
	{
		Matrix matrix = new Matrix();
		matrix.postRotate($angle);

		Bitmap rotated = Bitmap.createBitmap($bitmap, 0, 0, $bitmap.getWidth(), $bitmap.getHeight(),
		        matrix, true);
		
		return rotated;
	}
	
	
	public static  File getAlbumDir(AlbumStorageDirFactory mAlbumStorageDirFactory,String albumName) {
		File storageDir = null;

		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			
			storageDir = mAlbumStorageDirFactory.getAlbumStorageDir(albumName);

			if (storageDir != null) {
				if (! storageDir.mkdirs()) {
					if (! storageDir.exists()){
						Log.d("console"," ImageUtils GetAlbumDir"+ "failed to create directory");
						return null;
					}
				}
			}
			
		} else {
			Log.v("console","ImageUtils GetAlbumDir "+ "External storage is not mounted READ/WRITE.");
		}
		
		return storageDir;
	}
	
	public static File createImageFile(AlbumStorageDirFactory mAlbumStorageDirFactory,String albumName) throws IOException {
		// Create an image file name
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String imageFileName = JPEG_FILE_PREFIX + timeStamp + "_";
		File albumF = getAlbumDir(mAlbumStorageDirFactory,albumName);
		File imageF = File.createTempFile(imageFileName, JPEG_FILE_SUFFIX, albumF);
		return imageF;
	}
	
	public static  File setUpPhotoFile(AlbumStorageDirFactory mAlbumStorageDirFactory,String albumName) throws IOException
	{
		
		File f = createImageFile(mAlbumStorageDirFactory,albumName);
		//mCurrentPhotoPath = f.getAbsolutePath();
		
		return f;
	}
	
	public static Matrix getOrientation(String filePath)
	{
		Matrix matrix=new Matrix();
		ExifInterface exifReader=null;
		int orientation=0;
		String norientation="";
		try 
		{
			exifReader=new ExifInterface(filePath);
			orientation=exifReader.getAttributeInt(ExifInterface.TAG_ORIENTATION, -1);

			switch (orientation) 
			{
				case ExifInterface.ORIENTATION_NORMAL:
					norientation="NORMAL";
					break;
				case ExifInterface.ORIENTATION_ROTATE_90:
					matrix.postRotate(90);
					norientation="90";
					break;
				case ExifInterface.ORIENTATION_ROTATE_180:
					matrix.postRotate(180);
					norientation="180";
					break;
				case ExifInterface.ORIENTATION_ROTATE_270:
					matrix.postRotate(270);
					norientation="270";
					break;
				case ExifInterface.ORIENTATION_FLIP_HORIZONTAL:
					//matrix.postRotate(270);
					norientation="ORIENTATION_FLIP_HORIZONTAL";
					break;
				case ExifInterface.ORIENTATION_FLIP_VERTICAL:
					//matrix.postRotate(270);
					norientation="ORIENTATION_FLIP_VERTICAL";
					break;

			default:
				break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.v("console","rotate "+norientation+ " orientation "+orientation);
		return matrix;
	}
	
	public static String getPath(Activity _context, Uri uri) 
	{
		String[] projection = { MediaStore.Images.Media.DATA };
		Cursor cursor = _context.managedQuery(uri, projection, null, null, null);
		
		if(cursor!=null)
		{
			//HERE YOU WILL GET A NULLPOINTER IF CURSOR IS NULL
			//THIS CAN BE, IF YOU USED OI FILE MANAGER FOR PICKING THE MEDIA
			int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
			cursor.moveToFirst();
			return cursor.getString(column_index);
		}
		else return null;
	} 
	
	//---------------------------------------------------------
	
	public static String getPathFragment(Fragment _context,Uri uri)
	{
		String[] projection = { MediaStore.Images.Media.DATA };
		Cursor cursor = _context.getActivity().managedQuery(uri, projection, null, null, null);
		if (cursor != null) {
			// HERE YOU WILL GET A NULLPOINTER IF CURSOR IS NULL
			// THIS CAN BE, IF YOU USED OI FILE MANAGER FOR PICKING THE MEDIA
			int column_index = cursor
					.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
			cursor.moveToFirst();
			return cursor.getString(column_index);
		} else
			return null;
	}
	public static Bitmap decodeFile(String filePath) {
		// Decode image size
		BitmapFactory.Options o = new BitmapFactory.Options();
		o.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(filePath, o);

		// The new size we want to scale to
		final int REQUIRED_SIZE = 1024;

		// Find the correct scale value. It should be the power of 2.
		int width_tmp = o.outWidth, height_tmp = o.outHeight;
		int scale = 1;
		while (true) {
			if (width_tmp < REQUIRED_SIZE && height_tmp < REQUIRED_SIZE)
				break;
			width_tmp /= 2;
			height_tmp /= 2;
			scale *= 2;
		}

		// Decode with inSampleSize
		BitmapFactory.Options o2 = new BitmapFactory.Options();
		o2.inSampleSize = scale;
		Bitmap bitmap = BitmapFactory.decodeFile(filePath, o2);
		//Bitmap useThisBitmap = Bitmap.createScaledBitmap(bitmap,bitmap.getWidth(),bitmap.getHeight(), true);
		//bitmap.recycle();
		//imgView.setImageBitmap(bitmap);
		return bitmap;

	}
}
