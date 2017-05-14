package view.search;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Search3Model extends AbstractTableModel {
	private ArrayList<ArrayList<Object>> data;
	private ArrayList<String> columnNames;
	
	public Search3Model(ArrayList<ArrayList<Object>> data) {
		this.data = data;
		columnNames.add("NomDemandeur");
		columnNames.add("Prenom1");
		columnNames.add("DateDemande");
		columnNames.add("SoldeRestantAPayer");
		columnNames.add("InscriptionValidee");
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
	public Class<?> getColumnClass(int columnIndex) 
	{
		switch(columnIndex)
		{
			case 0 : 
			case 1 : 
				return String.class;
			case 2 : 
				return Date.class;	
			case 3 :
				return Float.class;
			case 4 :
				return Boolean.class;
			
			default : return null;
		}
	}
}
