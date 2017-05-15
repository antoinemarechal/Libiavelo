package exception;

import java.util.Date;

@SuppressWarnings("serial")
public class InvalidDateException extends Exception {
	
	private String sourceBefore, sourceAfter;
	private Date dateBefore, dateAfter;
	
	public InvalidDateException(String sourceBefore, Date dateBefore, String sourceAfter, Date dateAfter) {
		this.dateBefore = dateBefore;
		this.dateAfter = dateAfter;
	}
	
	public String getSourceBefore() {
		return sourceBefore;
	}
	
	public String getSourceAfter() {
		return sourceAfter;
	}
		
	public Date getDateBefore() {
		return dateBefore;
	}

	public Date getDateAfter() {
		return dateAfter;
	}

	@Override
	public String toString() {
		return "La donn�e " + dateBefore + " pr�c�de dans le temps de fa�on invalide la donn�e " + dateAfter + ".";
	}
}
