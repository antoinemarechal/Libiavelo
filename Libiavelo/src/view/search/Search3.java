package view.search;

import java.awt.GridLayout;

import javax.swing.BorderFactory;

@SuppressWarnings("serial")
public class Search3 extends Search{
	public Search3() {
		super(SearchType.SEARCH3);
		
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Recherche 1 : "), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.setLayout(new GridLayout(11, 2, 15, 5));
				
		
	}
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
}
