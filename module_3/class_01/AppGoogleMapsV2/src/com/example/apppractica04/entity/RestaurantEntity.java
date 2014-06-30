package com.example.apppractica04.entity;

import java.io.Serializable;

public class RestaurantEntity implements Serializable {

	private String name;
	private String category;
	private String phone;
	private String address;
	private String desc;
	
	
	
	public RestaurantEntity(String name, String category, String phone,
			String address, String desc) {
		super();
		this.name = name;
		this.category = category;
		this.phone = phone;
		this.address = address;
		this.desc = desc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
