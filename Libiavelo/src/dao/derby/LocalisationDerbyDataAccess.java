package dao.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConnectionSingleton;
import dao.LocalisationDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Bike;
import model.Estate;
import model.Localisation;

public class LocalisationDerbyDataAccess implements LocalisationDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	@Override
	public void addLocalisation(Localisation localisation) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	@Override
	public Localisation getLocalisation(int bikeID) throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException {
		Connection connection = ConnectionSingleton.getInstance();
		
		Localisation localisation = null;
		
		BikeDerbyDataAccess bikeDerbyDataAccess = new BikeDerbyDataAccess();
		GarageDerbyDataAccess garageDerbyDataAccess = new GarageDerbyDataAccess();		
		BikeStationDerbyDataAccess bikeStationDerbyDataAccess = new BikeStationDerbyDataAccess();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Localisation WHERE ? = NumeroVelo");
			preparedStatement.setInt(1, bikeID);
			
			ResultSet queryResult = preparedStatement.executeQuery();
			
			while(queryResult.next()) {
				Boolean available = queryResult.getBoolean("EstDisponible");
				Integer premisesID = queryResult.getInt("CodePropriete");	
				Bike bike = bikeDerbyDataAccess.getBike(bikeID);
				
				Estate estate = bikeStationDerbyDataAccess.getBikeStation(premisesID);
				
				if(estate == null)
					estate = garageDerbyDataAccess.getGarage(premisesID);
				
				localisation = new Localisation(available, bike, estate);
			}
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getLocalisation(int)", e.getMessage());
		}
		
		return localisation;
	}
	
	@Override
	public ArrayList<Localisation> getAllLocalisations() throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException {
		Connection connexion = ConnectionSingleton.getInstance();
		
		ArrayList<Localisation> localisations = new ArrayList<Localisation>();
		Localisation localisation = null;
		
		BikeDerbyDataAccess bikeDerbyDataAccess = new BikeDerbyDataAccess();
		GarageDerbyDataAccess garageDerbyDataAccess = new GarageDerbyDataAccess();
		BikeStationDerbyDataAccess bikeStationDerbyDataAccess = new BikeStationDerbyDataAccess();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM Localisation");
			ResultSet queryResult = preparedStatement.executeQuery();
			
			while(queryResult.next()) {
				Boolean available = queryResult.getBoolean("EstDisponible");
				Integer bikeID = queryResult.getInt("NumeroVelo");
				Integer premisesID = queryResult.getInt("CodePropriete");
				Bike bike = bikeDerbyDataAccess.getBike(bikeID);
				
				Estate estate = bikeStationDerbyDataAccess.getBikeStation(premisesID);
				
				if(estate == null)
					estate = garageDerbyDataAccess.getGarage(premisesID);
				
				localisation = new Localisation(available, bike, estate);
				
				localisations.add(localisation);
			}
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getAllLocalisations()", e.getMessage());
		}
		
		return localisations;
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	@Override
	public void updateLocalisation(Localisation localisation) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	@Override
	public void removeLocalisation(Localisation localisation) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
}
