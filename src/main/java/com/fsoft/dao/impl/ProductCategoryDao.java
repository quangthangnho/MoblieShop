package com.fsoft.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.fsoft.dao.IProductCategoryDao;
import com.fsoft.dto.ProductCategoryDto;
import com.fsoft.mapper.impl.ProductCategoryMapper;

public class ProductCategoryDao extends AbstractDao<ProductCategoryDto> implements IProductCategoryDao {

	@Override
	public ProductCategoryDto findById(int id) {
		List<ProductCategoryDto> list = new ArrayList<ProductCategoryDto>();
		StringBuilder sql = new StringBuilder("SELECT p.*, c.category");
		sql.append(" FROM product AS p");
		sql.append(" INNER JOIN category AS c");
		sql.append(" ON p.idcategory = c.id");
		sql.append(" WHERE p.id = ?");
		list = query(sql.toString(), new ProductCategoryMapper(), id);
		return list != null ? list.get(0) : null;
	}

	@Override
	public List<ProductCategoryDto> findAll() {
		StringBuilder sql = new StringBuilder("SELECT p.*, c.category");
		sql.append(" FROM product AS p");
		sql.append(" INNER JOIN category AS c");
		sql.append(" ON p.idcategory = c.id");
		return query(sql.toString(), new ProductCategoryMapper());
	}

	

}
