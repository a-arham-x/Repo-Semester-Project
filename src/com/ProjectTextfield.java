package com;

import javax.swing.*;
import java.awt.*;

public class ProjectTextfield extends JTextField{
    ProjectTextfield(int x, int y){
        this.setBounds(x, y, 300, 30);
        this.setFont(new Font("Arial", Font.PLAIN, 20));
    }
}
