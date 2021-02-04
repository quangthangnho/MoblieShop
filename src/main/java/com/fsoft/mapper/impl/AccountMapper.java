package com.fsoft.mapper.impl;

import java.sql.ResultSet;

import com.fsoft.mapper.IRowMapper;
import com.fsoft.model.AccountModel;

public class AccountMapper implements IRowMapper<AccountModel> {

	@Override
	public AccountModel rowMapping(ResultSet resultSet) {
		try {
			AccountModel account = new AccountModel();
			account.setId(resultSet.getInt("id"));
			account.setUsername(resultSet.getString("username"));
			account.setPassword(resultSet.getString("password"));
			account.setAddress(resultSet.getString("address"));
			account.setAvatar(resultSet.getString("avatar"));
			account.setEmail(resultSet.getString("email"));
			account.setName(resultSet.getString("name"));
			account.setPhone(resultSet.getString("phone"));
			account.setRole(resultSet.getInt("role"));
			
			return account;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
}
