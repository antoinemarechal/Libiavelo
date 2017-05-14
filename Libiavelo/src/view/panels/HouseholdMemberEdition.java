package view.panels;

import java.awt.GridLayout;
import java.text.ParseException;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import model.HouseholdMember;
import exception.InvalidNumberException;
import exception.NoDataException;

@SuppressWarnings("serial")
public class HouseholdMemberEdition extends Form { // TODO : passer le nom de famille d'office

	private JLabel surnameLabel, name1Label, name2Label, name3Label, name4Label, name5Label, nationalNumberLabel;
	private JTextField surnameTextField, name1TextField, name2TextField, name3TextField, name4TextField, name5TextField, nationalNumberTextField;

	private final String nationalNumberFormat = "##.##.##-###.##";
	private final char placeholderCharacter = '_';
	
	private String baseSurname;
	
	private HouseholdMember formGeneratedObject;
	
	public HouseholdMemberEdition(String surname) {
		super(PanelType.ADD_HOUSEHOLD_MEMBER);

		this.baseSurname = surname;
		
		buildDefaultDisplay();
	}
	
	public HouseholdMemberEdition(HouseholdMember householdMember) 
	{
		super(PanelType.EDIT_HOUSEHOLD_MEMBER);
		
		this.formGeneratedObject = householdMember;
		
		buildDefaultDisplay();
		
		reset();
	}
	
	public void buildDefaultDisplay()
	{
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(" Edition d'un membre de la famille : "), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.setLayout(new GridLayout(7, 2, 15, 5));
		
		MaskFormatter nationalNumberFormatter = null;
		
		try 
		{
			nationalNumberFormatter = new MaskFormatter(nationalNumberFormat);
			nationalNumberFormatter.setPlaceholderCharacter(placeholderCharacter);
		} 
		catch (ParseException e) { }
		
		nationalNumberLabel = new JLabel("Numéro national* :");
		nationalNumberLabel.setLabelFor(nationalNumberTextField);
		nationalNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
		nationalNumberTextField = new JFormattedTextField(nationalNumberFormatter);
		this.add(nationalNumberLabel);
		this.add(nationalNumberTextField);
		
		surnameLabel = new JLabel("Nom* :");
		surnameLabel.setLabelFor(surnameTextField);
		surnameLabel.setHorizontalAlignment(JLabel.RIGHT);
		surnameTextField = new JTextField("", 20);
		this.add(surnameLabel);
		this.add(surnameTextField);
		
		name1Label = new JLabel("Prénom* :");
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
		
		// TODO : birthdate
	}

	@Override
	public void reset() 
	{
		if(this.getFormType() == PanelType.ADD_HOUSEHOLD_MEMBER)
		{
			nationalNumberTextField.setText("");
			surnameTextField.setText(baseSurname);
			name1TextField.setText("");
			name2TextField.setText("");
			name3TextField.setText("");
			name4TextField.setText("");
			name5TextField.setText("");
		}
		else if(this.getFormType() == PanelType.EDIT_HOUSEHOLD_MEMBER)
		{
			nationalNumberTextField.setText(formGeneratedObject.getNationalNumber());
			surnameTextField.setText(formGeneratedObject.getSurname());
			name1TextField.setText(formGeneratedObject.getFirstNames()[0]);
			name2TextField.setText(formGeneratedObject.getFirstNames()[1]);
			name3TextField.setText(formGeneratedObject.getFirstNames()[2]);
			name4TextField.setText(formGeneratedObject.getFirstNames()[3]);
			name5TextField.setText(formGeneratedObject.getFirstNames()[4]);			
		}
	}

	@Override
	public boolean validateForm() 
	{
		NoDataException e = null;
		
		String nationalNumber = nationalNumberTextField.getText();
		String surname = surnameTextField.getText();
		String[] firstNames = new String[5];
		firstNames[0] = name1TextField.getText();
		firstNames[1] = name2TextField.getText();
		firstNames[2] = name3TextField.getText();
		firstNames[3] = name4TextField.getText();
		firstNames[4] = name5TextField.getText();
		Date birthDate = null; // TODO : birthdate
		
		if(surname.length() == 0)
		{
			e = new NoDataException("Nom");
		}
		else if(firstNames[0].length() == 0)
		{
			e = new NoDataException("Prénom");
		}
		else if(nationalNumber.equals(nationalNumberFormat.replace('#', placeholderCharacter)))
		{
			e = new NoDataException("Numéro national");
		}
		
		if(e == null)
		{
			try 
			{
				formGeneratedObject = new HouseholdMember(birthDate, firstNames, nationalNumber, surname);
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
