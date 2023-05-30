package com.SCMS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NightDashboardApp extends JFrame {
    private JPanel contentPanel;
    private JPanel sidebar;
    private JPanel mainPanel;
    private boolean isDarkMode;

    public NightDashboardApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Night Dashboard");
        setSize(800, 600);
        isDarkMode = true;

        // Create content panel
        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.DARK_GRAY);
        setContentPane(contentPanel);

        // Create sidebar
        sidebar = createSidebar();
        contentPanel.add(sidebar, BorderLayout.WEST);

        // Create main panel
        mainPanel = createMainPanel();
        contentPanel.add(mainPanel, BorderLayout.CENTER);
    }

    private JPanel createSidebar() {
        JPanel sidebarPanel = new JPanel(new BorderLayout());
        sidebarPanel.setPreferredSize(new Dimension(200, getHeight()));

        JButton toggleButton = new JButton("☰");
        toggleButton.setFont(new Font("Arial", Font.BOLD, 20));
        toggleButton.setFocusable(false);
        toggleButton.setForeground(Color.WHITE);
        toggleButton.setBackground(Color.BLACK);
        toggleButton.setBorder(null);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(toggleButton, BorderLayout.WEST);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(Color.BLACK);

        JButton homeButton = createSidebarButton("Home");
        JButton settingsButton = createSidebarButton("Settings");
        JButton profileButton = createSidebarButton("Profile");

        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(homeButton);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(settingsButton);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(profileButton);
        menuPanel.add(Box.createVerticalGlue());

        sidebarPanel.add(buttonPanel, BorderLayout.NORTH);
        sidebarPanel.add(menuPanel, BorderLayout.CENTER);

        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleSidebar();
            }
        });

        return sidebarPanel;
    }

    private JButton createSidebarButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button.setFocusable(false);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setBorder(null);
        button.setMargin(new Insets(5, 10, 5, 10));
        return button;
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);
        JLabel label = new JLabel("Main Content");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setForeground(Color.WHITE);
        mainPanel.add(label);
        return mainPanel;
    }

    private void toggleSidebar() {
        if (sidebar.isVisible()) {
            animateSidebarClosing();
        } else {
            animateSidebarOpening();
        }
    }

    private void animateSidebarOpening() {
        sidebar.setVisible(true);
        int sidebarWidth = sidebar.getWidth();
        int mainPanelWidth = mainPanel.getWidth();
        sidebar.setLocation(-sidebarWidth, 0);
        mainPanel.setLocation(0, 0);

        Timer timer = new Timer(10, new ActionListener() {
            int currentX = -sidebarWidth;
            int targetX = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentX >= targetX) {
                    ((Timer) e.getSource()).stop();
                    mainPanel.setLocation(sidebarWidth, 0);
                } else {
                    currentX += 10;
                    sidebar.setLocation(currentX, 0);
                    mainPanel.setLocation(currentX + sidebarWidth, 0);
                }
            }
        });

        timer.start();
    }

    private void animateSidebarClosing() {
        int sidebarWidth = sidebar.getWidth();
        int mainPanelWidth = mainPanel.getWidth();

        Timer timer = new Timer(10, new ActionListener() {
            int currentX = 0;
            int targetX = -sidebarWidth;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentX <= targetX) {
                    ((Timer) e.getSource()).stop();
                    mainPanel.setLocation(0, 0);
                } else {
                    currentX -= 10;
                    sidebar.setLocation(currentX, 0);
                    mainPanel.setLocation(currentX + sidebarWidth, 0);
                }
            }
        });

        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                NightDashboardApp app = new NightDashboardApp();
                app.setVisible(true);
            }
        });
    }
}
