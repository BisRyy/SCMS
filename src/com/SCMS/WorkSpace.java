package com.SCMS;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class WorkSpace extends JPanel{
    public static JPanel workSpace = null;

    public WorkSpace(){
        setLayout(null);
        setBackground(Color.CYAN);
        setBounds(240,0,1200,765);
        JButton button = new JButton("Button");
        button.setBounds(50, 50, 100, 20);
        add(button);

        workSpace = this;
    }

    public static void addComponent(JComponent component){
        workSpace.add(component);
    }

    public static void removeComponent(JComponent component){
        workSpace.remove(component);
    }

    public static void removeAllComponents(){
        workSpace.removeAll();
    }
    
}
