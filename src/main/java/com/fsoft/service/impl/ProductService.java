package com.fsoft.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.fsoft.dao.IProductDao;
import com.fsoft.model.ProductModel;
import com.fsoft.service.IProductService;

public class ProductService implements IProductService {
	
	@Inject
	private IProductDao productDao;

	@Override
	public List<ProductModel> findAll() {
		return productDao.findAll();
	}

	@Override
	public ProductModel findById(int id) {
		return productDao.findById(id);
	}

	@Override
	public int getMaxIdProduct() {
		// TODO Auto-generated method stub
		return productDao.getMaxIdProduct();
	}

	@Override
	public int insert(ProductModel product) {
		return productDao.insert(product);
	}

}
