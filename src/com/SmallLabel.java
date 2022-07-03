package com;

import javax.swing.*;
import java.awt.*;

public class SmallLabel extends JLabel{
    SmallLabel(String text, int x, int y){
        this.setText(text);
        this.setBounds(x, y, 250, 35);
        this.setFont(new Font("Arial", Font.BOLD, 20));
    }

}
