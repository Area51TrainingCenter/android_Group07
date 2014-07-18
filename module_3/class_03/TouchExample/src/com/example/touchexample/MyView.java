package com.example.touchexample;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MyView extends View implements OnTouchListener {

	private float postX, postY; 
	private Paint paint = new Paint();
	private List<MyPoint> arr;
	
	public MyView(Context context)
	{
		super(context);
		// TODO Auto-generated constructor stub
		
	   this.setClickable(true);
        setBackgroundColor(Color.WHITE);    
        this.setOnTouchListener(this);        
        
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        arr=new ArrayList<MyPoint>();
	}

	@Override
	public boolean onTouch(View view, MotionEvent e) 
	{
		// TODO Auto-generated method stub
		Log.v("console","x "+ e.getX()+" y "+e.getY());
		postX=e.getX();
		postY=e.getY();
		arr.add(new MyPoint(e.getX(), e.getY()));
		invalidate();
		return false;//false;
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		//canvas.drawCircle(postX, postY, 20, paint);
		for (MyPoint point : arr) {
			canvas.drawCircle(point.getX(), point.getY(), 5, paint);
		}
	}

}
class MyPoint
{
	private float x;
	private float y;
	
	public MyPoint(float _x,float _y)
	{
		x=_x;
		y=_y;
	}
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}

}
