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
import com.fsoft.dto.ProductCategoryDto;
import com.fsoft.model.AccountModel;
import com.fsoft.service.IProductCategoryService;
import com.fsoft.utils.SessionUtil;

@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IProductCategoryService productCategoryService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccountModel account = (AccountModel) SessionUtil.getInstance().getValue(request, SystemConstant.USER_LOGIN);
		if (account != null) {
			request.setAttribute("userLogin", account.getUsername());
		} else {
			request.setAttribute("userLogin", "");
		}
		int id = Integer.parseInt(request.getParameter("id"));
		ProductCategoryDto product = productCategoryService.findById(id);
		request.setAttribute("title", "product");
		request.setAttribute("product", product);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/product.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
