package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Search1Model extends AbstractTableModel {
	private ArrayList<ArrayList<Object>> data;
	private ArrayList<String> columnNames;
	
	public Search1Model(ArrayList<ArrayList<Object>> data) {
		this.data = data;
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

}
