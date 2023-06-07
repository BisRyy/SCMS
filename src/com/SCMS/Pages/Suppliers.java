package com.SCMS.Pages;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Suppliers extends JPanel {
    private JPanel productPanel;
    private List<Product> products;

    public Suppliers() {
        setSize(1200, 800);
        setLayout(new BorderLayout());

        // Product panel
        productPanel = new JPanel(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane(productPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Initialize sample products
        products = createSampleProducts();

        // Add products to the panel
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.insets = new Insets(10, 10, 10, 10);

        int columnCount = 0;
        int rowCount = 0;

        for (Product product : products) {
            JPanel cardPanel = createProductCard(product);

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

    private List<Product> createSampleProducts() {
        List<Product> productList = new ArrayList<>();

        productList.add(new Product("Product 1", "Description of Product 1", "$9.99", "lib/product.png"));
        productList.add(new Product("Product 2", "Description of Product 2", "$19.99", "lib/product.png"));
        productList.add(new Product("Product 3", "Description of Product 3", "$29.99", "lib/product.png"));
        productList.add(new Product("Product 4", "Description of Product 4", "$39.99", "lib/product.png"));
        productList.add(new Product("Product 5", "Description of Product 5", "$49.99", "lib/product.png"));
        productList.add(new Product("Product 1", "Description of Product 1", "$9.99", "lib/product.png"));
        productList.add(new Product("Product 2", "Description of Product 2", "$19.99", "lib/product.png"));
        productList.add(new Product("Product 3", "Description of Product 3", "$29.99", "lib/product.png"));
        productList.add(new Product("Product 4", "Description of Product 4", "$39.99", "lib/product.png"));
        productList.add(new Product("Product 5", "Description of Product 5", "$49.99", "lib/product.png"));

        return productList;
    }

    private JPanel createProductCard(Product product) {
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
        cardPanel.setPreferredSize(new Dimension(200, 250));
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        cardPanel.setBackground(Color.WHITE);

        // Product image
        ImageIcon imageIcon = new ImageIcon(product.getImagePath());
        Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardPanel.add(imageLabel);

        // Product name
        JLabel nameLabel = new JLabel(product.getName());
        nameLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardPanel.add(nameLabel);

        // Product description
        JLabel descLabel = new JLabel("<html><body style='width: 150px; text-align: center;'>"
                + product.getDescription() + "</body></html>");
        descLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        descLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardPanel.add(descLabel);

        // Product price
        JLabel priceLabel = new JLabel(product.getPrice());
        priceLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardPanel.add(priceLabel);

        return cardPanel;
    }

    private class Product {
        private String name;
        private String description;
        private String price;
        private String imagePath;

        public Product(String name, String description, String price, String imagePath) {
            this.name = name;
            this.description = description;
            this.price = price;
            this.imagePath = imagePath;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getPrice() {
            return price;
        }

        public String getImagePath() {
            return imagePath;
        }
    }

}
