package com;

import javax.swing.*;
import java.awt.*;

public class LargeLabel extends JLabel{
    LargeLabel(String text, int x, int y){
        this.setText(text);
        this.setForeground(new Color(148, 0, 211));
        this.setBounds(x, y, 700, 80);
        this.setFont(new Font("Arial", Font.BOLD, 50));
    }
}
