package com.fsoft.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fsoft.constant.SystemConstant;
import com.fsoft.model.AccountModel;
import com.fsoft.model.CategoryModel;
import com.fsoft.model.ProductModel;
import com.fsoft.service.ICategoryService;
import com.fsoft.service.IProductService;
import com.fsoft.utils.SessionUtil;
import com.fsoft.utils.UploadFileUtil;

@WebServlet("/admin-create-product")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 50, // 50MB
maxRequestSize = 1024 * 1024 * 50)
public class AdminCreateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private IProductService productService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message_create = request.getParameter("message_create");
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
		
		if (message_create != null) {
			request.setAttribute("message_create", message_create);
		} else {
			request.setAttribute("message_create", null);
		}
		
		List<CategoryModel> list = categoryService.findAll();
		
		request.setAttribute("listCategory", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/product/create.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = getServletContext().getRealPath("resources/images/product") + File.separator;
		
		Part part = request.getPart("images");
		
		String name = request.getParameter("name");
		
		String categoryid = request.getParameter("categoryid");
		int idcategory = Integer.parseInt(categoryid);
		String description = request.getParameter("description");
		
		String price = request.getParameter("price");
		Double priceProduct = Double.parseDouble(price);
		
		String stock = request.getParameter("stock");
		int stockProduct = Integer.parseInt(stock);
		
		int id = productService.getMaxIdProduct() + 1;
		
		UploadFileUtil uploadFile = new UploadFileUtil();
		String url = uploadFile.getSavedFileURL(id, idcategory, name, part, path);
		
		String code = "P" + id;
		
		ProductModel product = new ProductModel(name, idcategory, description, url, code, priceProduct, stockProduct);
		
		int idNew = productService.insert(product);
		
		if (idNew > 0) {
			response.sendRedirect(request.getContextPath() + "/admin-create-product?message_create=success");
		} else {
			response.sendRedirect(request.getContextPath() + "/admin-create-product?message_create=fail");
		}
		
	}

}
