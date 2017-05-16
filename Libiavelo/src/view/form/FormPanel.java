package view.form;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.PreviousPanel;
import controller.ApplicationController;
import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import model.Client;
import model.Locality;
import model.Repair;

@SuppressWarnings("serial")
public class FormPanel extends JPanel implements ActionListener {
	
	private PreviousPanel previous;
	
	private JButton backButton;
	private JButton validateButton;
	private JButton resetButton;
	
	private Form form;
	
	public FormPanel(Form form, PreviousPanel previous) {
		super();
		
		this.previous = previous;
		this.form = form;
		
		this.setLayout(new BorderLayout());		
		
		JPanel buttonsPanel = new JPanel();
			
			backButton = new JButton("Retour");
			backButton.addActionListener(this);
			
			validateButton = new JButton("Valider");
			validateButton.addActionListener(this);
			
			resetButton = new JButton("R�initialiser");
			resetButton.addActionListener(this);
	
			buttonsPanel.add(backButton);
			buttonsPanel.add(validateButton);
			buttonsPanel.add(resetButton);
			
		this.add(form, BorderLayout.CENTER);
		this.add(buttonsPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == backButton) {
			previous.goBackTo();
		}
		else if(event.getSource() == validateButton) {

			if(form.validateForm())
			{
				ApplicationController appController = new ApplicationController();
				
				switch (form.getFormType()) {
					case ADD_CLIENT :
						Client client = (Client) form.getFormGeneratedObject();
						
						try 
						{
							appController.addClient(client);
						} 
						catch (DataAccessConnectionException | DataAccessOperationException e) 
						{
							JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur d'acc�s aux donn�es", JOptionPane.ERROR_MESSAGE);
						}
						
						previous.goBackTo();
						break;
						
					case EDIT_CLIENT :
						Client clientBis = (Client) form.getFormGeneratedObject();
						
						try 
						{
							appController.updateClient(clientBis);
						} 
						catch (DataAccessConnectionException | DataAccessOperationException e) 
						{
							JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur d'acc�s aux donn�es", JOptionPane.ERROR_MESSAGE);
						}
						
						previous.goBackTo();
						break;
						
					case ADD_LOCALITY :
						Locality locality = (Locality) form.getFormGeneratedObject();
						
						try 
						{
							appController.addLocality(locality);
						} 
						catch (DataAccessConnectionException | DataAccessOperationException e) 
						{
							JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur d'acc�s aux donn�es", JOptionPane.ERROR_MESSAGE);
						}
						
						previous.goBackTo();
						break;
						
					case ADD_HOUSEHOLD_MEMBER :
					case EDIT_HOUSEHOLD_MEMBER :
						previous.goBackTo();
						break;
						
					case ADD_REPAIR :
						Repair repair = (Repair) form.getFormGeneratedObject();
						
						try 
						{
							appController.addRepair(repair);
						} 
						catch (DataAccessConnectionException | DataAccessOperationException e) 
						{
							JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur d'acc�s aux donn�es", JOptionPane.ERROR_MESSAGE);
						}
						
						previous.goBackTo();
						break;
						
					case EDIT_REPAIR :
						Repair repairBis = (Repair) form.getFormGeneratedObject();
						
						try 
						{
							appController.updateRepair(repairBis);
							appController.updateBike(repairBis.getBike());
						} 
						catch (DataAccessConnectionException | DataAccessOperationException e) 
						{
							JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur d'acc�s aux donn�es", JOptionPane.ERROR_MESSAGE);
						}
						
						previous.goBackTo();
						break;
						
					default :
						break;
				}
			}
		}
		else if(event.getSource() == resetButton)
			form.reset();
	}
}
