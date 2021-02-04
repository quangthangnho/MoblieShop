package com.fsoft.dao.impl;

import java.util.List;

import com.fsoft.dao.ICategoryDao;
import com.fsoft.mapper.impl.CategoryMapper;
import com.fsoft.model.CategoryModel;

public class CategoryDao extends AbstractDao<CategoryModel> implements ICategoryDao {

	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

	@Override
	public int save(CategoryModel category) {
		
		return 0;
	}
	
}
