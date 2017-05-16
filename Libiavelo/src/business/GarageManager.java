package business;

import java.util.ArrayList;

import dao.GarageDataAccess;
import dao.derby.GarageDerbyDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Garage;

public class GarageManager {
	
	private GarageDataAccess garageDataAccess;
	
	public GarageManager() {
		garageDataAccess = new GarageDerbyDataAccess();
	}
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addGarage(Garage Garage) throws DataAccessConnectionException, DataAccessOperationException {
		garageDataAccess.addGarage(Garage);
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Garage getGarage(int garageID) throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException {
		return garageDataAccess.getGarage(garageID);
	}
	
	public ArrayList<Garage> getAllGarages() throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException {
		return garageDataAccess.getAllGarages();
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateGarage(Garage garage) throws DataAccessConnectionException, DataAccessOperationException {
		garageDataAccess.updateGarage(garage);
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	public void removeGarage(Garage garage) throws DataAccessConnectionException, DataAccessOperationException {
		garageDataAccess.removeGarage(garage);
	}
}
