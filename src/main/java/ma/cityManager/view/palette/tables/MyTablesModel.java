package ma.cityManager.view.palette.tables;

import lombok.Data;
import ma.cityManager.entities.City;

import javax.swing.table.AbstractTableModel;
import java.util.List;

@Data
public class MyTablesModel extends AbstractTableModel
{

    private String [] columnNames;
    private Object [][] data;

    public MyTablesModel(String... columns) {
        setColumnNames(columns);

    }

    public void initCitiesData(List<City> cities){

        data = new Object[cities.size()][columnNames.length];

        int i = 0;
        for(City city : cities){
            data[i][0] = city.getIdCity();
            data[i][1] = city.getName();
            data[i][2] = city.getPopulation();
            data[i][3] = city.getRegion();


            i++;
        }
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }
}
