package com.fsoft.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fsoft.constant.SystemConstant;
import com.fsoft.dao.IAccountDao;
import com.fsoft.dao.impl.AccountDao;
import com.fsoft.model.AccountModel;
import com.fsoft.utils.CookieUtil;
import com.fsoft.utils.SessionUtil;

public class AuthorizationFilter implements Filter {

	@Inject
	private IAccountDao accountDao;
	
//	@Inject
//	private IAccountService accountService;
	
	@SuppressWarnings("unused")
	private ServletContext context;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.context = filterConfig.getServletContext();
		//accountService = new AccountService();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String userCookie = CookieUtil.checkCookie(req);
		
		if (!userCookie.equalsIgnoreCase("")) {
			AccountModel account = new AccountModel();
			account.setUsername(userCookie);
			accountDao = new AccountDao();
			account = accountDao.findByUsername(account);
			if (account != null) {
				SessionUtil.getInstance().putValue(req, SystemConstant.USER_LOGIN, account);
			}else {
				CookieUtil.removeCookie(resp);
				
			}
		} else {
			HttpSession session = req.getSession();
			session.invalidate();
		}
		
		String url = req.getRequestURI();
		url = url.replace(req.getContextPath(), "");

		if (url.startsWith("/admin")) {
			AccountModel account = (AccountModel) SessionUtil.getInstance().getValue(req, SystemConstant.USER_LOGIN);
			if (account != null) {
				if(account.getRole() == 1) {
					chain.doFilter(request, response);
				} else if (account.getRole() == 0) {
					resp.sendRedirect(req.getContextPath() + "/404");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/login");
			}
		} else {
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
