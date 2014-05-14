package com.area51.pandroidtemplate.model;

public class BallEntity {
	
	private int speed= 10;
	private int radio=5;
	private float mass=10f;
	
	public BallEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BallEntity(int speed, int radio, float mass) {
		super();
		this.speed = speed;
		this.radio = radio;
		this.mass = mass;
	}
// metodo propios
	
	public void speedUp(int _value)
	{
		this.speed+= _value;
		//this.speed =this.speed+_value;
	}
	
	
	public void speedDown(int _value)
	{
		this.speed-= _value;
	}

	public float momentum()
	{
		//Integer.parseInt(string);
		//Float.parseFloat(string);
		//String.valueOf(100);
		
		return this.mass*this.speed;
	}
	
	public String printStatus()
	{
		String aux="BallEntity "+" speed "+speed+ " radio "+radio+ " mass "+mass;
		return aux;
	}
	//métodos de acceso
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public float getMass() {
		return mass;
	}

	public void setMass(float mass) {
		this.mass = mass;
	}
	

}
