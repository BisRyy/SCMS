package com.SCMS;
import javax.swing.*;

public class MenuBar extends JMenuBar {
    private JMenu fileMenu, supplierItem, employeeItem, productItem, reportItem, saleItem, purchaseOrderItem, aboutUsItem, contactItem, logOutItem;

    public MenuBar() {

        // Initialize components
        fileMenu = new JMenu("Home");
        supplierItem = new JMenu("Supplier");
        employeeItem = new JMenu("Employee");
        productItem = new JMenu("Product");
        reportItem = new JMenu("Report");
        saleItem = new JMenu("Sale");
        purchaseOrderItem = new JMenu("Purchase Order");
        aboutUsItem = new JMenu("About Us");
        contactItem = new JMenu("Contact");
        logOutItem = new JMenu("Log Out");

        // Add components to menu bar
        add(fileMenu);
        add(supplierItem);
        add(employeeItem);
        add(productItem);
        add(reportItem);
        add(saleItem);
        add(purchaseOrderItem);
        add(aboutUsItem);
        add(contactItem);
        add(logOutItem);
    }
}

        