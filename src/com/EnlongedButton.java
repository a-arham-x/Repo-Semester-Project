package com;

import java.awt.*;

public class EnlongedButton extends SmallButton{
    EnlongedButton(String text, int x, int y){
        super(text, x, y);
        this.setSize(150, 50);
        this.setBackground(new Color(148, 0, 211));
        this.setForeground(Color.white);

    }
}
