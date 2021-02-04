package com.fsoft.mapper;

import java.sql.ResultSet;

public interface IRowMapper<T> {
	T rowMapping(ResultSet resultSet);
}
