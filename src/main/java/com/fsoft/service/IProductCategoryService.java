package com.fsoft.service;

import java.util.List;

import com.fsoft.dto.ProductCategoryDto;

public interface IProductCategoryService {
	ProductCategoryDto findById(int id);
	List<ProductCategoryDto> findAll();
}
