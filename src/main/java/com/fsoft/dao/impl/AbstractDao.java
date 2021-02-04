package com.fsoft.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fsoft.dao.IGenericDao;
import com.fsoft.mapper.IRowMapper;

public class AbstractDao<T> implements IGenericDao<T> {

	public Connection connectionDatabase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/MobileShop";
			String dbUser = "root";
			String dbPass = "root";
			return DriverManager.getConnection(url, dbUser, dbPass);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters) {
		// TODO Auto-generated method stub
		List<T> result = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = connectionDatabase();
			result = new ArrayList<T>();
			if (connection != null) {
				statement = connection.prepareStatement(sql);
				setParamter(statement, parameters);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					result.add(rowMapper.rowMapping(resultSet));
				}
				if (result.size() > 0) {
					return result;
				} else {
					return null;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}
		return null;
	}
	
	private void setParamter(PreparedStatement statement, Object... parameters) {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object paramter = parameters[i];
				int index = i + 1;
				if (paramter instanceof Integer) {
					statement.setInt(index, (Integer) paramter);
				} else if (paramter instanceof String) {
					statement.setString(index, (String) paramter);
				} else if (paramter instanceof Double) {
					statement.setDouble(index, (Double) paramter);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int save(String sql, Object... parameters) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			int id = 0;
			connection = connectionDatabase();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParamter(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int getMaxId(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			int id = 0;
			connection = connectionDatabase();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParamter(statement, parameters);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return 0;
	}
	
}
