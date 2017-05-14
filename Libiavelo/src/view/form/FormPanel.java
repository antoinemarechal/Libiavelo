package view.form;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ApplicationController;
import model.Client;
import model.Locality;

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
			previous.goBackTo();
		}
		else if(event.getSource() == validateButton) {

			if(form.validateForm())
			{
				ApplicationController appController = new ApplicationController();
				
				switch (form.getFormType()) {
					case ADD_CLIENT :
						Client client = (Client) form.getFormGeneratedObject();
						
						appController.addClient(client);
						
						previous.goBackTo();
						break;
						
					case EDIT_CLIENT :
						//Client client = (Client) form.getFormGeneratedObject();
						
						// FIXME : appController.addClient(client);
						
						previous.goBackTo();
						break;
						
					case ADD_LOCALITY :
						Locality locality = (Locality) form.getFormGeneratedObject();
						
						appController.addLocality(locality);
						
						previous.goBackTo();
						break;
						
					case ADD_HOUSEHOLD_MEMBER :
					case EDIT_HOUSEHOLD_MEMBER :
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
