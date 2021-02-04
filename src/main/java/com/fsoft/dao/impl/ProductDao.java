package com.fsoft.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.fsoft.dao.IProductDao;
import com.fsoft.mapper.impl.ProductMapper;
import com.fsoft.model.ProductModel;

public class ProductDao extends AbstractDao<ProductModel> implements IProductDao {

	@Override
	public List<ProductModel> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM product";
		return query(sql, new ProductMapper());
	}

	@Override
	public ProductModel findById(int id) {
		// TODO Auto-generated method stub
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "SELECT * FROM product WHERE id = ?";
		list = query(sql, new ProductMapper(), id);
		return list != null ? list.get(0) : null;
	}

	@Override
	public int getMaxIdProduct() {
		// TODO Auto-generated method stub
		String sql = "SELECT Max(id) FROM product";
		return getMaxId(sql);
	}

	@Override
	public int insert(ProductModel product) {
		StringBuilder sql = new StringBuilder("INSERT INTO product ");
		sql.append("(idcategory, name, description, thumbnail, code, price, stock)");
		sql.append(" VALUES(?,?,?,?,?,?,?)");
		return save(sql.toString(), product.getIdcategory(), product.getName(), product.getDescription(), product.getThumbnail(), product.getCode(), product.getPrice(), product.getStock());
	}

}
