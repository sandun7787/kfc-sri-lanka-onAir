package com.codewithlak.kfcsrilanka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codewithluck.kfcsrilanka.dao.dbuils.DbDriverManager;
import com.codewithluck.kfcsrilanka.dao.dbuils.DbDriverManagerFactory;
import com.codewithluck.kfcsrilanka.model.Product;

public class ProductManagerlmpl implements ProductManager {
	
	

	public ProductManagerlmpl() {
		// TODO Auto-generated constructor stub
	}
		private Connection getConnection() throws ClassNotFoundException, SQLException {
		
	DbDriverManagerFactory driverFactory = new DbDriverManagerFactory();
	DbDriverManager driverManager = driverFactory.getDbDriver("MySQL");
		
		return driverManager.getConnection(); 
	}

	@Override
	public boolean addProduct(Product product) throws SQLException, ClassNotFoundException{
		
	Connection connection = getConnection();
		
		//String query = "INSERT INTO product (name, price) VALUES ("+ product.getName() + "," + product.getPrice() + ")";
		//Statement st = connection.createStatement();
		
		/*if(st.executeUpdate(query) > 0)
			result = true;*/
		
		String query = "INSERT INTO product (name, price) VALUES (?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, product.getName());
		ps.setDouble(2, product.getPrice());
		
		boolean result = false;
		
		if(ps.executeUpdate() > 0)
			result = true;		
		
		ps.close();
		connection.close();		
		return result;
	}

	@Override
	public boolean editProduct(Product product) throws SQLException, ClassNotFoundException {

		Connection connection = getConnection();
		String query = "UPDATE product SET name=?, price=? WHERE product_code=?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, product.getName());
		ps.setDouble(2, product.getPrice());
		ps.setInt(3, product.getProduct_code());
		
		boolean result = false;		
		if(ps.executeUpdate() > 0)
			result = true;
		
		ps.close();
		connection.close();
		
		return result;
	}

	@Override
	public boolean deleteProduct(int productCode) throws SQLException, ClassNotFoundException {
		
		Connection connection = getConnection();
		String query = "DELETE FROM product WHERE product_code=?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, productCode);
		
		boolean result = false;
		if(ps.executeUpdate() > 0) {
			result = true;
		}
		
		ps.close();
		connection.close();
		
		return result;
	}

	@Override
	public Product fetchSingleProduct(int productCode) throws SQLException, ClassNotFoundException {

		Connection connection = getConnection();
		String query = "SELECT * FROM product WHERE product_code=?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, productCode);
		
		ResultSet rs = ps.executeQuery();
		
		Product product = new Product();
		
		while(rs.next()) {
			product.setProduct_code(rs.getInt("product_code"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getDouble("price"));
		}
		
		ps.close();
		connection.close();		
		return product;
	}

	@Override
	public List<Product> fetchAllProducts() throws SQLException, ClassNotFoundException {

		Connection connection = getConnection();
		
		String query = "SELECT * FROM product";
		Statement st = connection.createStatement();
		
		List<Product> productList = new ArrayList<Product>();
		
		ResultSet rs = st.executeQuery(query);
		while(rs.next()) {
			
			Product product = new Product();
			product.setProduct_code(rs.getInt("product_code"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getDouble("price"));
			
			productList.add(product);
		}
		
		st.close();
		connection.close();
		
		return productList;
	}

}
