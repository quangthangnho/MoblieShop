package com.fsoft.dao;

import java.util.List;

import com.fsoft.model.CategoryModel;

public interface ICategoryDao extends IGenericDao<CategoryModel>{
	List<CategoryModel> findAll();
	int save(CategoryModel category);
}
