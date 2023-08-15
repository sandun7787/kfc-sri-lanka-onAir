package com.codewithluck.kfcsrilanka.model;

public class Product {

	private int product_code;
	private String name;
	private double price;
	
	public Product() {
		
	}

	public Product(int product_code, String name, double price) {
		this.product_code = product_code;
		this.name = name;
		this.price = price;
	}

	public int getProduct_code() {
		return product_code;
	}

	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}	

}

