package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import view.form.ClientListing;
import view.form.FormPanel;
import view.form.LocalityEdition;
import view.form.PreviousPanel;
import view.search.Search1;
import view.search.Search2;
import view.search.Search3;
import view.search.SearchPanel;
import model.PersonnelMember;

@SuppressWarnings("serial")
public class Window extends JFrame implements ActionListener, PreviousPanel {
	
	private JMenuBar menuBar;
	private JMenu menuApplication , menuForms, menuInfos, menuResearch;
	private JMenuItem jMenuItemQuit, jMenuItemClient, jMenuItemLocality, jMenuItemBike, jMenuItemRepair, jMenuItemHelp, jMenuItemAbout, jMenuItemSearch1, jMenuItemSearch2, jMenuItemSearch3;
	
	public Window() {
		super("Application Libiavelo");
		
		this.setPreferredSize(new Dimension(500, 600));
		this.addWindowListener(new CustomWindowListener());
		
		menuBar = new JMenuBar();
		
		menuApplication = new JMenu("Application");
		menuForms = new JMenu("Formulaires");
		menuResearch = new JMenu("Recherches");
		menuInfos = new JMenu("Infos");
		
		jMenuItemQuit = new JMenuItem("Quitter");
		jMenuItemQuit.addActionListener(this);
		
		jMenuItemClient = new JMenuItem("Clients");
		jMenuItemClient.addActionListener(this);
		
		jMenuItemLocality = new JMenuItem("Localités");
		jMenuItemLocality.addActionListener(this);
		
		jMenuItemBike = new JMenuItem("Vélos");
		jMenuItemBike.addActionListener(this);
		
		jMenuItemRepair = new JMenuItem("Réparations");
		jMenuItemRepair.addActionListener(this);		
		
		jMenuItemHelp = new JMenuItem("Aide");
		jMenuItemHelp.addActionListener(this);
		
		jMenuItemAbout = new JMenuItem("A propos");
		jMenuItemAbout.addActionListener(this);
		
		jMenuItemSearch1 = new JMenuItem("Recherche 1");
		jMenuItemSearch1.addActionListener(this);
		
		jMenuItemSearch2 = new JMenuItem("Recherche 2");
		jMenuItemSearch2.addActionListener(this);
		
		jMenuItemSearch3 = new JMenuItem("Recherche 3");
		jMenuItemSearch3.addActionListener(this);		
		
		menuApplication.add(jMenuItemQuit);
		
		menuForms.add(jMenuItemClient);
		menuForms.add(jMenuItemLocality);
		menuForms.add(jMenuItemBike);
		menuForms.add(jMenuItemRepair);
		
		menuInfos.add(jMenuItemHelp);
		menuInfos.add(jMenuItemAbout);
		
		menuResearch.add(jMenuItemSearch1);
		menuResearch.add(jMenuItemSearch2);
		menuResearch.add(jMenuItemSearch3);
		
		menuBar.add(menuApplication);
		menuBar.add(menuForms);
		menuBar.add(menuResearch);
		menuBar.add(menuInfos);
	
		Container container = this.getContentPane();
		container.setLayout(new BorderLayout());
		
		this.setJMenuBar(menuBar);
		
		this.pack();		
	}
	
	public void showConnectionPopup()
	{
		ConnectionDialog dialog = new ConnectionDialog(this, "Veuillez entrez vos informations de connexion :");
		dialog.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object object = arg0.getSource();	
		
		if (object.equals(jMenuItemQuit)) {
			System.exit(0);
		}
		else if(object.equals(jMenuItemClient)) {
			this.getContentPane().removeAll();
			this.getContentPane().add(new ClientListing(this), BorderLayout.CENTER);
			this.getContentPane().repaint();
			this.setVisible(true);			
		}
		else if(object.equals(jMenuItemLocality)) {
			this.getContentPane().removeAll();
			this.getContentPane().add(new FormPanel(new LocalityEdition(), this), BorderLayout.CENTER);
			this.getContentPane().repaint();
			this.setVisible(true);
		}
		else if(object.equals(jMenuItemBike)) {
			
		}
		else if(object.equals(jMenuItemRepair)) {
			
		}
		else if (object.equals(jMenuItemSearch1)) {
			this.getContentPane().removeAll();
			this.getContentPane().add(new SearchPanel(new Search1()), BorderLayout.CENTER);
			this.getContentPane().repaint();
			this.setVisible(true);				
		}
		else if (object.equals(jMenuItemSearch2)) {
			this.getContentPane().removeAll();
			this.getContentPane().add(new SearchPanel(new Search2()), BorderLayout.CENTER);
			this.getContentPane().repaint();
			this.setVisible(true);	
		}
		else if (object.equals(jMenuItemSearch3)) {
			this.getContentPane().removeAll();
			this.getContentPane().add(new SearchPanel(new Search3()), BorderLayout.CENTER);
			this.getContentPane().repaint();
			this.setVisible(true);	
		}
		
		else if(object.equals(jMenuItemHelp)) {
			JOptionPane.showMessageDialog(this, "En cas de problème veuillez contacter les développeurs à l'adresse suivante : libia-app@gmail.com", "A propos", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(object.equals(jMenuItemAbout)) {
			JOptionPane.showMessageDialog(this, "Application développée par Antoine Maréchal et Lionel Mottet à l'usage de la société Libiavélo.", "Aide", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void onConnectionSet(PersonnelMember member) {
		// FIXME : Thread
	}

	public void onDialogClosed() {
		System.exit(0);		
	}

	@Override
	public void goBackTo() 
	{
		this.getContentPane().removeAll();
		this.getContentPane().repaint();
		this.setVisible(true);		
	}
}
