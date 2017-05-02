package exception;

public class NoDataException extends Exception {
	private static final long serialVersionUID = 1L;
	String source;
	
	public NoDataException() {
	}
	
	public NoDataException(String source) {
		this.source = source;
	}
	
	@Override
	public String toString() {
		return "Le champ obligatoire " + source + " a été omis";
	}
}
