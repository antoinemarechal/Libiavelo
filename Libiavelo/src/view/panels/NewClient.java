package view.panels;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;

import exception.NoDataException;
import exception.NotANumberException;

public class NewClient extends Form {
	private static final long serialVersionUID = 1L;
	
	private JLabel surnameLabel, name1Label, name2Label, name3Label, name4Label, name5Label, nationalNumberLabel, homeNumberLabel, phoneNumberLabel, streetNameLabel, streetNumberLabel;
	private JTextField surnameTextField, name1TextField, name2TextField, name3TextField, name4TextField, name5TextField, nationalNumberTextField, homeNumberTextField, phoneNumberTextField, streetNameTextField, streetNumberTextField;
	
	public NewClient() {
		super();
		
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(" Nouveau client : "), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.setLayout(new GridLayout(11, 2, 15, 5));
				
		super.setFormType(PanelType.ADD_CLIENT);
		
		surnameLabel = new JLabel("Nom : ");
		surnameLabel.setLabelFor(surnameTextField);
		surnameLabel.setHorizontalAlignment(JLabel.RIGHT);
		surnameTextField = new JTextField("", 20);
		this.add(surnameLabel);
		this.add(surnameTextField);
				
		name1Label = new JLabel("Pr�nom :");
		name1Label.setLabelFor(name1TextField);
		name1Label.setHorizontalAlignment(JLabel.RIGHT);
		name1TextField = new JTextField("", 20);
		this.add(name1Label);
		this.add(name1TextField);
		
		name2Label = new JLabel("Deuxi�me pr�nom :");
		name2Label.setLabelFor(name2TextField);
		name2Label.setHorizontalAlignment(JLabel.RIGHT);
		name2TextField = new JTextField("", 20);
		this.add(name2Label);
		this.add(name2TextField);
			
		name3Label = new JLabel("Troisi�me pr�nom :");
		name3Label.setLabelFor(name3TextField);
		name3Label.setHorizontalAlignment(JLabel.RIGHT);
		name3TextField = new JTextField("", 20);
		this.add(name3Label);
		this.add(name3TextField);
		
		name4Label = new JLabel("Quatri�me pr�nom :");
		name4Label.setLabelFor(name4TextField);
		name4Label.setHorizontalAlignment(JLabel.RIGHT);
		name4TextField = new JTextField("", 20);
		this.add(name4Label);
		this.add(name4TextField);
		
		name5Label = new JLabel("Cinqui�me pr�nom :");
		name5Label.setLabelFor(name5TextField);
		name5Label.setHorizontalAlignment(JLabel.RIGHT);
		name5TextField = new JTextField("", 20);
		this.add(name5Label);
		this.add(name5TextField);
		
		nationalNumberLabel = new JLabel("Num�ro national :");
		nationalNumberLabel.setLabelFor(nationalNumberTextField);
		nationalNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
		nationalNumberTextField = new JTextField("", 10);
		this.add(nationalNumberLabel);
		this.add(nationalNumberTextField);
		
		homeNumberLabel = new JLabel("Num�ro de fixe :");
		homeNumberLabel.setLabelFor(homeNumberTextField);
		homeNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
		homeNumberTextField = new JTextField("", 10);
		this.add(homeNumberLabel);
		this.add(homeNumberTextField);
		
		phoneNumberLabel = new JLabel("Num�ro de portable :");
		phoneNumberLabel.setLabelFor(phoneNumberTextField);
		phoneNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
		phoneNumberTextField = new JTextField("", 10);
		this.add(phoneNumberLabel);
		this.add(phoneNumberTextField);
		
		streetNumberLabel = new JLabel("Num�ro de rue :");
		streetNumberLabel.setLabelFor(streetNumberTextField);
		streetNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
		streetNumberTextField = new JTextField("", 10);
		this.add(streetNumberLabel);
		this.add(streetNumberTextField);
		
		streetNameLabel = new JLabel("Nom de rue :");
		streetNameLabel.setLabelFor(streetNameTextField);
		streetNameLabel.setHorizontalAlignment(JLabel.RIGHT);
		streetNameTextField = new JTextField("", 10);
		this.add(streetNameLabel);
		this.add(streetNameTextField);
	}
	
