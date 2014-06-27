package com.facebook.samples.sessionlogin;



import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import android.widget.DatePicker;

public class FbUtils {

	public FbUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
	public static void goToURL(Context context,String url) 
	{
		Uri uriUrl = Uri.parse(url);
		Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl); 
		context.startActivity(launchBrowser);
	}
	
	public static void showKeyHashes(String spackage,Context context)
	{
		PackageInfo packageInfo;
        	try {
			        packageInfo = context.getPackageManager().getPackageInfo(spackage,
					PackageManager.GET_SIGNATURES);
					        for (Signature signature : packageInfo.signatures) {
					                MessageDigest md = MessageDigest.getInstance("SHA");
					                md.update(signature.toByteArray());
					                String key = new String(Base64.encode(md.digest(), 0));
					                // String key = new String(Base64.encodeBytes(md.digest()));
					                FLog.v("Hash key", key);
					        }
		        }
		        catch (NameNotFoundException e1) {
		        	FLog.v("Name not found", e1.toString());
		        }
		 
		        catch (NoSuchAlgorithmException e) {
		        	FLog.v("No such an algorithm", e.toString());
		        }
		        catch (Exception e){
		        	FLog.v("Exception", e.toString());
		        }
	}
	
	public static Date getDateFromDatePicket(DatePicker datePicker){
	    int day = datePicker.getDayOfMonth();
	    int month = datePicker.getMonth();
	    int year =  datePicker.getYear();

	    Calendar calendar = Calendar.getInstance();
	    calendar.set(year, month, day);

	    return calendar.getTime();
	}
	
	 public static Bitmap getBitmapFromAssets(Context context,String fileName) {
		    AssetManager assetManager = context.getAssets();

		    InputStream istr;
		    Bitmap bitmap =null;
			try {
				istr = assetManager.open(fileName);
				bitmap=BitmapFactory.decodeStream(istr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		    return bitmap;
		}
	 
	 public static String getDateFormat(Date date)
	 {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDay=f.format(date);
		FLog.v("formattedDay ",formattedDay);

		return formattedDay;
	 }
	 
	 public static String getDateFormat(int year, int month, int day)
	 {
		String mMonth = month+"";
		String mDay = day+"";
		if(month<0)
		{
			mMonth="0"+month;
		}
		if(day<0)
		{
			mDay="0"+day;
		}
		
		return day+"/"+month+"/"+year; 
	 }
	 
	 public static String getDateFormatAPI(int year, int month, int day)
	 {
		String mMonth = month+"";
		String mDay = day+"";
		if(month<0)
		{
			mMonth="0"+month;
		}
		if(day<0)
		{
			mDay="0"+day;
		}
		
		return year+"/"+month+"/"+day; 
	 }
	 

}
