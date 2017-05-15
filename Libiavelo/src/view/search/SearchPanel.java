package view.search;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ApplicationController;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JTable;

import exception.DataAccessConnectionException;
import exception.DataAccessOperationException;
import model.enumerations.BikeState;
import view.Window;


@SuppressWarnings("serial")
public class SearchPanel extends JPanel implements ActionListener {
	private boolean isSearch;
        
	private JButton validateButton, resetButton, leaveButton, backToSearchButton;
	
    private JPanel searchButtonPanel, resultButtonPanel;
	private Search search;
	
	private ApplicationController applicationController;
	private Window window;
        
	public SearchPanel(Search search, boolean isSearch) {
		super();
        this.setLayout(new BorderLayout());
		this.search = search;
		searchButtonPanel = new JPanel();
			
			validateButton = new JButton("Valider");
			validateButton.addActionListener(this);
			
			resetButton = new JButton("Reinitialiser");
			resetButton.addActionListener(this);
	
			searchButtonPanel.add(validateButton);
			searchButtonPanel.add(resetButton);
                        
		resultButtonPanel = new JPanel();
			
			leaveButton = new JButton("Quitter");
			leaveButton.addActionListener(this);
			
			backToSearchButton = new JButton("Retour a la recherche");
			backToSearchButton.addActionListener(this);
	
			resultButtonPanel.add(leaveButton);
			resultButtonPanel.add(backToSearchButton);

		applicationController = new ApplicationController();
        this.isSearch = isSearch;
        this.switchToSearch(search);
        this.setVisible(true);
	}       
        
    public void switchToSearch(Search search) {
    	this.removeAll();
        this.setLayout(new BorderLayout());
        isSearch = true;
        this.search = search;
        this.add(search, BorderLayout.CENTER);
        this.add(searchButtonPanel, BorderLayout.SOUTH);	
        this.setVisible(true);
        this.repaint();
        }
        
    public void swtichToResult(Search search) {
            this.removeAll();
            this.setLayout(new BorderLayout());
            isSearch = false;
            this.search = search;
            this.add(search, BorderLayout.CENTER);
            this.add(resultButtonPanel, BorderLayout.SOUTH);
            this.setVisible(true);
            this.repaint();
        }
        
	@Override
	public void actionPerformed(ActionEvent event) {
		if (isSearch) {
			ArrayList<ArrayList<Object>> data;
            JTable table;
            if(event.getSource() == validateButton) {
            	switch (search.getSearchType()) {
                	case SEARCH1 :
                		Date date = new Date(((Search1) search).getInputDate().getTime());
					
                		try {
							data = applicationController.getSearch1Data(date,((Search1) search).getIsExceptionnal(), ((Search1) search).getIsAvailable());
	                        Search1Model search1DataModel = new Search1Model(data);
	                        table = new JTable(search1DataModel);
	                        this.swtichToResult(new Search1Result(search, table));
						} 
                		catch (DataAccessConnectionException | DataAccessOperationException e) {
                			JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur d'accès aux données", JOptionPane.ERROR_MESSAGE);
						}
                        break;
						
                    case SEARCH2 :
                        Date startDate = new Date(((Search2) search).getStartDate().getTime());
                        Date endDate = new Date(((Search2) search).getEndDate().getTime());
                        BikeState bikeState = ((Search2) search).getBikeState();
						
                        try {
							data = applicationController.getSearch2Data(startDate, endDate, bikeState);
	                        Search2Model search2DataModel = new Search2Model(data);
	                        table = new JTable(search2DataModel);
	                        this.swtichToResult(new Search2Result(search, table));  
						} 
						catch (DataAccessConnectionException | DataAccessOperationException e) {
                			JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur d'accès aux données", JOptionPane.ERROR_MESSAGE);
						}                  
                        break;
						
                    case SEARCH3 :
                        Boolean isValid = ((Search3) search).getSubscriptionValidity();
                        Date dateThreshold =  new Date(((Search3) search).getDate().getTime());
                        Float minimumAmount = ((Search3) search).getMinimumAmount();
						
                        try {
							data = applicationController.getSearch3Data(isValid, dateThreshold, minimumAmount);
	                        Search3Model search3DataModel = new Search3Model(data);
	                        table = new JTable(search3DataModel);
	                        this.swtichToResult(new Search3Result(search, table));
						} 
                        catch (DataAccessConnectionException | DataAccessOperationException e) {
                			JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur d'accès aux données", JOptionPane.ERROR_MESSAGE);
						}
                        break;
                        
                    default :
                    	break;
            	}
            }
            else if(event.getSource() == resetButton)
            	window.goBackTo();
            }
		else {
			if(event.getSource() == backToSearchButton) {
				switch (search.getSearchType()) {
                	case SEARCH1RESULT :
                		this.switchToSearch(search.getSearch());
                        break;
						
                	case SEARCH2RESULT :
                	   	this.switchToSearch(search.getSearch());
                        break;
						
                	case SEARCH3RESULT :
                		this.switchToSearch(search.getSearch());
                		break;
                        
                	default :
                		break;
                }
            }
			else if(event.getSource() == leaveButton) {
                    window.goBackTo();
                }
            }    
	}
}
