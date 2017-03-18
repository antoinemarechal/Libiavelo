package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Window extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu menuApplication , menuForms, menuInfos;
	private JMenuItem jMenuItemQuit, jMenuItemAddClient, jMenuItemHelp;
	private Container container;
	
	private AddClientPanel formPanel;
	
	public Window(){
		super("MainWindow");
		setBounds(100, 100, 500, 500);
		
		CustomWindowListener mainWindowListener = new CustomWindowListener();
		this.addWindowListener(mainWindowListener);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuApplication = new JMenu("Application");
		menuForms = new JMenu("Formulaires");
		menuInfos = new JMenu("Infos");
		
		jMenuItemQuit = new JMenuItem("Quitter");
		jMenuItemQuit.addActionListener(this);
		
		jMenuItemAddClient = new JMenuItem("Nouveau client");
		jMenuItemAddClient.addActionListener(this);
		
		
		jMenuItemHelp = new JMenuItem("Aide");
		jMenuItemHelp.addActionListener(this);
		
		menuApplication.add(jMenuItemQuit);
		
		menuForms.add(jMenuItemAddClient);
		
		menuInfos.add(jMenuItemHelp);
		
		menuBar.add(menuApplication);
		menuBar.add(menuForms);
		menuBar.add(menuInfos);
	
		container = getContentPane();
		container.setLayout(null);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object object = arg0.getSource();
		if(object.equals(jMenuItemAddClient)) {
			formPanel = new AddClientPanel();
			container.add(formPanel);
			container.setSize(500, 500);
			setVisible(true);
		}
		
		else if(object.equals(jMenuItemHelp)) {
			
		}
		
		else if(object.equals(jMenuItemQuit))
			System.exit(0);
		
	}
}