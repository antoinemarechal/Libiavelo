package view.form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.MaskFormatter;

import view.PreviousPanel;
import model.Client;
import model.HouseholdMember;
import model.Locality;
import exception.InvalidNumberException;
import exception.NoDataException;

@SuppressWarnings("serial")
public class ClientEdition extends Form implements ListSelectionListener, ActionListener, PreviousPanel {
	
	private JLabel surnameLabel, name1Label, name2Label, name3Label, name4Label, name5Label, nationalNumberLabel, homeNumberLabel, phoneNumberLabel, streetNameLabel, streetNumberLabel,
			depositAmountLabel, registrationValidatedLabel, localityLabel;
	private JTextField surnameTextField, name1TextField, name2TextField, name3TextField, name4TextField, name5TextField, nationalNumberTextField, homeNumberTextField, phoneNumberTextField, 
			streetNameTextField, streetNumberTextField,	depositAmountTextField;
	private JCheckBox registrationValidatedCheckBox;
	private JComboBox<Locality> localityComboBox;
	private JButton addHouseholdMemberButton;
	private JButton editHouseholdMemberButton;
	private JButton removeHouseholdMemberButton;
	private JDialog householdMemberEditionDialog;
	
	private JTable householdMembersTable;
	
	// TODO (Bonus) : vérificateurs de taille
	private final String nationalNumberFormat = "##.##.##-###.##";
	private final String homeNumberFormat = "0## ## ## ##";
	private final String phoneNumberFormat = "04## ## ## ##";
	private final String depositAmountFormat = "##.## €";
	private final char placeholderCharacter = '_';
	
	private ArrayList<HouseholdMember> householdMembers;
	private Client formGeneratedObject;
	
	private Form currentForm;
	
	public ClientEdition(ArrayList<Locality> localitiesListing) {
		super(FormType.ADD_CLIENT);
		
		buildDefaultDisplay(localitiesListing);
		
		depositAmountTextField.setText("00.00");
		depositAmountTextField.setEnabled(false);
		registrationValidatedCheckBox.setEnabled(false);
	}
	
	public ClientEdition(Client client, ArrayList<Locality> localitiesListing) 
	{
		super(FormType.EDIT_CLIENT);
		
		buildDefaultDisplay(localitiesListing);
		
		formGeneratedObject = client;
		
		reset();
	}
	
