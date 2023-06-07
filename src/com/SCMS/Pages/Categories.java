package com.SCMS.Pages;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.SCMS.Utils.Database;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Categories extends JPanel {

    private DefaultListModel<String> categoryListModel;
    Object[][] categories;
    String[] categoryNames;
    Database db = new Database();

    public Categories() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, getHeight()));
        setLayout(new BorderLayout());
        
        setBorder(new EmptyBorder(10, 10, 10, 10));

        categories = db.getCategories();
        categoryNames = new String[categories.length];
        for (int i = 0; i < categories.length; i++) {
            categoryNames[i] = (String) categories[i][1];
        }

        // Categories panel
        JPanel categoriesPanel = new JPanel();
        categoriesPanel.setLayout(new BorderLayout());
        categoriesPanel.setBorder(BorderFactory.createTitledBorder("Categories"));

        // Create a sample list of categories
        categoryListModel = new DefaultListModel<>();
        for (String categoryName : categoryNames) {
            categoryListModel.addElement(categoryName);
        }

        JList<String> categoryJList = new JList<>(categoryListModel);
        JScrollPane categoryScrollPane = new JScrollPane(categoryJList);
        categoriesPanel.add(categoryScrollPane, BorderLayout.CENTER);


        // Add Category button
        JButton addCategoryButton = new JButton("Add Category");
        addCategoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String categoryName = JOptionPane.showInputDialog("Enter Category Name");
                if (categoryName != null) {
                    // Add the category to the list and database
                    db.addCategory(categoryName);
                    categories = db.getCategories();
                    categoryNames = new String[categories.length];
                    for (int i = 0; i < categories.length; i++) {
                        categoryNames[i] = (String) categories[i][1];
                    }
                    categoryJList.setListData(categoryNames);
                }
            }
        });
        categoriesPanel.add(addCategoryButton, BorderLayout.SOUTH);

        add(categoriesPanel, BorderLayout.CENTER);

        // Remove Category button
        JButton removeCategoryButton = new JButton("Remove Category");
        removeCategoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = categoryJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    // Remove the category from the list and database
                    db.removeCategory((String) categories[selectedIndex][0]);
                    categories = db.getCategories();
                    categoryNames = new String[categories.length];
                    for (int i = 0; i < categories.length; i++) {
                        categoryNames[i] = (String) categories[i][1];
                    }
                    categoryJList.setListData(categoryNames);
                }
            }
        });
        add(removeCategoryButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}
