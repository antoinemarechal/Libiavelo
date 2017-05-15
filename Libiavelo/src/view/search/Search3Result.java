/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.search;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;

/**
 *
 * @author Lio
 */
@SuppressWarnings("serial")
public class Search3Result extends Search {
        JSpinner dateSpinner;
        JScrollPane jScrollPane;
        
    	public Search3Result(Search previous, JTable table) {
		super(SearchType.SEARCH2RESULT);
		super.setSearch(previous);
                
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(" Resultat recherche 3 : "), 
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.setLayout(new GridLayout(4, 2, 15, 5));
		
		jScrollPane = new JScrollPane(table);
		this.add(jScrollPane);
                this.setVisible(true);
      	}

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
