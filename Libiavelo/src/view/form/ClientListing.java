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

import model.Client;
import model.Locality;
import controller.ApplicationController;

@SuppressWarnings("serial")
public class ClientListing extends JPanel implements ActionListener, ListSelectionListener, PreviousPanel
{
	private ArrayList<Client> clientsListing = new ArrayList<Client>();
	private ArrayList<Locality> localities = new ArrayList<Locality>( );
	
	private JButton backButton;
	private JButton addClientButton;
	private JButton editClientButton;
	private JButton removeClientButton;
	
	private JTable clientsTable;
	
	private Form currentForm = null;
	
	private PreviousPanel previous;
	
	public ClientListing(PreviousPanel previous) 
	{
		super();
		
		this.previous = previous;
		
		ApplicationController appController = new ApplicationController();
		clientsListing = appController.getAllClients();
		localities = appController.getAllLocalities();
				
		clientsTable = new JTable();
		clientsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		clientsTable.setModel(new ClientsTableModel());
		clientsTable.getSelectionModel().addListSelectionListener(this);
		clientsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		for(int i = 0; i < clientsTable.getColumnCount(); i++)
		{
			clientsTable.getColumnModel().getColumn(i).setPreferredWidth(100);;
		}
		
		backButton = new JButton("Retour");
		backButton.addActionListener(this);
		
		addClientButton = new JButton("Nouveau client");
		addClientButton.addActionListener(this);
			
		editClientButton = new JButton("Editer");
		editClientButton.addActionListener(this);
		editClientButton.setEnabled(false);
			
		removeClientButton = new JButton("Supprimer");
		removeClientButton.addActionListener(this);
		removeClientButton.setEnabled(false);
		
		this.setLayout(new BorderLayout());

		buildDefaultDisplay();
	}

	private void buildDefaultDisplay() 
	{
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(" Clients inscrits : "), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(backButton);
		buttonsPanel.add(addClientButton);
		buttonsPanel.add(editClientButton);
		buttonsPanel.add(removeClientButton);
		
		JScrollPane clientsScrollPane = new JScrollPane(clientsTable);
		
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
		else if(e.getSource() == addClientButton)
		{
			this.removeAll();
			this.setBorder(null);
			
			currentForm = new ClientEdition(localities);
			
			this.add(new FormPanel(currentForm, this), BorderLayout.CENTER);
		}
		else if(e.getSource() == editClientButton)
		{
			this.removeAll();
			this.setBorder(null);
			
			currentForm = new ClientEdition(clientsListing.get(clientsTable.getSelectedRow()), localities);
			
			this.add(new FormPanel(currentForm, this), BorderLayout.CENTER);
		}
		else if(e.getSource() == removeClientButton)
		{
			//ApplicationController appController = new ApplicationController();
			//appController.removeClient(clientsListing.get(clientsTable.getSelectedRow()));
			
			clientsListing.remove(clientsTable.getSelectedRow());
			
			clientsTable.revalidate();
			
			if(clientsListing.size() == 0)
			{
				editClientButton.setEnabled(false);
				removeClientButton.setEnabled(false);
			}
		}
	}

	@Override
	public void goBackTo() 
	{
		this.removeAll();
		
		if(currentForm.getFormType() == FormType.ADD_CLIENT)
		{
			Object generatedObject = currentForm.getFormGeneratedObject();
			
			if(generatedObject != null)
			{
				clientsListing.add((Client) generatedObject);
				
				clientsTable.revalidate();
			}
		}
		
		currentForm = null;
		
		buildDefaultDisplay();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) 
	{
		if(!e.getValueIsAdjusting() && clientsTable.getSelectedRow() > -1)
		{
			if(clientsTable.getSelectedRowCount() == 1)
			{
				editClientButton.setEnabled(true);
				removeClientButton.setEnabled(true);
			}
			else
			{	
				editClientButton.setEnabled(false);
				removeClientButton.setEnabled(false);
			}
		}		
	}
	
	private class ClientsTableModel extends AbstractTableModel
	{ 
		private ArrayList<String> columnNames = new ArrayList<String>( );
		
		public ClientsTableModel()
		{			
			columnNames.add("Nom");
			columnNames.add("Prénom");
			columnNames.add("2ème prénom");
			columnNames.add("3ème prénom");
			columnNames.add("4ème prénom");
			columnNames.add("5ème prénom");
			columnNames.add("Numéro national");
			columnNames.add("Localité");
			columnNames.add("Nom de rue");
			columnNames.add("Numéro de rue");			
			columnNames.add("Numéro fixe");
			columnNames.add("Numéro gsm");			
			columnNames.add("Date d'inscription");
			columnNames.add("Caution restante");
			columnNames.add("Inscription validée");
		}

		@Override
		public int getColumnCount() 
		{
			return columnNames.size();
		}

		@Override
		public int getRowCount() 
		{
			return clientsListing.size();
		}

		@Override
		public String getColumnName(int columnIndex) 
		{
			return columnNames.get(columnIndex); 
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) 
		{
			Client client = clientsListing.get(rowIndex);
			
			switch(columnIndex)
			{ 
				case  0 : return client.getSurname();
				
				case  1 : 
				case  2 : 
				case  3 : 
				case  4 : 
				case  5 : 
					return client.getFirstNames()[columnIndex - 1];
				
				case  6 : return client.getNationalNumber();
				case  7 : return client.getLocality().getCityName(); 
				case  8 : return client.getStreetName();
				case  9 : return client.getStreetNumber();
				case 10 : return client.getHomeNumber();
				case 11 : return client.getPhoneNumber();
				case 12 : return client.getSubscriptionDate();
				case 13 : return client.getDepositAmount();
				case 14 : return client.isSubsriptionValidated();
				
				default : return null;
			}
		}
		
		@Override
		public Class<?> getColumnClass(int columnIndex) 
		{
			switch(columnIndex)
			{ 
				case  0 : 
				case  1 : 
				case  2 : 
				case  3 : 
				case  4 : 
				case  5 : 			
				case  6 :
				case  7 :
				case  8 : 
				case  9 : 
				case 10 :
				case 11 :
					return String.class;
								
				case 12 : return Date.class;
				case 13 : return Integer.class;
				case 14 : return Boolean.class;
				
				default : return null;
			}
		}
	}
}
