package view.form;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerDateModel;

import model.Garage;
import model.PersonnelMember;
import model.Repair;
import model.enumerations.BikeState;

@SuppressWarnings("serial")
public class RepairEdition extends Form 
{
	private JLabel bikeNumberLabel, bikeStateLabel, startDateLabel, descriptionLabel, notesLabel, endDateLabel, repairerLabel, garageLabel;
	
	private JSpinner startDateSpinner, endDateSpinner;
	private JTextArea descriptionTextArea, notesTextArea;
	private JComboBox<Integer> bikeNumberComboBox;
	private JComboBox<BikeState> bikeStateComboBox;
	private JComboBox<PersonnelMember> repairerComboBox;
	private JComboBox<Garage> garageComboBox;
	
	private Repair formGeneratedObject;

	public RepairEdition(ArrayList<PersonnelMember> personnelMembers) 
	{
		super(FormType.ADD_REPAIR);
		
		buildDefaultDisplay(personnelMembers);
		
		bikeStateComboBox.setEnabled(false);
		startDateSpinner.setEnabled(false);
		notesTextArea.setEnabled(false);
		endDateSpinner.setVisible(false);		
	}

	public RepairEdition(Repair repair,	ArrayList<PersonnelMember> personnelMembers) 
	{
		super(FormType.EDIT_REPAIR);
		
		buildDefaultDisplay(personnelMembers);
		
		formGeneratedObject = repair;
		
		startDateSpinner.setValue(repair.getRepairStartDate());
		startDateSpinner.setEnabled(false);
				
		reset();
	}

	private void buildDefaultDisplay(ArrayList<PersonnelMember> personnelMembers) 
	{
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(" Edition d'une réparation : "), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.setLayout(new GridLayout(8, 2, 15, 5));
		
		bikeNumberLabel = new JLabel("Numéro du vélo* :");
		bikeNumberLabel.setLabelFor(bikeNumberComboBox);
		bikeNumberLabel.setToolTipText("Obligatoire");
		bikeNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
		bikeNumberComboBox = new JComboBox<Integer>();
		this.add(bikeNumberLabel);
		this.add(bikeNumberComboBox);
		
		bikeStateLabel = new JLabel("Etat du vélo :");
		bikeStateLabel.setLabelFor(bikeStateComboBox);
		bikeStateLabel.setHorizontalAlignment(JLabel.RIGHT);
		bikeStateComboBox = new JComboBox<BikeState>();
		this.add(bikeStateLabel);
		this.add(bikeStateComboBox);
		
		SpinnerDateModel dateSpinnerModel = new SpinnerDateModel();
		dateSpinnerModel.setStart(new Date(System.currentTimeMillis() - 150 * 31536000000l));
		dateSpinnerModel.setEnd(new Date(System.currentTimeMillis()));
				
		startDateLabel = new JLabel("Date d'entrée au garage :");
		startDateLabel.setLabelFor(startDateSpinner);
		startDateLabel.setHorizontalAlignment(JLabel.RIGHT);
		startDateSpinner = new JSpinner(dateSpinnerModel);
		startDateSpinner.setEditor(new JSpinner.DateEditor(startDateSpinner, "dd/MM/yyyy"));
		this.add(startDateLabel);
		this.add(startDateSpinner);
		
		descriptionLabel = new JLabel("Description du problème* :");
		descriptionLabel.setLabelFor(descriptionTextArea);
		descriptionLabel.setToolTipText("Obligatoire");
		descriptionLabel.setHorizontalAlignment(JLabel.RIGHT);
		descriptionTextArea = new JTextArea();
		this.add(descriptionLabel);
		this.add(descriptionTextArea);
		
		notesLabel = new JLabel("Remarques : ");
		notesLabel.setLabelFor(notesTextArea);
		notesLabel.setHorizontalAlignment(JLabel.RIGHT);
		notesTextArea = new JTextArea();
		this.add(notesLabel);
		this.add(notesTextArea);
		
		endDateLabel = new JLabel("Date de fin de réparation :");
		endDateLabel.setLabelFor(endDateSpinner);
		endDateLabel.setHorizontalAlignment(JLabel.RIGHT);
		endDateSpinner = new JSpinner(dateSpinnerModel);
		endDateSpinner.setEditor(new JSpinner.DateEditor(endDateSpinner, "dd/MM/yyyy"));
		this.add(endDateLabel);
		this.add(endDateSpinner);
		
		repairerLabel = new JLabel("Réparateur* :");
		repairerLabel.setLabelFor(repairerComboBox);
		repairerLabel.setToolTipText("Obligatoire");
		repairerLabel.setHorizontalAlignment(JLabel.RIGHT);
		repairerComboBox = new JComboBox<PersonnelMember>();
		this.add(repairerLabel);
		this.add(repairerComboBox);
		
		garageLabel = new JLabel("Garage* :");
		garageLabel.setLabelFor(garageComboBox);
		garageLabel.setToolTipText("Obligatoire");
		garageLabel.setHorizontalAlignment(JLabel.RIGHT);
		garageComboBox = new JComboBox<Garage>();
		this.add(garageLabel);
		this.add(garageComboBox);
	}

	@Override
	public void reset() 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean validateForm() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getFormGeneratedObject() 
	{
		return formGeneratedObject;
	}

}
