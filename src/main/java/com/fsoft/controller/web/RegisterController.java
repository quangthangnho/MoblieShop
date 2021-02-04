package com.fsoft.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsoft.constant.SystemConstant;
import com.fsoft.model.AccountModel;
import com.fsoft.service.IAccountService;
import com.fsoft.utils.SessionUtil;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IAccountService accountService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountModel account = (AccountModel) SessionUtil.getInstance().getValue(request, SystemConstant.USER_LOGIN);
		if (account != null) {
			response.sendRedirect(request.getContextPath() + "/home");
		} else {
			request.setAttribute("title", "register");
			request.setAttribute("message", "");
			request.setAttribute("userLogin", "");
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/register.jsp");
			rd.forward(request, response);
		}
	}
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		AccountModel account = new AccountModel(username, password, name, email, phone, address, "system.jpg",0);
		int id = accountService.insert(account);
		if (id > 0) {
			account.setId(id);
			SessionUtil.getInstance().putValue(request, SystemConstant.USER_LOGIN , account);
			response.sendRedirect(request.getContextPath() + "/home");
		} else {
			request.setAttribute("message", "Register fail");
			request.setAttribute("userLogin", "");
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/register.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
