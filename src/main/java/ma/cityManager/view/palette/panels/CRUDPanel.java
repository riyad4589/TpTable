package ma.cityManager.view.palette.panels;

import lombok.Data;
import ma.cityManager.view.palette.buttons.MyButton;
import ma.cityManager.view.palette.fields.CustomTextField;
import ma.cityManager.view.themes.Theme;

import javax.swing.*;
import java.awt.*;

@Data
public class CRUDPanel extends JPanel
{
    private Theme currentTheme;
    private MyButton btn_create, btn_read, btn_update, btn_delete;
    private CustomTextField txt_search;

    private void initComponent(String hintTxt){
        btn_read   = new MyButton(currentTheme, "", "read.png", "readH.png");
        btn_create = new MyButton(currentTheme,"Add", "create.png", "createH.png");
        btn_update = new MyButton(currentTheme,"Update", "update.png", "updateH.png");
        btn_delete = new MyButton(currentTheme,"Delete", "delete.png", "deleteH.png");


        txt_search = new CustomTextField(currentTheme,hintTxt);

        setLayout(new BorderLayout());

        var centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10,10));
            centerPanel.add(btn_create);
            centerPanel.add(btn_update);
            centerPanel.add(btn_delete);
        var eastPanel   = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10,10));
            eastPanel.add(btn_read);
            eastPanel.add(txt_search);
        add(centerPanel, BorderLayout.CENTER);
        add(eastPanel  , BorderLayout.EAST);
    }

    public CRUDPanel(Theme theme, String hintTxt){

        setCurrentTheme(theme);
        initComponent(hintTxt);
    }
}
