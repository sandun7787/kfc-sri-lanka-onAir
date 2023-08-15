package com.codewithlak.kfcsrilanka.dao;

import java.sql.SQLException;
import java.util.List;

import com.codewithluck.kfcsrilanka.model.Product;

public interface ProductManager {

public boolean addProduct(Product product) throws SQLException, ClassNotFoundException;
	
	public boolean editProduct(Product product) throws SQLException, ClassNotFoundException;
	
	public boolean deleteProduct(int productCode) throws SQLException, ClassNotFoundException;
	
	public Product fetchSingleProduct(int productCode) throws SQLException, ClassNotFoundException;
	
	public List<Product> fetchAllProducts() throws SQLException, ClassNotFoundException;

	
}
