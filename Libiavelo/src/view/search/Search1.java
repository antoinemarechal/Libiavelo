package view.search;

import java.awt.GridLayout;

import javax.swing.BorderFactory;

@SuppressWarnings("serial")
public class Search1 extends Search {

	public Search1() {
		super(SearchType.SEARCH1);
		
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
