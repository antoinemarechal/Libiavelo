package dao.derby;

import java.util.ArrayList;

import model.Subscription;
import model.SubscriptionType;
import dao.SubscriptionTypeDataAccess;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;

public class SubscriptionTypeDerbyDataAccess implements SubscriptionTypeDataAccess {

	// ===============================================================================================
	// CREATE
	// ===============================================================================================
	@Override
	public void addSubscription(SubscriptionType subscriptionType) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
	
	// ===============================================================================================
	// READ
	// ===============================================================================================
	@Override
	public SubscriptionType getSubscriptionType(SubscriptionType subscriptionType) throws DataAccessConnectionException, DataAccessOperationException {
		return null;
	}

	@Override
	public ArrayList<Subscription> getAllSubscriptionTypes() throws DataAccessConnectionException, DataAccessOperationException {
		return null;
	}
	
	// ===============================================================================================
	// UPDATE
	// ===============================================================================================
	@Override
	public void updateSubscriptionType(SubscriptionType subscriptionType) throws DataAccessConnectionException, DataAccessOperationException {
		
	}
	
	// ===============================================================================================
	// DELETE
	// ===============================================================================================
	@Override
	public void removeSubscriptionType(SubscriptionType subscriptionType) throws DataAccessConnectionException, DataAccessOperationException {
		
	}

}
