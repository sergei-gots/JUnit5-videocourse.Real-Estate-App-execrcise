package com.realestateapp;

import java.math.BigDecimal;

public class Apartment {
	
	private double area;
	private BigDecimal price;
	
	public Apartment(double area, BigDecimal price) {
		super();
		this.area = area;
		this.price = price;
	}
	public double getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Apartment [area=" + area + ", price=" + price + "]";
	}
	
}
