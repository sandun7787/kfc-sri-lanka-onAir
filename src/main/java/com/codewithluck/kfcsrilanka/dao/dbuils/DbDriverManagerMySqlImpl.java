package com.codewithluck.kfcsrilanka.dao.dbuils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbDriverManagerMySqlImpl implements DbDriverManager {

	public Connection getConnection() throws ClassNotFoundException, SQLException {	

		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/?user=root";
		String userName = "root";
		String password = "Sandun1234567890";
		
		return DriverManager.getConnection(url, userName, password);
	}

}
