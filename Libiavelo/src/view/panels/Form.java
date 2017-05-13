package view.panels;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class Form extends JPanel {
	private PanelType formType;
	
	public PanelType getFormType() {
		return formType;
	}

	public void setFormType(PanelType formType) {
		this.formType = formType;
	}
	
	abstract public boolean isDataValid();
	
	abstract public void reset();
}