	/**
	 * 
	 * @return une cha�ne de caract�re contenant le nom entr� par l'utilisateur
	 * @throws NoDataException si la cha�ne de caract�re est vide
	 */
	public String getSurname() throws NoDataException {
		String surname = surnameTextField.getText();
		if(surname.length() == 0)
			throw new NoDataException("Nom");
		else
			return surname;
	}
	/**
	 * 
	 * @return un tableau de String contenant les pr�nom entr�s par l'utilisateur
	 * @throws NoDataException si le premier pr�nom est une cha�ne de caract�re vide
	 */
	public String[] getFirstnames() throws NoDataException {
		String[] firstNames = new String[5];
		firstNames[0] = name1TextField.getText();
		firstNames[1] = name2TextField.getText();
		firstNames[2] = name3TextField.getText();
		firstNames[3] = name4TextField.getText();
		firstNames[4] = name5TextField.getText();
		
		if (firstNames[0].length() == 0)
			throw new NoDataException("Pr�nom");
		else
			return firstNames;
	}
	
	/**
	 * 
	 * @return un entier, le num�ro de registre national entr� par l'utilisateur
	 * @throws NotANumberException si l'utilisateur n'entre pas un nombre
	 * @throws NoDataException 
	 */
	public int getNationalNumber() throws NotANumberException, NoDataException {
		int nationalNumber;
		String textFieldContent = nationalNumberTextField.getText();
		try {
			if (textFieldContent.length() == 0)
				throw new NoDataException("Num�ro national");
			nationalNumber = Integer.parseInt(textFieldContent);
		} catch (NumberFormatException numberFormatException) {
			throw new NotANumberException("Num�ro national", textFieldContent);
		}
		return nationalNumber;
	}
	
	/**
	 * 
	 * @return une cha�ne de caract�re contenant le num�ro de t�l�phone entr� par l'utilisateur
	 * @throws NotANumberException si cette cha�ne de caract�re contient autre chose de des nombres
	 * @throws NoDataException 
	 */
	public String getHomeNumber() throws NotANumberException {
		String homeNumber = homeNumberTextField.getText();
		if (homeNumber.length() == 0) {
			return null;			
		}
		else {
			try {
				Integer.parseInt(homeNumber);
			} catch (NumberFormatException numberFormatException) {
					throw new NotANumberException("Num�ro de fixe", homeNumber);
			}
			return homeNumber;
		}		
	}
	
	/**
	 * 
	 * @return une cha�ne de caract�re contenant le num�ro de gsm entr� par l'utilisateur
	 * @throws NotANumberException si cette cha�ne de caract�re contient autre chose de des nombres
	 * @throws NoDataException 
	 */
	public String getPhoneNumber() throws NotANumberException {
		String phoneNumber = phoneNumberTextField.getText();
		if (phoneNumber.length() == 0) {
			return null;
		}
		else {
			try {
				Integer.parseInt(phoneNumber);
			} catch (NumberFormatException numberFormatException) {
					throw new NotANumberException("Num�ro de portable", phoneNumber);
			}
			return phoneNumber;
		}	
	}
	
	
	/**
	 * 
	 * @return une cha�ne de caract�re contenant le nom entr� par l'utilisateur
	 * @throws NoDataException si la cha�ne de caract�re est vide
	 */
	public String getStreetNumber() throws NoDataException {
		String streetNumber = streetNumberTextField.getText();
		if(streetNumber.length() == 0)
			throw new NoDataException("Num�ro de rue");
		else
			return streetNumber;
	}
	
	/**
	 * 
	 * @return une cha�ne de caract�re contenant le nom entr� par l'utilisateur
	 * @throws NoDataException si la cha�ne de caract�re est vide
	 */
	public String getStreetName() throws NoDataException {
		String streetName = streetNameTextField.getText();
		if(streetName.length() == 0)
			throw new NoDataException("Nom de rue");
		else
			return streetName;
	}
	
	
	@Override
	public void reset() 
	{
		surnameTextField.setText("");
		name1TextField.setText("");
		name2TextField.setText("");
		name3TextField.setText("");
		name4TextField.setText("");
		name5TextField.setText("");
		nationalNumberTextField.setText("");
		homeNumberTextField.setText("");
		phoneNumberTextField.setText("");
	}
}
