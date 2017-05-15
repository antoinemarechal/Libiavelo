package dao.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConnectionSingleton;
import dao.GarageDataAccess;
import model.Garage;
import model.Locality;

public class GarageDerbyDataAccess implements GarageDataAccess {
	public GarageDerbyDataAccess() {
	}
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addGarage(Garage garage) {
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public Garage getGarage(int garageID) {
		Garage garage = null;
		
		LocalityDerbyDataAccess localityDerbyDataAccess = new LocalityDerbyDataAccess();
		
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Propriete WHERE Code = ?");
			preparedStatement.setInt(1, garageID);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			Locality locality = localityDerbyDataAccess.getLocality(resultSet.getInt("CodeLocalite"));
			String streetName = resultSet.getString("NomRue");
			String streetNumber = resultSet.getString("Numero");
			String description = resultSet.getString("Libelle");
			
			garage = new Garage(garageID, description, streetName, streetNumber, locality);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return garage;
	}
	
	@Override
	public ArrayList<Garage> getAllGarages() 
	{
		ArrayList<Garage> garages = new ArrayList<Garage>();

		LocalityDerbyDataAccess localityDerbyDataAccess = new LocalityDerbyDataAccess();
		
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Garage INNER JOIN Propriete ON Garage.Code = Propriete.Code");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				Locality locality = localityDerbyDataAccess.getLocality(resultSet.getInt("CodeLocalite"));
				String streetName = resultSet.getString("NomRue");
				String streetNumber = resultSet.getString("Numero");
				String description = resultSet.getString("Libelle");
				Integer code = resultSet.getInt("Code");
				
				garages.add(new Garage(code, description, streetName, streetNumber, locality));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return garages;
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateGarage(Garage garage) {
	}
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeGarage(Garage garage) {
	}
}
