package com.fsoft.controller.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsoft.constant.SystemConstant;
import com.fsoft.model.AccountModel;
import com.fsoft.model.ProductModel;
import com.fsoft.service.IProductService;
import com.fsoft.utils.SessionUtil;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private IProductService productService;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(getServletContext().getRealPath("resources/images/product"));
		AccountModel account = (AccountModel) SessionUtil.getInstance().getValue(request, SystemConstant.USER_LOGIN);
		if (account != null) {
			request.setAttribute("userLogin", account.getUsername());
			request.setAttribute("userAdmin", account.getRole());
			String message = request.getParameter("message");
			request.setAttribute("message", message);
		} else {
			request.setAttribute("userLogin", "");
			request.setAttribute("message", "");
		}
		List<ProductModel> list = productService.findAll();
		request.setAttribute("listProduct", list);
		request.setAttribute("title", "home");
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
