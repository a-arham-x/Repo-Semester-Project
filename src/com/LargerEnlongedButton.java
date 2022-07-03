package com;

import java.awt.*;

public class LargerEnlongedButton extends EnlongedButton{
    LargerEnlongedButton(String text, int x, int y){
        super(text, x, y);
        this.setSize(300, 80);
        this.setFont(new Font("Arial", Font.BOLD, 30));
    }
}
