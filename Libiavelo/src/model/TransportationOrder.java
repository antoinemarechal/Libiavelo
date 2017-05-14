package model;

import java.util.Date;

public class TransportationOrder {
	private Boolean exceptionnal;
	
	private Date execution;
	
	private Bike bike;
	private Estate source, destination;
	
	/*************************************************************************************************
	 CONSTRUCTORS
	 *************************************************************************************************/
	public TransportationOrder(boolean exceptionnal, Date date, Bike bike, Estate source, Estate destination) {
		this.setExceptionnal(exceptionnal);
		this.setExecution(date);
		this.setBike(bike);
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

	public Bike getBike() {
		return bike;
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
	
	private void setBike(Bike bike) {
		this.bike = bike;
	}
	
	public void setSource(Estate source) {
		this.source = source;
	}

	public void setDestination(Estate destination) {
		this.destination = destination;
	}
}
