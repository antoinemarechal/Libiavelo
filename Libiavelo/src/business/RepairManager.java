package business;

import java.util.ArrayList;

import dao.derby.RepairDerbyDataAccess;
import model.Repair;

public class RepairManager {
	RepairDerbyDataAccess repairDerbyDataAccess;
	
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
	public Repair getRepair(int repairID) {
		return repairDerbyDataAccess.getRepair(repairID);
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
	
	/*************************************************************************************************
	 DELETE
	 *************************************************************************************************/
	public void removeRepair(Repair repair) {
		repairDerbyDataAccess.removeRepair(repair);
	}
}
