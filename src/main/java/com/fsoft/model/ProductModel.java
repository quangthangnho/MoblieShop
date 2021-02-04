package com.fsoft.model;

public class ProductModel extends AbstractModel {
	private int idcategory;
	
	private String name;
	
	private String description;
	
	private String thumbnail;
	
	private String code;
	
	private Double price;
	
	private int stock;
	
	public ProductModel() {}
	
	public ProductModel(String name, int idcategory, String description, String thumbnail, String code, Double price,
			int stock) {
		this.name = name;
		this.idcategory = idcategory;
		this.description = description;
		this.thumbnail = thumbnail;
		this.code = code;
		this.price = price;
		this.stock = stock;
	}

	public ProductModel(int id, String name, String description, String thumbnail, String code, Double price,
			int stock) {
		super(id);
		this.name = name;
		this.description = description;
		this.thumbnail = thumbnail;
		this.code = code;
		this.price = price;
		this.stock = stock;
	}

	public int getIdcategory() {
		return idcategory;
	}

	public void setIdcategory(int idcategory) {
		this.idcategory = idcategory;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
