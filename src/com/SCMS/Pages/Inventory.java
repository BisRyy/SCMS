package com.SCMS.Pages;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.SCMS.Utils.Database;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

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
        editButton.addActionListener((e) -> {
            if (selected >= 0){
                EditInventoryDialog editInventoryDialog = new EditInventoryDialog(selected);
                editInventoryDialog.setVisible(true);
                String[] columnNames = { "Code", "Name", "Quantity", "Price", "Unit", "Category", "Supplier","Date Added", "Expiry Date", "Description" };
                inventoryList = db.getInventory();
                inventoryTable.setModel(new DefaultTableModel(inventoryList, columnNames));
            }else{
                JOptionPane.showMessageDialog(this, "Please select a inventory item to edit.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
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
            AddInventoryDialog addInventoryDialog = new AddInventoryDialog();
            addInventoryDialog.setVisible(true);

            // reload the updated inventory table
            String[] columnNames = {"Code", "Name", "Quantity", "Price","Unit", "Category", "Supplier", "Date Added", "Expiry Date", "Description"};
            inventoryTable.setModel(new DefaultTableModel(inventoryList = db.getInventory(), columnNames));
        }
    }

    private class AddInventoryDialog extends JDialog {
        private JComboBox<String> productBox;
        private JTextField quantityField;
        private JLabel priceField;
        private JLabel unitField;
        private JLabel categoryField;
        private JLabel supplierField;
        private JTextField expiryDateField;
        private JTextArea descriptionField;
        private JButton addButton;
        private JButton cancelButton;
        Object[][] productList = null;
        String[] productNames = null;
        int selected = 0;

        public AddInventoryDialog() {
            setTitle("Add Inventory");
            setModal(true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setResizable(false);
            setLocationRelativeTo(getParent().getParent());

            JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel nameLabel = new JLabel("Product:");
            panel.add(nameLabel);
            productList = db.getProducts();
            productNames = new String[productList.length];
            for(int i=0; i<productList.length;i++){
                productNames[i] = (String) productList[i][1];
            }
            productBox = new JComboBox<String>(productNames);
            panel.add(productBox);
            productBox.addActionListener((e) -> {
                selected = productBox.getSelectedIndex();
                priceField.setText(productList[selected][2].toString());
                unitField.setText(productList[selected][3].toString());
                categoryField.setText(productList[selected][4].toString());
                supplierField.setText(productList[selected][5].toString());
                repaint();
                revalidate();
            });

            selected = productBox.getSelectedIndex();

            JLabel priceLabel = new JLabel("Price:");
            panel.add(priceLabel);
            priceField = new JLabel(inventoryTable.getValueAt(selected, 3).toString());
            panel.add(priceField);

            JLabel quantityLabel = new JLabel("Quantity:");
            panel.add(quantityLabel);
            quantityField = new JTextField();
            panel.add(quantityField);


            JLabel unitLabel = new JLabel("Unit:");
            panel.add(unitLabel);
            unitField = new JLabel(inventoryTable.getValueAt(selected, 4).toString());
            panel.add(unitField);

            JLabel expiryDateLabel = new JLabel("Expiry Date:");
            panel.add(expiryDateLabel);
            expiryDateField = new JTextField();
            panel.add(expiryDateField);

            JLabel categoryLabel = new JLabel("Category:");
            panel.add(categoryLabel);
            categoryField = new JLabel(inventoryTable.getValueAt(selected, 5).toString());
            panel.add(categoryField);

            JLabel descriptionLabel = new JLabel("Description:");
            panel.add(descriptionLabel);
            descriptionField = new JTextArea();
            descriptionField.setLineWrap(true);
            descriptionField.setWrapStyleWord(true);
            panel.add(descriptionField);  
            
            JLabel supplierLabel = new JLabel("Supplier:");
            panel.add(supplierLabel);
            supplierField = new JLabel(inventoryTable.getValueAt(selected, 6).toString());
            panel.add(supplierField);

      

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

                    // verify expiry date format 2023-04-05
                    String expirydate = expiryDateField.getText();
                    if (!Pattern.matches("\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])", expirydate)){
                        JOptionPane.showMessageDialog(AddInventoryDialog.this, "Invalid Expiry date format. Use YYYY-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
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

    // edit inventory dialog
    // edit all inventory item features
    private class EditInventoryDialog extends JDialog {
        private JComboBox<String> productBox;
        private JTextField quantityField;
        private JLabel priceField;
        private JLabel unitField;
        private JLabel categoryField;
        private JLabel supplierField;
        private JTextField expiryDateField;
        private JTextArea descriptionField;
        private JButton editButton;
        private JButton cancelButton;
        Object[][] productList = null;
        String[] productNames = null;

        public EditInventoryDialog(int selected){
            setTitle("Edit Inventory");
            setModal(true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setResizable(false);
            setLocationRelativeTo(getParent().getParent());
            add(new EditInventoryPanel(selected));
            pack();
        }
    }  
    
    // edit inventory panel
    private class EditInventoryPanel extends JPanel{
        private JComboBox<String> productBox;
        private JTextField quantityField;
        private JLabel priceField;
        private JLabel unitField;
        private JLabel categoryField;
        private JLabel supplierField;
        private JTextField expiryDateField;
        private JTextArea descriptionField;
        private JButton editButton;
        private JButton cancelButton;
        Object[][] productList = null;
        String[] productNames = null;
        int selected = 0;
        
        public EditInventoryPanel(int index){
            this.selected = index;
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            
            JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel nameLabel = new JLabel("Product:");
            panel.add(nameLabel);
            productList = db.getProducts();
            productNames = new String[productList.length];
            for(int i=0; i<productList.length;i++){
                productNames[i] = (String) productList[i][1];
            }
            productBox = new JComboBox<String>(productNames);
            productBox.setSelectedIndex(selected);
            panel.add(productBox);
            productBox.addActionListener((e) -> {
                selected = productBox.getSelectedIndex();
                priceField.setText(productList[selected][2].toString());
                unitField.setText(productList[selected][3].toString());
                categoryField.setText(productList[selected][4].toString());
                supplierField.setText(productList[selected][5].toString());
                repaint();
                revalidate();
            });

            selected = productBox.getSelectedIndex();

            JLabel priceLabel = new JLabel("Price:");
            panel.add(priceLabel);
            priceField = new JLabel(inventoryTable.getValueAt(selected, 3).toString());
            panel.add(priceField);

            JLabel quantityLabel = new JLabel("Quantity:");
            panel.add(quantityLabel);
            quantityField = new JTextField();
            panel.add(quantityField);
        }
    }
}
