package com;

import javax.swing.*;
import java.awt.*;

public class AboutPanelLines extends JLabel{
    AboutPanelLines(int y, String text){
        this.setText(text);
        this.setBounds(10, y, 630, 25);
        this.setForeground(new Color(148, 0, 211));
        this.setFont(new Font("Arial", Font.BOLD, 20));
    }
}
