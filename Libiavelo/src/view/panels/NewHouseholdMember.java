package view.panels;

import java.awt.GridLayout;

import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;

import exception.NoDataException;
import exception.NotANumberException;

public class NewHouseholdMember extends Form {
	private static final long serialVersionUID = 1L;

	private JLabel surnameLabel, name1Label, name2Label, name3Label, name4Label, name5Label, nationalNumberLabel;
	private JTextField surnameTextField, name1TextField, name2TextField, name3TextField, name4TextField, name5TextField, nationalNumberTextField;
	
	public NewHouseholdMember() {
		super();
		
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(" Nouveau membre de la famille : "), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.setLayout(new GridLayout(7, 2, 15, 5));
		
		super.setFormType(PanelType.ADD_HOUSEHOLD_MEMBER);
				
		surnameLabel = new JLabel("Nom : ");
		surnameLabel.setLabelFor(surnameTextField);
		surnameTextField = new JTextField("", 20);
		this.add(surnameLabel);
		this.add(surnameTextField);
		
		name1Label = new JLabel("Prénom : ");
		name1Label.setLabelFor(name1TextField);
		name1TextField = new JTextField("", 20);
		this.add(name1Label);
		this.add(name1TextField);
		
		name2Label = new JLabel("Deuxième prénom : ");
		name2Label.setLabelFor(name2TextField);
		name2TextField = new JTextField("", 20);
		this.add(name2Label);
		this.add(name2TextField);
				
		name3Label = new JLabel("Troisième prénom : ");
		name3Label.setLabelFor(name3TextField);
		name3TextField = new JTextField("", 20);
		this.add(name3Label);
		this.add(name3TextField);
		
		name4Label = new JLabel("Quatrième prénom : ");
		name4Label.setLabelFor(name4TextField);
		name4TextField = new JTextField("", 20);
		this.add(name4Label);
		this.add(name4TextField);
		
		name5Label = new JLabel("Cinquième prénom : ");
		name5Label.setLabelFor(name5TextField);
		name5TextField = new JTextField("", 20);
		this.add(name5Label);
		this.add(name5TextField);
		
		nationalNumberLabel = new JLabel("Numéro national : ");
		nationalNumberLabel.setLabelFor(nationalNumberTextField);
		nationalNumberTextField = new JTextField("", 10);
		this.add(nationalNumberLabel);
		this.add(nationalNumberTextField);
	}

	/** 
	 * 
	 * @return la date entrée par l'utilisateur
	 */
	public Date getBirthDate() {
		return null;
	}

	/**
	 * 
	 * @return une chaï¿½ne de caractï¿½re contenant le nom entrï¿½ par l'utilisateur
	 * @throws NoDataException si la chaï¿½ne de caractï¿½re est vide
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
	 * @return un tableau de String contenant les prï¿½nom entrï¿½s par l'utilisateur
	 * @throws NoDataException si le premier prï¿½nom est une chaï¿½ne de caractï¿½re vide
	 */
	public String[] getFirstnames() throws NoDataException {
		String[] firstNames = new String[5];
		firstNames[0] = name1TextField.getText();
		firstNames[1] = name2TextField.getText();
		firstNames[2] = name3TextField.getText();
		firstNames[3] = name4TextField.getText();
		firstNames[4] = name5TextField.getText();
		
		if (firstNames[0].length() == 0)
			throw new NoDataException("Prénom");
		else
			return firstNames;
	}
	
	/**
	 * 
	 * @return un entier, le numï¿½ro de registre national entrï¿½ par l'utilisateur
	 * @throws NotANumberException si l'utilisateur n'entre pas un nombre
	 * @throws NoDataException 
	 */
	public String getNationalNumber() throws NotANumberException, NoDataException {
		String nationalNumber = null;
		String textFieldContent = nationalNumberTextField.getText();
		try {
			if (textFieldContent.length() == 0)
				throw new NoDataException("Numéro national");
			Integer.parseInt(textFieldContent); // FIX format prob.
		} catch (NumberFormatException numberFormatException) {
			throw new NotANumberException("Numéro national", textFieldContent);
		}
		return nationalNumber;
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
	}
}
