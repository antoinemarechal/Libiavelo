package view.panels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.Window;
import controller.ApplicationController;
import model.Client;
import model.HouseholdMember;

@SuppressWarnings("serial")
public class FormPanel extends JPanel implements ActionListener {
	private Component parent;
	
	private JButton backButton;
	private JButton validateButton;
	private JButton resetButton;
	
	private Form form;
	
	public FormPanel(Form form, Component parent) {
		super();
		
		this.parent = parent;
		this.form = form;
		
		this.setLayout(new BorderLayout());		
		
		JPanel buttonsPanel = new JPanel();
			
			backButton = new JButton("Retour");
			backButton.addActionListener(this);
			
			validateButton = new JButton("Valider");
			validateButton.addActionListener(this);
			
			resetButton = new JButton("Réinitialiser");
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
			if(parent != null && parent instanceof Window)
				((Window) parent).returnToMainMenu();
		}
		
		else if(event.getSource() == validateButton) {
			switch (form.getFormType()) {
				case ADD_CLIENT :
					NewClient clientPanel = (NewClient) form;
					
					Client client = clientPanel.getEnteredClient();
					if (client != null) {
						ApplicationController appController = new ApplicationController();
						appController.addClient(client);
						int addMember = JOptionPane.showConfirmDialog(parent, "Souhaiez-vous ajouter quelqu'un à cette abonnement ?", "Ajouter du monde", JOptionPane.YES_NO_OPTION);
						if (addMember == JOptionPane.OK_OPTION) {
							if (parent != null && parent instanceof Window) 
								((Window) parent).changeToHouseholdMemberForm();
						}
							
						else if (addMember == JOptionPane.NO_OPTION) {
							if (parent != null && parent instanceof Window) 
								((Window) parent).returnToMainMenu();
						}	
					}
								
					break;
					
				case ADD_HOUSEHOLD_MEMBER :
					NewHouseholdMember panel = (NewHouseholdMember) form;
					HouseholdMember householdmember = panel.getEnteredHouseholdMember();
					if (householdmember != null) {
						ApplicationController appController = new ApplicationController();
						appController.addHouseholdMember(householdmember, null); // FIXME : related to ajout membre mén.
						int addMember = JOptionPane.showConfirmDialog(parent, "Souhaiez-vous ajouter quelqu'un à cette abonnement ?", "Ajouter du monde", JOptionPane.YES_NO_OPTION);
						if (addMember == JOptionPane.OK_OPTION) {
							if (parent != null && parent instanceof Window) 
								((Window) parent).changeToHouseholdMemberForm();
						}
							
						else if (addMember == JOptionPane.NO_OPTION) {
							if (parent != null && parent instanceof Window) 
								((Window) parent).returnToMainMenu();
						}
					}					
					break;
					
				case SEARCH1 :
					break;
					
				case SEARCH2 :
					break;
					
				case SEARCH3 :
					break;
					
				default :
					break;
			}
		}
		else if(event.getSource() == resetButton)
			form.reset();
	}
}