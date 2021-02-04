package com.fsoft.mapper.impl;

import java.sql.ResultSet;

import com.fsoft.mapper.IRowMapper;
import com.fsoft.model.ProductModel;

public class ProductMapper implements IRowMapper<ProductModel> {

	@Override
	public ProductModel rowMapping(ResultSet resultSet) {
		// TODO Auto-generated method stub
		try {
			ProductModel product = new ProductModel();
			product.setId(resultSet.getInt("id"));
			product.setIdcategory(resultSet.getInt("idcategory"));
			product.setName(resultSet.getString("name"));
			product.setDescription(resultSet.getString("description"));
			product.setThumbnail(resultSet.getString("thumbnail"));
			product.setCode(resultSet.getString("code"));
			product.setPrice(resultSet.getDouble("price"));
			product.setStock(resultSet.getInt("stock"));
			
			return product;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
}
