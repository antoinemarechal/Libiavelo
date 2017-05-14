package dao.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BikeStationDataAccess;
import dao.ConnectionSingleton;
import exception.InvalidNumberException;
import model.BikeStation;
import model.Locality;

public class BikeStationDerbyDataAccess implements BikeStationDataAccess {
	public BikeStationDerbyDataAccess() {
	}
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addBikeStation(BikeStation bikeStation) {
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public BikeStation getBikeStation(int bikeStationID) {
		BikeStation bikeStation = null;
		
		LocalityDerbyDataAccess localityDerbyDataAccess = new LocalityDerbyDataAccess();
		
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement selectStationStatement = connection.prepareStatement("SELECT * FROM Station WHERE Code = ?");
			selectStationStatement.setInt(1, bikeStationID);
			ResultSet selectStationResult = selectStationStatement.executeQuery();
			selectStationResult.next();
			
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNumberException e) {
			// not supposed to happen
			e.printStackTrace();
		}
		catch (NullPointerException e) {
			// not supposed to happen
			e.printStackTrace();
		}
		return bikeStation;
	}
	
	public ArrayList<BikeStation> getAllBikeStations() {
		BikeStation bikeStation = null;
		ArrayList<BikeStation> bikeStations = new ArrayList<BikeStation>();
		
		LocalityDerbyDataAccess localityDerbyDataAccess = new LocalityDerbyDataAccess();
		
		Connection connection = ConnectionSingleton.getInstance();
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNumberException e) {
			// not supposed to happen
			e.printStackTrace();
		} catch (NullPointerException e) {
			// not supposed to happen
			e.printStackTrace();
		}
		return bikeStations;
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateBikeStation(BikeStation bikeStation) {
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeBikeStation() {
	}
}
