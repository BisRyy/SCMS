package com.SCMS.Pages;

import java.awt.*;

import javax.swing.*;

import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.SCMS.Utils.Database;

public class Analytics extends JPanel {
    Database db = new Database();
    String companyId;

    public Analytics(String companyId) {
        this.companyId = companyId;
        setSize(1200, 800);
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(getWidth(), 60));
        headerPanel.add(new JLabel("Analytics"));
        add(headerPanel, BorderLayout.NORTH);

        // Sidebar panel
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setPreferredSize(new Dimension(250, getHeight()));
        sidebarPanel.setBackground(Color.LIGHT_GRAY);
        // add(sidebarPanel, BorderLayout.WEST);

        // Main content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2, 2));
        add(contentPanel, BorderLayout.CENTER);

        // Orders panel
        JPanel ordersPanel = new JPanel();
        ordersPanel.setBackground(Color.WHITE);
        ordersPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ordersPanel.setLayout(new BorderLayout());
        JLabel ordersLabel = new JLabel("Orders");
        ordersLabel.setHorizontalAlignment(JLabel.CENTER);
        ordersPanel.add(ordersLabel, BorderLayout.NORTH);
        // Add bar chart for orders
        JFreeChart ordersChart = createBarChart();
        ChartPanel ordersChartPanel = new ChartPanel(ordersChart);
        ordersPanel.add(ordersChartPanel, BorderLayout.CENTER);

        contentPanel.add(ordersPanel);

        // Inventory panel
        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setBackground(Color.WHITE);
        inventoryPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        inventoryPanel.setLayout(new BorderLayout());
        JLabel inventoryLabel = new JLabel("Inventory");
        JFreeChart inventoryChart = createInventoryChart();
        ChartPanel inventoryChartPanel = new ChartPanel(inventoryChart);
        inventoryLabel.setHorizontalAlignment(JLabel.CENTER);
        inventoryPanel.add(inventoryLabel, BorderLayout.NORTH);
        inventoryPanel.add(inventoryChartPanel, BorderLayout.CENTER);

        contentPanel.add(inventoryPanel);

        // Sales panel
        JPanel salesPanel = new JPanel();
        salesPanel.setBackground(Color.WHITE);
        salesPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        salesPanel.setLayout(new BorderLayout());
        JLabel salesLabel = new JLabel("Sales");
        salesLabel.setHorizontalAlignment(JLabel.CENTER);
        salesPanel.add(salesLabel, BorderLayout.NORTH);
        // Add line chart for sales
        JFreeChart salesChart = createLineChart();
        ChartPanel salesChartPanel = new ChartPanel(salesChart);
        salesPanel.add(salesChartPanel, BorderLayout.CENTER);

        contentPanel.add(salesPanel);

        // Employees panel
        JPanel usersPanel = new JPanel();
        usersPanel.setBackground(Color.WHITE);
        usersPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        usersPanel.setLayout(new BorderLayout());
        JLabel usersLabel = new JLabel("Users");
        usersLabel.setHorizontalAlignment(JLabel.CENTER);
        usersPanel.add(usersLabel, BorderLayout.NORTH);
        // Add dummy data or graph for users
        JFreeChart catChart = createCatChart();
        ChartPanel catChartPanel = new ChartPanel(catChart);
        usersPanel.add(catChartPanel, BorderLayout.CENTER);

        contentPanel.add(usersPanel);

        // Footer panel
        JPanel footerPanel = new JPanel();
        footerPanel.setPreferredSize(new Dimension(getWidth(), 60));
        footerPanel.add(new JLabel("SCMS"));
        add(footerPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    // Create a bar chart
    private JFreeChart createBarChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(100, "Orders", "January");
        dataset.setValue(200, "Orders", "February");
        dataset.setValue(300, "Orders", "March");
        dataset.setValue(400, "Orders", "April");
        dataset.setValue(500, "Orders", "May");
        dataset.setValue(600, "Orders", "June");
        dataset.setValue(700, "Orders", "July");
        dataset.setValue(800, "Orders", "August");
        dataset.setValue(900, "Orders", "September");
        dataset.setValue(1000, "Orders", "October");
        dataset.setValue(1100, "Orders", "November");
        dataset.setValue(1200, "Orders", "December");

        JFreeChart chart = ChartFactory.createBarChart("Orders", "Month", "Number of Orders", dataset);
        return chart;
    }

    // Create a pie chart
    private JFreeChart createPieChart() {
        Object[][] inventory = db.getInventory(companyId);
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < inventory.length; i++) {
            dataset.setValue((String) inventory[i][1], (int) inventory[i][2]);
            if (i == 8) {
                break;
            }
        }

        JFreeChart chart = ChartFactory.createPieChart("Status", dataset);
        return chart;
    }

    // Create a line chart
    private JFreeChart createLineChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(100, "Sales", "January");
        dataset.setValue(200, "Sales", "February");
        dataset.setValue(300, "Sales", "March");
        dataset.setValue(400, "Sales", "April");
        dataset.setValue(500, "Sales", "May");
        dataset.setValue(600, "Sales", "June");
        dataset.setValue(700, "Sales", "July");
        dataset.setValue(800, "Sales", "August");
        dataset.setValue(900, "Sales", "September");
        dataset.setValue(1000, "Sales", "October");
        dataset.setValue(1100, "Sales", "November");
        dataset.setValue(1200, "Sales", "December");

        JFreeChart chart = ChartFactory.createLineChart("Sales", "Month", "Number of Sales", dataset);
        return chart;
    }
    
    private JFreeChart createInventoryChart() {
        Object[][] inventory = db.getInventory(companyId);
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < inventory.length; i++) {
            dataset.setValue((String) inventory[i][1], (int) inventory[i][2]);
            if (i == 8) {
                break;
            }
        }

        JFreeChart chart = ChartFactory.createPieChart("Status", dataset);
        return chart;
    }

    private JFreeChart createCatChart() {
        Object[][] inventory = db.getCategories();
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < inventory.length; i++) {
            dataset.setValue((String) inventory[i][1], i);
        }

        JFreeChart chart = ChartFactory.createPieChart("Categories", dataset);
        return chart;
    }

}