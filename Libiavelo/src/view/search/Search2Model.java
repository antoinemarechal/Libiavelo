package view.search;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Search2Model extends AbstractTableModel {
	private ArrayList<ArrayList<Object>> data;
	private ArrayList<String> columnNames;
	
	public Search2Model(ArrayList<ArrayList<Object>> data) {
		this.data = data;
                columnNames = new  ArrayList<>();
		columnNames.add("Libelle");
		columnNames.add("DescriptionProbleme");
		columnNames.add("NumeroVelo");
		columnNames.add("Etat");
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
			case 1 :
			case 3 :
				return String.class;
			case 2 : 
				return Integer.class;
			
			default : return null;
		}
	}
}
