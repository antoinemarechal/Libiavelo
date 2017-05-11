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
		Connection connexion = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM Station WHERE Code IS ?");
			preparedStatement.setInt(1, bikeStationID);
			ResultSet queryResult = preparedStatement.executeQuery();

			while(queryResult.next()) {
				Integer lowerBikeSoftLimit = queryResult.getInt("LimiteBasseNbrVelos");
				Integer lowerBikeHardLimit = queryResult.getInt("LimiteBasseExtremeNbrVelos");
				Integer upperBikeSoftLimit = queryResult.getInt("LimiteHauteNbrVelos");
				Integer upperBikeHardLimit = queryResult.getInt("LimiteHauteExtremeNbrVelos");
				
				bikeStation = new BikeStation(lowerBikeSoftLimit, lowerBikeHardLimit, upperBikeSoftLimit, upperBikeHardLimit);
				bikeStation.setId(bikeStationID);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNumberException e) {
			// not supposed to happen
			e.printStackTrace();
		}
		return bikeStation;
	}
	
	public ArrayList<BikeStation> getAllBikeStations() {
		ArrayList<BikeStation> bikeStations = new ArrayList<BikeStation>();
		BikeStation bikeStation = null;
		Connection connexion = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM Station");
			ResultSet queryResult = preparedStatement.executeQuery();

			while(queryResult.next()) {
				Integer lowerBikeSoftLimit = queryResult.getInt("LimiteBasseNbrVelos");
				Integer lowerBikeHardLimit = queryResult.getInt("LimiteBasseExtremeNbrVelos");
				Integer upperBikeSoftLimit = queryResult.getInt("LimiteHauteNbrVelos");
				Integer upperBikeHardLimit = queryResult.getInt("LimiteHauteExtremeNbrVelos");
				Integer bikeStationID = queryResult.getInt("Code");
				
				bikeStation = new BikeStation(lowerBikeSoftLimit, lowerBikeHardLimit, upperBikeSoftLimit, upperBikeHardLimit);
				bikeStation.setId(bikeStationID);
				bikeStations.add(bikeStation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNumberException e) {
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
