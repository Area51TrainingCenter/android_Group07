package com.area51.pandroidtemplate.model;

public interface IBall {
	
	public void speedUp(int _value);
	public void speepDown(int _value);
	
	public float momentum();
	public String printStatus();
	
}
