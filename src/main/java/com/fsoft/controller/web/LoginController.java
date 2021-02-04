	package com.fsoft.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsoft.constant.SystemConstant;
import com.fsoft.dto.CartDto;
import com.fsoft.model.AccountModel;
import com.fsoft.model.ProductModel;
import com.fsoft.service.IAccountService;
import com.fsoft.utils.CookieUtil;
import com.fsoft.utils.SessionUtil;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private IAccountService accountService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AccountModel account = (AccountModel) SessionUtil.getInstance().getValue(request, SystemConstant.USER_LOGIN);
		if (account != null) {
			response.sendRedirect(request.getContextPath() + "/home");
		} else {
			request.setAttribute("title", "login");
			request.setAttribute("message", "");
			request.setAttribute("userLogin", "");
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		boolean rm = "Y".equalsIgnoreCase(remember);
		
		AccountModel account = new AccountModel();
		account.setUsername(username);
		account.setPassword(password);
		
		account = accountService.findByUsernameAndPassword(request, account);
		
		if (account != null) {
			List<ProductModel> list = new ArrayList<ProductModel>();
			list = null;
			CartDto cart = new CartDto();
			cart.setList(list);
			SessionUtil.getInstance().putValue(request, SystemConstant.CART, cart);
			if (rm) {
				CookieUtil.addCookie(response, account);
			}
			if (account.getRole() == 1) {
				response.sendRedirect(request.getContextPath() + "/admin-product");
			} else {
				response.sendRedirect(request.getContextPath() + "/home");
			}
		} else {
			request.setAttribute("message", "Login fail");
			request.setAttribute("userLogin", "");
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
			rd.forward(request, response);
		}
		
	}

}
