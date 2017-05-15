package exception;

@SuppressWarnings("serial")
public class NoDataException extends Exception {

	private String source;
		
	public NoDataException(String source) {
		this.source = source;
	}
	
	public String getSource() 
	{
		return source;
	}
	
	@Override
	public String getMessage() {
		return "Le champ obligatoire " + source + " a été omis.";
	}
}