	private void buildDefaultDisplay(ArrayList<Locality> localitiesListing) 
	{		
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(" Edition d'un client : "), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.setLayout(new BorderLayout());

		householdMembers = new ArrayList<HouseholdMember>();

		householdMemberEditionDialog = new JDialog();
		householdMemberEditionDialog.setTitle("Edition d'un membre");
		householdMemberEditionDialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		householdMemberEditionDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		householdMemberEditionDialog.getContentPane().setLayout(new BorderLayout());
		
		JPanel mainFormPanel = new JPanel();
		mainFormPanel.setLayout(new GridLayout(14, 2, 15, 5));
		
			MaskFormatter nationalNumberFormatter = null;
			MaskFormatter homeNumberFormatter = null;
			MaskFormatter phoneNumberFormatter = null;
			MaskFormatter depositAmountFormatter = null;
			
			try 
			{
				nationalNumberFormatter = new MaskFormatter(nationalNumberFormat);
				nationalNumberFormatter.setPlaceholderCharacter(placeholderCharacter);
				homeNumberFormatter = new MaskFormatter(homeNumberFormat);
				homeNumberFormatter.setPlaceholderCharacter(placeholderCharacter);
				phoneNumberFormatter = new MaskFormatter(phoneNumberFormat);
				phoneNumberFormatter.setPlaceholderCharacter(placeholderCharacter);
				depositAmountFormatter = new MaskFormatter(depositAmountFormat);
				depositAmountFormatter.setPlaceholderCharacter(placeholderCharacter);
			} 
			catch (ParseException e) { }
			
			surnameLabel = new JLabel("Nom* :");
			surnameLabel.setLabelFor(surnameTextField);
			surnameLabel.setToolTipText("Obligatoire");
			surnameLabel.setHorizontalAlignment(JLabel.RIGHT);
			surnameTextField = new JTextField();
			mainFormPanel.add(surnameLabel);
			mainFormPanel.add(surnameTextField);
					
			name1Label = new JLabel("Prénom* :");
			name1Label.setLabelFor(name1TextField);
			name1Label.setToolTipText("Obligatoire");
			name1Label.setHorizontalAlignment(JLabel.RIGHT);
			name1TextField = new JTextField();
			mainFormPanel.add(name1Label);
			mainFormPanel.add(name1TextField);
			
			name2Label = new JLabel("Deuxième prénom :");
			name2Label.setLabelFor(name2TextField);
			name2Label.setHorizontalAlignment(JLabel.RIGHT);
			name2TextField = new JTextField();
			mainFormPanel.add(name2Label);
			mainFormPanel.add(name2TextField);
				
			name3Label = new JLabel("Troisième prénom :");
			name3Label.setLabelFor(name3TextField);
			name3Label.setHorizontalAlignment(JLabel.RIGHT);
			name3TextField = new JTextField();
			mainFormPanel.add(name3Label);
			mainFormPanel.add(name3TextField);
			
			name4Label = new JLabel("Quatrième prénom :");
			name4Label.setLabelFor(name4TextField);
			name4Label.setHorizontalAlignment(JLabel.RIGHT);
			name4TextField = new JTextField();
			mainFormPanel.add(name4Label);
			mainFormPanel.add(name4TextField);
			
			name5Label = new JLabel("Cinquième prénom :");
			name5Label.setLabelFor(name5TextField);
			name5Label.setHorizontalAlignment(JLabel.RIGHT);
			name5TextField = new JTextField();
			mainFormPanel.add(name5Label);
			mainFormPanel.add(name5TextField);
		    
			nationalNumberLabel = new JLabel("Numéro national* :");
			nationalNumberLabel.setLabelFor(nationalNumberTextField);
			nationalNumberLabel.setToolTipText("Obligatoire");
			nationalNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
			nationalNumberTextField = new JFormattedTextField(nationalNumberFormatter);
			mainFormPanel.add(nationalNumberLabel);
			mainFormPanel.add(nationalNumberTextField);
			
			localityLabel = new JLabel("Localité* :");	// TODO (Bonus) : Add localité
			localityLabel.setLabelFor(nationalNumberTextField);
			localityLabel.setToolTipText("Obligatoire");
			localityLabel.setHorizontalAlignment(JLabel.RIGHT);
			localityComboBox = new JComboBox<Locality>();
			
			for(Locality l : localitiesListing)
				localityComboBox.addItem(l);
			
			mainFormPanel.add(localityLabel);
			mainFormPanel.add(localityComboBox);
			
			streetNameLabel = new JLabel("Nom de rue* :");
			streetNameLabel.setLabelFor(streetNameTextField);
			streetNameLabel.setToolTipText("Obligatoire");
			streetNameLabel.setHorizontalAlignment(JLabel.RIGHT);
			streetNameTextField = new JTextField();
			mainFormPanel.add(streetNameLabel);
			mainFormPanel.add(streetNameTextField);
			
			streetNumberLabel = new JLabel("Numéro de rue* :");
			streetNumberLabel.setLabelFor(streetNumberTextField);
			streetNumberLabel.setToolTipText("Obligatoire");
			streetNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
			streetNumberTextField = new JTextField();
			mainFormPanel.add(streetNumberLabel);
			mainFormPanel.add(streetNumberTextField);
			
			homeNumberLabel = new JLabel("Numéro de fixe :");
			homeNumberLabel.setLabelFor(homeNumberTextField);
			homeNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
			homeNumberTextField = new JFormattedTextField(homeNumberFormatter);
			mainFormPanel.add(homeNumberLabel);
			mainFormPanel.add(homeNumberTextField);
			
			phoneNumberLabel = new JLabel("Numéro de portable :");
			phoneNumberLabel.setLabelFor(phoneNumberTextField);
			phoneNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
			phoneNumberTextField = new JFormattedTextField(phoneNumberFormatter);
			mainFormPanel.add(phoneNumberLabel);
			mainFormPanel.add(phoneNumberTextField);
			
			depositAmountLabel = new JLabel("Caution restante :");
			depositAmountLabel.setLabelFor(depositAmountTextField);
			depositAmountLabel.setHorizontalAlignment(JLabel.RIGHT);
			depositAmountTextField = new JFormattedTextField(depositAmountFormatter);
			mainFormPanel.add(depositAmountLabel);
			mainFormPanel.add(depositAmountTextField);
			
			registrationValidatedLabel = new JLabel("Inscription validée :");
			registrationValidatedLabel.setLabelFor(phoneNumberTextField);
			registrationValidatedLabel.setHorizontalAlignment(JLabel.RIGHT);
			registrationValidatedCheckBox = new JCheckBox();
			mainFormPanel.add(registrationValidatedLabel);
			mainFormPanel.add(registrationValidatedCheckBox);
			
		JPanel housholdMembersPanel = new JPanel();
		housholdMembersPanel.setLayout(new BorderLayout());
		housholdMembersPanel.setPreferredSize(new Dimension(0, 120));
		
			householdMembersTable = new JTable();
			householdMembersTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			householdMembersTable.setModel(new HouseholdMembersTableModel());
			householdMembersTable.getSelectionModel().addListSelectionListener(this);
			householdMembersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			for(int i = 0; i < householdMembersTable.getColumnCount(); i++)
			{
				householdMembersTable.getColumnModel().getColumn(i).setPreferredWidth(100);;
			}
			
			JScrollPane householdMembersScrollPane = new JScrollPane(householdMembersTable);
			
			JPanel buttonsPanel = new JPanel();
			
				addHouseholdMemberButton = new JButton("Nouveau membre");
				addHouseholdMemberButton.addActionListener(this);
					
				editHouseholdMemberButton = new JButton("Editer");
				editHouseholdMemberButton.addActionListener(this);
				editHouseholdMemberButton.setEnabled(false);
					
				removeHouseholdMemberButton = new JButton("Supprimer");
				removeHouseholdMemberButton.addActionListener(this);
				removeHouseholdMemberButton.setEnabled(false);
			
			buttonsPanel.add(addHouseholdMemberButton);
			buttonsPanel.add(editHouseholdMemberButton);
			buttonsPanel.add(removeHouseholdMemberButton);
			
		housholdMembersPanel.add(new JLabel("Membres du ménage :"), BorderLayout.NORTH);
		housholdMembersPanel.add(householdMembersScrollPane, BorderLayout.CENTER);
		housholdMembersPanel.add(buttonsPanel, BorderLayout.SOUTH);
		
		this.add(mainFormPanel, BorderLayout.CENTER);
		this.add(housholdMembersPanel, BorderLayout.SOUTH);
	}

