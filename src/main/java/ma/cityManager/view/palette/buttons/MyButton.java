package ma.cityManager.view.palette.buttons;

import lombok.Data;
import ma.cityManager.view.palette.imagesTools.ImageUtils;
import ma.cityManager.view.themes.Theme;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Data
public class MyButton extends JButton
{
    private Theme currentTheme;

    public MyButton(Theme theme, String text, String iconName, String hoverIconName){
        setCurrentTheme(theme);
        setText(text);
        if(iconName != null) {
            setIcon(currentTheme.getButtonIcon(iconName));
            setForeground(ImageUtils
                             .getDominantColor(currentTheme.getButtonIcon(iconName)));

        }
        setFont(currentTheme.buttonsFont());
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setFocusable(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                if(iconName != null) {
                    setIcon(currentTheme.getButtonIcon(iconName));
                    setForeground(ImageUtils
                            .getDominantColor(currentTheme.getButtonIcon(iconName)));

                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if(hoverIconName != null) {
                    setIcon(currentTheme.getButtonIcon(hoverIconName));
                    setForeground(ImageUtils
                            .getDominantColor(currentTheme.getButtonIcon(hoverIconName)));

                }
            }
        });
    }
}
