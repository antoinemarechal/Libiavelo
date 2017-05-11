package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import controller.ApplicationController;
import view.observers.CustomWindowListener;
import model.PersonnelMember;

@SuppressWarnings("serial")
public class ConnectionDialog extends JDialog implements ActionListener, ItemListener, KeyListener
{
	private Window mainWindow;
	
	private JTextField usernameField;	
	private JPasswordField passwordField;
	private JCheckBox showPasswordCheckBox;
	private JButton okButton;
	private JButton cancelButton;
	
	public ConnectionDialog(Window parentWindow, String description) 
	{
		super(parentWindow);
		
		int width = 300;
		int height = 172;
		
		this.setResizable(false);
		this.setTitle("Connexion utilisateur");
		this.setLocationRelativeTo(parentWindow);
		this.setLocation(this.getX() - (width / 2), this.getY() - (height / 2));
		this.setPreferredSize(new Dimension(width, height));
		this.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		this.addWindowListener(new CustomWindowListener());
		
		mainWindow = parentWindow;
		
		JLabel descriptionLabel = new JLabel(description);
		descriptionLabel.setBounds(10, 5, width - 27, 20);
		descriptionLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel fieldsPanel = new JPanel();
		fieldsPanel.setLayout(new GridLayout(2, 2, 5, 0));
		fieldsPanel.setBounds(10, 31, width - 25, 40);
		
			usernameField = new JTextField();
					
			passwordField = new JPasswordField();
			passwordField.addKeyListener(this);
			
			JLabel matriculeLabel = new JLabel("Matricule :");
			matriculeLabel.setLabelFor(usernameField);
			matriculeLabel.setHorizontalAlignment(JLabel.RIGHT);
			
			JLabel passwordLabel = new JLabel("Mot de passe :");
			passwordLabel.setLabelFor(passwordField);
			passwordLabel.setHorizontalAlignment(JLabel.RIGHT);
			
		fieldsPanel.add(matriculeLabel);
		fieldsPanel.add(usernameField);
		fieldsPanel.add(passwordLabel);
		fieldsPanel.add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 78, width - 18, 20);
		
		showPasswordCheckBox = new JCheckBox("Afficher mot de passe");
		showPasswordCheckBox.setBounds(6, 83, 150, 20);
		showPasswordCheckBox.addItemListener(this);
		showPasswordCheckBox.addKeyListener(this);
		
		okButton = new JButton("OK");
		okButton.setBounds((width - 176) / 2, 110, 80, 26);
		okButton.addActionListener(this);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(((width - 6) / 2) + 5, 110, 80, 26);
		cancelButton.addActionListener(this);
		
		Container container = this.getContentPane();
		container.setLayout(null);
		container.add(descriptionLabel);
		container.add(fieldsPanel);
		container.add(separator);
		container.add(showPasswordCheckBox);
		container.add(okButton);
		container.add(cancelButton);
		
		this.pack();
	}
	
	private void onConfirmation()
	{
		if(usernameField.getText() == null || usernameField.getText().length() < 1)
		{
			this.setVisible(false);
			
			JOptionPane.showMessageDialog(this, "Le matricule doit compter au moins un caractère.", "Matricule invalide", JOptionPane.ERROR_MESSAGE);
			
			this.setVisible(true);
		}
		else if(passwordField.getPassword() == null || passwordField.getPassword().length < 1)
		{
			this.setVisible(false);
			
			JOptionPane.showMessageDialog(this, "Le mot de passe doit compter au moins un caractère.", "Mot de passe invalide", JOptionPane.ERROR_MESSAGE);
			
			this.setVisible(true);
		}		else		{			// TODO catch error pour déterminer que le nom de compte est invalide			ApplicationController ap = new ApplicationController();						PersonnelMember pm = ap.getPersonnelMember(usernameField.getText());						if(pm == null)			{				this.setVisible(false);								JOptionPane.showMessageDialog(this, "Le nom d'utilisateur entré n'existe pas.", "Mot de passe invalide", JOptionPane.ERROR_MESSAGE);								this.setVisible(true);			}			else			{				if(pm.isEnteredPasswordValid(String.valueOf(passwordField.getPassword())))				{										this.dispose();
					
					mainWindow.onConnectionSet(pm);				}				else				{					this.setVisible(false);										JOptionPane.showMessageDialog(this, "Le mot de passe pour cet utilisateur est invalide.", "Mot de passe invalide", JOptionPane.ERROR_MESSAGE);										this.setVisible(true);				
			}}		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == okButton)
		{
			onConfirmation();
		}
		else if(e.getSource() == cancelButton)
		{
			this.dispose();
			
			mainWindow.onDialogClosed();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		if(e.getSource() == showPasswordCheckBox)
		{
			if(showPasswordCheckBox.isSelected())
				passwordField.setEchoChar((char) 0);
			else
				passwordField.setEchoChar((char) 8226);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		if(((int) e.getKeyChar()) == 10)
		{
			onConfirmation();
		}		
	}

	@Override
	public void keyPressed(KeyEvent e) {	}

	@Override
	public void keyReleased(KeyEvent e) {	}
}

