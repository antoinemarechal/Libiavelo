package view.search;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Search1Model extends AbstractTableModel {
	private ArrayList<ArrayList<Object>> data;
	private ArrayList<String> columnNames;
	
	public Search1Model(ArrayList<ArrayList<Object>> data) {
		this.data = data;
                columnNames = new ArrayList<>();
		columnNames.add("NumeroVelo");
		columnNames.add("Etat");
		columnNames.add("ID source");
		columnNames.add("ID destination");
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int rowNumber, int columnNumber) {
		return data.get(rowNumber).get(columnNumber);
	}
        
        @Override
        public String getColumnName(int col) {
            return columnNames.get(col);
        }
        
	@Override
	public Class<?> getColumnClass(int columnIndex) 
	{
		switch(columnIndex)
		{
			case 0 : 
			case 2 : 
			case 3 : 
				return Integer.class;
				
			case 1 : return String.class;
			
			default : return null;
		}
	}
}
