package dao.derby;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BikeDataAccess;
import dao.ConnectionSingleton;
import model.Bike;
import model.enumerations.BikeState;

public class BikeDerbyDataAccess implements BikeDataAccess {
	public BikeDerbyDataAccess() {
	}

	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addBike(Bike bike) {
		Connection connection = (Connection)  (ConnectionSingleton.getInstance());
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Velo(Etat) VALUES(?)");
			preparedStatement.setString(1, bike.getState().toString());
			preparedStatement.executeUpdate();
			
			ResultSet queryResults = preparedStatement.getGeneratedKeys();
			queryResults.next();
			bike.setId(queryResults.getInt("1"));	
		}
		catch (SQLException e) {
		}
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public Bike getBike(int bikeID) {
		Bike bike = null;
		
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Velo where NumeroVelo is ? ");
			ResultSet queryResult = preparedStatement.executeQuery();
			queryResult.next();
			
			bike = new Bike();
			bike.setId(queryResult.getInt("NumeroVelo"));
			bike.setState(BikeState.valueOf(queryResult.getString("Etat")));
		} catch (SQLException | IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return bike;
	}
	
	public ArrayList<Bike> getAllBikes() {
		Bike bike = null;
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Velo where NumeroVelo is ? ");
			ResultSet queryResult = preparedStatement.executeQuery();
			while (queryResult.next()) {
				bike = new Bike();
				bike.setId(queryResult.getInt("NumeroVelo"));
				bike.setState(BikeState.valueOf(queryResult.getString("Etat")));
				bikes.add(bike);
			}
		} catch (SQLException | IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return bikes;
	}
	
	public ArrayList<ArrayList<Object>> getSearch1Data(Date date, Boolean isExceptionnal, Boolean isAvailable) {
		ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
		
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT Velo.NumeroVelo, Velo.Etat, Transport.CodeEmission, Transport.CodeDestination FROM Velo INNER JOIN Transport ON Velo.NumeroVelo = Tansport.NumeroVelo WHERE Transport.DateDemande = ? AND Transport.EstExceptionnel = ? INNER JOIN Localisation ON Localisation.NumeroVelo where EstDisponible = ? ORDER BY Velo.NumeroVelo");			
			preparedStatement.setDate(1, date);
			preparedStatement.setBoolean(2, isExceptionnal);
			preparedStatement.setBoolean(3, isAvailable);
			
			ResultSet queryResult = preparedStatement.executeQuery();
			ResultSetMetaData metaData = queryResult.getMetaData();
			
			int columnCount = metaData.getColumnCount();	
		    while (queryResult.next()) {
		        ArrayList<Object> row = new ArrayList<Object>();
		        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++)
		        	row.add(queryResult.getObject(columnIndex));
		        data.add(row);
		    }	
		} catch (SQLException | IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return data;
	}
	 
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateBike(Bike bike) {
		Connection connection = (Connection)  (ConnectionSingleton.getInstance());
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Velo SET Etat = ? WHERE NumeroVelo = ?");
			preparedStatement.setString(1, bike.getState().toString());
			preparedStatement.setInt(2, bike.getId());
			
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeBike(Bike bike) {
		
	}
}
