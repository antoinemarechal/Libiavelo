package view.form;

import java.awt.GridLayout;
import java.text.ParseException;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import model.Client;
import exception.InvalidNumberException;
import exception.NoDataException;

@SuppressWarnings("serial")
public class NewClient extends Form { // TODO : rename + 2eme constructeur pour édition
	
	private JLabel surnameLabel, name1Label, name2Label, name3Label, name4Label, name5Label, nationalNumberLabel, homeNumberLabel, phoneNumberLabel, streetNameLabel, streetNumberLabel;
	private JTextField surnameTextField, name1TextField, name2TextField, name3TextField, name4TextField, name5TextField, nationalNumberTextField, homeNumberTextField, phoneNumberTextField, streetNameTextField, streetNumberTextField;
	
	private final String nationalNumberFormat = "##.##.##-###.##";
	private final String homeNumberFormat = "0## ## ## ##";
	private final String phoneNumberFormat = "04## ## ## ##";
	private final char placeholderCharacter = '_';
	
	private Client formGeneratedObject;
	
	public NewClient() {
		super(PanelType.ADD_CLIENT);
		
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(" Nouveau client : "), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.setLayout(new GridLayout(11, 2, 15, 5));
		
		MaskFormatter nationalNumberFormatter = null;
		MaskFormatter homeNumberFormatter = null;
		MaskFormatter phoneNumberFormatter = null;
		
		try 
		{
			nationalNumberFormatter = new MaskFormatter(nationalNumberFormat);
			nationalNumberFormatter.setPlaceholderCharacter(placeholderCharacter);
			homeNumberFormatter = new MaskFormatter(homeNumberFormat);
			homeNumberFormatter.setPlaceholderCharacter(placeholderCharacter);
			phoneNumberFormatter = new MaskFormatter(phoneNumberFormat);
			phoneNumberFormatter.setPlaceholderCharacter(placeholderCharacter);
		} 
		catch (ParseException e) { }
		
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
		nationalNumberTextField = new JFormattedTextField(nationalNumberFormatter);
		this.add(nationalNumberLabel);
		this.add(nationalNumberTextField);
		
		homeNumberLabel = new JLabel("Numéro de fixe :");
		homeNumberLabel.setLabelFor(homeNumberTextField);
		homeNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
		homeNumberTextField = new JFormattedTextField(homeNumberFormatter);
		this.add(homeNumberLabel);
		this.add(homeNumberTextField);
		
		phoneNumberLabel = new JLabel("Numéro de portable :");
		phoneNumberLabel.setLabelFor(phoneNumberTextField);
		phoneNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
		phoneNumberTextField = new JFormattedTextField(phoneNumberFormatter);
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
		streetNumberTextField.setText("");
		streetNameTextField.setText("");
	}

	@Override
	public boolean validateForm() 
	{
		NoDataException e = null;
		
		String nationalNumber = nationalNumberTextField.getText();
		String homeNumber = null;
		String phoneNumber = null;
		String clientSurname = surnameTextField.getText();
		String[] clientFirstNames = new String[5];
		clientFirstNames[0] = name1TextField.getText();
		clientFirstNames[1] = name2TextField.getText();
		clientFirstNames[2] = name3TextField.getText();
		clientFirstNames[3] = name4TextField.getText();
		clientFirstNames[4] = name5TextField.getText();
		Boolean subscriptionValidated = false;
		Integer depositAmount = 0;
		String streetNumber = streetNumberTextField.getText();
		String streetName = streetNameTextField.getText();
		Date subscriptionDate = new Date(System.currentTimeMillis()); // TODO : optionnel : faire façon cours avec greg calendar
		
		if(clientSurname.length() == 0)
		{
			e = new NoDataException("Nom");
		}
		else if(clientFirstNames[0].length() == 0)
		{
			e = new NoDataException("Prénom");
		}
		else if(nationalNumber.equals(nationalNumberFormat.replace('#', placeholderCharacter)))
		{
			e = new NoDataException("Numéro national");
		}
		else if(streetNumber.length() == 0)
		{
			e = new NoDataException("Numéro de rue");
		}
		else if(streetName.length() == 0)
		{
			e = new NoDataException("Nom de rue");
		}	
		
		if(e == null)
		{
			if(!homeNumberTextField.getText().equals(homeNumberFormat.replace('#', placeholderCharacter)))
				homeNumber = homeNumberTextField.getText();
			
			if(!phoneNumberTextField.getText().equals(phoneNumberFormat.replace('#', placeholderCharacter)))
				phoneNumber = phoneNumberTextField.getText();
			
			try 
			{
				formGeneratedObject = new Client(nationalNumber, homeNumber, phoneNumber, clientSurname, clientFirstNames, subscriptionValidated, depositAmount, streetNumber, streetName, subscriptionDate);
			
				// TODO : add les membres du ménage
			} 
			catch (InvalidNumberException | NoDataException e1) 
			{
				JOptionPane.showMessageDialog(this, e1.getMessage(), "Erreur de création", JOptionPane.ERROR_MESSAGE);
			}
			
			return formGeneratedObject != null;
		}
		else
		{
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur de formulaire", JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
	}

	@Override
	public Object getFormGeneratedObject() 
	{
		return formGeneratedObject;
	}
	
}
