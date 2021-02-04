package com.fsoft.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.fsoft.dao.ICategoryDao;
import com.fsoft.model.CategoryModel;
import com.fsoft.service.ICategoryService;

public class CategoryService implements ICategoryService {

	@Inject
	private ICategoryDao categoryDao;
	
	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}
	
}
