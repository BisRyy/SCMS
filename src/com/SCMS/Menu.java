package com.SCMS;
import java.awt.*;
import javax.swing.*;

public class Menu extends JFrame {
    public JPanel workSpace;
    public JPanel navBar;
    public MenuBar menuBar;
    public JButton[] menuItems = new JButton[10];
    public JButton current;
    orders order = new orders();
    public Menu() {
        super("Supply Chain Management System");

        // Initialize components
        menuBar = new MenuBar();
        navBar = new NavBar();
        
        
        setJMenuBar(menuBar);
        add(navBar);
        workSpace = new JPanel();
        workSpace.setBounds(240, 0, 1400 - 240, 760);
        workSpace.setBackground(Color.CYAN);
        JButton button = new JButton("Click Me");
        workSpace.add(button);

        String[] menuItemsNames = {"Dashboard", "Inventory", "Orders", "Suppliers", "Customers", "Employees", "Reports", "Settings", "Help", "Logout"};

        for (int i = 0; i < menuItems.length; i++) {
            menuItems[i] = new SButton(menuItemsNames[i]);
            menuItems[i].setBounds(0, 10 + 55 * i, 240, 50);
            // menuItems[i].setForeground(Color.WHITE);
            // menuItems[i].setBackground(Color.DARK_GRAY);
            menuItems[i].setBorder(BorderFactory.createEmptyBorder());
            menuItems[i].setFocusPainted(false);
            navBar.add(menuItems[i]);
            menuItems[i].addActionListener(e -> {
                workSpace.removeAll();
                workSpace.repaint();
                workSpace.revalidate();
                current = (JButton) e.getSource();

                    if (current == menuItems[2]) {
                        workSpace.add(order);
                        menuItems[2].setBackground(Color.LIGHT_GRAY);
                        menuItems[2].setForeground(Color.WHITE);
                    } else {
                        menuItems[2].setBackground(Color.WHITE);
                        menuItems[2].setForeground(Color.BLACK);
                    }

            });
        }

        add(workSpace);
        add(new JPanel());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1400, 760);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}