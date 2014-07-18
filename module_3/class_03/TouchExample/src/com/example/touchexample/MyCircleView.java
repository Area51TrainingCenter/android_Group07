package com.example.touchexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MyCircleView extends View implements OnTouchListener{

	static int x,y;
	final static int radius=30;
    Paint paint;
    private int px=0;
    
	public MyCircleView(Context context) 
	{
		super(context);
      paint=new Paint();
      paint.setAntiAlias(true);       //for smooth rendering
      paint.setColor(Color.BLUE);

      setFocusable(true);
      this.setOnTouchListener(this);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		paint.setColor(Color.BLUE);
	    canvas.drawCircle(x,y,radius,paint);
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent event) 
	{
		// TODO Auto-generated method stub
		 x=(int)event.getX()-(radius/2);  
	     y=(int)event.getY()-(radius/2);
	     invalidate(); 
	     
	     switch (event.getAction()) 
	     {
			case MotionEvent.ACTION_DOWN:
				 Log.v("CONSOLE", "ACTION_DOWN");
				break;
			case MotionEvent.ACTION_UP:
				 Log.v("CONSOLE", "ACTION_UP");
				break;
			case MotionEvent.ACTION_MOVE:
				/*Log.v("CONSOLE", "ACTION_MOVE x: "+event.getX()+" y: "+
						event.getY()+" y: "); */
				 if(x>px)
				 {
					 Log.v("CONSOLE","DERECHA");
				 }else if(x<px)
				 {
					 Log.v("CONSOLE","IZQUIERDA");
				 }
				 px=x;
				break;
	
			default:
				break;
		}
	     return true;
	}

}
