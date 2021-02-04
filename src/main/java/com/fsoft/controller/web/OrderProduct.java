package com.fsoft.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsoft.constant.SystemConstant;
import com.fsoft.dto.CartDto;
import com.fsoft.model.AccountModel;
import com.fsoft.model.ProductModel;
import com.fsoft.service.IProductService;
import com.fsoft.utils.SessionUtil;

/**
 * Servlet implementation class OrderProduct
 */
@WebServlet("/order")
public class OrderProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IProductService productService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccountModel account = (AccountModel) SessionUtil.getInstance().getValue(request, SystemConstant.USER_LOGIN);
		if (account == null) {
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			String id = request.getParameter("id");
			int idProduct = Integer.parseInt(id);
			
			ProductModel product = new ProductModel();
			product = productService.findById(idProduct);
			
			if (product != null) {
				ProductModel cart = new ProductModel(product.getId(), product.getName(), product.getDescription(), product.getThumbnail(), product.getCode(), product.getPrice(), 1);
				CartDto cart1 = (CartDto) SessionUtil.getInstance().getValue(request, SystemConstant.CART);
				
				if (cart1 == null) {
					List<ProductModel> list = new ArrayList<ProductModel>();
					list = null;
					CartDto cart2 = new CartDto();
					cart2.setList(list);
					SessionUtil.getInstance().putValue(request, SystemConstant.CART, cart2);
					cart1 = (CartDto) SessionUtil.getInstance().getValue(request, SystemConstant.CART);
				}
				
				if (cart1.getList() == null) {
					List<ProductModel> list2 = new ArrayList<ProductModel>();
					list2.add(cart);
					cart1.setList(list2);
				} else {
					List<ProductModel> list2 = cart1.getList();
					list2.add(cart);
					
					for (int i = 0; i <= list2.size() - 2 ; i++) {
						if (cart.getId() == list2.get(i).getId()) {
							list2.get(i).setStock(list2.get(i).getStock() + 1);
							list2.remove(list2.size() - 1);
						}
					}
					
					cart1.setList(list2);
				}
				
				SessionUtil.getInstance().updateValue(request, SystemConstant.CART, cart1);
				response.sendRedirect(request.getContextPath() + "/home?message=success");
			} else {
				response.sendRedirect(request.getContextPath() + "/home?message=fail");
			}
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
