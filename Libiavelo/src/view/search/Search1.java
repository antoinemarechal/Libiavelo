package view.search;

import java.awt.GridLayout;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

@SuppressWarnings("serial")
public class Search1 extends Search {	
	private JSpinner dateSpinner;
	private JRadioButton isExceptionnalButton, isAvailableButton;
	
	public Search1() {
		super(SearchType.SEARCH1);
		
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(" Recherche 1 : "), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.setLayout(new GridLayout(4, 2, 15, 5));
		
		dateSpinner = new JSpinner(new SpinnerDateModel());
		this.add(dateSpinner);
		
		isExceptionnalButton = new JRadioButton("Exceptionnel");
		isExceptionnalButton.setSelected(true);
		this.add(isExceptionnalButton);
		
		isAvailableButton = new JRadioButton("Disponible");
		isAvailableButton.setSelected(true);
		this.add(isAvailableButton); 
                this.setVisible(true);
      	}
	
	public Date getInputDate() {
		return (Date) dateSpinner.getModel().getValue();
	}

	public Boolean getIsExceptionnal() {
		return isExceptionnalButton.isSelected();
	}

	public Boolean getIsAvailable() {
		return isAvailableButton.isSelected();
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub	
	}

 }
