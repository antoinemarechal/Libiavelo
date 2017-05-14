package view.form;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class Form extends JPanel {
	private PanelType formType;
	
	public Form(PanelType formType) {
		this.formType = formType;
	}
	
	public PanelType getFormType() {
		return formType;
	}
	
	abstract public void reset();
	
	abstract public boolean validateForm();
	
	abstract public Object getFormGeneratedObject();
}
