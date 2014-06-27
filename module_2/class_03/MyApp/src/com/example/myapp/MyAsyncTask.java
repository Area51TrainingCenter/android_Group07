package com.example.myapp;

import android.os.AsyncTask;

public class MyAsyncTask extends AsyncTask<Params, Progress, Result> {

	@Override
	protected Result doInBackground(Params... arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	protected void onCancelled(Result result) {
		//preloader.hide();
	};
	protected void onPostExecute(Result result) 
	{
		//preloader.hide();
	};
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		//preloader...
		//preloader.show();
	}

}
