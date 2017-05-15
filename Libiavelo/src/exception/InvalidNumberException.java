package exception;

@SuppressWarnings("serial")
public class InvalidNumberException extends Exception {

	private String source;
	private Number number;
	
	public InvalidNumberException(String source, Number number) {
		this.source = source;
		this.number = number;
	}
	
	public String getSource()
	{
		return source;
	}
	
	public Number getInvalidNumber()
	{
		return number;
	}

	@Override
	public String getMessage() {
		return "Le nombre " + number + " est un invalide pour la donnée " + source + ".";
	}
}
