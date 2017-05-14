package dao.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConnectionSingleton;
import dao.LocalisationDataAccess;
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
	public Localisation getLocalisation(int bikeID) {
		Localisation localisation = null;
		
		BikeDerbyDataAccess bikeDerbyDataAccess = new BikeDerbyDataAccess();
		GarageDerbyDataAccess garageDerbyDataAccess = new GarageDerbyDataAccess();		
		BikeStationDerbyDataAccess bikeStationDerbyDataAccess = new BikeStationDerbyDataAccess();
		
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Localisation WHERE ? is NumeroVelo");
			preparedStatement.setInt(1, bikeID);
			ResultSet queryResult = preparedStatement.executeQuery();
			while(queryResult.next()) {
				Boolean available = queryResult.getBoolean("EstDisponible");
				Integer premisesID = queryResult.getInt("CodePropriete");	
				Bike bike = bikeDerbyDataAccess.getBike(bikeID);
				
				ResultSetMetaData metaData = queryResult.getMetaData();
				if (metaData.getColumnCount() == 1) {
					Garage garage = garageDerbyDataAccess.getGarage(premisesID);
					localisation = new Localisation(available, bike, garage);
				}
				else {
					BikeStation bikeStation = bikeStationDerbyDataAccess.getBikeStation(premisesID);
					localisation = new Localisation(available, bike, bikeStation);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return localisation;
	}
	
	public ArrayList<Localisation> getAllLocalisation() {
		Localisation localisation = null;
		ArrayList<Localisation> localisations = new ArrayList<Localisation>();
		
		BikeDerbyDataAccess bikeDerbyDataAccess = new BikeDerbyDataAccess();
		GarageDerbyDataAccess garageDerbyDataAccess = new GarageDerbyDataAccess();
		BikeStationDerbyDataAccess bikeStationDerbyDataAccess = new BikeStationDerbyDataAccess();
		
		Connection connexion = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM Localisation");
			ResultSet queryResult = preparedStatement.executeQuery();
			while(queryResult.next()) {
				Boolean available = queryResult.getBoolean("EstDisponible");
				Integer bikeID = queryResult.getInt("NumeroVelo");
				Integer premisesID = queryResult.getInt("CodePropriete");
				Bike bike = bikeDerbyDataAccess.getBike(bikeID);
				
				ResultSetMetaData metaData = queryResult.getMetaData();
				if (metaData.getColumnCount() == 1) {
					Garage garage = garageDerbyDataAccess.getGarage(premisesID);
					localisation = new Localisation(available, bike, garage);
				}
				else {
					BikeStation bikeStation = bikeStationDerbyDataAccess.getBikeStation(premisesID);
					localisation = new Localisation(available, bike, bikeStation);
				}
				localisations.add(localisation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
