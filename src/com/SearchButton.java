package com;

import javax.swing.*;

public class SearchButton extends JButton{
    ImageIcon search_icon;
    SearchButton(int x, int y){
        search_icon = new ImageIcon("search icon.png");
        this.setIcon(search_icon);
        this.setBounds(x, y, 40, 40);
        this.setFocusable(false);
    }
}
