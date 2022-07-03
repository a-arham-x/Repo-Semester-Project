package com;

import javax.swing.*;
import java.awt.*;

public class SmallButton extends JButton{
    SmallButton(String text, int x, int y){
        this.setText(text);
        this.setFocusable(false);
        this.setFont(new Font("Arial", Font.BOLD, 20));
        this.setBounds(x, y, 100, 50);
        this.setForeground(new Color(148, 0, 211));
        this.setBackground(Color.white);
    }
}
