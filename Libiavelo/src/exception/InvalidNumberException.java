package exception;

public class InvalidNumberException extends Exception {

	private int number;
	
	public InvalidNumberException(int number) {
		this.number = number;
	}
	
	public int getSource() {
		return number;
	}
	
	@Override
	public String getMessage() {
		return number + " est un nombre invalide.";
	}
}
