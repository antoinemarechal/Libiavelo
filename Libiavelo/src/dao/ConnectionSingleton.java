package dao;

public class ConnectionSingleton {

	private static ConnectionSingleton connection;
	
	public static  ConnectionSingleton getInstance() {
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
