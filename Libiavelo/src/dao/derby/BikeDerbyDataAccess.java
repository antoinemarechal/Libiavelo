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
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import model.Bike;
import model.enumerations.BikeState;

public class BikeDerbyDataAccess implements BikeDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	@Override
	public void addBike(Bike bike) throws DataAccessConnectionException, DataAccessOperationException {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Velo(CodeEtat) VALUES(?)");
			preparedStatement.setInt(1, bike.getState().getStateID());
			preparedStatement.executeUpdate();
			
			ResultSet queryResults = preparedStatement.getGeneratedKeys();
			queryResults.next();
			bike.setId(queryResults.getInt("1"));	
		}
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".addBike(Bike)", e.getMessage());
		}
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	@Override
	public Bike getBike(int bikeID) throws DataAccessConnectionException, DataAccessOperationException {
		Connection connection = ConnectionSingleton.getInstance();
		
		Bike bike = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Velo WHERE NumeroVelo = ?");
			preparedStatement.setInt(1, bikeID);
			
			ResultSet queryResult = preparedStatement.executeQuery();
			
			if(queryResult.next()) {			
				bike = new Bike();
				bike.setId(bikeID);
				bike.setState(BikeState.getFromId(queryResult.getInt("CodeEtat")));
			}
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getBike(int)", e.getMessage());
		} 
		return bike;
	}
	
	@Override
	public ArrayList<Bike> getAllBikes() throws DataAccessConnectionException, DataAccessOperationException {
		Connection connection = ConnectionSingleton.getInstance();
		
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		Bike bike = null;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Velo");
			ResultSet queryResult = preparedStatement.executeQuery();
			
			while (queryResult.next()) {
				bike = new Bike();
				bike.setId(queryResult.getInt("NumeroVelo"));
				bike.setState(BikeState.getFromId(queryResult.getInt("CodeEtat")));
				
				bikes.add(bike);
			}
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getAllBikes()", e.getMessage());
		} 
		return bikes;
	}
	
	@Override
	public ArrayList<ArrayList<Object>> getSearch1Data(java.util.Date date, Boolean isExceptionnal, Boolean isAvailable) throws DataAccessConnectionException, DataAccessOperationException {
		Connection connection = ConnectionSingleton.getInstance();
		
		ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT v.NumeroVelo, e.Libelle, t.CodeEmission, t.CodeDestination FROM Velo v INNER JOIN Transport t ON v.NumeroVelo = t.NumeroVelo and t.DATEDEMANDE = ? and t.ESTEXCEPTIONNEL = ? INNER JOIN EtatVelo e ON e.Code = v.CodeEtat INNER JOIN Localisation l ON t.NumeroVelo = l.NUMEROVELO and l.ESTDISPONIBLE = ?");			
					
			preparedStatement.setDate(1, new Date(date.getTime()));
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
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getSearch1Data(Date, Boolean, Boolean)", e.getMessage());
		} 
		return data;
	}
	
	@Override
	public ArrayList<ArrayList<Object>> getSearch2Data(java.util.Date startDate, java.util.Date endDate, BikeState state) throws DataAccessConnectionException, DataAccessOperationException {
		Connection connection = ConnectionSingleton.getInstance();
		
		ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT p.libelle, r.DescriptionProbleme, r.NumeroVelo, e.Libelle FROM Reparation r INNER JOIN Velo v ON r.NumeroVelo = v.NumeroVelo AND r.DATEENTREEGARAGE >= ? AND r.DATEFINREPARATION <= ?   INNER JOIN EtatVelo e ON v.CodeEtat = e.Code AND v.CodeEtat = ? INNER JOIN Garage g ON r.CodeGarage = g.CODE INNER JOIN Propriete p ON g.CODE = p.CODE");			

			preparedStatement.setDate(1, new Date(startDate.getTime()));
			preparedStatement.setDate(2, new Date(endDate.getTime()));
			preparedStatement.setInt(3, state.getStateID());
			
			ResultSet queryResult = preparedStatement.executeQuery();
			ResultSetMetaData metaData = queryResult.getMetaData();
			
			int columnCount = metaData.getColumnCount();
			
		    while (queryResult.next()) {
		        ArrayList<Object> row = new ArrayList<Object>();
		        
		        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++)
		        	row.add(queryResult.getObject(columnIndex));
		        
		        data.add(row);
		    }	
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getSearch2Data(Date, Date, BikeState)", e.getMessage());
		} 
		return data;
	}
	
	@Override
	public ArrayList<ArrayList<Object>> getSearch3Data(Boolean isValid, java.util.Date dateThreshold, Float minimumAmount) throws DataAccessConnectionException, DataAccessOperationException {
		Connection connection = ConnectionSingleton.getInstance();
		
		ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
		
		try {

			PreparedStatement preparedStatement = connection.prepareStatement("SELECT c.NomDemandeur, c.Prenom1, l.Libelle, a.DateDemande, a.SoldeRestantAPayer, c.InscriptionValidee FROM Client c INNER JOIN Localite l ON c.CodeLocalite = l.Code and c.InscriptionValidee = ? INNER JOIN Abonnement a on c.NumeroClient = a.NumeroClient and a.DateDemande >= ? and a.SoldeRestantAPayer >= ?");				

			preparedStatement.setBoolean(1, isValid);
			preparedStatement.setDate(2, new Date(dateThreshold.getTime()));
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
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getSearch3Data(Boolean, Date, Float)", e.getMessage());
		} 
		return data;
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	@Override
	public void updateBike(Bike bike) throws DataAccessConnectionException, DataAccessOperationException {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Velo SET CodeEtat = ? WHERE NumeroVelo = ?");
			preparedStatement.setInt(1, bike.getState().getStateID());
			preparedStatement.setInt(2, bike.getId());
			
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".updateBike(Bike)", e.getMessage());
		}
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	@Override
	public void removeBike(Bike bike) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
}
