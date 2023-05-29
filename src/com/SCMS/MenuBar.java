package com.SCMS;
import java.awt.event.*;
import javax.swing.*;

public class MenuBar extends JMenuBar implements ActionListener {
    private JMenu fileMenu, supplierItem, employeeItem, productItem, reportItem, saleItem, purchaseOrderItem, aboutUsItem, contactItem, logOutItem;
    private JMenuItem addproduct, addsupplier, addsale, addpurchase, addemployee, deleteemployee, updateemployee, searchemployee, updateproduct, updatesupplier, updatesale, updatepurchase, deleteproduct, deletesupplier, deletesale, deletepurchase, searchproduct, searchsupplier, searchsale, searchpurchase, reportproduct, reportpurchase, reportsale, reportsupply;

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
        addproduct = new JMenuItem("Add Product");
        addsupplier = new JMenuItem("Add Supplier");
        addemployee = new JMenuItem("Add Employee");
        addsale = new JMenuItem("Add Sale");
        addpurchase = new JMenuItem("Add Purchase");
        updateproduct = new JMenuItem("Update Product");
        updatesupplier = new JMenuItem("Update Supplier");
        updateemployee = new JMenuItem("Update Employee");
        updatesale = new JMenuItem("Update Sale");
        updatepurchase = new JMenuItem("Update Purchase");
        deleteproduct = new JMenuItem("Delete Product");
        deletesupplier  = new JMenuItem("Delete Supplier");
        deleteemployee = new JMenuItem("Delete Employee");
        deletesale = new JMenuItem("Delete Sale");
        deletepurchase = new JMenuItem("Delete Purchase");
        searchproduct = new JMenuItem("Search Product");
        searchsupplier = new JMenuItem("Search Supplier");
        searchemployee = new JMenuItem("Search Employee");
        searchsale = new JMenuItem("Search Sale");
        searchpurchase = new JMenuItem("Search Purchase");
        reportproduct = new JMenuItem("Product Report");
        reportpurchase = new JMenuItem("Purchase Report");
        reportsale = new JMenuItem("Sale item Report");
        reportsupply = new JMenuItem("Supplier Report");



        supplierItem.addActionListener(this);
        employeeItem.addActionListener(this);
        productItem.addActionListener(this);
        reportItem.addActionListener(this);
        saleItem.addActionListener(this);
        purchaseOrderItem.addActionListener(this);
        aboutUsItem.addActionListener(this);
        contactItem.addActionListener(this);
        logOutItem.addActionListener(this);


        productItem.add(addproduct);
        productItem.add(updateproduct);
        productItem.add(deleteproduct);
        productItem.add(searchproduct);

        saleItem.add(addsale);
        saleItem.add(updatesale);
        saleItem.add(deletesale);
        saleItem.add(searchsale);

        purchaseOrderItem.add(addpurchase);
        purchaseOrderItem.add(updatepurchase);
        purchaseOrderItem.add(deletepurchase);
        purchaseOrderItem.add(searchpurchase);

        supplierItem.add(addsupplier);
        supplierItem.add(updatesupplier);
        supplierItem.add(deletesupplier);
        supplierItem.add(searchsupplier);

        employeeItem.add(addemployee);
        employeeItem.add(updateemployee);
        employeeItem.add(deleteemployee);
        employeeItem.add(searchemployee);

        reportItem.add(reportproduct);
        reportItem.add(reportpurchase);
        reportItem.add(reportsale);
        reportItem.add(reportsupply);

        this.add(fileMenu);
        this.add(supplierItem);
        this.add(employeeItem);
        this.add(productItem);
        this.add(reportItem);
        this.add(saleItem);
        this.add(purchaseOrderItem);
        this.add(logOutItem);
        this.add(aboutUsItem);
        this.add(contactItem);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle menu item clicks
        if (e.getSource() == supplierItem) {
            // Code to open supplier window
            System.out.println("Supplier");
        } else if (e.getSource() == productItem) {
            // Code to open product window
        } else if (e.getSource() == reportItem) {
            // Code to open report window
        } else if (e.getSource() == saleItem) {
            // Code to open sale window
        } else if (e.getSource() == purchaseOrderItem) {
            // Code to open purchase order window
        } else if (e.getSource() == aboutUsItem) {
            // Code to open about us window
        } else if (e.getSource() == contactItem) {
            // Code to open contact window
        } else if (e.getSource() == logOutItem){
            // Code to log out and close the menu window
            System.exit(0);
        }
    }

}