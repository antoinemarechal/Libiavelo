package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.DataAccessConnectionException;

public class ConnectionSingleton {

	private static Connection connection;
	
	public static  Connection getInstance() throws DataAccessConnectionException {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/libiavelo", "root", "");
			}
			catch (SQLException e) { 
				throw new DataAccessConnectionException(e.getMessage());
			};
		}
		return connection;
	}
}
