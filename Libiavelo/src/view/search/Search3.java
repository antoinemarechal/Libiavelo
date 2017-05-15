package view.search;

import java.awt.GridLayout;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

@SuppressWarnings("serial")
public class Search3 extends Search {
	private JSpinner dateSpinner;
	private JComboBox<Boolean> validSubscription;
	private JTextField amountTextField;
	private JLabel amountLabel;
	
	public Search3() {
		super(SearchType.SEARCH3);
		
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Recherche 3 : "), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.setLayout(new GridLayout(3, 2, 15, 5));
		
		dateSpinner = new JSpinner(new SpinnerDateModel());
		this.add(dateSpinner);
		
		validSubscription = new JComboBox<>();
		validSubscription.addItem(true);
		validSubscription.addItem(false);
		validSubscription.setSelectedItem(true);
		this.add(validSubscription);
		
		
		amountTextField = new JTextField();
		amountLabel = new JLabel("montant");
		amountLabel.setLabelFor(amountTextField);
		this.add(amountTextField);
	}
	
	public Date getDate() {
		return (Date) dateSpinner.getModel().getValue();
	}
	
	public Boolean getSubscriptionValidity() {
		return (Boolean)(validSubscription.getSelectedItem());
	}
	
	public Float getMinimumAmount() throws NumberFormatException{
		return new Float(amountTextField.getText());
	}
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
}
