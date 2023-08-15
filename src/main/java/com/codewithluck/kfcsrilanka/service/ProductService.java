package com.codewithluck.kfcsrilanka.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithlak.kfcsrilanka.dao.ProductManager;
import com.codewithlak.kfcsrilanka.dao.ProductManagerlmpl;
import com.codewithluck.kfcsrilanka.model.Product;

public class ProductService {
	private static ProductService productServiceObj;

	private ProductService() {
		
	}
public synchronized static ProductService getProductService() {
		
		if(productServiceObj == null) {
			productServiceObj = new ProductService();
		}
		
		return productServiceObj;
		
}
		
private ProductManager getProductManager() {
	return new ProductManagerlmpl();
}

public boolean addProduct(Product product) throws ClassNotFoundException, SQLException {
	return getProductManager().addProduct(product);
}

public boolean editProduct(Product product) throws ClassNotFoundException, SQLException {
	return getProductManager().editProduct(product);
}

public boolean deleteProduct(int productCode) throws ClassNotFoundException, SQLException {
	return getProductManager().deleteProduct(productCode);
}

public Product fetchSingleProduct(int productCode) throws ClassNotFoundException, SQLException {
	return getProductManager().fetchSingleProduct(productCode);
}

public List<Product> fetchAllProducts() throws ClassNotFoundException, SQLException {
	return getProductManager().fetchAllProducts();
}
}
	
	

