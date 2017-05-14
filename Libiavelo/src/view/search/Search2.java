package view.search;

import java.awt.GridLayout;

import javax.swing.BorderFactory;

@SuppressWarnings("serial")
public class Search2 extends Search {
	public Search2() {
		super(SearchType.SEARCH2);
		
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Recherche 2 : "), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.setLayout(new GridLayout(11, 2, 15, 5));
				
		
	}
	
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
}
