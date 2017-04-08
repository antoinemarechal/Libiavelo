package view.observers;

import view.Main;
import view.buttons.ConfirmationButton;
import view.panels.NewClient;
import view.panels.NewHouseholdMember;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import controller.ConfirmationButtonService;
import exception.NoDataException;
import exception.InvalidNumberException;
import exception.NotANumberException;

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
				NewClient panel = (NewClient) confirmationButton.getPanel();
				
				int nationalNumber = panel.getNationalNumber();
				String homeNumber = panel.getHomeNumber();
				String phoneNumber = panel.getPhoneNumber();
				String surname = panel.getSurname();
				String[] firstNames = panel.getFirstnames();
						
				ConfirmationButtonService.addClient(nationalNumber, homeNumber, phoneNumber, surname, firstNames, false, 0, null, null, null, null);
				
				
				
				NewHouseholdMember formPanel = new NewHouseholdMember();
				Main.mainWindow.getContentPane().removeAll();
				Main.mainWindow.getContentPane().add(formPanel);
				Main.mainWindow.repaint();
				
			} catch (InvalidNumberException | NoDataException | NotANumberException e) {
				JOptionPane.showMessageDialog(null, e.toString());
			}
			break;
			
		case ADDHOUSEHOLDMEMBER:
			NewHouseholdMember panel = (NewHouseholdMember) confirmationButton.getPanel();
			try {
				Date birthDate = panel.getBirthDate();	
				String clientSurname = panel.getSurname();
				String[] firstNames = panel.getFirstnames();
				int nationalNumber = panel.getNationalNumber();
				ConfirmationButtonService.addHouseholdMember(birthDate, firstNames, nationalNumber, clientSurname);
			} catch (InvalidNumberException | NoDataException | NotANumberException e) {
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
