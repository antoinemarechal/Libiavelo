package dao.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConnectionSingleton;
import dao.GarageDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Garage;
import model.Locality;

public class GarageDerbyDataAccess implements GarageDataAccess {

	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	@Override
	public void addGarage(Garage garage) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	@Override
	public Garage getGarage(int garageID) throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException {
		Connection connection = ConnectionSingleton.getInstance();
		
		Garage garage = null;
		
		LocalityDerbyDataAccess localityDerbyDataAccess = new LocalityDerbyDataAccess();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Propriete WHERE Code = ?");
			preparedStatement.setInt(1, garageID);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {			
				Locality locality = localityDerbyDataAccess.getLocality(resultSet.getInt("CodeLocalite"));
				String streetName = resultSet.getString("NomRue");
				String streetNumber = resultSet.getString("Numero");
				String description = resultSet.getString("Libelle");
			
				garage = new Garage(garageID, description, streetName, streetNumber, locality);
			}
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getGarage(int)", e.getMessage());
		}
		
		return garage;
	}
	
	@Override
	public ArrayList<Garage> getAllGarages() throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException	{
		Connection connection = ConnectionSingleton.getInstance();
		
		ArrayList<Garage> garages = new ArrayList<Garage>();

		LocalityDerbyDataAccess localityDerbyDataAccess = new LocalityDerbyDataAccess();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Garage INNER JOIN Propriete ON Garage.Code = Propriete.Code");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Locality locality = localityDerbyDataAccess.getLocality(resultSet.getInt("CodeLocalite"));
				String streetName = resultSet.getString("NomRue");
				String streetNumber = resultSet.getString("Numero");
				String description = resultSet.getString("Libelle");
				Integer code = resultSet.getInt("Code");
				
				garages.add(new Garage(code, description, streetName, streetNumber, locality));
			}
		} 
		catch (SQLException e) {
			throw new DataAccessOperationException(getClass().getName() + ".getAllGarages()", e.getMessage());
		}
		
		return garages;
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	@Override
	public void updateGarage(Garage garage) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	@Override
	public void removeGarage(Garage garage) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
}
