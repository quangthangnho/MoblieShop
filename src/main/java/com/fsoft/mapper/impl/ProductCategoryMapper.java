package com.fsoft.mapper.impl;

import java.sql.ResultSet;

import com.fsoft.dto.ProductCategoryDto;
import com.fsoft.mapper.IRowMapper;

public class ProductCategoryMapper implements IRowMapper<ProductCategoryDto> {

	@Override
	public ProductCategoryDto rowMapping(ResultSet resultSet) {
		try {
			ProductCategoryDto productcategory = new ProductCategoryDto();
			productcategory.setId(resultSet.getInt("id"));
			productcategory.setIdcategory(resultSet.getInt("idcategory"));
			productcategory.setName(resultSet.getString("name"));
			productcategory.setDescription(resultSet.getString("description"));
			productcategory.setThumbnail(resultSet.getString("thumbnail"));
			productcategory.setCode(resultSet.getString("code"));
			productcategory.setPrice(resultSet.getDouble("price"));
			productcategory.setStock(resultSet.getInt("stock"));
			productcategory.setCategory(resultSet.getString("category"));
			
			return productcategory;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
