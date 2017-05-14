package view.form;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class Form extends JPanel {
	private FormType formType;
	
	public Form(FormType formType) {
		this.formType = formType;
	}
	
	public FormType getFormType() {
		return formType;
	}
	
	abstract public void reset();
	
	abstract public boolean validateForm();
	
	abstract public Object getFormGeneratedObject();
}
