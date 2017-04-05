package exception;

import java.io.IOException;
import java.util.Date;

public class InvalidDateException extends IOException {
	private static final long serialVersionUID = 1L;
	private Date dateBefore, dateAfter;
	
	public InvalidDateException(Date dateBefore, Date dateAfter) {
		this.dateBefore = dateBefore;
		this.dateAfter = dateAfter;
	}
	
	@Override
	public String toString() {
		return dateBefore + " est avant " + dateAfter;
	}
}
