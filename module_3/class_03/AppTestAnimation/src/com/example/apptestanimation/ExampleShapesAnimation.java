package com.example.apptestanimation;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
//import static com.nineoldandroids.view.ViewPropertyAnimator.animate;

public class ExampleShapesAnimation extends Activity {

	//RelativeLayout container;
	int ITEM_W=120;
	int MAIN_W=300;
	int centerX=0;
	int centerY=0;
	
	View  view;
	View[] views =new View[6];
	boolean state=false;
	View viewMain;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shapes);
		
		//container=(RelativeLayout)findViewById(R.id.mycontainer2);
		/*views ={(View)findViewById(R.id.myview1),
				(View)findViewById(R.id.myview2),
				(View)findViewById(R.id.myview3),
				(View)findViewById(R.id.myview4)
				};
		*/
		viewMain=(View)findViewById(R.id.myview0);
		
		views[0]=(View)findViewById(R.id.myview1);
		views[1]=(View)findViewById(R.id.myview2);
		views[2]=(View)findViewById(R.id.myview3);
		views[3]=(View)findViewById(R.id.myview4);
		views[4]=(View)findViewById(R.id.myview5);
		views[5]=(View)findViewById(R.id.myview6);
		
		//view=(View)findViewById(R.id.myview1);
		//view.setLayoutParams(getLayout(0,0));
		//view.setLayoutParams(getLayout(100,100));
		
		//int r=200;
		
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);

		centerX=(int)Math.floor(metrics.widthPixels*0.5);
		centerY=(int)Math.floor(metrics.heightPixels*0.5)-100;
		
		viewMain.setLayoutParams(getLayout(MAIN_W,MAIN_W,0,0));
		
		for (int i = 0; i < views.length; i++) 
		{
			views[i].setLayoutParams(getLayout(ITEM_W,ITEM_W,0,0));
		}
		/*animate(views[0]).setDuration(250);
		animate(views[1]).setDuration(250);
		animate(views[2]).setDuration(250);
		animate(views[3]).setDuration(250); */
		
		/*int x1=(int)Math.floor(r*Math.cos(0));
		int y1=(int)Math.floor(r*Math.sin(0));
		
		int x2=(int)Math.floor(r*Math.cos(30*(Math.PI/180)));
		int y2=(int)Math.floor(r*Math.sin(30*(Math.PI/180)));
		
		int x3=(int)Math.floor(r*Math.cos(60*(Math.PI/180)));
		int y3=(int)Math.floor(r*Math.sin(60*(Math.PI/180)));
		
		int x4=(int)Math.floor(r*Math.cos(90*(Math.PI/180)));
		int y4=(int)Math.floor(r*Math.sin(90*(Math.PI/180)));
		
		int x5=(int)Math.floor(r*Math.cos(120*(Math.PI/180)));
		int y5=(int)Math.floor(r*Math.sin(120*(Math.PI/180))); */
		
		//views[0].setLayoutParams(getLayout(x1,y1));
		//views[1].setLayoutParams(getLayout(x2,y2));
		//views[2].setLayoutParams(getLayout(x3,y3));
		//views[3].setLayoutParams(getLayout(x3,y3));
		//views[4].setLayoutParams(getLayout(x4,y4));
		//views[5].setLayoutParams(getLayout(x5,y5));
		
		//views[2].setLayoutParams(getLayout(x3,y3));
		
		/*TranslateAnimation t =new TranslateAnimation(0, 0, 200+y1, 200+x1);
		t.setDuration(1000);
		views[0].startAnimation(t);*/
		/*views[0].setLayoutParams(getLayout(0,0));
		views[1].setLayoutParams(getLayout(0,0));
		views[2].setLayoutParams(getLayout(0,0));
		views[3].setLayoutParams(getLayout(0,0));
		views[4].setLayoutParams(getLayout(0,0));
		views[5].setLayoutParams(getLayout(0,0)); */
		
		//animate(views[0]).x(200+x1).y(200+y1);
		//animate(views[1]).x(200+x2).y(200+y2);
		//animate(views[2]).x(200+x3).y(200+y3);
		//animate(views[3]).x(200+x4).y(200+y4);
		
		viewMain.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				toggle();
			}
		});
	}
	
	public void click_handler(View view)
	{
		toggle();

	}
	private void toggle() {
		// TODO Auto-generated method stub
		if(state)
		{
			state=false;
			int nPostX=(int)Math.floor(centerX-ITEM_W*0.5);
			int nPostY=(int)Math.floor(centerY-ITEM_W*0.5);

			//animate(views[0]).x(nPostX).y(nPostY);
			//animate(views[1]).x(nPostX).y(nPostY);
			//animate(views[2]).x(nPostX).y(nPostY);
			//animate(views[3]).x(nPostX).y(nPostY);
		}else
		{
			state=true;
			
			int r=250;
			int x1=(int)Math.floor(r*Math.cos(0));
			int y1=(int)Math.floor(r*Math.sin(0));
			
			int x2=(int)Math.floor(r*Math.cos(30*(Math.PI/180)));
			int y2=(int)Math.floor(r*Math.sin(30*(Math.PI/180)));
			
			int x3=(int)Math.floor(r*Math.cos(60*(Math.PI/180)));
			int y3=(int)Math.floor(r*Math.sin(60*(Math.PI/180)));
			
			int x4=(int)Math.floor(r*Math.cos(90*(Math.PI/180)));
			int y4=(int)Math.floor(r*Math.sin(90*(Math.PI/180)));
			
			int x5=(int)Math.floor(r*Math.cos(120*(Math.PI/180)));
			int y5=(int)Math.floor(r*Math.sin(120*(Math.PI/180)));
			
			/*animate(views[0]).x(centerX+x1).y(centerY+y1);
			animate(views[1]).x(centerX+x2).y(centerY+y2);
			animate(views[2]).x(centerX+x3).y(centerY+y3);
			animate(views[3]).x(centerX+x4).y(centerY+y4); */
		}
	}

	
	/*public RelativeLayout.LayoutParams getLayout(int x, int y)
	{
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				50,50); //The WRAP_CONTENT parameters can be replaced by an absolute width and height or the FILL_PARENT option)
		params.leftMargin = 200+x-25;//x-25; //Your X coordinate
		params.topMargin = 200+y-25;//y-25; //Your Y coordinate

		return params;
	}*/
	public RelativeLayout.LayoutParams getLayout(int w, int h, int x, int y)
	{
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				w,h); //The WRAP_CONTENT parameters can be replaced by an absolute width and height or the FILL_PARENT option)
		params.leftMargin = (int)Math.floor(centerX+x-w*0.5);//x-25; //Your X coordinate
		params.topMargin = (int)Math.floor(centerY+y-h*0.5);//y-25; //Your Y coordinate

		return params;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		return true;
	}

}
