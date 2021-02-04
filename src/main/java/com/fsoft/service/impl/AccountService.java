package com.fsoft.service.impl;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.fsoft.constant.SystemConstant;
import com.fsoft.dao.IAccountDao;
import com.fsoft.model.AccountModel;
import com.fsoft.service.IAccountService;
import com.fsoft.utils.SessionUtil;

public class AccountService implements IAccountService {

	@Inject
	private IAccountDao accountDao;
	
	public int insert(AccountModel account) {
		return accountDao.insert(account);
	}

	@Override
	public AccountModel findByUsernameAndPassword(HttpServletRequest request, AccountModel account) {
		AccountModel accountLogin = new AccountModel();
		accountLogin = accountDao.findByUsernameAndPassword(account);
		if (accountLogin != null) {
			SessionUtil.getInstance().putValue(request, SystemConstant.USER_LOGIN, accountLogin);
		}
		return accountLogin;
	}

	@Override
	public AccountModel findByUsername(AccountModel account) {
		return accountDao.findByUsername(account);
	}

}
