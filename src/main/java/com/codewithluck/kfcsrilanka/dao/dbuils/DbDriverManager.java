package com.codewithluck.kfcsrilanka.dao.dbuils;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbDriverManager {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException;
	

}
