package dao.derby;

import java.util.ArrayList;
import java.util.Date;

import dao.SubscriptionDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import model.Subscription;

public class SubscriptionDerbyDataAccess implements SubscriptionDataAccess {
	
	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	@Override
	public void addSubscription(Subscription subsription) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	@Override
	public Subscription getSubscription(int clientId, Date demand) throws DataAccessConnectionException, DataAccessOperationException {
		return null;
	}
	
	@Override
	public ArrayList<Subscription> getAllSubscriptions() throws DataAccessConnectionException, DataAccessOperationException {
		return null;
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	@Override
	public void updateSubscription(Subscription subscription) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	@Override
	public void removeSubscription(Subscription subscription) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
}
