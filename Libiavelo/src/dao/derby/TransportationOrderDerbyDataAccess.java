package dao.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

import dao.ConnectionSingleton;
import dao.TransportationOrderDataAccess;
import model.Bike;
import model.Estate;
import model.TransportationOrder;

public class TransportationOrderDerbyDataAccess implements TransportationOrderDataAccess {
	public TransportationOrderDerbyDataAccess() { // FIXME : DO dis + mettre la requête du join dans la table "principale" de la requête
	}
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	
	public void addTransportationOrder(TransportationOrder transportationOrder) {
		Connection connection = (Connection)  (ConnectionSingleton.getInstance());
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Transport VALUES(?,?,?,?,?)");
			preparedStatement.setInt(1, transportationOrder.getDestination().getId());
			preparedStatement.setInt(2, transportationOrder.getBike().getId());
			preparedStatement.setInt(3, transportationOrder.getSource().getId());
			preparedStatement.setDate(4, new Date(transportationOrder.getExecution().getTime()));
			preparedStatement.setBoolean(5, transportationOrder.isExceptionnal());
			
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public TransportationOrder getTransportationOrder(int bikeID) {//FIXME prend int en paramètre mais reçoit Int => NullPointerE possible, et possible partout. aussi, prolly plusieurs getters à faire avec différent param. si oui, pêtre gen les méthodes et pas copier coller des codes quasi identiques
		TransportationOrder transportationOrder = null;
		
		BikeDerbyDataAccess bikeDerbyDataAccess = new BikeDerbyDataAccess();
		GarageDerbyDataAccess garageDerbyDataAccess = new GarageDerbyDataAccess();
		BikeStationDerbyDataAccess bikeStationDerbyDataAccess = new BikeStationDerbyDataAccess();
		
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Transport where NumeroVelo is ?");
			preparedStatement.setInt(1, bikeID);
			ResultSet queryResult = preparedStatement.executeQuery();
			queryResult.next();
			Boolean exceptionnal = queryResult.getBoolean("EstExceptionnel ");
			Date date =  new Date(queryResult.getDate("DateDemande").getTime());
			Bike bike = bikeDerbyDataAccess.getBike(queryResult.getInt("NumeroVelo"));
				
			Integer sourceID = queryResult.getInt("CodeEmission");	
			Estate source = garageDerbyDataAccess.getGarage(sourceID);
			if (source == null)
				source = bikeStationDerbyDataAccess.getBikeStation(sourceID);
				
			Integer destinationID = queryResult.getInt("CodeDestination");
			Estate destination = garageDerbyDataAccess.getGarage(destinationID);
			if (source == null)
				source = bikeStationDerbyDataAccess.getBikeStation(sourceID);
				
			transportationOrder = new TransportationOrder(exceptionnal, date, bike, source, destination);
		}
		catch (SQLException e) {
				
		}
		return transportationOrder;
	}
	
	public ArrayList<TransportationOrder> getAllTransportationOrders() {
		TransportationOrder transportationOrder = null;
		ArrayList<TransportationOrder> transportationOrders = new ArrayList<TransportationOrder>();
		
		BikeDerbyDataAccess bikeDerbyDataAccess = new BikeDerbyDataAccess();
		GarageDerbyDataAccess garageDerbyDataAccess = new GarageDerbyDataAccess();
		BikeStationDerbyDataAccess bikeStationDerbyDataAccess = new BikeStationDerbyDataAccess();
		
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Transport");
			ResultSet queryResult = preparedStatement.executeQuery();
			while(queryResult.next()) {
				Boolean exceptionnal = queryResult.getBoolean("EstExceptionnel ");
				Date date =  new Date(queryResult.getDate("DateDemande").getTime());
				Bike bike = bikeDerbyDataAccess.getBike(queryResult.getInt("NumeroVelo"));
				
				Integer sourceID = queryResult.getInt("CodeEmission");	
				Estate source = garageDerbyDataAccess.getGarage(sourceID);
				if (source == null)
					source = bikeStationDerbyDataAccess.getBikeStation(sourceID);
				
				Integer destinationID = queryResult.getInt("CodeDestination");
				Estate destination = garageDerbyDataAccess.getGarage(destinationID);
				if (source == null)
					source = bikeStationDerbyDataAccess.getBikeStation(sourceID);
				
				transportationOrder = new TransportationOrder(exceptionnal, date, bike, source, destination);
				transportationOrders.add(transportationOrder);
			}
		}
		catch (SQLException e) {
				
		}
		return transportationOrders;
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateClient(TransportationOrder transportationOrder) {
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeTransportationOrder() {
		
	}
}
