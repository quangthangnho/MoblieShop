package com.fsoft.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.fsoft.dao.IProductCategoryDao;
import com.fsoft.dto.ProductCategoryDto;
import com.fsoft.service.IProductCategoryService;

public class ProductCategoryService implements IProductCategoryService {

	@Inject
	private IProductCategoryDao productCategoryDao;
	
	@Override
	public ProductCategoryDto findById(int id) {
		return productCategoryDao.findById(id);
	}

	@Override
	public List<ProductCategoryDto> findAll() {
		return productCategoryDao.findAll();
	}

}
