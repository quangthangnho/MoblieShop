package com.fsoft.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.fsoft.utils.SessionUtil;

@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccountModel account = (AccountModel) SessionUtil.getInstance().getValue(request, SystemConstant.USER_LOGIN);
		
		String idProduct = request.getParameter("idProduct");
		
		if (account != null) {
			request.setAttribute("title", "cart");
			request.setAttribute("userLogin", account.getUsername());
			
			CartDto cart = (CartDto) SessionUtil.getInstance().getValue(request, SystemConstant.CART);
			
			if (cart == null) {
				List<ProductModel> list = new ArrayList<ProductModel>();
				list = null;
				CartDto cart1 = new CartDto();
				cart1.setList(list);
				SessionUtil.getInstance().putValue(request, SystemConstant.CART, cart1);
				cart = (CartDto) SessionUtil.getInstance().getValue(request, SystemConstant.CART);
			}
			
			List<ProductModel> list = cart.getList();
			
			if (idProduct != null) {
				int id1 = Integer.parseInt(idProduct);
//				Map<Integer, ProductModel> map = new HashMap<Integer, ProductModel>();
//				for (ProductModel p : list) {
//					if (id1 == p.getId()) {
//						map.put(id1, p);
//					}
//				}
				list.removeIf(p -> (p.getId() == id1));
			}
			
			if (list != null && list.size() > 0) {
				request.setAttribute("list", list);
			} else {
				request.setAttribute("list", "");
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/cart.jsp");
			rd.forward(request, response);
			
		} else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		SessionUtil.getInstance().removeValue(request, SystemConstant.CART);
		
		response.sendRedirect(request.getContextPath() + "/cart");
	}

}
