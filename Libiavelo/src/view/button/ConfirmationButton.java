package view.button;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.panel.PanelType;

public class ConfirmationButton extends JButton {
	private static final long serialVersionUID = 1L;
	
	private PanelType panelType;
	private JPanel panel;
	
	public ConfirmationButton(JPanel panel, PanelType panelType) {
		super("Confirmer");
		this.panelType = panelType;
		this.panel = panel;
	}

	public PanelType getPanelType() {
		return panelType;
	}

	public JPanel getPanel() {
		return panel;
	}
}
