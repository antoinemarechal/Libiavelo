package dao;

import java.sql.Connection;

public class ConnectionSingleton {

	private static Connection connection;
	
	public static  Connection getInstance() {
		if (connection == null) {/*
			try {
	            Context ctx = new InitialContext();
	            DataSource source = (DataSource) ctx.lookup("jdbc/myDatasource");
	            Connection connexion = source.getConnection();	            
	        }
	        catch (Exception e) {
	            
	        }*/
		}
		return connection;
	}
}
