package ma.cityManager;


import ma.cityManager.repository.dbMem.CityDao;
import ma.cityManager.view.CityManagerView;
import ma.cityManager.view.themes.ThemeLight;

import javax.swing.*;

public class App
{
    public static void main( String[] args ) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        SwingUtilities.invokeLater(()->
                new CityManagerView(new ThemeLight(),new CityDao().findAll()));
    }
}
