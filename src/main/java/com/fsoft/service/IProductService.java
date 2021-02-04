package com.fsoft.service;

import java.util.List;

import com.fsoft.model.ProductModel;

public interface IProductService {
	List<ProductModel> findAll();
	ProductModel findById(int id);
	int getMaxIdProduct();
	int insert(ProductModel product);
}
