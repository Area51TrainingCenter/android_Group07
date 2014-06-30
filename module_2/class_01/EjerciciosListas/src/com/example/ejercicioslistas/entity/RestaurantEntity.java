package com.example.ejercicioslistas.entity;

import java.io.Serializable;

public class RestaurantEntity implements Serializable {

	private int id;
	private String name;
	private String category;
	private int distance;
	private String desc;
	
	
	public RestaurantEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RestaurantEntity(int id, String name, String category, int distance,
			String desc) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.distance = distance;
		this.desc = desc;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	
}
