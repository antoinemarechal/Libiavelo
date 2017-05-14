package view.search;

import java.awt.GridLayout;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import model.enumerations.BikeState;

@SuppressWarnings("serial")
public class Search2 extends Search {
	private JComboBox<BikeState> bikeStateComboBox;
	private JSpinner startDateSpinner, endDateSpinner;
	
	public Search2() {
		super(SearchType.SEARCH2);
		
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Recherche 2 : "), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.setLayout(new GridLayout(3, 2, 15, 5));
				
		startDateSpinner = new JSpinner(new SpinnerDateModel());
		endDateSpinner = new JSpinner(new SpinnerDateModel());
		this.add(startDateSpinner);
		this.add(endDateSpinner);
		
		bikeStateComboBox = new JComboBox<BikeState>();
		bikeStateComboBox.addItem(BikeState.DAMMAGED);
		bikeStateComboBox.addItem(BikeState.WORKING);
		bikeStateComboBox.addItem(BikeState.DESTROYED);
		bikeStateComboBox.setSelectedItem(BikeState.WORKING);
		this.add(bikeStateComboBox);		
	}
	
	public Date getStartDate() {
		return (Date) startDateSpinner.getModel().getValue();
	}
	
	public Date getEndDate() {
		return (Date) endDateSpinner.getModel().getValue();
	}
	
	public BikeState getBikeState() {
		return (BikeState)(bikeStateComboBox.getSelectedItem());
	}
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
}
