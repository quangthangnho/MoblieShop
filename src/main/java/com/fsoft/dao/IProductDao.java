package com.fsoft.dao;

import java.util.List;

import com.fsoft.model.ProductModel;

public interface IProductDao extends IGenericDao<ProductModel> {
	List<ProductModel> findAll();
	ProductModel findById(int id);
	int getMaxIdProduct();
	int insert(ProductModel product);
}
