package exception;

@SuppressWarnings("serial")
public class DataAccessOperationException extends Exception {

	private String currentFunctionName;
	private String errorMessage;
	
	public DataAccessOperationException(String currentFunctionName, String errorMessage) {
		this.currentFunctionName = currentFunctionName;
		this.errorMessage = errorMessage;
	}

	public String getCurrentFunctionName() {
		return currentFunctionName;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	@Override
	public String getMessage() 
	{
		return "Une erreur s'est produite lors de l'�tablissement de l'acc�s aux donn�es."
				+ "\nContactez le gestionnaire de programme et transmettez-lui le message d'erreur suivant :"
				+ "\n\nOp�ration : " + currentFunctionName
				+ "\n\"" + errorMessage + "\"";
	}
}
