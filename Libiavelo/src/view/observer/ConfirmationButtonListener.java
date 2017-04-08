package view.observer;

import view.Main;
import view.button.ConfirmationButton;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import controller.ConfirmationButtonService;
import exception.EmptyStringException;
import exception.InvalidNumberException;
import exception.NotANumberException;
import view.panel.AddClient;
import view.panel.AddHouseholdMember;

public class ConfirmationButtonListener implements ActionListener {
	ConfirmationButton confirmationButton;
	
	public ConfirmationButtonListener(ConfirmationButton confirmationButton) {
		this.confirmationButton = confirmationButton;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		switch (confirmationButton.getPanelType()) {
		case ADDCLIENT :
			try {
				AddClient panel = (AddClient) confirmationButton.getPanel();
				
				int nationalNumber = panel.getNationalNumber();
				String homeNumber = panel.getHomeNumber();
				String phoneNumber = panel.getPhoneNumber();
				String surname = panel.getSurname();
				String[] firstNames = panel.getFirstnames();
						
				ConfirmationButtonService.addClient(nationalNumber, homeNumber, phoneNumber, surname, firstNames, false, 0, null, null, null, null);
				
				Container container = new Container();
				
				/*AddHouseholdMember formPanel = new AddHouseholdMember();
				
				container.add(formPanel);
				container.setSize(500, 500);
				Main.mainWindow.setContentPane(container);
			just a test
				*/			
				
			} catch (InvalidNumberException | EmptyStringException | NotANumberException e) {
				JOptionPane.showMessageDialog(null, e.toString());
			}
			break;
			
		case ADDHOUSEHOLDMEMBER:
			AddHouseholdMember panel = (AddHouseholdMember) confirmationButton.getPanel();
			try {
				Date birthDate = panel.getBirthDate();	
				String clientSurname = panel.getSurname();
				String[] firstNames = panel.getFirstnames();
				int nationalNumber = panel.getNationalNumber();
				ConfirmationButtonService.addHouseholdMember(birthDate, firstNames, nationalNumber, clientSurname);
			} catch (InvalidNumberException | EmptyStringException | NotANumberException e) {
				JOptionPane.showMessageDialog(null, e.toString());
			}
			break;
			
		case SEARCH1:
			break;
			
		case SEARCH2:
			break;
			
		case SEARCH3:
			break;
			
		default:
			break;
		}
	}
}
