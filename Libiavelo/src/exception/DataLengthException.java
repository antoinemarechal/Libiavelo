package exception;

@SuppressWarnings("serial")
public class DataLengthException extends Exception {
	
	private String source;
	private int maxAuthorized;
	
	public DataLengthException(String source, int maxAuthorized) 
	{
		this.source = source;
		this.maxAuthorized = maxAuthorized;
	}
	
	public String getSource() {
		return source;
	}
	
	public int getMaxAuthorized() {
		return maxAuthorized;
	}

	@Override
	public String getMessage() {
		return "La limite de caractères de " + maxAuthorized + " pour la donnée " + source + ".";
	}
}
