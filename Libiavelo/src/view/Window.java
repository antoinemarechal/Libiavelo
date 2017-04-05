package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import view.observer.CustomWindowListener;
import view.panel.AddClient;

public class Window extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu menuApplication , menuForms, menuInfos, menuResearch;
	private JMenuItem jMenuItemQuit, jMenuItemAddClient, jMenuItemAddHouseholdMember, jMenuItemHelp, jMenuItemAbout, jMenuItemSearch1, jMenuItemSearch2, jMenuItemSearch3;
	private Container container;
	
	private AddClient formPanel;
	
	public Window(){
		super("MainWindow");
		setBounds(100, 100, 500, 500);
		
		CustomWindowListener mainWindowListener = new CustomWindowListener();
		this.addWindowListener(mainWindowListener);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuApplication = new JMenu("Application");
		menuForms = new JMenu("Formulaires");
		menuResearch = new JMenu("Recherches");
		menuInfos = new JMenu("Infos");
		
		jMenuItemQuit = new JMenuItem("Quitter");
		jMenuItemQuit.addActionListener(this);
		
		jMenuItemAddClient = new JMenuItem("Nouveau client");
		jMenuItemAddClient.addActionListener(this);
		
		jMenuItemAddHouseholdMember = new JMenuItem("Nouveau membre de famille");
		jMenuItemAddClient.addActionListener(this); 
		
		
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
		
		menuForms.add(jMenuItemAddClient);
		menuForms.add(jMenuItemAddHouseholdMember);
		
		menuInfos.add(jMenuItemHelp);
		menuInfos.add(jMenuItemAbout);
		
		menuResearch.add(jMenuItemSearch1);
		menuResearch.add(jMenuItemSearch2);
		menuResearch.add(jMenuItemSearch3);
		
		menuBar.add(menuApplication);
		menuBar.add(menuForms);
		menuBar.add(menuResearch);
		menuBar.add(menuInfos);
	
		container = getContentPane();
		container.setLayout(null);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object object = arg0.getSource();	
		
		if (object.equals(jMenuItemQuit)) 
			System.exit(0);
		
		else if(object.equals(jMenuItemAddClient)) {
			formPanel = new AddClient();
			container.add(formPanel);
			container.setSize(500, 500);
			setVisible(true);
		}
		
		else if(object.equals(jMenuItemAddHouseholdMember)) {
			
		}
		
		else if(object.equals(jMenuItemHelp)) {
			
		}
		
		else if(object.equals(jMenuItemAbout)) {
			
		}
		
		else if (object.equals(jMenuItemSearch1)) {
			
		}
		
		else if (object.equals(jMenuItemSearch2)) {
	
		}
		
		else if (object.equals(jMenuItemSearch3)) {
	
		}
	}
}