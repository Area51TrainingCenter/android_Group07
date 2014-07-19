package com.area51.mytracking.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class TrackMeSession {

	public static final String TRACKME="trackme";
	public static final String TRACK="track";
	
	public static SharedPreferences  getSession(Context context)
	{
		SharedPreferences settings = context.getSharedPreferences(TRACKME, Context.MODE_PRIVATE);
		return settings;
	}
	public static void trackingON(Context context,String s)
	{
		SharedPreferences.Editor editor = getSession(context).edit();
		editor.putString("TRACK",s );
		editor.commit();
	}
	public static void trackingOff(Context context)
	{
		clear(context);
	}
	public static String getCurrentTracking(Context context)
	{
		SharedPreferences prefe=getSession(context);
        String obj= prefe.getString(TRACK,null);
		return obj;
	}
	
	public static boolean isTracking(Context context)
	{
		SharedPreferences prefe=getSession(context);
        String obj= prefe.getString(TRACK,null);
        if(obj!=null)return true;
        
        return false;
	}
	

	public  static void clear(Context context)
	{
		SharedPreferences.Editor defaultPrefsPut=getSession(context).edit();
		defaultPrefsPut.clear();
		defaultPrefsPut.commit();
	}

}
