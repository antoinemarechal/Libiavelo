package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {

	private static Connection connection;
	
	public static  Connection getInstance() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/libiavelo", "root", "");
			}
			catch (SQLException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
		return connection;
	}
}
