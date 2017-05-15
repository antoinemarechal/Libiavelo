package view.form;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerDateModel;

import exception.InvalidDateException;
import exception.NoDataException;
import model.Bike;
import model.Garage;
import model.PersonnelMember;
import model.Repair;
import model.enumerations.BikeState;
import model.enumerations.WorkType;

@SuppressWarnings("serial")
public class RepairEdition extends Form 
{
	private JLabel bikeNumberLabel, bikeStateLabel, startDateLabel, descriptionLabel, notesLabel, endDateLabel, repairerLabel, garageLabel;
	
	private JSpinner startDateSpinner, endDateSpinner;
	private JTextArea descriptionTextArea, notesTextArea;
	private JComboBox<Bike> bikeNumberComboBox;
	private JComboBox<BikeState> bikeStateComboBox;
	private JComboBox<PersonnelMember> repairerComboBox;
	private JComboBox<Garage> garageComboBox;
	
	private Repair formGeneratedObject;

	public RepairEdition(ArrayList<PersonnelMember> personnelMembers, ArrayList<Garage> garages, ArrayList<Bike> bikes) 
	{
		super(FormType.ADD_REPAIR);
		
		buildDefaultDisplay(new Date(System.currentTimeMillis()), personnelMembers, garages, bikes);
		
		bikeStateComboBox.setVisible(false);
		startDateSpinner.setEnabled(false);
		notesTextArea.setEnabled(false);
		endDateSpinner.setVisible(false);	
		
		reset();	
	}

	public RepairEdition(Repair repair,	ArrayList<PersonnelMember> personnelMembers, ArrayList<Garage> garages, ArrayList<Bike> bikes) 
	{
		super(FormType.EDIT_REPAIR);
		
		buildDefaultDisplay(repair.getRepairStartDate(), personnelMembers, garages, bikes);
		
		formGeneratedObject = repair;
		
		startDateSpinner.setValue(repair.getRepairStartDate());
		startDateSpinner.setEnabled(false);
				
		reset();
	}

	private void buildDefaultDisplay(Date repairStartDate, ArrayList<PersonnelMember> personnelMembers, ArrayList<Garage> garages, ArrayList<Bike> bikes) 
	{
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(" Edition d'une réparation : "), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.setLayout(new GridLayout(8, 2, 15, 5));
		
		bikeNumberLabel = new JLabel("Numéro du vélo* :");
		bikeNumberLabel.setLabelFor(bikeNumberComboBox);
		bikeNumberLabel.setToolTipText("Obligatoire");
		bikeNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
		bikeNumberComboBox = new JComboBox<Bike>();
		
		for(Bike b : bikes)
			bikeNumberComboBox.addItem(b);
		
		this.add(bikeNumberLabel);
		this.add(bikeNumberComboBox);
		
		bikeStateLabel = new JLabel("Etat du vélo :");
		bikeStateLabel.setLabelFor(bikeStateComboBox);
		bikeStateLabel.setHorizontalAlignment(JLabel.RIGHT);
		bikeStateComboBox = new JComboBox<BikeState>();
		
		for(BikeState bs : BikeState.values())
			bikeStateComboBox.addItem(bs);
		
		this.add(bikeStateLabel);
		this.add(bikeStateComboBox);
		
		startDateLabel = new JLabel("Date d'entrée au garage :");
		startDateLabel.setLabelFor(startDateSpinner);
		startDateLabel.setHorizontalAlignment(JLabel.RIGHT);
		startDateSpinner = new JSpinner(new SpinnerDateModel());
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

		SpinnerDateModel endDateSpinnerModel = new SpinnerDateModel();
		endDateSpinnerModel.setStart(repairStartDate);
		endDateSpinnerModel.setEnd(new Date(System.currentTimeMillis()));
		
		endDateLabel = new JLabel("Date de fin de réparation :");
		endDateLabel.setLabelFor(endDateSpinner);
		endDateLabel.setHorizontalAlignment(JLabel.RIGHT);
		endDateSpinner = new JSpinner(endDateSpinnerModel);
		endDateSpinner.setEditor(new JSpinner.DateEditor(endDateSpinner, "dd/MM/yyyy"));
		this.add(endDateLabel);
		this.add(endDateSpinner);
		
		repairerLabel = new JLabel("Réparateur* :");
		repairerLabel.setLabelFor(repairerComboBox);
		repairerLabel.setToolTipText("Obligatoire");
		repairerLabel.setHorizontalAlignment(JLabel.RIGHT);
		repairerComboBox = new JComboBox<PersonnelMember>();
		
		for(PersonnelMember pm : personnelMembers)
			if(pm.getFunction() == WorkType.REPAIRER)
				repairerComboBox.addItem(pm);
		
		this.add(repairerLabel);
		this.add(repairerComboBox);
		
		garageLabel = new JLabel("Garage* :");
		garageLabel.setLabelFor(garageComboBox);
		garageLabel.setToolTipText("Obligatoire");
		garageLabel.setHorizontalAlignment(JLabel.RIGHT);
		garageComboBox = new JComboBox<Garage>();
		
		for(Garage g : garages)
			garageComboBox.addItem(g);
		
		this.add(garageLabel);
		this.add(garageComboBox);
	}