	@Override
	public void reset() 
	{
		if(this.getFormType() == FormType.ADD_CLIENT)
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
			streetNameTextField.setText("");
			streetNumberTextField.setText("");
			
			householdMembers.clear();
		}
		else if(this.getFormType() == FormType.EDIT_CLIENT)
		{
			surnameTextField.setText(formGeneratedObject.getSurname());
			name1TextField.setText(formGeneratedObject.getFirstNames()[0]);
			name2TextField.setText(formGeneratedObject.getFirstNames()[1]);
			name3TextField.setText(formGeneratedObject.getFirstNames()[2]);
			name4TextField.setText(formGeneratedObject.getFirstNames()[3]);
			name5TextField.setText(formGeneratedObject.getFirstNames()[4]);
			nationalNumberTextField.setText(formGeneratedObject.getNationalNumber());
			localityComboBox.setSelectedItem(formGeneratedObject.getLocality());
			streetNameTextField.setText(formGeneratedObject.getStreetName());
			streetNumberTextField.setText(formGeneratedObject.getStreetNumber());
			homeNumberTextField.setText(formGeneratedObject.getHomeNumber());
			phoneNumberTextField.setText(formGeneratedObject.getPhoneNumber());
			
			DecimalFormat depositFormat = new DecimalFormat("##.00");
			depositFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
			depositFormat.setMinimumIntegerDigits(2);
			
			depositAmountTextField.setText(depositFormat.format(formGeneratedObject.getDepositAmount()));
			registrationValidatedCheckBox.setSelected(formGeneratedObject.isSubsriptionValidated());
			
			householdMembers.clear();
			
			for(HouseholdMember hm : formGeneratedObject.getHousehold())
				householdMembers.add(hm);			
		}
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
		String streetNumber = streetNumberTextField.getText();
		String streetName = streetNameTextField.getText();
		
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
		else if(depositAmountTextField.getText().equals(depositAmountFormat.replace('#', placeholderCharacter)))
		{
			e = new NoDataException("Caution Restante");
		}
		
