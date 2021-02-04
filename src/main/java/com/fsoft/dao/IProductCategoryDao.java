package com.fsoft.dao;

import java.util.List;

import com.fsoft.dto.ProductCategoryDto;

public interface IProductCategoryDao extends IGenericDao<ProductCategoryDto> {
	ProductCategoryDto findById(int id);
	List<ProductCategoryDto> findAll();
}
