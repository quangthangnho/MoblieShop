package com.fsoft.dto;

import java.util.List;

import com.fsoft.model.ProductModel;

public class CartDto {
	private int id;

	private String name;

	private String description;

	private String thumbnail;

	private String code;

	private double price;

	private int stock;
	
	private int quantity;
	
	private List<ProductModel> list;
	
	public CartDto() {
		
	}

	public CartDto(int id, String name, String description, String thumbnail,
			String code, double price, int stock, int quantity) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.thumbnail = thumbnail;
		this.code = code;
		this.price = price;
		this.stock = stock;
		this.quantity = quantity;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<ProductModel> getList() {
		return list;
	}

	public void setList(List<ProductModel> list) {
		this.list = list;
	}
}
