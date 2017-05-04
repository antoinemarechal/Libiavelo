package view.panels;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;

import exception.NoDataException;
import exception.NotANumberException;

@SuppressWarnings("serial")
public class NewLocality extends Form {
	private JLabel cityNameLabel, postalCodeLabel;
	private JTextField cityNameTextField, postalCodeTextField;
	
	public NewLocality() {
		super();
		
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Localité : "), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.setLayout(new GridLayout(9, 2, 15, 5));
				
		
		cityNameLabel = new JLabel("Ville :");
		cityNameLabel.setLabelFor(cityNameTextField);
		cityNameLabel.setHorizontalAlignment(JLabel.RIGHT);
		cityNameTextField = new JTextField("", 20);
		this.add(cityNameLabel);
		this.add(cityNameTextField);
		
		postalCodeLabel = new JLabel("Code postal :");
		postalCodeLabel.setLabelFor(postalCodeTextField);
		postalCodeLabel.setHorizontalAlignment(JLabel.RIGHT);
		postalCodeTextField = new JTextField("", 20);
		this.add(postalCodeLabel);
		this.add(postalCodeTextField);
	}

	/**
	 * 
	 * @return un entier, le numï¿½ro de registre national entrï¿½ par l'utilisateur
	 * @throws NotANumberException si l'utilisateur n'entre pas un nombre
	 * @throws NoDataException 
	 */
	public String getCityName() throws NoDataException {
		String cityName = cityNameTextField.getText();
		if (cityName.length() == 0)
			throw new NoDataException("Ville");
		return cityName;
	}
	
	public String getPostalCode() throws NotANumberException, NoDataException {
		String postalCode = postalCodeTextField.getText();
		try {
			if (postalCode.length() == 0)
				throw new NoDataException("Code postal");
			Integer.parseInt(postalCode);
		} catch (NumberFormatException numberFormatException) {
			throw new NotANumberException(postalCode);
		}
		return postalCode;
	}
	
	@Override
	public void reset() {
		cityNameTextField.setText("");
		postalCodeTextField.setText("");		
	}
}
