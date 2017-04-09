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
import controller.ConfirmationButtonService;
import exception.InvalidNumberException;
import exception.NoDataException;
import exception.NotANumberException;

@SuppressWarnings("serial")
public class FormPanel extends JPanel implements ActionListener
{
	private Component parent;
	
	private JButton backButton;
	private JButton validateButton;
	private JButton resetButton;
	
	private Form form;
	
	public FormPanel(Form form, Component parent)
	{
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
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == backButton)
		{
			if(parent != null && parent instanceof Window)
			{
				((Window) parent).returnToMainMenu();
			}
		}
		else if(event.getSource() == validateButton)
		{
			switch (form.getFormType()) // TODO : indiquer le champ d'où vient l'erreur dans le popup
			{
				case ADD_CLIENT :
					try 
					{
						NewClient panel = (NewClient) form;
						
						int nationalNumber = panel.getNationalNumber();
						String homeNumber = panel.getHomeNumber();
						String phoneNumber = panel.getPhoneNumber();
						String surname = panel.getSurname();
						String[] firstNames = panel.getFirstnames();
								
						ConfirmationButtonService.addClient(nationalNumber, homeNumber, phoneNumber, surname, firstNames, false, 0, null, null, null, null);
						
						if(parent != null && parent instanceof Window)
						{
							((Window) parent).changeToHouseholdMemberForm();
						}						
					} 
					catch (InvalidNumberException | NoDataException | NotANumberException e) 
					{
						JOptionPane.showMessageDialog(parent, e.toString());
					}
					break;
					
				case ADD_HOUSEHOLD_MEMBER :
					try 
					{
						NewHouseholdMember panel = (NewHouseholdMember) form;
					
						Date birthDate = panel.getBirthDate();	
						String clientSurname = panel.getSurname();
						String[] firstNames = panel.getFirstnames();
						int nationalNumber = panel.getNationalNumber();
						ConfirmationButtonService.addHouseholdMember(birthDate, firstNames, nationalNumber, clientSurname);
					} 
					catch (InvalidNumberException | NoDataException | NotANumberException e1) 
					{
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
		{
			form.reset();
		}
	}
}

