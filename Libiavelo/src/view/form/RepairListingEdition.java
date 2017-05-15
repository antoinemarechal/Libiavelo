package view.form;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import controller.ApplicationController;
import model.Bike;
import model.Garage;
import model.PersonnelMember;
import model.Repair;
import view.PreviousPanel;

@SuppressWarnings("serial")
public class RepairListingEdition extends JPanel implements ActionListener, ListSelectionListener, PreviousPanel 
{
	private ArrayList<Repair> repairsListing;
	private ArrayList<PersonnelMember> personnelMembers;
	private ArrayList<Garage> garages;
	private ArrayList<Bike> bikes;
	
	private JButton backButton;
	private JButton addRepairButton;
	private JButton editRepairButton;
	
	private JTable repairsTable;
	
	private Form currentForm = null;
	
	private PreviousPanel previous;
	
	public RepairListingEdition(PreviousPanel previous) 
	{
		super();
		
		this.previous = previous;
		
		ApplicationController appController = new ApplicationController();
		repairsListing = appController.getAllRepairs();
		personnelMembers = appController.getAllPersonnelMembers();
		garages = appController.getAllGarages();
		bikes = appController.getAllBikes();
		
		repairsTable = new JTable();
		repairsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		repairsTable.setModel(new RepairsTableModel());
		repairsTable.getSelectionModel().addListSelectionListener(this);
		repairsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		for(int i = 0; i < repairsTable.getColumnCount(); i++)
		{
			repairsTable.getColumnModel().getColumn(i).setPreferredWidth(150);
		}
		
		backButton = new JButton("Retour");
		backButton.addActionListener(this);
		
		addRepairButton = new JButton("Nouvelle réparation");
		addRepairButton.addActionListener(this);
			
		editRepairButton = new JButton("Editer");
		editRepairButton.addActionListener(this);
		editRepairButton.setEnabled(false);
		
		this.setLayout(new BorderLayout());

		buildDefaultDisplay();
	}
	
	private void buildDefaultDisplay() 
	{
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(" Liste des réparations : "), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(backButton);
		buttonsPanel.add(addRepairButton);
		buttonsPanel.add(editRepairButton);
		
		JScrollPane clientsScrollPane = new JScrollPane(repairsTable);
		
		this.add(clientsScrollPane, BorderLayout.CENTER);
		this.add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == backButton)
		{
			previous.goBackTo();
		}	
		else if(e.getSource() == addRepairButton)
		{
			this.removeAll();
			this.setBorder(null);
			
			currentForm = new RepairEdition(personnelMembers, garages, bikes);
			
			this.add(new FormPanel(currentForm, this), BorderLayout.CENTER);
		}
		else if(e.getSource() == editRepairButton)
		{
			this.removeAll();
			this.setBorder(null);
			
			currentForm = new RepairEdition(repairsListing.get(repairsTable.getSelectedRow()), personnelMembers, garages, bikes);
			
			this.add(new FormPanel(currentForm, this), BorderLayout.CENTER);
		}
	}
	
	@Override
	public void goBackTo() 
	{
		this.removeAll();
		
		if(currentForm.getFormType() == FormType.ADD_REPAIR)
		{
			Object generatedObject = currentForm.getFormGeneratedObject();
			
			if(generatedObject != null)
			{
				repairsListing.add((Repair) generatedObject);
				
				repairsTable.revalidate();
			}
		}
		
		currentForm = null;
		
		buildDefaultDisplay();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) 
	{
		if(!e.getValueIsAdjusting() && repairsTable.getSelectedRow() > -1)
		{
			if(repairsTable.getSelectedRowCount() == 1)
			{
				editRepairButton.setEnabled(true);
			}
			else
			{	
				editRepairButton.setEnabled(false);
			}
		}		
	}
	
	private class RepairsTableModel extends AbstractTableModel
	{ 
		private ArrayList<String> columnNames = new ArrayList<String>( );
		
		public RepairsTableModel()
		{			
			columnNames.add("Numéro de vélo");
			columnNames.add("Date d'entrée au garage");
			columnNames.add("Description du problème");
			columnNames.add("Réparateur");
			columnNames.add("Remarques");
			columnNames.add("Date de fin des réparations");
			columnNames.add("Garage");
		}

		@Override
		public int getColumnCount() 
		{
			return columnNames.size();
		}

		@Override
		public int getRowCount() 
		{
			return repairsListing.size();
		}

		@Override
		public String getColumnName(int columnIndex) 
		{
			return columnNames.get(columnIndex); 
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) 
		{
			Repair repair = repairsListing.get(rowIndex);
			
			switch(columnIndex)
			{ 
				case 0 : return repair.getBike().getId();
				case 1 : return repair.getRepairStartDate();
				case 2 : return repair.getDescription();
				case 3 : 
					if(repair.getVerifier() == null)
						return "";
					else
						return repair.getVerifier().getSurname() + " " + repair.getVerifier().getFirstNames()[0];
				
				case 4 : return repair.getNotes();
				case 5 : return repair.getRepairEndDate();
				case 6 : return repair.getGarage().getDescription(); 
								
				default : return null;
			}
		}
		
		@Override
		public Class<?> getColumnClass(int columnIndex) 
		{
			switch(columnIndex)
			{ 
				case 0 : return Integer.class;
				
				case 1 : 
				case 5 : 
					return Date.class;
					
				case 2 : 
				case 3 : 
				case 4 : 		
				case 6 :
					return String.class;
				
				default : return null;
			}
		}
	}
}
