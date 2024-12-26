package ma.cityManager.view;

import lombok.Data;
import ma.cityManager.entities.City;
import ma.cityManager.view.palette.panels.CRUDPanel;
import ma.cityManager.view.palette.panels.TablePanel;
import ma.cityManager.view.palette.tables.MyTablesModel;
import ma.cityManager.view.themes.Theme;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class CityManagerView
                            extends JFrame
{
    private Theme  currentTheme;
    private JPanel pnl_main;
    private CRUDPanel crudPanel;
    private TablePanel tablePanel;
    private MyTablesModel model;
    private List<City> cities = new ArrayList<>();


    private void initComponent(List<City> cities){

        this.cities = cities;
        model = new MyTablesModel("id", "Name", "Population", "Region");
        model.initCitiesData(cities);

        tablePanel = new TablePanel(currentTheme, model);

        crudPanel = new CRUDPanel(currentTheme, "City Keyword");

        pnl_main = new JPanel(new BorderLayout());
        pnl_main.setBackground(currentTheme.bgColor());
        pnl_main.add(crudPanel, BorderLayout.SOUTH);
        pnl_main.add(tablePanel, BorderLayout.CENTER);


        setContentPane(pnl_main);
    }

    public CityManagerView(Theme theme , List<City> cities){

        setCurrentTheme(theme);
        initComponent(cities);
        setTitle("City Manager");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1500, 1000);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
