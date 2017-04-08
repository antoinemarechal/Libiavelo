package exception;

public class NotANumberException extends Exception {
	private static final long serialVersionUID = 1L;
	private String source;
	
	public NotANumberException(String source) {
		this.source = source;
	}
	
	public String getSource() {
		return source;
	}
	
	@Override
	public String toString() {
		return source + " n'est pas un nombre";
	}
}
