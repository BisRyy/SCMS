package com.SCMS.Pages;


import com.SCMS.Utils.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class Purchase extends JPanel {
    private Object[][] productList;
    Database db = new Database();

    public Purchase(String companyId) {
        setLayout(new BorderLayout());

        productList = db.getInventory(companyId);

        setSize(800, 600);

        // Create the product table
        JTable productTable = createProductTable();
        // productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(productTable);
        add(scrollPane, BorderLayout.CENTER);

        // Create the add to cart section
        JPanel addToCartPanel = createAddToCartPanel(productTable);
        add(addToCartPanel, BorderLayout.SOUTH);
        setVisible(true);

    }

    private JTable createProductTable() {
        String[] columnNames = { "Product Name", "Company", "Price", "Qty. Available", "Category" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (int i = 0; i < productList.length; i++) {
            Object[] rowData = { productList[i][1], productList[i][6], productList[i][3], productList[i][2],
                    productList[i][5] };

            model.addRow(rowData);
        }

        return new JTable(model);
    }

    private JPanel createAddToCartPanel(JTable productTable) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel label = new JLabel("Add Product: ");
        panel.add(label);

        // Create a number field for selecting the product index
        int maxProductIndex = productList.length;
        SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, maxProductIndex, 1);
        JSpinner spinner = new JSpinner(spinnerModel);

        panel.add(spinner);

        // Create the add to cart button
        JButton addToCartButton = new JButton("Add to Cart");
        panel.add(addToCartButton);

        addToCartButton.addActionListener(e -> {
            int selectedProductIndex = Integer.parseInt(spinner.getValue().toString()) - 1;
            Object[] selectedProduct = productList[selectedProductIndex];

            // Open the checkout page for the selected product
            openCheckoutPage(selectedProduct);
        });

        return panel;
    }

    // private JTable createOrderTable() {
    // String[] columnNames = { "Product Name", "Company", "Contact Person",
    // "Quantity", "Status" };
    // DefaultTableModel model = new DefaultTableModel(columnNames, 0);

    // for (Order order : orderList) {
    // Object[] rowData = { order.getProduct(), order.getCompanyName(),
    // order.getContactPerson(),
    // order.getQuantity(), order.getStatus() };
    // model.addRow(rowData);
    // }

    // return new JTable(model);
    // }

    // private JPanel createOrderSummaryPanel() {
    // JPanel panel = new JPanel(new GridLayout(2, 1));

    // JPanel successfulOrdersPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    // JLabel successfulLabel = new JLabel("Successful Orders: ");
    // successfulOrdersLabel = new JLabel("0");
    // successfulOrdersPanel.add(successfulLabel);
    // successfulOrdersPanel.add(successfulOrdersLabel);

    // JPanel unsuccessfulOrdersPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    // JLabel unsuccessfulLabel = new JLabel("Unsuccessful Orders: ");
    // unsuccessfulOrdersLabel = new JLabel("0");
    // unsuccessfulOrdersPanel.add(unsuccessfulLabel);
    // unsuccessfulOrdersPanel.add(unsuccessfulOrdersLabel);

    // panel.add(successfulOrdersPanel);
    // panel.add(unsuccessfulOrdersPanel);

    // return panel;
    // }

    private void openCheckoutPage(Object[] product) {
        JFrame checkoutFrame = new JFrame("Checkout Page");
        checkoutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        checkoutFrame.setSize(600, 600);
        // checkoutFrame.setLocationRelativeTo(null);
        checkoutFrame.setLocation(200, 200);

        JPanel formPanel = new JPanel(new GridLayout(11, 2));
        formPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel companyNameLabel = new JLabel("Company Name:");
        JTextField companyNameField = new JTextField((String) product[6], 10);
        formPanel.add(companyNameLabel);
        formPanel.add(companyNameField);

        JLabel SupplierLable = new JLabel("Address:");
        JTextField SupplierCompany = new JTextField((String) product[1], 10);
        formPanel.add(SupplierLable);
        formPanel.add(SupplierCompany);

        // JPanel row2 = new JPanel();
        JLabel contactPersonLabel = new JLabel("Contact Person:");
        JTextField contactPersonField = new JTextField("Bisrat", 10);
        formPanel.add(contactPersonLabel);
        formPanel.add(contactPersonField);

        JLabel contactNumberLabel = new JLabel("Contact Number:");
        JTextField contactNumberField = new JTextField("0912345678", 10);
        formPanel.add(contactNumberLabel);
        formPanel.add(contactNumberField);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField("bisry@proton.me", 20);
        formPanel.add(emailLabel);
        formPanel.add(emailField);

        JLabel deliveryDateLabel = new JLabel("Delivery Date:");
        JTextField deliveryDateField = new JTextField("2023-07-01", 10);
        formPanel.add(deliveryDateLabel);
        formPanel.add(deliveryDateField);

        JLabel quantityLabel = new JLabel("Quantity:");
        int qty = (int) product[2];
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 0, qty, 1);
        JSpinner quantitySpinner = new JSpinner(spinnerModel);

        JLabel feeLabel = new JLabel("Fee:");
        JLabel feeField = new JLabel(product[3] + " Birr");
        formPanel.add(quantityLabel);
        formPanel.add(quantitySpinner);
        formPanel.add(feeLabel);
        formPanel.add(feeField);

        JLabel paymentOptionLabel = new JLabel("Payment Option:");
        String[] paymentOptions = { "Cash", "Cheque", "Credit" };
        JComboBox<String> paymentOptionComboBox = new JComboBox<>(paymentOptions);
        formPanel.add(paymentOptionLabel);
        formPanel.add(paymentOptionComboBox);

        JLabel additionalNotesLabel = new JLabel("Additional Notes:");
        JTextArea additionalNotesField = new JTextArea("Please deliver the product on time.", 5, 20);
        additionalNotesField.setLineWrap(true);
        JScrollPane additionalNotesScrollPane = new JScrollPane(additionalNotesField);

        formPanel.add(additionalNotesLabel);
        formPanel.add(additionalNotesScrollPane);

        JButton orderButton = new JButton("Order");
        JButton cancelButton = new JButton("Cancel");
        formPanel.add(orderButton);
        formPanel.add(cancelButton);

        orderButton.addActionListener(e -> {
            // Order button action handling
            String companyName = companyNameField.getText();
            String SupplierComp = SupplierCompany.getText();
            String contactPerson = contactPersonField.getText();
            String contactNumber = contactNumberField.getText();
            String email = emailField.getText();
            String deliveryDate = deliveryDateField.getText();
            int quantity = (int) quantitySpinner.getValue();
            String paymentOption = (String) paymentOptionComboBox.getSelectedItem();
            String additionalNotes = additionalNotesField.getText();

            if (companyName.isEmpty() || SupplierComp.isEmpty() || contactPerson.isEmpty() || contactNumber.isEmpty() ||
                    email.isEmpty() || deliveryDate.isEmpty() || quantity == 0 || paymentOption.isEmpty() ||
                    additionalNotes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            } else {
                // Create the order
                // Order order = new Order(product, companyName, address, contactPerson,
                // contactNumber, email,
                // deliveryDate, quantity, paymentOption, additionalNotes);

                // // Add the order to the order list
                // orderList.add(order);

                // // Update the order table
                // updateOrderTable();

                // Close the checkout page
                formPanel.removeAll();
                formPanel.setLayout(new BorderLayout());
                // Display "Ordered successfully" message

                if (db.orderProduct("1", product[10].toString(), quantity, "pending")) {
                    JOptionPane.showMessageDialog(null, "Order Placed Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "500 : SERVER ERROR");
                }

                // // Show "Go to Order Page" button
                // JButton goToOrderPageButton = new JButton("Go to Order Page");
                // formPanel.add(goToOrderPageButton, BorderLayout.SOUTH);

                // goToOrderPageButton.addActionListener(e1 -> {
                // // Go to order page button action handling
                // checkoutFrame.dispose();
                // // openOrderListPage();
                // });

                // formPanel.revalidate();
                // formPanel.repaint();
                checkoutFrame.dispose();
            }
        });

        cancelButton.addActionListener(e -> {
            // Cancel button action handling
            checkoutFrame.dispose();
        });

        checkoutFrame.add(formPanel);
        checkoutFrame.setVisible(true);
    }

    // private void openOrderListPage() {
    // JFrame orderListFrame = new JFrame("Order List Page");
    // orderListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    // orderListFrame.setSize(800, 600);
    // orderListFrame.setLocationRelativeTo(null);

    // JPanel panel = new JPanel(new GridLayout(1, 2));
    // panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

    // JPanel tablePanel = new JPanel(new BorderLayout());

    // // Create the order table
    // orderTable = createOrderTable();
    // JScrollPane scrollPane = new JScrollPane(orderTable);
    // tablePanel.add(scrollPane);

    // orderListFrame.add(tablePanel);
    // orderListFrame.setVisible(true);
    // }

    // private void updateOrderTable() {
    // String[] columnNames = { "Product Name", "Company", "Contact Person",
    // "Quantity", "Status" };
    // DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    // orderTable = new JTable(model);
    // orderTable.setModel(model);

    // for (Order order : orderList) {
    // Object[] rowData = { order.getProduct().getName(), order.getCompanyName(),
    // order.getContactPerson(),
    // order.getQuantity(), order.getStatus() };
    // model.addRow(rowData);
    // }
    // }
}
