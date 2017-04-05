package model;

import java.util.ArrayList;
import java.util.Date;

public class TransportationOrder {
	private boolean exceptionnal;
	
	private Date execution;
	private ArrayList<Bike> bikes;
	
	private Premises source, destination;
	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public TransportationOrder(boolean exceptionnal, Date date, ArrayList<Bike> bikes, Premises source, Premises destination) {
		this.setExceptionnal(exceptionnal);
		this.setExecution(date);
		this.setBikes(bikes);
		this.setDestination(destination);
		this.setSource(source);
	}
	
	/*************************************************************************************************
	 GETTERS
	 *************************************************************************************************/
	public boolean isExceptionnal() {
		return exceptionnal;
	}

	public Date getExecution() {
		return execution;
	}

	private ArrayList<Bike> getBikes() {
		return bikes;
	}

	public Premises getSource() {
		return source;
	}

	public Premises getDestination() {
		return destination;
	}
	
	/*************************************************************************************************
	 SETTERS
	 *************************************************************************************************/
	public void setExceptionnal(boolean exceptionnal) {
		this.exceptionnal = exceptionnal;
	}

	public void setExecution(Date execution) {
		this.execution = execution;
	}
	
	private void setBikes(ArrayList<Bike> bikes) {
		this.bikes = bikes;
	}
	
	public void setSource(Premises source) {
		this.source = source;
	}

	public void setDestination(Premises destination) {
		this.destination = destination;
	}
}
