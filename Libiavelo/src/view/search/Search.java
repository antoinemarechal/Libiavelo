package view.search;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class Search extends JPanel{
	private SearchType searchType;
	
	public Search(SearchType searchType) {
		this.searchType = searchType;
	}
	
	public SearchType getSearchType() {
		return searchType;
	}
	
	abstract public void reset();
}
