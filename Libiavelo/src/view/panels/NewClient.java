package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import exception.NoDataException;
import exception.NotANumberException;
import view.buttons.ConfirmationButton;
import view.observers.ConfirmationButtonListener;

public class NewClient extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JLabel surnameLabel, name1Label, name2Label, name3Label, name4Label, name5Label, nationalNumberLabel, homeNumberLabel, phoneNumberLabel;
	private TextField surnameTextField, name1TextField, name2TextField, name3TextField, name4TextField, name5TextField, nationalNumberTextField, homeNumberTextField, phoneNumberTextField;
	
	public NewClient() {
		super();
		this.setVisible(true);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setSize(new Dimension(500, 500));
		
		surnameLabel = new JLabel("Nom : ");
		surnameLabel.setLabelFor(surnameTextField);
		surnameTextField = new TextField("", 20);
		this.add(surnameLabel);
		this.add(surnameTextField);
		
		name1Label = new JLabel("Premier pr�nom : ");
		name1Label.setLabelFor(name1TextField);
		name1TextField = new TextField("", 20);
		this.add(name1Label);
		this.add(name1TextField);

		
		name2Label = new JLabel("Deuxi�me pr�nom : ");
		name2Label.setLabelFor(name2TextField);
		name2TextField = new TextField("", 20);
		this.add(name2Label);
		this.add(name2TextField);
		
		
		name3Label = new JLabel("Troisi�me pr�nom : ");
		name3Label.setLabelFor(name3TextField);
		name3TextField = new TextField("", 20);
		this.add(name3Label);
		this.add(name3TextField);
		
		name4Label = new JLabel("Quatri�me pr�nom : ");
		name4Label.setLabelFor(name4TextField);
		name4TextField = new TextField("", 20);
		this.add(name4Label);
		this.add(name4TextField);
		
		name5Label = new JLabel("Cinqui�me pr�nom : ");
		name5Label.setLabelFor(name5TextField);
		name5TextField = new TextField("", 20);
		this.add(name5Label);
		this.add(name5TextField);
		
		nationalNumberLabel = new JLabel("Num�ro national : ");
		nationalNumberLabel.setLabelFor(nationalNumberTextField);
		nationalNumberTextField = new TextField("", 20);
		this.add(nationalNumberLabel);
		this.add(nationalNumberTextField);
		
		homeNumberLabel = new JLabel("Num�ro de fixe");
		homeNumberLabel.setLabelFor(homeNumberTextField);
		homeNumberTextField = new TextField("", 20);
		this.add(homeNumberLabel);
		this.add(homeNumberTextField);
		
		phoneNumberLabel = new JLabel("Num�ro de portable");
		phoneNumberLabel.setLabelFor(phoneNumberTextField);
		phoneNumberTextField = new TextField("", 20);
		this.add(phoneNumberLabel);
		this.add(phoneNumberTextField);
		
		ConfirmationButton cbutton = new ConfirmationButton(this, PanelType.ADDCLIENT);
		cbutton.addActionListener(new ConfirmationButtonListener(cbutton));
		this.add(cbutton);
	}
	
	/**
	 * 
	 * @return une cha�ne de caract�re contenant le nom entr� par l'utilisateur
	 * @throws NoDataException si la cha�ne de caract�re est vide
	 */
	public String getSurname() throws NoDataException {
		String surname = surnameTextField.getText();
		if(surname.length() == 0)
			throw new NoDataException();
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
			throw new NoDataException();
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
				throw new NoDataException();
			nationalNumber = Integer.parseInt(textFieldContent);
		} catch (NumberFormatException numberFormatException) {
			throw new NotANumberException(textFieldContent);
		}
		return nationalNumber;
	}
	
	/**
	 * 
	 * @return une cha�ne de caract�re contenant le num�ro de t�l�phone entr� par l'utilisateur
	 * @throws NotANumberException si cette cha�ne de caract�re contient autre chose de des nombres
	 * @throws NoDataException 
	 */
	public String getHomeNumber() throws NotANumberException, NoDataException {
		String homeNumber = homeNumberTextField.getText();
		try {
			if (homeNumber.length() == 0)
				throw new NoDataException();
			Integer.parseInt(homeNumber);
		} catch (NumberFormatException numberFormatException) {
			throw new NotANumberException(homeNumber);
		}
		return homeNumber;
	}
	
	/**
	 * 
	 * @return une cha�ne de caract�re contenant le num�ro de gsm entr� par l'utilisateur
	 * @throws NotANumberException si cette cha�ne de caract�re contient autre chose de des nombres
	 * @throws NoDataException 
	 */
	public String getPhoneNumber() throws NotANumberException, NoDataException {
		String phoneNumber = phoneNumberTextField.getText();
		try {
			if (phoneNumber.length() == 0)
				throw new NoDataException();
			Integer.parseInt(phoneNumber);
		} catch (NumberFormatException numberFormatException) {
			throw new NotANumberException(phoneNumber);
		}
		return phoneNumber;
	}
}
