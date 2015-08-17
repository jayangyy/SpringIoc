package com.ioc.domains;

import org.springframework.stereotype.Component;

@Component("car1")
public class Car1 {
	private String brand;
	private double price;
	// Ê¡ÂÔ get/setter

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "brand:" + brand + "," + "price:" + price;
	}
}
