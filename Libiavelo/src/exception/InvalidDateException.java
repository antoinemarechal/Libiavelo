package exception;

import java.util.Date;

public class InvalidDateException extends Exception {
	private static final long serialVersionUID = 1L;
	private Date dateBefore, dateAfter;
	
	public InvalidDateException(Date dateBefore, Date dateAfter) {
		this.dateBefore = dateBefore;
		this.dateAfter = dateAfter;
	}
		
	public Date getDateBefore() {
		return dateBefore;
	}

	public Date getDateAfter() {
		return dateAfter;
	}

	@Override
	public String toString() {
		return dateBefore + " est avant " + dateAfter;
	}
}
