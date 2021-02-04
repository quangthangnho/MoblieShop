package com.fsoft.dao;

import java.util.List;

import com.fsoft.mapper.IRowMapper;

public interface IGenericDao<T> {
	List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters);
	int save(String sql, Object... parameters);
	int getMaxId(String sql, Object... parameters);
}
