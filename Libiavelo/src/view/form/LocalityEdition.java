package view.form;

import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import model.Locality;
import exception.InvalidNumberException;
import exception.NoDataException;

@SuppressWarnings("serial")
public class LocalityEdition extends Form {
	
	private JLabel cityNameLabel, postalCodeLabel;
	private JTextField cityNameTextField, postalCodeTextField;
	
	private final String postalCodeFormat = "####";
	private final char placeholderCharacter = '_';
	
	private Locality formGeneratedObject;
		
	public LocalityEdition() {
		super(FormType.ADD_LOCALITY);
		
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(" Localité : "), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.setLayout(new GridLayout(2, 2, 15, 5));
		
		MaskFormatter postalCodeFormatter = null;
		
		try 
		{
			postalCodeFormatter = new MaskFormatter(postalCodeFormat);
			postalCodeFormatter.setPlaceholderCharacter(placeholderCharacter);
		} 
		catch (ParseException e) { }
		
		cityNameLabel = new JLabel("Ville* :");
		cityNameLabel.setLabelFor(cityNameTextField);
		cityNameLabel.setToolTipText("Obligatoire");
		cityNameLabel.setHorizontalAlignment(JLabel.RIGHT);
		cityNameTextField = new JTextField();
		this.add(cityNameLabel);
		this.add(cityNameTextField);
		
		postalCodeLabel = new JLabel("Code postal* :");
		postalCodeLabel.setLabelFor(postalCodeTextField);
		postalCodeLabel.setToolTipText("Obligatoire");
		postalCodeLabel.setHorizontalAlignment(JLabel.RIGHT);
		postalCodeTextField = new JFormattedTextField(postalCodeFormatter);
		this.add(postalCodeLabel);
		this.add(postalCodeTextField);
	}
	
	@Override
	public void reset() {
		cityNameTextField.setText("");
		postalCodeTextField.setText("");		
	}

	@Override
	public boolean validateForm() 
	{
		NoDataException e = null;
		
		String cityName = cityNameTextField.getText();
		String postalCode = postalCodeTextField.getText();
		
		if(cityName.length() == 0)
		{
			e = new NoDataException("Ville");
		}
		else if(postalCode.equals(postalCodeFormat.replace('#', placeholderCharacter)))
		{
			e = new NoDataException("Code postal");
		}
		
		if(e == null)
		{
			try 
			{
				formGeneratedObject = new Locality(cityName, Integer.parseInt(postalCode));
			}
			catch (NoDataException | NumberFormatException | InvalidNumberException e1) 
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
