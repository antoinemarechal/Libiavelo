package exception;

public class NoDataException extends Exception {

	String source;
	
	public NoDataException() {
	}
	
	public NoDataException(String source) {
		this.source = source;
	}
	
	@Override
	public String getMessage() {
		return "Le champ obligatoire " + source + " a été omis.";
	}
}
