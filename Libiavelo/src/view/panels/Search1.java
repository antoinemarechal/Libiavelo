package view.panels;

import java.awt.GridLayout;

import javax.swing.BorderFactory;

public class Search1 extends Form {
	private static final long serialVersionUID = 1L;

	
	public Search1() {
		super();
		
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Recherche 1 : "), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.setLayout(new GridLayout(11, 2, 15, 5));
				
		super.setFormType(PanelType.SEARCH1);
	}
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDataValid() {
		// TODO Auto-generated method stub
		return false;
	}

}
