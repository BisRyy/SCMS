package com.SCMS.Pages;

import java.awt.Color;


import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import com.SCMS.Utils.Database;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inventory extends JPanel {
    private JTable inventoryTable;
    private JScrollPane scrollPane;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private int selectedRow = -1;

    public Inventory() {
        initializeUI();
        addButton.addActionListener(new AddButtonListener());
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        // Inventory Table
        inventoryTable = new JTable();
        scrollPane = new JScrollPane(inventoryTable);
        add(scrollPane, BorderLayout.CENTER);

        inventoryTable.setFillsViewportHeight(true);
        inventoryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Add some dummy data to the table
        String[] columnNames = {"Code", "Name", "Quantity", "Price","Unit", "Category", "Supplier", "Date Added", "Expiry Date", "Description"};
        Database db = new Database();

        DefaultTableModel model = new DefaultTableModel(db.getInventory(), columnNames);
        inventoryTable.setModel(model);
        
        // make the table cells width fit the contents inside for all columns
        inventoryTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        // show item details in a dialog when the user double-clicks on a row
        inventoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = inventoryTable.rowAtPoint(evt.getPoint());
                int col = inventoryTable.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    selectedRow = row;

                }

            }
        });


        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout());

        addButton = new JButton("Add");
        buttonPanel.add(addButton);

        editButton = new JButton("Edit");
        buttonPanel.add(editButton);

        deleteButton = new JButton("Delete");
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Open add inventory dialog
            AddInventoryDialog addInventoryDialog = new AddInventoryDialog();
            addInventoryDialog.setVisible(true);

            // reload the updated inventory table
            String[] columnNames = {"Code", "Name", "Quantity", "Price","Unit", "Category", "Supplier", "Date Added", "Expiry Date", "Description"};
            Database db = new Database();

            DefaultTableModel model = new DefaultTableModel(db.getInventory(), columnNames);
            inventoryTable.setModel(model);
        }
    }

    private class AddInventoryDialog extends JDialog {
        private JTextField nameField;
        private JTextField quantityField;
        private JTextField priceField;
        private JTextField unitField;
        private JTextField categoryField;
        private JTextField supplierField;
        private JTextField expiryDateField;
        private JTextField descriptionField;
        private JButton addButton;
        private JButton cancelButton;

        public AddInventoryDialog() {
            setTitle("Add Inventory");
            setModal(true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setResizable(false);

            // move the dialog to the center of the screen
            setLocationRelativeTo(getParent().getParent());

            JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel nameLabel = new JLabel("Name:");
            nameField = new JTextField(15);
            panel.add(nameLabel);
            panel.add(nameField);
            
            JLabel quantityLabel = new JLabel("Quantity:");
            quantityField = new JTextField(15);
            panel.add(quantityLabel);
            panel.add(quantityField);

            JLabel priceLabel = new JLabel("Price:");
            priceField = new JTextField(15);
            panel.add(priceLabel);
            panel.add(priceField);

            JLabel unitLabel = new JLabel("Unit:");
            unitField = new JTextField(15);
            panel.add(unitLabel);
            panel.add(unitField);

            JLabel categoryLabel = new JLabel("Category:");
            categoryField = new JTextField(15);
            panel.add(categoryLabel);
            panel.add(categoryField);

            JLabel supplierLabel = new JLabel("Supplier:");
            supplierField = new JTextField(15);
            panel.add(supplierLabel);
            panel.add(supplierField);
                
            JLabel expiryDateLabel = new JLabel("Expiry Date:");
            expiryDateField = new JTextField(15);
            panel.add(expiryDateLabel);
            panel.add(expiryDateField);

            JLabel descriptionLabel = new JLabel("Description:");
            descriptionField = new JTextField(15);
            panel.add(descriptionLabel);
            panel.add(descriptionField);

            addButton = new JButton("Add");
            cancelButton = new JButton("Cancel");

            addButton.addActionListener((e) -> {    
                    String name = nameField.getText();

                    if (name.isEmpty()) {
                        JOptionPane.showMessageDialog(AddInventoryDialog.this, "Please enter a name", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    try {
                        Integer.parseInt(quantityField.getText());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(AddInventoryDialog.this, "Please enter a valid quantity", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    int quantity = Integer.parseInt(quantityField.getText());
                    if (quantity <= 0) {
                        JOptionPane.showMessageDialog(AddInventoryDialog.this, "Please enter a valid quantity", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    try {
                        Double.parseDouble(priceField.getText());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(AddInventoryDialog.this, "Please enter a valid price", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    double price = Double.parseDouble(priceField.getText());
                    if (price <= 0) {
                        JOptionPane.showMessageDialog(AddInventoryDialog.this, "Please enter a valid price", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String category = categoryField.getText();
                    String expiryDate = expiryDateField.getText();
                    int id = selectedRow;
                    Database db = new Database();
                    db.addInventory(id, quantity, category, expiryDate);
                    dispose();
                }
            );

            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.add(addButton);
            buttonPanel.add(cancelButton);

            getContentPane().add(panel, BorderLayout.CENTER);
            getContentPane().add(buttonPanel, BorderLayout.SOUTH);

            pack();
        }
    }


public static void main(String[] args) {
	// InventoryManagementPage inventoryPage = new InventoryManagementPage();
        }

}
