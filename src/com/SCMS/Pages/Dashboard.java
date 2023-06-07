package com.SCMS.Pages;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.SCMS.Utils.Database;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JPanel {
    Database db = new Database();
    String companyId;

    public Dashboard(String companyId) {
        this.companyId = companyId;
        setSize(1200, 800);
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);
        

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(getWidth(), 60));
        headerPanel.add(new JLabel("This Is Dashboard Page"));
        add(headerPanel, BorderLayout.NORTH);

        // Sidebar panel
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setPreferredSize(new Dimension(250, getHeight()));
        sidebarPanel.setBackground(Color.LIGHT_GRAY);
        add(sidebarPanel, BorderLayout.WEST);

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
        // Add dummy data or graph for inventory

        contentPanel.add(inventoryPanel);

        // Products panel
        JPanel productsPanel = new JPanel();
        productsPanel.setBackground(Color.WHITE);
        productsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        productsPanel.setLayout(new BorderLayout());
        JLabel productsLabel = new JLabel("Products");
        productsLabel.setHorizontalAlignment(JLabel.CENTER);
        productsPanel.add(productsLabel, BorderLayout.NORTH);
        // Add pie chart for products
        JFreeChart productsChart = createPieChart();
        ChartPanel productsChartPanel = new ChartPanel(productsChart);
        productsPanel.add(productsChartPanel, BorderLayout.CENTER);

        contentPanel.add(productsPanel);

        // Users panel
        JPanel usersPanel = new JPanel();
        usersPanel.setBackground(Color.WHITE);
        usersPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        usersPanel.setLayout(new BorderLayout());
        JLabel usersLabel = new JLabel("Users");
        usersLabel.setHorizontalAlignment(JLabel.CENTER);
        usersPanel.add(usersLabel, BorderLayout.NORTH);
        // Add dummy data or graph for users

        contentPanel.add(usersPanel);

        setVisible(true);
    }

    private JFreeChart createBarChart() {
        Object[][] orders = db.getOrders();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < orders.length; i++) {
            dataset.setValue((int) orders[i][2], "Orders", (String) orders[i][1]);
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "",
                "Month",
                "Orders",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false);

        return chart;
    }

    private JFreeChart createPieChart() {
        Object[][] orders = db.getOrders();
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < orders.length; i++) {
            dataset.setValue((String) orders[i][8], (int) orders[i][2]);
            System.out.println((String) orders[i][8]);
        }
        JFreeChart chart = ChartFactory.createPieChart(
                "",
                dataset,
                true,
                true,
                false);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelGenerator(null); // Disable labels on pie slices

        return chart;
    }

    // Create a pie chart
    private JFreeChart createInventoryChart() {
        Object[][] inventory = db.getInventory(companyId);
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < inventory.length; i++) {
            dataset.setValue((String) inventory[i][1], (int) inventory[i][2]);
        }

        JFreeChart chart = ChartFactory.createPieChart("Inventory", dataset);
        return chart;
    }
}
