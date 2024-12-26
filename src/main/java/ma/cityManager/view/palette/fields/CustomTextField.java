package ma.cityManager.view.palette.fields;

import lombok.Data;
import ma.cityManager.view.themes.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

@Data
public class CustomTextField extends JTextField {

    private Theme currentTheme;
    private Color gainColor,lostColor;
    private Font gainFont,lostFont;

    public CustomTextField(Theme theme, String hint){
        setCurrentTheme(theme);
        setText(hint);
        setGainFont(currentTheme.buttonsFont());
        setLostFont(new Font("Candara", Font.ITALIC, 18));
        setGainColor(new Color(45 , 83, 187));
        setLostColor(new Color(208, 195, 194));
        setForeground(gainColor);
        setFont(gainFont);
        setBorder(BorderFactory.createLineBorder(gainColor, 2, true));
        setMinimumSize(new Dimension(200,55));
        setPreferredSize(new Dimension(200,55));
        setBackground(Color.WHITE);
        setHorizontalAlignment(JTextField.CENTER);

        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(getText().equals(hint)){
                    setText("");
                    setForeground(gainColor);
                    setFont(gainFont);
                }else{
                    setForeground(gainColor);
                    setFont(gainFont);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(getText().equals(hint) || getText().trim().equals("")) {
                    setText(hint);
                    setForeground(lostColor);
                    setFont(lostFont);
                }else{
                    setForeground(gainColor);
                    setFont(gainFont);
                }
            }
        });

    }
}
