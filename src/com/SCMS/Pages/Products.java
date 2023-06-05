package com.SCMS.Pages;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.SCMS.Utils.Database;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Products extends JPanel {
    private JTable productsTable;
    private Object[][] productList;
    private JScrollPane scrollPane;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private int selected = -1;
    Database db = new Database();

    public Products() {
        initializeUI();
        addButton.addActionListener(new AddButtonListener());
        deleteButton.addActionListener((e)->{
            System.out.println(productList.toString());
            if (selected != -1) {
                int confirm = JOptionPane.showConfirmDialog(this, "Do you want to delete " + productList[selected][0], "Are you sure?", JOptionPane.ERROR_MESSAGE);
                if (confirm == 0) {
                    db.removeProduct((String) productList[selected][7]);
                    String[] columnNames = { "Code", "Name", "Price", "Unit", "Category", "Supplier", "Description" };
                    productList = db.getProducts();
                    productsTable.setModel(new DefaultTableModel(productList, columnNames));
                    JOptionPane.showMessageDialog(this, "Product Deleted Successfully! " + selected, "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a product to delete.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        // Product Table
        productsTable = new JTable();
        scrollPane = new JScrollPane(productsTable);
        add(scrollPane, BorderLayout.CENTER);

        productsTable.setFillsViewportHeight(true);
        productsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add some dummy data to the table
        String[] columnNames = { "Code", "Name", "Price", "Unit", "Category", "Supplier", "Description" };
        
        productList = db.getProducts();
        productsTable.setModel(new DefaultTableModel(productList, columnNames));

        // make the table cells width fit the contents inside for all columns
        productsTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        // show item details in a dialog when the user double-clicks on a row
        productsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = productsTable.rowAtPoint(evt.getPoint());
                int col = productsTable.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    selected = row;
                    System.out.println(selected);
                }
            }
        });

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
            // Open add products dialog
            AddProductDialog addProductDialog = new AddProductDialog();
            addProductDialog.setVisible(true);

            // reload the updated products table
            String[] columnNames = { "Code", "Name", "Price", "Unit", "Category", "Supplier", "Description" };
            Database db = new Database();

            DefaultTableModel model = new DefaultTableModel(productList= db.getProducts(), columnNames);
            productsTable.setModel(model);
        }
    }

    private class AddProductDialog extends JDialog {
        private JTextField nameField;
        private JTextField priceField;
        private JTextField unitField;
        private JTextField categoryField;
        private JComboBox<String> supplierField;
        private JTextField descriptionField;
        private JButton addButton;
        private JButton cancelButton;

        public AddProductDialog() {
            setTitle("Add Product");
            setModal(true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setResizable(false);

            // move the dialog to the center of the screen
            setLocationRelativeTo(getParent().getParent());

            JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel nameLabel = new JLabel("Name:");
            nameField = new JTextField(15);
            panel.add(nameLabel);
            panel.add(nameField);

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

            Object[][] suppliers = db.getSuppliers();
            String[] supplierName = new String[suppliers.length];
            for (int i = 0; i < supplierName.length; i++) {
                supplierName[i] = (String) suppliers[i][0];
            }

            JLabel supplierLabel = new JLabel("Supplier:");
            supplierField = new JComboBox<>(supplierName);
            panel.add(supplierLabel);
            panel.add(supplierField);

            JLabel descriptionLabel = new JLabel("Description:");
            descriptionField = new JTextField(15);
            panel.add(descriptionLabel);
            panel.add(descriptionField);

            addButton = new JButton("Add");
            cancelButton = new JButton("Cancel");

            addButton.addActionListener((e) -> {
                String name = nameField.getText();

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(AddProductDialog.this, "Please enter a name", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    Double.parseDouble(priceField.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(AddProductDialog.this, "Please enter a valid price", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                double price = Double.parseDouble(priceField.getText());
                if (price <= 0) {
                    JOptionPane.showMessageDialog(AddProductDialog.this, "Please enter a valid price", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String unit = unitField.getText();
                String category = categoryField.getText();
                int supplierIndex = supplierField.getSelectedIndex();
                String supplier_id = (String) suppliers[supplierIndex][5];
                String description = descriptionField.getText();

                Database db = new Database();
                db.addProduct(name, "code", price, unit, category, description, "image", supplier_id);

                JOptionPane.showMessageDialog(AddProductDialog.this, "Product Added Successfully.", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
            });

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
}
