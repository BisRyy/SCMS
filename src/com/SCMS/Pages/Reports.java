package com.SCMS.Pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reports extends JPanel {

    public Reports() {
        setLayout(new BorderLayout());
        setSize(400, 300);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Report selection panel
        JPanel reportSelectionPanel = new JPanel();
        reportSelectionPanel.setLayout(new GridLayout(4, 1, 10, 10));
        reportSelectionPanel.setBorder(BorderFactory.createTitledBorder("Select a Report"));

        JButton salesReportButton = new JButton("Sales Report");
        salesReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateSalesReport();
            }
        });

        JButton inventoryReportButton = new JButton("Inventory Report");
        inventoryReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateInventoryReport();
            }
        });

        JButton ordersReportButton = new JButton("Orders Report");
        ordersReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateOrdersReport();
            }
        });

        JButton shipmentReportButton = new JButton("Shipment Report");
        shipmentReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateShipmentReport();
            }
        });

        reportSelectionPanel.add(salesReportButton);
        reportSelectionPanel.add(inventoryReportButton);
        reportSelectionPanel.add(ordersReportButton);
        reportSelectionPanel.add(shipmentReportButton);

        mainPanel.add(reportSelectionPanel, BorderLayout.CENTER);

        // Buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goBack();
            }
        });

        buttonsPanel.add(backButton);

        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.DARK_GRAY);
        headerPanel.setPreferredSize(new Dimension(getWidth(), 60));

        JLabel headerLabel = new JLabel("Reports");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(headerLabel);

        add(headerPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void generateSalesReport() {
        // Generate sales report logic here
        JOptionPane.showMessageDialog(this, "Sales report generated!");
    }

    private void generateInventoryReport() {
        // Generate inventory report logic here
        JOptionPane.showMessageDialog(this, "Inventory report generated!");
    }

    private void generateOrdersReport() {
        // Generate orders report logic here
        JOptionPane.showMessageDialog(this, "Orders report generated!");
    }

    private void generateShipmentReport() {
        // Generate shipment report logic here
        JOptionPane.showMessageDialog(this, "Shipment report generated!");
    }

    private void goBack() {
        // Close the Reports page and go back to the previous page
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Reports());
    }
}
