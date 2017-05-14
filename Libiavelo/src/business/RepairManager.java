package business;

import java.util.ArrayList;
import java.util.Date;

import dao.RepairDataAccess;
import dao.derby.RepairDerbyDataAccess;
import model.Repair;

public class RepairManager {
	RepairDataAccess repairDerbyDataAccess;
	
	public RepairManager() {
		repairDerbyDataAccess = new RepairDerbyDataAccess();
	}
	
	/*************************************************************************************************
	 CREATE
	 *************************************************************************************************/
	public void addRepair(Repair repair) {
		repairDerbyDataAccess.addRepair(repair);
	}
	
	/*************************************************************************************************
	 READ
	 *************************************************************************************************/
	public Repair getRepair(int repairID, Date entryDate) {
		return repairDerbyDataAccess.getRepair(repairID, entryDate);
	}
	
	public ArrayList<Repair> getAllRepairs() {
		return repairDerbyDataAccess.getAllRepairs();
	}
	
	/*************************************************************************************************
	 UPDATE
	 *************************************************************************************************/
	public void updateRepair(Repair repair) {
		repairDerbyDataAccess.updateRepair(repair);
	}
}
