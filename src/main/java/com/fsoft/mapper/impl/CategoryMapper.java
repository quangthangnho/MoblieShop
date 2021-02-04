package com.fsoft.mapper.impl;

import java.sql.ResultSet;

import com.fsoft.mapper.IRowMapper;
import com.fsoft.model.CategoryModel;

public class CategoryMapper implements IRowMapper<CategoryModel> {

	@Override
	public CategoryModel rowMapping(ResultSet resultSet) {
		try {
			CategoryModel category = new CategoryModel();
			category.setId(resultSet.getInt("id"));
			category.setCategory(resultSet.getString("category"));
			return category;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
