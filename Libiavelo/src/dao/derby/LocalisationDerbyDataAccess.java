package dao.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConnectionSingleton;
import dao.LocalisationDataAccess;
import exception.InvalidNumberException;
import model.Bike;
import model.BikeStation;
import model.Garage;
import model.Localisation;

public class LocalisationDerbyDataAccess implements LocalisationDataAccess {
	public LocalisationDerbyDataAccess() {
	}
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addLocalisation() {
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public Localisation getLocalisation() {
		Localisation localisation = null;
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Localisation");
			ResultSet queryResult = preparedStatement.executeQuery();
			while(queryResult.next()) {
				Boolean available = queryResult.getBoolean("EstDisponible");
				Integer bikeID = queryResult.getInt("NumeroVelo");
				Integer premisesID = queryResult.getInt("CodePropriete");
				
				BikeDerbyDataAccess bikeDerbyDataAccess = new BikeDerbyDataAccess();
				Bike bike = bikeDerbyDataAccess.getBike(bikeID);
				
				ResultSetMetaData metaData = queryResult.getMetaData();
				if (metaData.getColumnCount() == 1) {
					Garage garage = new Garage(); // TODO : récup garage. demande de faire garage dans dao
					localisation = new Localisation(available, bike, garage);
				}
				else {
					Integer lowerBikeSoftLimit = queryResult.getInt("LimiteBasseNbrVelos");
					Integer lowerBikeHardLimit = queryResult.getInt("LimiteBasseExtremeNbrVelos");
					Integer upperBikeSoftLimit = queryResult.getInt("LimiteHauteNbrVelos");
					Integer upperBikeHardLimit = queryResult.getInt("LimiteHauteExtremeNbrVelos");
					BikeStation bikeStation = new BikeStation(lowerBikeSoftLimit, lowerBikeHardLimit, upperBikeSoftLimit, upperBikeHardLimit);
					bikeStation.setId(premisesID);
					localisation = new Localisation(available, bike, bikeStation);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNumberException e) {
			// not supposed to happen
			e.printStackTrace();
		}
		return localisation;
	}
	
	public ArrayList<Localisation> getAllLocalisation() {
		ArrayList<Localisation> localisations = new ArrayList<Localisation>();
		Localisation localisation = null;
		Connection connexion = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM Localisation");
			ResultSet queryResult = preparedStatement.executeQuery();
			while(queryResult.next()) {
				Boolean available = queryResult.getBoolean("EstDisponible");
				Integer bikeID = queryResult.getInt("NumeroVelo");
				Integer premisesID = queryResult.getInt("CodePropriete");
				
				BikeDerbyDataAccess bikeDerbyDataAccess = new BikeDerbyDataAccess();
				Bike bike = bikeDerbyDataAccess.getBike(bikeID);
				
				ResultSetMetaData metaData = queryResult.getMetaData();
				if (metaData.getColumnCount() == 1) {
					Garage garage = new Garage(); // TODO : récup garage dans bd. implique de faire garage dans dao
					localisation = new Localisation(available, bike, garage);
					localisations.add(localisation);
				}
				else {
					Integer lowerBikeSoftLimit = queryResult.getInt("LimiteBasseNbrVelos");
					Integer lowerBikeHardLimit = queryResult.getInt("LimiteBasseExtremeNbrVelos");
					Integer upperBikeSoftLimit = queryResult.getInt("LimiteHauteNbrVelos");
					Integer upperBikeHardLimit = queryResult.getInt("LimiteHauteExtremeNbrVelos");
					BikeStation bikeStation = new BikeStation(lowerBikeSoftLimit, lowerBikeHardLimit, upperBikeSoftLimit, upperBikeHardLimit);
					bikeStation.setId(premisesID);
					localisation = new Localisation(available, bike, bikeStation);
					localisations.add(localisation);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidNumberException e) {
			// not supposed to happen
			e.printStackTrace();
		}
		return localisations;
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateLocalisation(Localisation localisation) {
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeLocalisation() {
	}
}
