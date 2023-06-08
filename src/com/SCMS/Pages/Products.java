package com.SCMS.Pages;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.SCMS.Utils.Database;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

public class Products extends JPanel {
    String[] columnNames = { "Code", "Name", "Price", "Unit", "Category", "Supplier", "Description" };
    private JTable productsTable;
    private Object[][] productList;
    Database db = new Database();
    Object[][] categories = db.getCategories();
    String[] categoryName = new String[categories.length];
    private JScrollPane scrollPane;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private int selected = -1;
    String companyId;
    private JLabel profilePictureLabel;
    String image = "lib/product.png";

    public Products(String companyId) {
        initializeUI(companyId);
        this.companyId = companyId;
        addButton.addActionListener(e -> {
            AddProductDialog addProductDialog = new AddProductDialog();
            addProductDialog.setVisible(true);

            // reload the updated products table
            DefaultTableModel model = new DefaultTableModel(productList = db.getProducts(companyId), columnNames);
            productsTable.setModel(model);
        });
        deleteButton.addActionListener((e)->{
            if (selected != -1) {
                int confirm = JOptionPane.showConfirmDialog(this, "Do you want to delete " + productList[selected][0], "Are you sure?", JOptionPane.ERROR_MESSAGE);
                if (confirm == 0) {
                    db.removeProduct((String) productList[selected][7]);
                    productList = db.getProducts(companyId);
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

    private void initializeUI(String companyId) {
        setLayout(new BorderLayout());

        // Product Table
        productsTable = new JTable();
        scrollPane = new JScrollPane(productsTable);
        add(scrollPane, BorderLayout.CENTER);

        productsTable.setFillsViewportHeight(true);
        productsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add some dummy data to the table
        productList = db.getProducts(companyId);
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

    private class AddProductDialog extends JDialog {
        private JTextField nameField;
        private JTextField priceField;
        private JTextField unitField;
        private JComboBox<String> categoryField;
        // private JComboBox<String> supplierField;
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
            categoryName = new String[categories.length];
            for (int i = 0; i < categoryName.length; i++) {
                categoryName[i] = (String) categories[i][1];
            }

            categoryField = new JComboBox<>(categoryName);
            panel.add(categoryLabel);
            panel.add(categoryField);

            Object[][] suppliers = db.getSuppliers();
            String[] supplierName = new String[suppliers.length];
            for (int i = 0; i < supplierName.length; i++) {
                supplierName[i] = (String) suppliers[i][0];
            }

            // JLabel supplierLabel = new JLabel("Supplier:");
            // supplierField = new JComboBox<>(supplierName);
            // panel.add(supplierLabel);
            // panel.add(supplierField);

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
                String categoryId = (String) categories[categoryField.getSelectedIndex()][0];
                // int supplierIndex = supplierField.getSelectedIndex();
                String description = descriptionField.getText();
                String code = "code" + new Random().nextInt(100);
                db.addProduct(name, code, price, unit, categoryId, description, image, companyId);

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
            // JPanel mainPanel = new JPanel(new BorderLayout());
            // mainPanel.add(panel, BorderLayout.CENTER);
            
            getContentPane().add(ProfilePicture(), BorderLayout.NORTH);
            getContentPane().add(panel, BorderLayout.CENTER);
            getContentPane().add(buttonPanel, BorderLayout.SOUTH);

            pack();
        }
    }

    private JPanel ProfilePicture() {
        JPanel profilePicturePanel = new JPanel();
        profilePicturePanel.setLayout(new BorderLayout());
        profilePicturePanel.setBorder(BorderFactory.createTitledBorder("Profile Picture"));

        profilePictureLabel = new JLabel();
        profilePictureLabel.setPreferredSize(new Dimension(150, 150));
        profilePicturePanel.setPreferredSize(new Dimension(150, 150));
        profilePictureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        profilePictureLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton uploadButton = new JButton("Upload");
        uploadButton.addActionListener((e) -> {
            uploadProfilePicture();
        });

        profilePicturePanel.add(profilePictureLabel, BorderLayout.CENTER);
        profilePicturePanel.add(uploadButton, BorderLayout.SOUTH);

        return profilePicturePanel;
    }


    private void uploadProfilePicture() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            // Perform image upload and update the profile picture label
            image = selectedFile.getPath();
            ImageIcon imageIcon = new ImageIcon(selectedFile.getPath());
            // scale image
            Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            profilePictureLabel.setIcon(new ImageIcon(image));
        }
    }
}
