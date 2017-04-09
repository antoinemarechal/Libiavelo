package view.panels;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class Form extends JPanel 
{
	PanelType formType;
	
	
	public PanelType getFormType() 
	{
		return formType;
	}

	abstract public void reset();
}
