package exception;

public class NoDataException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NoDataException() {
	}
	
	@Override
	public String toString() {
		return "Un champ obligatoire a été omis";
	}
}
