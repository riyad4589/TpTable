package ma.cityManager.view.themes;

import javax.swing.*;
import java.awt.*;

public abstract class Theme {

    public abstract Color bgColor();
    public abstract Font  buttonsFont();
    public abstract ImageIcon getButtonIcon(String name);

}
