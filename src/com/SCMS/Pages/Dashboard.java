package com.SCMS.Pages;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JPanel {

    public Dashboard() {
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
        inventoryLabel.setHorizontalAlignment(JLabel.CENTER);
        inventoryPanel.add(inventoryLabel, BorderLayout.NORTH);
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
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(50, "Completed", "Jan");
        dataset.setValue(70, "Completed", "Feb");
        dataset.setValue(60, "Completed", "Mar");
        dataset.setValue(80, "Completed", "Apr");
        dataset.setValue(90, "Completed", "May");
        dataset.setValue(120, "Completed", "Jun");

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
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category 1", 40);
        dataset.setValue("Category 2", 20);
        dataset.setValue("Category 3", 30);
        dataset.setValue("Category 4", 10);

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
}
