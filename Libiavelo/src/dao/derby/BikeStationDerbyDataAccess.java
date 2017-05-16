package dao.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BikeStationDataAccess;
import dao.ConnectionSingleton;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.BikeStation;
import model.Locality;

public class BikeStationDerbyDataAccess implements BikeStationDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	@Override
	public void addBikeStation(BikeStation bikeStation) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	@Override
	public BikeStation getBikeStation(int bikeStationID) throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException {
		Connection connection = ConnectionSingleton.getInstance();
		
		BikeStation bikeStation = null;
		
		LocalityDerbyDataAccess localityDerbyDataAccess = new LocalityDerbyDataAccess();
		
		try {
			PreparedStatement selectStationStatement = connection.prepareStatement("SELECT * FROM Station WHERE Code = ?");
			selectStationStatement.setInt(1, bikeStationID);
			ResultSet selectStationResult = selectStationStatement.executeQuery();
			
			if(selectStationResult.next()) {
				Integer lowerBikeSoftLimit = selectStationResult.getInt("LimiteBasseNbrVelos");
				Integer lowerBikeHardLimit = selectStationResult.getInt("LimiteBasseExtremeNbrVelos");
				Integer upperBikeSoftLimit = selectStationResult.getInt("LimiteHauteNbrVelos");
				Integer upperBikeHardLimit = selectStationResult.getInt("LimiteHauteExtremeNbrVelos");
				
				PreparedStatement selectEstateStatement = connection.prepareStatement("SELECT * FROM Propriete WHERE Code = ?");
				selectEstateStatement.setInt(1, bikeStationID);
				ResultSet selectEstateResult = selectEstateStatement.executeQuery();					
				selectEstateResult.next();
				
				Locality locality = localityDerbyDataAccess.getLocality(selectEstateResult.getInt("CodeLocalite"));
				String streetName = selectEstateResult.getString("NomRue");
				String streetNumber = selectEstateResult.getString("Numero");
				String description = selectEstateResult.getString("Libelle");
				
				bikeStation = new BikeStation(bikeStationID, locality, streetName, streetNumber, description, lowerBikeSoftLimit, lowerBikeHardLimit, upperBikeSoftLimit, upperBikeHardLimit);
			}
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getBikeStation(int)", e.getMessage());
		} 
		
		return bikeStation;
	}
	
	@Override
	public ArrayList<BikeStation> getAllBikeStations() throws DataAccessConnectionException, DataAccessOperationException, InvalidNumberException, NoDataException {
		Connection connection = ConnectionSingleton.getInstance();
		
		ArrayList<BikeStation> bikeStations = new ArrayList<BikeStation>();
		BikeStation bikeStation = null;
		
		LocalityDerbyDataAccess localityDerbyDataAccess = new LocalityDerbyDataAccess();
		
		try {
			PreparedStatement selectStationStatement = connection.prepareStatement("SELECT * FROM Station");
			ResultSet selectStationResult = selectStationStatement.executeQuery();
			
			while(selectStationResult.next()) {
				Integer lowerBikeSoftLimit = selectStationResult.getInt("LimiteBasseNbrVelos");
				Integer lowerBikeHardLimit = selectStationResult.getInt("LimiteBasseExtremeNbrVelos");
				Integer upperBikeSoftLimit = selectStationResult.getInt("LimiteHauteNbrVelos");
				Integer upperBikeHardLimit = selectStationResult.getInt("LimiteHauteExtremeNbrVelos");
				Integer bikeStationID = selectStationResult.getInt("Code");
				
				PreparedStatement selectEstateStatement = connection.prepareStatement("SELECT * FROM Propriete WHERE Code = ?");
				selectEstateStatement.setInt(1, bikeStationID);
				ResultSet selectEstateResult = selectEstateStatement.executeQuery();		
				Locality locality = localityDerbyDataAccess.getLocality(selectEstateResult.getInt("CodeLocalite"));	
				selectEstateResult.next();
				
				selectEstateResult = selectEstateStatement.executeQuery();	
				String streetName = selectEstateResult.getString("NomRue");
				String streetNumber = selectEstateResult.getString("Numero");
				String description = selectEstateResult.getString("Libelle");
				
				bikeStation = new BikeStation(bikeStationID, locality, streetName, streetNumber, description, lowerBikeSoftLimit, lowerBikeHardLimit, upperBikeSoftLimit, upperBikeHardLimit);
				bikeStations.add(bikeStation);
			}
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getAllBikeStations()", e.getMessage());
		} 
		
		return bikeStations;
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	@Override
	public void updateBikeStation(BikeStation bikeStation) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	@Override
	public void removeBikeStation() throws DataAccessConnectionException, DataAccessOperationException {
		
	}
}
