package exception;

public class EmptyStringException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String string;

	public EmptyStringException(String string) {
		this.string = string;
	}
	
	public String getSource() {
		return string;
	}
	
	@Override
	public String toString() {
		return string + " est une chaîne de caractère vide";
	}
}
