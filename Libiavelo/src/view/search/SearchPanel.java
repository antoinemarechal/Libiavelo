package view.search;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ApplicationController;
import model.enumerations.BikeState;


@SuppressWarnings("serial")
public class SearchPanel extends JPanel implements ActionListener {
	
	private JButton validateButton;
	private JButton resetButton;
	
	private Search search;
	
	private ApplicationController applicationController;
	
	public SearchPanel(Search search) {
		super();
	
		this.search = search;
		
		this.setLayout(new BorderLayout());		
		
		JPanel buttonsPanel = new JPanel();
			
			validateButton = new JButton("Valider");
			validateButton.addActionListener(this);
			
			resetButton = new JButton("Réinitialiser");
			resetButton.addActionListener(this);
	
			buttonsPanel.add(validateButton);
			buttonsPanel.add(resetButton);
			
		this.add(search, BorderLayout.CENTER);
		this.add(buttonsPanel, BorderLayout.SOUTH);
		applicationController = new ApplicationController();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == validateButton) {
			switch (search.getSearchType()) {
				case SEARCH1 :
					Date date = new Date(((Search1) search).getInputDate().getTime());
					applicationController.getSearch1Data(date,((Search1) search).getIsExceptionnal(), ((Search1) search).getIsAvailable());
					break;
						
				case SEARCH2 :
					Date startDate = new Date(((Search2) search).getStartDate().getTime());
					Date endDate = new Date(((Search2) search).getEndDate().getTime());
					BikeState bikeState = ((Search2) search).getBikeState();
					System.out.println(startDate);
					System.out.println(endDate);
					System.out.println(bikeState.name());
					applicationController.getSearch2Data(startDate, endDate, bikeState);
					break;
						
				case SEARCH3 :
					Boolean isValid = ((Search3) search).getSubscriptionValidity();
					Date dateThreshold =  new Date(((Search3) search).getDate().getTime());
					Float minimumAmount = ((Search3) search).getMinimumAmount();
					applicationController.getSearch3Data(isValid, dateThreshold, minimumAmount);
					break;
						
				default :
					break;
			}
		}
		else if(event.getSource() == resetButton)
			search.reset();
	}
}