		if(e == null)
		{
			if(!homeNumberTextField.getText().equals(homeNumberFormat.replace('#', placeholderCharacter)))
				homeNumber = homeNumberTextField.getText();
			
			if(!phoneNumberTextField.getText().equals(phoneNumberFormat.replace('#', placeholderCharacter)))
				phoneNumber = phoneNumberTextField.getText();
			
			try 
			{
				if(this.getFormType() == FormType.ADD_CLIENT)
				{
					formGeneratedObject = new Client(nationalNumber, homeNumber, phoneNumber, clientSurname, clientFirstNames, false, 0.0f, streetNumber, streetName, new Date(System.currentTimeMillis()));
				}
				else if(this.getFormType() == FormType.EDIT_CLIENT)
				{
					formGeneratedObject.setSurname(clientSurname);
					formGeneratedObject.setFirstNames(clientFirstNames);
					formGeneratedObject.setNationalNumber(nationalNumber);
					formGeneratedObject.setLocality((Locality) localityComboBox.getSelectedItem());
					formGeneratedObject.setStreetName(streetName);
					formGeneratedObject.setStreetNumber(streetNumber);
					formGeneratedObject.setHomeNumber(homeNumber);
					formGeneratedObject.setPhoneNumber(phoneNumber);
					formGeneratedObject.setDepositAmount(Float.parseFloat(depositAmountTextField.getText().substring(0, 5)));
					formGeneratedObject.setSubsriptionValidated(registrationValidatedCheckBox.isSelected());
				
					for(HouseholdMember hm : formGeneratedObject.getHousehold())
						formGeneratedObject.removeHouseholdMember(hm);
				}
				
				for(HouseholdMember hm : householdMembers)
					formGeneratedObject.addHouseholdMember(hm);
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

	@Override
	public void valueChanged(ListSelectionEvent e) 
	{
		if(!e.getValueIsAdjusting() && householdMembersTable.getSelectedRow() > -1)
		{
			if(householdMembersTable.getSelectedRowCount() == 1)
			{
				editHouseholdMemberButton.setEnabled(true);
				removeHouseholdMemberButton.setEnabled(true);
			}
			else
			{	
				editHouseholdMemberButton.setEnabled(false);
				removeHouseholdMemberButton.setEnabled(false);
			}
		}		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == addHouseholdMemberButton)
		{
			householdMemberEditionDialog.getContentPane().removeAll();
			
			currentForm = new HouseholdMemberEdition(surnameTextField.getText());
			
			householdMemberEditionDialog.getContentPane().add(new FormPanel(currentForm , this), BorderLayout.CENTER);
			householdMemberEditionDialog.setPreferredSize(new Dimension(400, 350));
			householdMemberEditionDialog.pack();
			
			householdMemberEditionDialog.setLocationRelativeTo(this);
			householdMemberEditionDialog.setVisible(true);
		}
		else if(e.getSource() == editHouseholdMemberButton)
		{
			householdMemberEditionDialog.getContentPane().removeAll();
			
			currentForm = new HouseholdMemberEdition(householdMembers.get(householdMembersTable.getSelectedRow()));
			
			householdMemberEditionDialog.getContentPane().add(new FormPanel((currentForm), this), BorderLayout.CENTER);
			householdMemberEditionDialog.setPreferredSize(new Dimension(400, 350));
			householdMemberEditionDialog.pack();
			
			householdMemberEditionDialog.setLocationRelativeTo(this);
			householdMemberEditionDialog.setVisible(true);
		}
		else if(e.getSource() == removeHouseholdMemberButton)
		{
			householdMembers.remove(householdMembersTable.getSelectedRow());
			
			householdMembersTable.revalidate();
			
			if(householdMembers.size() == 0)
			{
				editHouseholdMemberButton.setEnabled(false);
				removeHouseholdMemberButton.setEnabled(false);
			}
		}
	}

	@Override
	public void goBackTo() 
	{
		householdMemberEditionDialog.setVisible(false);
				
		if(currentForm.getFormType() == FormType.ADD_HOUSEHOLD_MEMBER)
		{
			Object generatedObject = currentForm.getFormGeneratedObject();
			
			if(generatedObject != null)
			{
				householdMembers.add((HouseholdMember) generatedObject);
				
				householdMembersTable.revalidate();
			}
		}
		
		currentForm = null;
	}
	
	private class HouseholdMembersTableModel extends AbstractTableModel
	{ 
		private ArrayList<String> columnNames = new ArrayList<String>( );
		
		public HouseholdMembersTableModel()
		{			
			columnNames.add("Numéro national");
			columnNames.add("Nom");
			columnNames.add("Prénom");
			columnNames.add("2ème prénom");
			columnNames.add("3ème prénom");
			columnNames.add("4ème prénom");
			columnNames.add("5ème prénom");
			columnNames.add("Date de naissance");
		}

		@Override
		public int getColumnCount() 
		{
			return columnNames.size();
		}

		@Override
		public int getRowCount() 
		{
			return householdMembers.size();
		}

		@Override
		public String getColumnName(int columnIndex) 
		{
			return columnNames.get(columnIndex); 
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) 
		{
			HouseholdMember householdMember = householdMembers.get(rowIndex);
			
			switch(columnIndex)
			{ 
				case 0 : return householdMember.getNationalNumber();
				case 1 : return householdMember.getSurname();
				case 2 : 
				case 3 : 
				case 4 : 
				case 5 : 
				case 6 :
					return householdMember.getFirstNames()[columnIndex - 2];					
				
				case 7 : return householdMember.getBirthDate(); 
								
				default : return null;
			}
		}
		
		@Override
		public Class<?> getColumnClass(int columnIndex) 
		{
			switch(columnIndex)
			{ 
				case 0 : 
				case 1 : 
				case 2 : 
				case 3 : 
				case 4 : 
				case 5 : 			
				case 6 :
					return String.class;
								
				case 7 : return Date.class;
				
				default : return null;
			}
		}
	}
}
