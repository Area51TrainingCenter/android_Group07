package com.example.apptestanimation;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.YuvImage;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;

@SuppressLint("NewApi")
public class HomeActivity extends Activity {

	private RelativeLayout container;
	private int windowwidth=0;
	private int screencenter=0;
	protected int x_cord;
	protected int y_cord;
	protected int Likes;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		container=(RelativeLayout)findViewById(R.id.container);
		windowwidth=getWindowManager().getDefaultDisplay().getWidth();
		Log.v("CONSOLE","windowwidth "+windowwidth);
		screencenter=windowwidth/2;
		
		
		int[] myImageList = new int[] { R.drawable.img01, R.drawable.img02,
	            R.drawable.img03, R.drawable.img04, R.drawable.img05,
	            R.drawable.img06,R.drawable.img07 };
		
		final int w=(int)Math.round(DisplayUtils.convertPixelsToDp(1600, this));
		final int h=(int)Math.round(DisplayUtils.convertPixelsToDp(2000, this));
		
		for (int i = 0; i <7; i++) 
		{
			final RelativeLayout myRelView = new RelativeLayout(this);
			//RelativeLayout.LayoutParams layout=new RelativeLayout.LayoutParams(w, h);
			//layout.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
		   myRelView.setLayoutParams(new LayoutParams(w, h));
		    //myRelView.setLayoutParams(layout);
		    myRelView.setX(0);
		    myRelView.setY(40);
		    myRelView.setTag(i);
		    myRelView.setBackgroundResource(myImageList[i]);
		    
		    if (i == 0) {
	            myRelView.setRotation(-1);
	        } else if (i == 1) {
	            myRelView.setRotation(-5);

	        } else if (i == 2) {
	            myRelView.setRotation(3);

	        } else if (i == 3) {
	            myRelView.setRotation(7);

	        } else if (i == 4) {
	            myRelView.setRotation(-2);

	        } else if (i == 5) {
	            myRelView.setRotation(5);

	        }
		    
	        final Button imageLike = new Button(this);
	        imageLike.setLayoutParams(new LayoutParams(120, 120));
	        imageLike.setBackgroundDrawable(getResources().getDrawable(
	                R.drawable.like_btn));
	        imageLike.setX(20);
	        imageLike.setY(80);
	        imageLike.setAlpha(0);
	        myRelView.addView(imageLike);
	        
	        final Button imageNoLike = new Button(this);
	        imageNoLike.setLayoutParams(new LayoutParams(120, 120));
	        imageNoLike.setBackgroundDrawable(getResources().getDrawable(
	                R.drawable.pass_btn));

	        imageNoLike.setX((windowwidth - 200));
	        imageNoLike.setY(100);
	       // imageNoLike.setRotation(45);
	        imageNoLike.setAlpha(0);
	        myRelView.addView(imageNoLike);
	        
	        
		    myRelView.setOnTouchListener(new OnTouchListener() {
				
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					
		            //x_cord = (int) event.getRawX();
	                //y_cord = (int) event.getRawY();
	                
	                //myRelView.setX(x_cord - screencenter + 40);
	                //myRelView.setY(y_cord-h/2);
	                
	                switch (event.getAction()) 
	                {
		                case MotionEvent.ACTION_DOWN:
		                    break;
		                case MotionEvent.ACTION_MOVE:
		                	
				            x_cord = (int) event.getRawX();
			                y_cord = (int) event.getRawY();
			                
			                myRelView.setX(x_cord - screencenter + 40);
			                myRelView.setY(y_cord-h/2);
			                
			                
			                if (x_cord >= screencenter) 
			                {
		                        myRelView.setRotation((float) ((x_cord - screencenter) * (Math.PI / 32)));
		                        
		                        //if (x_cord > (screencenter + (screencenter / 2))) 
		                        if (x_cord > screencenter) 
		                        {
		                            imageLike.setAlpha(1);
		                            if (x_cord > (windowwidth - (screencenter / 4))) {
		                                Likes = 2;
		                            } else {
		                                Likes = 0;
		                            }
		                        } else {
		                            Likes = 0;
		                            imageLike.setAlpha(0);
		                        }
		                        imageNoLike.setAlpha(0);
			                }else
			                {
			                	myRelView.setRotation((float) ((x_cord - screencenter) * (Math.PI / 32)));
			                	
			                	//if (x_cord < (screencenter / 2)) 
			                	if (x_cord < (screencenter)) 
			                	{
		                            imageNoLike.setAlpha(1);
		                            if (x_cord < screencenter / 4) {
		                                Likes = 1;
		                            } else {
		                                Likes = 0;
		                            }
		                        } else {
		                            Likes = 0;
		                            imageNoLike.setAlpha(0);
		                        }

		                        imageLike.setAlpha(0);
			                }
		                	break;
		                	
		                case MotionEvent.ACTION_UP:
		                    x_cord = (int) event.getRawX();
		                    y_cord = (int) event.getRawY();

		                    Log.e("X Point", "" + x_cord + " , Y " + y_cord);
		                    imageNoLike.setAlpha(0);
		                    imageLike.setAlpha(0);

		                    if (Likes == 0) {
		                        Log.e("Event Status", "Nothing");
		                        myRelView.setX(0);
		                        myRelView.setY(40);
		                        myRelView.setRotation(0);
		            			//RelativeLayout.LayoutParams layout=new RelativeLayout.LayoutParams(w, h);
		            			//layout.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
		            		   // myRelView.setLayoutParams(new LayoutParams(w, h));
		            		    //myRelView.setLayoutParams(layout);
		            		    //myRelView.setRotation(0);
		            		    
		                    } else if (Likes == 1) {
		                        Log.e("Event Status", "Passed");
		                        container.removeView(myRelView);
		                    } else if (Likes == 2) {

		                        Log.e("Event Status", "Liked");
		                        container.removeView(myRelView);
		                    }
		                    break;
		                default:
		                    break;
	                }
					return true;
				}
			});
		    container.addView(myRelView);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
