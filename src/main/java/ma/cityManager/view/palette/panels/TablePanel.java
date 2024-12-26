package ma.cityManager.view.palette.panels;

import lombok.Data;
import ma.cityManager.view.palette.tables.MyTablesModel;
import ma.cityManager.view.themes.Theme;

import javax.swing.*;
import java.awt.*;

@Data
public class TablePanel extends JPanel
{
    private Theme currentTheme;
    private JScrollPane scroll;
    private JTable table;
    private MyTablesModel model;


    private void initComponent(){
        table = new JTable(model);
        table.setRowHeight(50);
        table.setForeground(Color.BLUE);
        table.setFont(new Font("OpenSans", Font.PLAIN,20));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        var header = table.getTableHeader();
        header.setFont(currentTheme.buttonsFont());

        scroll = new JScrollPane(table);

        setLayout(new GridLayout(1,1));
        add(scroll);
    }

    public TablePanel(Theme theme,MyTablesModel model){

        setCurrentTheme(theme);
        setModel(model);
        initComponent();
    }


}
