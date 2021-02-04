package com.fsoft.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fsoft.constant.SystemConstant;
import com.fsoft.dto.CartDto;
import com.fsoft.model.AccountModel;
import com.fsoft.utils.CookieUtil;
import com.fsoft.utils.SessionUtil;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountModel account = new AccountModel();
		account = null;
		CartDto cart = new CartDto();
		cart = null;
		SessionUtil.getInstance().removeValue(request, SystemConstant.USER_LOGIN);
		SessionUtil.getInstance().putValue(request, SystemConstant.USER_LOGIN, account);
		SessionUtil.getInstance().removeValue(request, SystemConstant.CART);
		SessionUtil.getInstance().putValue(request, SystemConstant.CART, cart);
		CookieUtil.removeCookie(response);
		response.sendRedirect(request.getContextPath() + "/home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
