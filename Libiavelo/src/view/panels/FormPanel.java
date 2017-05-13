package view.panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ApplicationController;
import model.Client;

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
				switch (form.getFormType()) {
					case ADD_CLIENT :
						Client client = (Client) form.getFormGeneratedObject();
						
						ApplicationController appController = new ApplicationController();
						appController.addClient(client);
						
						previous.goBackTo();
						break;
						
					case ADD_HOUSEHOLD_MEMBER :
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
		}
		else if(event.getSource() == resetButton)
			form.reset();
	}
}
