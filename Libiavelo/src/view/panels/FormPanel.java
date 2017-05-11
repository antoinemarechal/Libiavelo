package view.panels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.Window;
import controller.ApplicationController;
import exception.InvalidNumberException;
import exception.NoDataException;
import exception.NotANumberException;
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
			switch (form.getFormType()) {// TODO : indiquer le champ d'où vient l'erreur dans le popup
				case ADD_CLIENT :
					try  {
						NewClient panel = (NewClient) form;
						
						Integer nationalNumber = panel.getNationalNumber();
						String homeNumber = panel.getHomeNumber();
						String phoneNumber = panel.getPhoneNumber();
						String clientSurname = panel.getSurname();
						String[] clientFirstNames = panel.getFirstnames();
						Boolean subscriptionValidated = false;
						Double depositAmount = 50.0; // TODO : fix value, see dossier
						String streetNumber = panel.getStreetNumber();
						String streetName = panel.getStreetName();
						Date subscriptionDate = new Date(System.currentTimeMillis()); // TODO : optionnel : faire façon cours avec greg calendar
												
						Client client = new Client(nationalNumber, homeNumber, phoneNumber, clientSurname, clientFirstNames, subscriptionValidated, depositAmount, streetNumber, streetName, subscriptionDate);
								
						ApplicationController appController = new ApplicationController();
						appController.addClient(client);

						int addMember = JOptionPane.showConfirmDialog(parent, "Souhaiez-vous ajouter quelqu'un à cette abonnement ?", "Ajouter du monde", JOptionPane.YES_NO_OPTION);
						if (addMember == JOptionPane.OK_OPTION) {
							if (parent != null && parent instanceof Window) 
							((Window) parent).changeToHouseholdMemberForm();
						}
							
						else if (addMember == JOptionPane.NO_OPTION) {
							// TODO	: décider de l'affichage et afficher
						}
								
					} 
					catch (InvalidNumberException | NoDataException | NotANumberException e) {
						JOptionPane.showMessageDialog(parent, e.toString());
					}					
					break;
					
				case ADD_HOUSEHOLD_MEMBER :
					try {
						NewHouseholdMember panel = (NewHouseholdMember) form;
					
						Date birthDate = panel.getBirthDate();	
						String clientSurname = panel.getSurname();
						String[] firstNames = panel.getFirstnames();
						int nationalNumber = panel.getNationalNumber();
						Client client = null; // TODO : Quid de l'ajout du membre de ménage à quoi comment et où ?
						HouseholdMember householdmember = new HouseholdMember(nationalNumber);
						
						ApplicationController appController = new ApplicationController();
						appController.addHouseholdMember(householdmember, client);
						
						int addMember = JOptionPane.showConfirmDialog(parent, "Souhaiez-vous ajouter quelqu'un à cette abonnement ?", "Ajouter du monde", JOptionPane.YES_NO_OPTION);
						if (addMember == JOptionPane.OK_OPTION) {
							if (parent != null && parent instanceof Window) 
							((Window) parent).changeToHouseholdMemberForm();
						}
							
						else if (addMember == JOptionPane.NO_OPTION) {
							// TODO	: décider de la réaction et réagir
						}
					} 
					catch (InvalidNumberException | NoDataException | NotANumberException e1) {
						JOptionPane.showMessageDialog(parent, e1.toString());
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