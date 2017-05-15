package view.form;

import java.awt.GridLayout;
import java.text.ParseException;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.text.MaskFormatter;

import model.HouseholdMember;
import exception.DataLengthException;
import exception.InvalidNumberException;
import exception.NoDataException;

@SuppressWarnings("serial")
public class HouseholdMemberEdition extends Form {

	private JLabel surnameLabel, name1Label, name2Label, name3Label, name4Label, name5Label, nationalNumberLabel, birthDateLabel;
	private JTextField surnameTextField, name1TextField, name2TextField, name3TextField, name4TextField, name5TextField, nationalNumberTextField;
	private JSpinner birthDateSpinner;
	
	private final String nationalNumberFormat = "##.##.##-###.##";
	private final char placeholderCharacter = '_';
	
	private String baseSurname;
	
	private HouseholdMember formGeneratedObject;
	
	public HouseholdMemberEdition(String surname) {
		super(FormType.ADD_HOUSEHOLD_MEMBER);

		this.baseSurname = surname;
		
		buildDefaultDisplay();
		
		surnameTextField.setText(baseSurname);
	}
	
	public HouseholdMemberEdition(HouseholdMember householdMember) 
	{
		super(FormType.EDIT_HOUSEHOLD_MEMBER);
		
		this.formGeneratedObject = householdMember;
		
		buildDefaultDisplay();
		
		reset();
	}
	
	public void buildDefaultDisplay() // TODO : contenu des combo box
	{
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(" Edition d'un membre de la famille : "), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.setLayout(new GridLayout(8, 2, 15, 5));
		
		MaskFormatter nationalNumberFormatter = null;
		
		try 
		{
			nationalNumberFormatter = new MaskFormatter(nationalNumberFormat);
			nationalNumberFormatter.setPlaceholderCharacter(placeholderCharacter);
		} 
		catch (ParseException e) { }
		
		nationalNumberLabel = new JLabel("Numéro national* :");
		nationalNumberLabel.setLabelFor(nationalNumberTextField);
		nationalNumberLabel.setToolTipText("Obligatoire");
		nationalNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
		nationalNumberTextField = new JFormattedTextField(nationalNumberFormatter);
		this.add(nationalNumberLabel);
		this.add(nationalNumberTextField);
		
		surnameLabel = new JLabel("Nom* :");
		surnameLabel.setLabelFor(surnameTextField);
		surnameLabel.setToolTipText("Obligatoire");
		surnameLabel.setHorizontalAlignment(JLabel.RIGHT);
		surnameTextField = new JTextField();
		this.add(surnameLabel);
		this.add(surnameTextField);
		
		name1Label = new JLabel("Prénom* :");
		name1Label.setLabelFor(name1TextField);
		name1Label.setToolTipText("Obligatoire");
		name1Label.setHorizontalAlignment(JLabel.RIGHT);
		name1TextField = new JTextField();
		this.add(name1Label);
		this.add(name1TextField);
		
		name2Label = new JLabel("Deuxième prénom :");
		name2Label.setLabelFor(name2TextField);
		name2Label.setHorizontalAlignment(JLabel.RIGHT);
		name2TextField = new JTextField();
		this.add(name2Label);
		this.add(name2TextField);
				
		name3Label = new JLabel("Troisième prénom :");
		name3Label.setLabelFor(name3TextField);
		name3Label.setHorizontalAlignment(JLabel.RIGHT);
		name3TextField = new JTextField();
		this.add(name3Label);
		this.add(name3TextField);
		
		name4Label = new JLabel("Quatrième prénom :");
		name4Label.setLabelFor(name4TextField);
		name4Label.setHorizontalAlignment(JLabel.RIGHT);
		name4TextField = new JTextField();
		this.add(name4Label);
		this.add(name4TextField);
		
		name5Label = new JLabel("Cinquième prénom :");
		name5Label.setLabelFor(name5TextField);
		name5Label.setHorizontalAlignment(JLabel.RIGHT);
		name5TextField = new JTextField();
		this.add(name5Label);
		this.add(name5TextField);
		
		SpinnerDateModel birthDateSpinnerModel = new SpinnerDateModel();
		birthDateSpinnerModel.setStart(new Date(System.currentTimeMillis() - 150 * 31536000000l));
		birthDateSpinnerModel.setEnd(new Date(System.currentTimeMillis()));
		
		birthDateLabel = new JLabel("Date de naissance* :");
		birthDateLabel.setLabelFor(birthDateSpinner);
		birthDateLabel.setToolTipText("Obligatoire");
		birthDateLabel.setHorizontalAlignment(JLabel.RIGHT);
		birthDateSpinner = new JSpinner(birthDateSpinnerModel);
		birthDateSpinner.setEditor(new JSpinner.DateEditor(birthDateSpinner, "dd/MM/yyyy"));
		this.add(birthDateLabel);
		this.add(birthDateSpinner);
	}

	@Override
	public void reset() 
	{
		if(this.getFormType() == FormType.ADD_HOUSEHOLD_MEMBER)
		{
			nationalNumberTextField.setText("");
			surnameTextField.setText(baseSurname);
			name1TextField.setText("");
			name2TextField.setText("");
			name3TextField.setText("");
			name4TextField.setText("");
			name5TextField.setText("");
			birthDateSpinner.setValue(new Date(System.currentTimeMillis()));
		}
		else if(this.getFormType() == FormType.EDIT_HOUSEHOLD_MEMBER)
		{
			nationalNumberTextField.setText(formGeneratedObject.getNationalNumber());
			surnameTextField.setText(formGeneratedObject.getSurname());
			name1TextField.setText(formGeneratedObject.getFirstNames()[0]);
			name2TextField.setText(formGeneratedObject.getFirstNames()[1]);
			name3TextField.setText(formGeneratedObject.getFirstNames()[2]);
			name4TextField.setText(formGeneratedObject.getFirstNames()[3]);
			name5TextField.setText(formGeneratedObject.getFirstNames()[4]);		
			birthDateSpinner.setValue(formGeneratedObject.getBirthDate());	
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
		Date birthDate = (Date) birthDateSpinner.getValue();
		
		if(nationalNumber.equals(nationalNumberFormat.replace('#', placeholderCharacter)))
		{
			e = new NoDataException("Numéro national");
		}
		else if(surname.length() == 0)
		{
			e = new NoDataException("Nom");
		}
		else if(firstNames[0].length() == 0)
		{
			e = new NoDataException("Prénom");
		}
		
		if(e == null)
		{
			try 
			{
				if(this.getFormType() == FormType.ADD_HOUSEHOLD_MEMBER)
				{
					formGeneratedObject = new HouseholdMember(nationalNumber, surname, firstNames, birthDate);
				}
				else if(this.getFormType() == FormType.EDIT_HOUSEHOLD_MEMBER)
				{
					formGeneratedObject.setNationalNumber(nationalNumber);
					formGeneratedObject.setSurname(surname);
					formGeneratedObject.setFirstNames(firstNames);
					formGeneratedObject.setBirthDate(birthDate);
				}
			} 
			catch (InvalidNumberException | NoDataException | DataLengthException e1) 
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
