package com;

import javax.swing.*;
import java.awt.*;

public class Vmp_label extends JLabel{
    Vmp_label(String text, int x, int y){
        this.setText(text);
        this.setBounds(x, y, 200, 25);
        this.setFont(new Font("Arial", Font.BOLD, 20));
    }
}
