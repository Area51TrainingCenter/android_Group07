package com.example.examplefragment.utils;

import android.util.Log;

public class AppLog {

	
	public static void v(Object obj,int state)
	{
		if(state==0)
		{
			Log.v("CATEDRA",obj.toString());
		}
	}
}
