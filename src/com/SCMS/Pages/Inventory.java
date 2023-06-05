package com.SCMS.Pages;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.SCMS.Utils.Database;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inventory extends JPanel {
    private JTable inventoryTable;
    private Object[][] inventoryList;
    private JScrollPane scrollPane;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private int selected = -1;
    Database db = new Database();

    public Inventory() {
        initializeUI();
        addButton.addActionListener(new AddButtonListener());
        deleteButton.addActionListener((e) -> {
            if (selected >= 0){
                int confirm = JOptionPane.showConfirmDialog(this, "Do you want to delete " + inventoryList[selected][1], "Are you sure?", JOptionPane.ERROR_MESSAGE);
                if (confirm == 0){
                    db.removeInventory((String) inventoryList[selected][11]);
                    String[] columnNames = { "Code", "Name", "Quantity", "Price", "Unit", "Category", "Supplier","Date Added", "Expiry Date", "Description" };
                    inventoryList = db.getInventory();
                    inventoryTable.setModel(new DefaultTableModel(inventoryList, columnNames));
                    JOptionPane.showMessageDialog(this, "Inventory Item Deleted Successfully! " + selected , "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Please select a inventory item to delete.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
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
        inventoryList = db.getInventory();
        inventoryTable.setModel(new DefaultTableModel(inventoryList, columnNames));
        
        // make the table cells width fit the contents inside for all columns
        inventoryTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        // show item details in a dialog when the user double-clicks on a row
        inventoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = inventoryTable.rowAtPoint(evt.getPoint());
                int col = inventoryTable.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    selected = row;
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
            if (selected == -1) {
                JOptionPane.showMessageDialog(getParent(), "Please select a product", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            AddInventoryDialog addInventoryDialog = new AddInventoryDialog();
            addInventoryDialog.setVisible(true);

            // reload the updated inventory table
            String[] columnNames = {"Code", "Name", "Quantity", "Price","Unit", "Category", "Supplier", "Date Added", "Expiry Date", "Description"};
            inventoryTable.setModel(new DefaultTableModel(inventoryList = db.getInventory(), columnNames));
        }
    }

    private class AddInventoryDialog extends JDialog {
        private JTextField nameField;
        private JTextField quantityField;
        private JTextField priceField;
        private JTextField unitField;
        private JTextField categoryField;
        private JComboBox<String> productBox;
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

            JPanel panel = new JPanel(new GridLayout(8, 1, 10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel nameLabel = new JLabel("Product:");
            nameField = new JTextField(15);
            panel.add(nameLabel);
            // panel.add(nameField);
            Object[][] productList = db.getProducts();
            String[] productNames = new String[productList.length];
            for(int i=0; i<productList.length;i++){
                productNames[i] = (String) productList[i][1];
            }

            productBox = new JComboBox<String>(productNames);
            panel.add(productBox);
            
            JLabel quantityLabel = new JLabel("Quantity:");
            quantityField = new JTextField(15);
            panel.add(quantityLabel);
            panel.add(quantityField);

            JLabel priceLabel = new JLabel("Price:");
            priceField = new JTextField(15);
            panel.add(priceLabel);
            // panel.add(priceField);
            JLabel priceValue = new JLabel((productList[selected][2]) + " Birr");
            panel.add(priceValue);

            JLabel unitLabel = new JLabel("Unit:");
            unitField = new JTextField(15);
            panel.add(unitLabel);
            // panel.add(unitField);
            JLabel unitValue = new JLabel((productList[selected][3]) + "");
            panel.add(unitValue);

            JLabel categoryLabel = new JLabel("Category:");
            categoryField = new JTextField(15);
            panel.add(categoryLabel);
            // panel.add(categoryField);
            JLabel categoryValue = new JLabel((productList[selected][4]) + "");
            panel.add(categoryValue);

            JLabel supplierLabel = new JLabel("Supplier:");
            supplierField = new JTextField(15);
            panel.add(supplierLabel);
            // panel.add(supplierField);
            JLabel supplierValue = new JLabel((productList[selected][5]) + "");
            panel.add(supplierValue);
                
            JLabel expiryDateLabel = new JLabel("Expiry Date:");
            expiryDateField = new JTextField(15);
            panel.add(expiryDateLabel);
            panel.add(expiryDateField);

            JLabel descriptionLabel = new JLabel("Description:");
            descriptionField = new JTextField(15);
            panel.add(descriptionLabel);
            // panel.add(descriptionField);
            JLabel descriptionValue = new JLabel((productList[selected][6]) + "");
            panel.add(descriptionValue);

            addButton = new JButton("Add");
            cancelButton = new JButton("Cancel");

            addButton.addActionListener((e) -> {    
                    int index = productBox.getSelectedIndex();
                    String id = (String) productList[index][7];
                    if (index < 0) {
                        JOptionPane.showMessageDialog(AddInventoryDialog.this, "Please select a product", "Error", JOptionPane.ERROR_MESSAGE);
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

                    String category = categoryField.getText();
                    String expiryDate = expiryDateField.getText();
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
}
