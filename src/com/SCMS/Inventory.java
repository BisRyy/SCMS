package com.SCMS;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Inventory extends JPanel{

    public Inventory(){
        setBounds(240, 0, 1400 - 240, 760);
        setBackground(Color.BLUE);
        JButton button = new JButton("Click Me");
        add(button);
        add(new JLabel("This Is Inventory Page"));
    }
    
}
