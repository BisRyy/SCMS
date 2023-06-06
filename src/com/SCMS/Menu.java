package com.SCMS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.SCMS.Auth.SessionManager;
import com.SCMS.Components.SButton;
import com.SCMS.Pages.*;

public class Menu extends JFrame {
    private CardLayout cardLayout;
    public JPanel workSpace;
    public JPanel navBar;
    public MenuBar menuBar;
    public JButton[] menuItems = new JButton[10];
    public JButton current;
    public JPanel[] views = new JPanel[10];
    boolean visible = true;
    JButton toggleButton = new SButton("", new ImageIcon("lib/icons/menu.png"));

    public Menu(String username, String role) {
        super("Supply Chain Management System");

        // Initialize components
        menuBar = new MenuBar();
        navBar = createSidebar();
        navBar.add(toggleButton);
        toggleButton.addActionListener(e -> {
            if (visible) {
                animateSidebarClosing();
            } else
                animateSidebarOpening();
            visible = !visible;

        });

        setJMenuBar(menuBar);
        cardLayout = new CardLayout();
        workSpace = new JPanel(cardLayout);
        workSpace.setBackground(Color.CYAN);

        String[] menuItemsNames = { "Dashboard", "Purchase","Inventory", "Products", "Orders", "Shipment", "Suppliers",
                "Employees", "Reports", "Settings", "Logout" };

        for (int i = 0; i < menuItems.length; i++) {
            JPanel panel = new JPanel(null);
            JButton button = new JButton(menuItemsNames[i], new ImageIcon("lib/icons/menu.png"));
            button.setSize(1000, 100);
            panel.add(button);
            views[i] = panel;
            if (menuItemsNames[i] == "Inventory")
                workSpace.add(new Inventory(), menuItemsNames[i]);
            else if (menuItemsNames[i] == "Orders")
                workSpace.add(new Orders(), menuItemsNames[i]);
            else if (menuItemsNames[i] == "Dashboard")
                workSpace.add(new Dashboard(), menuItemsNames[i]);
            else if (menuItemsNames[i] == "Products")
                workSpace.add(new Products(), menuItemsNames[i]);
            else if (menuItemsNames[i] == "Shipment") {
                workSpace.add(new Shipment(), menuItemsNames[i]);
            }
            else if (menuItemsNames[i] == "Purchase")
            workSpace.add(new Purchase(), menuItemsNames[i]);
            // else if (menuItemsNames[i] == "Suppliers")
            // workSpace.add(new Suppliers(), menuItemsNames[i]);
            // else if(menuItemsNames[i] == "Customers")
            // workSpace.add(new Customers(), menuItemsNames[i]);
            // else if(menuItemsNames[i] == "Employees")
            // workSpace.add(new Employees(), menuItemsNames[i]);
            // else if(menuItemsNames[i] == "Reports")
            // workSpace.add(new Reports(), menuItemsNames[i]);
            // else if(menuItemsNames[i] == "Settings")
            // workSpace.add(new Settings(), menuItemsNames[i]);
            // else if(menuItemsNames[i] == "Help")
            // workSpace.add(new Help(), menuItemsNames[i]);
            else
                workSpace.add(panel, menuItemsNames[i]);

            menuItems[i] = new SButton(menuItemsNames[i], new ImageIcon("lib/icons/" + menuItemsNames[i].toLowerCase() + ".png"));
            // menuItems[i].setBounds(20, 20 + 60 * i, 200, 50);
            menuItems[i].setForeground(Color.DARK_GRAY);
            menuItems[i].setBackground(Color.WHITE);
            menuItems[i].setBorder(BorderFactory.createEmptyBorder());
            menuItems[i].setFocusPainted(false);
            navBar.add(menuItems[i]);
            if (menuItemsNames[i] == "Logout") {
                menuItems[i].addActionListener((e) -> {
                    dispose();
                    SessionManager.logout();
                    new Auth();
                });
            } else {
                menuItems[i].addActionListener(e -> {
                    current = (JButton) e.getSource();
                    cardLayout.show(workSpace, current.getText());
                    current.setBackground(Color.LIGHT_GRAY);
                    for (int j = 0; j < menuItems.length; j++) {
                        if (current != menuItems[j]) {
                            menuItems[j].setBackground(Color.WHITE);
                        }
                    }
                });
            }
        }
        menuItems[0].setBackground(Color.LIGHT_GRAY);
        Container contentPane = getContentPane();
        contentPane.add(navBar, BorderLayout.WEST);
        contentPane.add(workSpace, BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1400, 760);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setBounds(10, 10, WIDTH, HEIGHT);
        sidebar.setPreferredSize(new Dimension(200, getHeight()));
        sidebar.setLayout(new GridLayout(12, 1, 10, 10));
        sidebar.setBackground(Color.DARK_GRAY);
        return sidebar;
    }

    private void animateSidebarOpening() {
        navBar.setVisible(true);
        int navBarWidth = navBar.getWidth();
        navBar.setLocation(-navBarWidth, 0);
        workSpace.setLocation(0, 0);

        Timer timer = new Timer(10, new ActionListener() {
            int currentX = -navBarWidth;
            int targetX = 100;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentX >= targetX) {
                    ((Timer) e.getSource()).stop();
                } else {
                    currentX += 10;
                    navBar.setPreferredSize(new Dimension(navBar.getWidth() + 10, getHeight()));
                    navBar.repaint();
                    navBar.revalidate();
                }
            }
        });

        timer.start();
    }

    private void animateSidebarClosing() {
        int navBarWidth = navBar.getWidth();

        Timer timer = new Timer(10, new ActionListener() {
            int currentX = 0;
            int targetX = -navBarWidth + 50;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentX <= targetX) {
                    ((Timer) e.getSource()).stop();
                } else {
                    currentX -= 10;
                    navBar.setPreferredSize(new Dimension(navBar.getWidth() - 10, getHeight()));
                    navBar.repaint();
                    navBar.revalidate();
                }
            }
        });

        timer.start();
    }
}