package com.example.appservice;

import android.content.res.Resources.Theme;
import android.os.AsyncTask;
import android.util.Log;

public class MyAsyncTask extends AsyncTask<String, Integer, String> {

	private static int count =0;
	private static Thread thread;
	private boolean process=true;
	
	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		count=0;
		thread= new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				// TODO Auto-generated method stub
				while(process)
				{
					try {
						Thread.sleep(2000);
					} catch (Exception e) {
						// TODO: handle exception
					}
					count++;
					Log.v("CONSOLE","Thread..."+count);
					//Toast.makeText(getApplicationContext(), "OAAAAAA !", Toast.LENGTH_SHORT).show();
					if(count>20)
					{
						process=false;
					}
					
				}
				
			}
		});
		thread.start();
		return null;
	}
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
	}
	
	@Override
	protected void onProgressUpdate(Integer... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}
	
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
	}
	
	/*
	 *  private class DownloadFilesTask extends AsyncTask<URL, Integer, Long> {
     protected Long doInBackground(URL... urls) {
         int count = urls.length;
         long totalSize = 0;
         for (int i = 0; i < count; i++) {
             totalSize += Downloader.downloadFile(urls[i]);
             publishProgress((int) ((i / (float) count) * 100));
             // Escape early if cancel() is called
             if (isCancelled()) break;
         }
         return totalSize;
     }

     protected void onProgressUpdate(Integer... progress) {
         setProgressPercent(progress[0]);
     }

     protected void onPostExecute(Long result) {
         showDialog("Downloaded " + result + " bytes");
     }
 }
	 */

}
