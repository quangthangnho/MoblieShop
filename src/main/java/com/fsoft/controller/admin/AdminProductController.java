package com.fsoft.controller.admin;

import java.io.IOException;
import java.util.List;

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
import com.fsoft.model.ProductModel;
import com.fsoft.service.IProductCategoryService;
import com.fsoft.service.IProductService;
import com.fsoft.utils.SessionUtil;

/**
 * Servlet implementation class AdminProductController
 */
@WebServlet("/admin-product")
public class AdminProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private IProductService productService;
	
	@Inject
	private IProductCategoryService productCategoryService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		List<ProductCategoryDto> list = productCategoryService.findAll();
		request.setAttribute("listProduct", list);
		request.setAttribute("title", "home");
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/home.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
