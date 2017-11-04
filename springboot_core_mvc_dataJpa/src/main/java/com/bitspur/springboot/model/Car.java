package com.bitspur.springboot.model;

public class Car {
	
	private String color;
	private String brand;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Car(String color, String brand) {
		super();
		this.color = color;
		this.brand = brand;
	}
	public Car() {
	}
	
	

}
