package com.codewithluck.kfcsrilanka.dao.dbuils;

public class DbDriverManagerFactory {

	public DbDriverManager getDbDriver(String databaseType) {
		
		if(databaseType.equals("MySQL")) {
			return new DbDriverManagerMySqlImpl();
		}
		else {
			return null;
		}
	}

}
