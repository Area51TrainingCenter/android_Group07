package com.area51.module1.examplejava.entity;

public class BallEntity 
{
	private int speed=5;
	private int radio=10;
	private float weight=50f;
	private float mass =10f;
	
	public BallEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BallEntity(int speed, int radio, float weight) {
		super();
		this.speed = speed;
		this.radio = radio;
		this.weight = weight;
	}
	
	public void setRadio(int _radio)
	{
		this.radio= _radio;
	}
	
	public void speedUp(int _value)
	{
		this.speed+=_value;
	}
	
	public void speedDown(int _value)
	{
		this.speed =this.speed-_value;
	}
	public float momentum()
	{
		return this.speed*this.mass;
	}
	
	public String printStatus()
	{
		return "speed: "+this.speed+ " "+ " radio: "+this.radio+ 
				" weight: "+this.weight;
	}
	
	
	

}
