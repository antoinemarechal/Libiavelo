package model;

import java.util.ArrayList;
import java.util.Date;

public class TransportationOrder {
	private Boolean exceptionnal;
	
	private Date execution;
	private ArrayList<Bike> bikes;
	
	private Estate source, destination;
	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public TransportationOrder(boolean exceptionnal, Date date, ArrayList<Bike> bikes, Estate source, Estate destination) {
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

	public ArrayList<Bike> getBikes() {
		return bikes;
	}

	public Estate getSource() {
		return source;
	}

	public Estate getDestination() {
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
	
	public void setSource(Estate source) {
		this.source = source;
	}

	public void setDestination(Estate destination) {
		this.destination = destination;
	}
}
