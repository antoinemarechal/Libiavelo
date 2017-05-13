package exception;

public class NotANumberException extends Exception {
	private static final long serialVersionUID = 1L;
	private String source;
	private String error;
	
	public NotANumberException(String source, String error) {
		this.error = error;
		this.source = source;
	}
	
	public String getSource() {
		return source;
	}
	
	public String getError() {
		return error;
	}
	
	@Override
	public String getMessage() {
		return "Le champ " + source + " requiert un nombre, la valeur " + error + " est incorrect";
	}
}
