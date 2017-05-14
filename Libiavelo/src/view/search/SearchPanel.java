package view.search;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ApplicationController;


@SuppressWarnings("serial")
public class SearchPanel extends JPanel implements ActionListener {
	
	private JButton validateButton;
	private JButton resetButton;
	
	private Search search;
	
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
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == validateButton) {
			switch (search.getSearchType()) {
				case SEARCH1 :
					ApplicationController applicationController = new ApplicationController();
					Date date = new Date(((Search1) search).getInputDate().getTime());
					applicationController.getSearch1Data(date,((Search1) search).getIsExceptionnal(), ((Search1) search).getIsAvailable());
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
			search.reset();
	}
}
