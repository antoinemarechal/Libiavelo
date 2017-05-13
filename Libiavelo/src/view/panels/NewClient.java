package view.panels;

import java.awt.GridLayout;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import exception.InvalidNumberException;
import exception.NoDataException;
import model.Client;

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
				
		name1Label = new JLabel("Prénom :");
		name1Label.setLabelFor(name1TextField);
		name1Label.setHorizontalAlignment(JLabel.RIGHT);
		name1TextField = new JTextField("", 20);
		this.add(name1Label);
		this.add(name1TextField);
		
		name2Label = new JLabel("Deuxième prénom :");
		name2Label.setLabelFor(name2TextField);
		name2Label.setHorizontalAlignment(JLabel.RIGHT);
		name2TextField = new JTextField("", 20);
		this.add(name2Label);
		this.add(name2TextField);
			
		name3Label = new JLabel("Troisième prénom :");
		name3Label.setLabelFor(name3TextField);
		name3Label.setHorizontalAlignment(JLabel.RIGHT);
		name3TextField = new JTextField("", 20);
		this.add(name3Label);
		this.add(name3TextField);
		
		name4Label = new JLabel("Quatrième prénom :");
		name4Label.setLabelFor(name4TextField);
		name4Label.setHorizontalAlignment(JLabel.RIGHT);
		name4TextField = new JTextField("", 20);
		this.add(name4Label);
		this.add(name4TextField);
		
		name5Label = new JLabel("Cinquième prénom :");
		name5Label.setLabelFor(name5TextField);
		name5Label.setHorizontalAlignment(JLabel.RIGHT);
		name5TextField = new JTextField("", 20);
		this.add(name5Label);
		this.add(name5TextField);
		
		nationalNumberLabel = new JLabel("Numéro national :");
		nationalNumberLabel.setLabelFor(nationalNumberTextField);
		nationalNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
		nationalNumberTextField = new JTextField("", 10);
		this.add(nationalNumberLabel);
		this.add(nationalNumberTextField);
		
		homeNumberLabel = new JLabel("Numéro de fixe :");
		homeNumberLabel.setLabelFor(homeNumberTextField);
		homeNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
		homeNumberTextField = new JTextField("", 10);
		this.add(homeNumberLabel);
		this.add(homeNumberTextField);
		
		phoneNumberLabel = new JLabel("Numéro de portable :");
		phoneNumberLabel.setLabelFor(phoneNumberTextField);
		phoneNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
		phoneNumberTextField = new JTextField("", 10);
		this.add(phoneNumberLabel);
		this.add(phoneNumberTextField);
		
		streetNumberLabel = new JLabel("Numéro de rue :");
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

	public Client getEnteredClient() {
		Client client = null;
		if (isDataValid()) {
			String[] firstNames = new String[5];
			firstNames[0] = name1TextField.getText();
			firstNames[1] = name2TextField.getText();
			firstNames[2] = name3TextField.getText();
			firstNames[3] = name4TextField.getText();
			firstNames[4] = name5TextField.getText();
			try {
				client = new Client(nationalNumberTextField.getText(), homeNumberTextField.getText(), phoneNumberTextField.getText(), surnameTextField.getText(), firstNames, false, null, streetNumberTextField.getText(), streetNameTextField.getText(), new Date(System.currentTimeMillis()));
			} catch (InvalidNumberException | NoDataException e) {
				e.printStackTrace();
			}
		}
		return client;
	}
	
	@Override
	public boolean isDataValid() {
		if (streetNameTextField.getText().length() == 0) {
			JOptionPane.showMessageDialog(getParent(), "Le champ obligatoire \"Nom de rue\" a été omis");
			return false;
		}
		
		if (streetNumberTextField.getText().length() == 0) {
			JOptionPane.showMessageDialog(getParent(), "Le champ obligatoire \"Numéro de rue\" a été omis");
			return false;
		}
			
		
		String homeNumber = homeNumberTextField.getText();
		if (homeNumber.length() > 0) {
			try {
				Integer.parseInt(homeNumber);
			} catch (NumberFormatException numberFormatException) {
				JOptionPane.showMessageDialog(getParent(), "Le champ \"Numéro de fixe\" ne doit contenir que des nombres");
				return false;
			}
		}
		
		
		String phoneNumber = phoneNumberTextField.getText();
		if (phoneNumber.length() > 0) {
			try {
				Integer.parseInt(phoneNumber);
			} catch (NumberFormatException numberFormatException) {
				JOptionPane.showMessageDialog(getParent(), "Le champ \"Numéro de portable\" ne doit contenir que des nombres");
				return false;
			}
		}
		
		
		if (name1TextField.getText().length() == 0) {
			JOptionPane.showMessageDialog(getParent(), "Le champ obligatoire \"Prénom\" a été omis");
			return false;
		}
				
		if (surnameTextField.getText().length() == 0) {
			JOptionPane.showMessageDialog(getParent(), "Le champ obligatoire \"Nom\" a été omis");
			return false;
		}
		
		String nationalNumber = nationalNumberTextField.getText();
		if (nationalNumber.length() != 12) {
			// FIXME size ?
	
			if (!nationalNumber.contains("-")) {
				//FIXME position ?
			}
		}
		return true;	
	}
}
