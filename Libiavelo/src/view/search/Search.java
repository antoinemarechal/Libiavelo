package view.search;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class Search extends JPanel{
	private SearchType searchType;
        private Search previous;
	
	public Search(SearchType searchType) {
		this.searchType = searchType;
	}
        
        public Search(SearchType searchType, Search previous) {
		this.searchType = searchType;
                this.previous = previous;
	}
	
	public SearchType getSearchType() {
		return searchType;
	}
	 
        public Search getSearch() {
		return previous;
	}
        
        public void setSearch(Search previous) {
            this.previous = previous;
	}
	abstract public void reset();
}
