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
			preparedStatement.setString(1, bike.getState().name());
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
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Velo WHERE NumeroVelo = ? ");
			preparedStatement.setInt(1, bikeID);
			
			ResultSet queryResult = preparedStatement.executeQuery();
			queryResult.next();
			
			bike = new Bike();
			bike.setId(queryResult.getInt("NumeroVelo"));
			bike.setState(BikeState.getFromId(queryResult.getInt("Etat")));
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
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Velo");
			ResultSet queryResult = preparedStatement.executeQuery();
			while (queryResult.next()) {
				bike = new Bike();
				bike.setId(queryResult.getInt("NumeroVelo"));
				bike.setState(BikeState.getFromId(queryResult.getInt("Etat")));
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
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT v.NumeroVelo, v.Etat, t.CodeEmission, t.CodeDestination FROM Velo v INNER JOIN Transport t ON v.NumeroVelo = t.NumeroVelo and t.DATEDEMANDE = ? and t.ESTEXCEPTIONNEL = ? INNER JOIN Localisation l ON t.NumeroVelo = l.NUMEROVELO and l.ESTDISPONIBLE = ?");			
					
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
	
	public ArrayList<ArrayList<Object>> getSearch2Data(Date startDate, Date endDate, BikeState state) {
		ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
		
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT p.libelle, r.DescriptionProbleme, r.NumeroVelo, v.Etat FROM Reparation r INNER JOIN Velo v ON r.NumeroVelo = v.NumeroVelo and r.DATEENTREEGARAGE >= ? and r.DATEFINREPARATION <= ? and v.etat = ? INNER JOIN Garage g ON r.CodeGarage = g.CODE INNER JOIN Propriete p on g.CODE = p.code");			
			preparedStatement.setDate(1, startDate);
			preparedStatement.setDate(2, endDate);
			preparedStatement.setString(3, state.name());
			
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
	
	public ArrayList<ArrayList<Object>> getSearch3Data(Boolean isValid, Date dateThreshold, Float minimumAmount) {
		ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
		
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT c. NomDemandeur, c.Prenom1, l.NomVille, a.DateDemande, A.SoldeRestantAPayer, c.InscriptionValidee FROM Client c INNER JOIN Localite l ON c.CodeLocalite = l.Code and c.InscriptionValidee = ? INNER JOIN Abonnement a on c.NumeroClient = a.Client and a.DateDemaned >= ? and a.SoldeRestantAPayer >= ?");				
			
			preparedStatement.setBoolean(1, isValid);
			preparedStatement.setDate(2, dateThreshold);
			preparedStatement.setFloat(3, minimumAmount);
			
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
