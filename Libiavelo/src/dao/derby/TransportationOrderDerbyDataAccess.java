package dao.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

import dao.ConnectionSingleton;
import dao.TransportationOrderDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Bike;
import model.Estate;
import model.TransportationOrder;

public class TransportationOrderDerbyDataAccess implements TransportationOrderDataAccess {

	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	@Override
	public void addTransportationOrder(TransportationOrder transportationOrder) throws DataAccessConnectionException, DataAccessOperationException {
		Connection connection = ConnectionSingleton.getInstance();
		
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
			throw new DataAccessOperationException(getClass().getName() + ".addTransportationOrder(TransportationOrder)", e.getMessage());
		}
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public TransportationOrder getTransportationOrder(int bikeID) throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException {
		Connection connection = ConnectionSingleton.getInstance();
		
		TransportationOrder transportationOrder = null;
		
		BikeDerbyDataAccess bikeDerbyDataAccess = new BikeDerbyDataAccess();
		GarageDerbyDataAccess garageDerbyDataAccess = new GarageDerbyDataAccess();
		BikeStationDerbyDataAccess bikeStationDerbyDataAccess = new BikeStationDerbyDataAccess();
		
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
			throw new DataAccessOperationException(getClass().getName() + ".getTransportationOrder(int)", e.getMessage());
		}
		
		return transportationOrder;
	}
	
	public ArrayList<TransportationOrder> getAllTransportationOrders() throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException {
		Connection connection = ConnectionSingleton.getInstance();
		
		ArrayList<TransportationOrder> transportationOrders = new ArrayList<TransportationOrder>();
		TransportationOrder transportationOrder = null;
		
		BikeDerbyDataAccess bikeDerbyDataAccess = new BikeDerbyDataAccess();
		GarageDerbyDataAccess garageDerbyDataAccess = new GarageDerbyDataAccess();
		BikeStationDerbyDataAccess bikeStationDerbyDataAccess = new BikeStationDerbyDataAccess();
		
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
			throw new DataAccessOperationException(getClass().getName() + ".getAllTransportationOrders()", e.getMessage());
		}
		
		return transportationOrders;
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateClient(TransportationOrder transportationOrder) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeTransportationOrder() throws DataAccessConnectionException, DataAccessOperationException {
		
	}
}
