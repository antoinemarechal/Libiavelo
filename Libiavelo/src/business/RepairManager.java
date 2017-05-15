package business;

import java.util.ArrayList;
import java.util.Date;

import dao.RepairDataAccess;
import dao.derby.RepairDerbyDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.DataLengthException;
import exception.InvalidDateException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Repair;

public class RepairManager {
	
	private RepairDataAccess repairDerbyDataAccess;
	
	public RepairManager() {
		repairDerbyDataAccess = new RepairDerbyDataAccess();
	}
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addRepair(Repair repair) throws DataAccessConnectionException, DataAccessOperationException {
		repairDerbyDataAccess.addRepair(repair);
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Repair getRepair(int repairID, Date entryDate) throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException, InvalidDateException, DataLengthException {
		return repairDerbyDataAccess.getRepair(repairID, entryDate);
	}
	
	public ArrayList<Repair> getAllRepairs() throws DataAccessConnectionException, DataAccessOperationException, NoDataException, DataLengthException, InvalidDateException, InvalidNumberException {
		return repairDerbyDataAccess.getAllRepairs();
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateRepair(Repair repair) throws DataAccessConnectionException, DataAccessOperationException {
		repairDerbyDataAccess.updateRepair(repair);
	}
}