	@Override
	public void reset() 
	{
		if(this.getFormType() == FormType.ADD_REPAIR)
		{
			bikeNumberComboBox.setSelectedItem(null);
			bikeStateComboBox.setSelectedItem(null);
			descriptionTextArea.setText("");
			notesTextArea.setText("");
			repairerComboBox.setSelectedItem(null);
			garageComboBox.setSelectedItem(null);
		}
		else if(this.getFormType() == FormType.EDIT_REPAIR)
		{
			bikeNumberComboBox.setSelectedItem(formGeneratedObject.getBike());
			bikeStateComboBox.setSelectedItem(formGeneratedObject.getBike().getState());
			descriptionTextArea.setText(formGeneratedObject.getDescription());
			notesTextArea.setText(formGeneratedObject.getNotes());
			
			if(formGeneratedObject == null)
				endDateSpinner.setValue(new Date(System.currentTimeMillis()));
			else
				endDateSpinner.setValue(formGeneratedObject.getRepairEndDate());
			
			repairerComboBox.setSelectedItem(formGeneratedObject.getVerifier());
			garageComboBox.setSelectedItem(formGeneratedObject.getGarage());
		}
	}

	@Override
	public boolean validateForm() 
	{
		NoDataException e = null;
		
		Bike bike = (Bike) bikeNumberComboBox.getSelectedItem();
		BikeState bikeState = (BikeState) bikeStateComboBox.getSelectedItem();
		Date startDate = (Date) startDateSpinner.getValue();
		String description = descriptionTextArea.getText();
		String notes = notesTextArea.getText();
		Date endDate = (Date) endDateSpinner.getValue();
		PersonnelMember repairer = (PersonnelMember) repairerComboBox.getSelectedItem();
		Garage garage = (Garage) garageComboBox.getSelectedItem();
		
		if(bike != null)
		{
			e = new NoDataException("Numéro du vélo");
		}
		else if(description.length() == 0)
		{
			e = new NoDataException("Description du problème");
		}
		else if(repairer != null)
		{
			e = new NoDataException("Réparateur");
		}
		else if(garage != null)
		{
			e = new NoDataException("Garage");
		}
		
		if(e == null)
		{
			try 
			{
				if(this.getFormType() == FormType.ADD_HOUSEHOLD_MEMBER)
				{
					formGeneratedObject = new Repair(bike, startDate, garage, repairer, description);
				}
				else if(this.getFormType() == FormType.EDIT_HOUSEHOLD_MEMBER)
				{
					formGeneratedObject.setBike(bike);
					formGeneratedObject.getBike().setState(bikeState);
					formGeneratedObject.setDescription(description);
					formGeneratedObject.setNotes(notes);
					formGeneratedObject.setEndDate(endDate);
					formGeneratedObject.setVerifier(repairer);
					formGeneratedObject.setGarage(garage);
				}
			} 
			catch (NoDataException | InvalidDateException e1) 
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
