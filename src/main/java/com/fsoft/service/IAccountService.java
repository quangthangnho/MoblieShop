package com.fsoft.service;

import javax.servlet.http.HttpServletRequest;

import com.fsoft.model.AccountModel;

public interface IAccountService {
	AccountModel findByUsernameAndPassword(HttpServletRequest request, AccountModel account);
	int insert(AccountModel account);
	AccountModel findByUsername(AccountModel account);
}
