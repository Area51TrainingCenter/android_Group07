package com.area51.pandroidtemplate;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class HomeActivty extends Activity {
	
	private ImageView imgPhoto;
	private int[] arrImages;
	private int count =0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		app();
	}

	private void app() {
		// TODO Auto-generated method stub
		arrImages = new int[]{R.drawable.sample_0, R.drawable.sample_1,R.drawable.sample_2,
				R.drawable.sample_3, R.drawable.sample_4,R.drawable.sample_5,
				R.drawable.sample_6, R.drawable.sample_7
				};
		
		imgPhoto = (ImageView)findViewById(R.id.imgPhoto);
		
		imgPhoto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(count>=arrImages.length)
				{
					// TODO Auto-generated method stub
					count=0;
				}
				imgPhoto.setImageResource(arrImages[count]);
				
				count++;
			}
		});
	}

}
