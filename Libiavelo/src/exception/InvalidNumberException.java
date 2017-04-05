package exception;

import java.io.IOException;

public class InvalidNumberException extends IOException {
	private static final long serialVersionUID = 1L;
	private int number;
	
	public InvalidNumberException(int number) {
		this.number = number;
	}
	
	public int getSource() {
		return number;
	}
	
	@Override
	public String toString() {
		return number + " est un nombre invalide";
	}
}
