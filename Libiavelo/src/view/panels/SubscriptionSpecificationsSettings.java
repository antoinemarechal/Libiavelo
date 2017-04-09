package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SubscriptionSpecificationsSettings extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel expiryDateLabel;
	private TextField expiryDateTextField;
	
	public SubscriptionSpecificationsSettings() {
		super();
		this.setVisible(true);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setSize(new Dimension(500, 500));
		
		expiryDateLabel = new JLabel("Date de demande : ");
		expiryDateLabel.setLabelFor(expiryDateTextField);
		expiryDateTextField = new TextField("", 20);
		this.add(expiryDateLabel);
		this.add(expiryDateTextField);
	}
	
}
