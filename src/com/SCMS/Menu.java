package com.SCMS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

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
    public Map<String, JPanel> views = new java.util.HashMap<String, JPanel>();
    public Map<String, JPanel> panelMap = new java.util.HashMap<String, JPanel>();

    boolean visible = true;
    JButton toggleButton = new SButton("", new ImageIcon("lib/icons/menu.png"));
    public JPanel currentPage;

    public Menu(String username, String role, String companyId) {
        super("Supply Chain Management System");
        // Initialize components
        navBar = createSidebar();
        navBar.add(toggleButton);
        toggleButton.addActionListener(e -> {
            if (visible) {
                animateSidebarClosing();
            } else
                animateSidebarOpening();
            visible = !visible;
            
        });
        
        cardLayout = new CardLayout();
        workSpace = new JPanel(cardLayout);
        workSpace.setBackground(Color.CYAN);
        panelMap.put("Inventory", new Inventory(companyId));
        panelMap.put("Orders", new Orders(companyId));
        panelMap.put("Dashboard", new Dashboard(companyId));

        JPanel productsPanel = new JPanel(new BorderLayout());
        productsPanel.add(new Products(companyId), BorderLayout.CENTER);
        productsPanel.add(new Categories(), BorderLayout.EAST);
        panelMap.put("Products", productsPanel);

        panelMap.put("Shipment", new Shipment());
        panelMap.put("Purchase", new Purchase(companyId));
        panelMap.put("Suppliers", new Suppliers(companyId));
        panelMap.put("Employees", new Employees());
        panelMap.put("Settings", new Settings());

        String[] menuItemsNames = { "Dashboard", "Purchase", "Inventory", "Products", "Orders", "Shipment", "Suppliers",
                "Employees", "Settings", "Logout" };

        for (int i = 0; i < menuItems.length; i++) {
            JPanel panel = panelMap.get(menuItemsNames[i]);
            if (panel == null) {
                panel = new JPanel();
                panel.add(new JLabel("Coming Soon"));
            }
            views.put(menuItemsNames[i], panel);
            workSpace.add(panel, menuItemsNames[i]);

            menuItems[i] = new SButton(menuItemsNames[i],
                    new ImageIcon("lib/icons/" + menuItemsNames[i].toLowerCase() + ".png"));
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
                    workSpace.remove(views.get(current.getText()));
                    if (current.getText() == "Products") {
                        JPanel panel1 = new JPanel(new BorderLayout());
                        panel1.add(new Products(companyId), BorderLayout.CENTER);
                        panel1.add(new Categories(), BorderLayout.EAST);
                        workSpace.add(panel1, current.getText());
                    }else{
                        workSpace.add(panelMap.get(current.getText()), current.getText());
                    }
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

        menuBar = new MenuBar();
        setJMenuBar(menuBar);

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