package com.codewithlak.kfcsrilanka.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codewithluck.kfcsrilanka.model.Product;
import com.codewithluck.kfcsrilanka.service.ProductService;


public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String message = "";
	
	private ProductService getProductService() {
		return ProductService.getProductService();
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("add-product.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String actionType = request.getParameter("actiontype");
		
		if(actionType.equals("add")) {
			addProduct(request, response);
		}
		else if(actionType.equals("edit")){
			editProduct(request, response);
		}
		else if(actionType.equals("delete")) {
			deleteProduct(request, response);
		}
	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		product.setName(request.getParameter("name"));
		product.setPrice(Double.parseDouble(request.getParameter("price")));		
		
		try {
			if(getProductService().addProduct(product))
			{
				message = "The product has been successfully added!";
			}
			else {
				message = "Failed to add the product!";
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			message = "operation failed! " + e.getMessage();
		}
		
		request.setAttribute("feebackMessage", message);
		RequestDispatcher rd = request.getRequestDispatcher("add-product.jsp");
		rd.forward(request, response);
	}
	
	
	
    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
		
	}
    
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
    private void fetchSingleProduct(HttpServletRequest request, HttpServletResponse response) {
		
	}
    
    private void fetchAllProducts(HttpServletRequest request, HttpServletResponse response) {
		
	}	
	
}
