package com.SCMS.Pages;

import javax.swing.*;

import com.SCMS.Auth.SessionManager;
import com.SCMS.Utils.Database;
import java.awt.*;

public class Purchase extends JPanel {
    private JPanel productPanel;
    private Object[][] products;
    private Database db = new Database();
    private int selectedProductId = -1;
    private String companyId;

    public Purchase(String companyId) {
        this.companyId = companyId;
        setSize(1200, 800);
        setLayout(new BorderLayout());
        
        // Initialize sample products
        products = db.getInventory(companyId, 1);
        
        // Add products to the panel
        productPanel = new JPanel(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane(productPanel);
        add(scrollPane, BorderLayout.CENTER);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.insets = new Insets(10, 10, 10, 10);

        int columnCount = 0;
        int rowCount = 0;

        for (Object[] product : products) {
            JPanel cardPanel = createProductCard(product);
            cardPanel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    selectedProductId = Integer.parseInt(product[0].toString());
                    openCheckoutPage(product);
                }
            });

            constraints.gridx = columnCount;
            constraints.gridy = rowCount;
            productPanel.add(cardPanel, constraints);

            columnCount++;
            if (columnCount == 4) {
                columnCount = 0;
                rowCount++;
            }
        }

        setVisible(true);
    }

    private JPanel createProductCard(Object[] product) {
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
        cardPanel.setPreferredSize(new Dimension(200, 250));
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        cardPanel.setBackground(Color.WHITE);

        // Product image
        ImageIcon imageIcon = new ImageIcon(product[12].toString());
        Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardPanel.add(imageLabel);

        // Product name
        JLabel nameLabel = new JLabel(product[1].toString());
        nameLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardPanel.add(nameLabel);

        // Product description
        JLabel descLabel = new JLabel(product[9].toString());
        descLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        descLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardPanel.add(descLabel);

        // Product price
        JLabel priceLabel = new JLabel(product[3].toString());
        priceLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardPanel.add(priceLabel);

        return cardPanel;
    }
    
    public void openCheckoutPage(Object[] product) {
        JFrame checkoutFrame = new JFrame("Checkout Page");
        checkoutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        checkoutFrame.setSize(600, 600);
        checkoutFrame.setLocationRelativeTo(null);

        JPanel formPanel = new JPanel(new GridLayout(11, 2, 10, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 0, 50));

        JLabel companyNameLabel = new JLabel("Company Name:");
        JLabel companyName = new JLabel((String) product[6]);
        formPanel.add(companyNameLabel);
        formPanel.add(companyName);

        JLabel productLabel = new JLabel("Product:");
        JLabel ProductName = new JLabel((String) product[1]);
        formPanel.add(productLabel);   
        formPanel.add(ProductName);

        JLabel contactPersonLabel = new JLabel("Contact Person:");
        JTextField contactPersonField = new JTextField(SessionManager.getAuthenticatedUser(), 10);
        formPanel.add(contactPersonLabel);
        formPanel.add(contactPersonField);

        JLabel contactNumberLabel = new JLabel("Contact Number:");
        JTextField contactNumberField = new JTextField("", 10);
        formPanel.add(contactNumberLabel);
        formPanel.add(contactNumberField);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField("", 20);
        formPanel.add(emailLabel);
        formPanel.add(emailField);

        JLabel quantityLabel = new JLabel("Quantity:");
        int qty = (int) product[2];
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, qty, 10);
        JSpinner quantitySpinner = new JSpinner(spinnerModel);

        JLabel feeLabel = new JLabel("Fee:");
        JLabel feeField = new JLabel();

        quantitySpinner.addChangeListener(e -> {
            int quantity = (int) quantitySpinner.getValue();
            double price = Double.parseDouble(product[3].toString());
            feeField.setText(String.valueOf(quantity * price));
        });
        
        formPanel.add(quantityLabel);
        formPanel.add(quantitySpinner);
        formPanel.add(feeLabel);
        formPanel.add(feeField);

        JLabel paymentOptionLabel = new JLabel("Payment Option:");
        String[] paymentOptions = { "Cash", "Check", "Credit" };
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

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(orderButton);
        buttonPanel.add(cancelButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        orderButton.addActionListener(e -> {
            // Order button action handling
            String contactPerson = contactPersonField.getText();
            String contactNumber = contactNumberField.getText();
            String email = emailField.getText();
            int quantity = (int) quantitySpinner.getValue();
            String paymentOption = (String) paymentOptionComboBox.getSelectedItem();
            String note = additionalNotesField.getText();

            if (contactPerson.isEmpty() || contactNumber.isEmpty() ||
                    email.isEmpty() || quantity == 0 || paymentOption.isEmpty() ||
                    note.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            } else {
                // formPanel.removeAll();
                // formPanel.setLayout(new BorderLayout());

                // Display "Ordered successfully" message
                if (db.orderProduct("1", product[10].toString(), quantity, "Waiting",companyId, note)) {
                    JOptionPane.showMessageDialog(null, "Order Placed Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "500 : SERVER ERROR");
                }
                checkoutFrame.dispose();
            }
        });

        cancelButton.addActionListener(e -> {
            // Cancel button action handling
            checkoutFrame.dispose();
        });

        checkoutFrame.add(mainPanel);
        checkoutFrame.setVisible(true);
    }
}