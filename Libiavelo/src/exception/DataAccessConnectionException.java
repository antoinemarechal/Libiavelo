package exception;

@SuppressWarnings("serial")
public class DataAccessConnectionException extends Exception
{
	private String errorMessage;
	
	public DataAccessConnectionException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	@Override
	public String getMessage() 
	{
		return "Une erreur s'est produite lors de l'�tablissement de l'acc�s aux donn�es."
				+ "\nContactez le gestionnaire de programme et transmettez-lui le message d'erreur suivant :"
				+ "\n\n\"" + errorMessage + "\"";
	}
}
