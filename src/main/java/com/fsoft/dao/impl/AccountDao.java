package com.fsoft.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.fsoft.dao.IAccountDao;
import com.fsoft.mapper.impl.AccountMapper;
import com.fsoft.model.AccountModel;

public class AccountDao extends AbstractDao<AccountModel> implements IAccountDao {

	@Override
	public AccountModel findByUsernameAndPassword(AccountModel account) {
		List<AccountModel> list = new ArrayList<AccountModel>();
		String sql = "SELECT * FROM account WHERE username = ? AND password = ?";
		list = query(sql, new AccountMapper(), account.getUsername(), account.getPassword());
		return list != null ? list.get(0) : null;
	}

	@Override
	public int insert(AccountModel account) {
		StringBuilder sql = new StringBuilder("INSERT INTO account ");
		sql.append("(username, password, name, email, phone, address, avatar, role)");
		sql.append(" values(?,?,?,?,?,?,?,?)");
		return save(sql.toString(), account.getUsername(), account.getPassword(), 
					account.getName(), account.getEmail(), account.getPhone(), 
					account.getAddress(), account.getAvatar(), account.getRole());
	}

	@Override
	public AccountModel findByUsername(AccountModel account) {
		List<AccountModel> list = new ArrayList<AccountModel>();
		String sql = "SELECT * FROM account WHERE username = ?";
		list = query(sql, new AccountMapper(), account.getUsername());
		return list != null ? list.get(0) : null;
	}

}
