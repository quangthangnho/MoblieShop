package com.fsoft.dao;

import com.fsoft.model.AccountModel;

public interface IAccountDao extends IGenericDao<AccountModel> {
	AccountModel findByUsernameAndPassword(AccountModel account);
	AccountModel findByUsername(AccountModel account);
	int insert(AccountModel account);
}
