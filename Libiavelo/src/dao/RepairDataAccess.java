package dao;

import java.util.ArrayList;
import java.util.Date;

import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import exception.DataLengthException;
import exception.InvalidDateException;
import exception.InvalidNumberException;
import exception.NoDataException;
import model.Repair;

public interface RepairDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	public void addRepair(Repair repair) throws DataAccessConnectionException, DataAccessOperationException;
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	public Repair getRepair(int repairID, Date entryDate) throws DataAccessConnectionException, DataAccessOperationException, NoDataException, InvalidNumberException, InvalidDateException, DataLengthException;
	public ArrayList<Repair> getAllRepairs() throws DataAccessConnectionException, DataAccessOperationException, NoDataException, DataLengthException, InvalidDateException, InvalidNumberException;
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	public void updateRepair(Repair repair) throws DataAccessConnectionException, DataAccessOperationException;	
}
