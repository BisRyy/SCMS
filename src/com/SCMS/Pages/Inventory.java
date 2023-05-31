//package com.SCMS.Pages;
//import java.awt.Color;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//public class Inventory extends JPanel{
//    private JTable inventoryTable;
//    private JScrollPane scrollPane;
//
//    public Inventory(){
//        setBackground(Color.LIGHT_GRAY);
//         String[] columnNames = {"Item", "Quantity", "Location", "Description", "Cost per item", "Inventory value"};
//        Object[][] data = {
//            {"Product A", 100, "Warehouse 1", "Something good", 300, 30000},
//            {"Product B", 50, "Warehouse 2", "Something better", 400, 20000},
//            {"Product C", 75, "Warehouse 1", "Something bad", 1000, 75000},
//            {"Product D", 120, "Warehouse 3", "Something worse", 500, 60000}
//        };
//        
//        DefaultTableModel model = new DefaultTableModel(data, columnNames);
//        inventoryTable = new JTable(model);
//
//        // Add a mouse listener to the table
//        inventoryTable.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                    int row = inventoryTable.getSelectedRow();
//                    int col = inventoryTable.getSelectedColumn();
//
//                    if (col == 0 && inventoryTable.getValueAt(row, col).equals("Product A")) {
//                    ProductAPage productAPage = new ProductAPage();
//                    productAPage.setVisible(true);
//                    }else if (col == 0 && inventoryTable.getValueAt(row, col).equals("Product B")) {
//                    ProductBPage productBPage = new ProductBPage();
//                    productBPage.setVisible(true);
//                    }else if (col == 0 && inventoryTable.getValueAt(row, col).equals("Product C")) {
//                    ProductCPage productCPage = new ProductCPage();
//                    productCPage.setVisible(true);
//                    }else if (col == 0 && inventoryTable.getValueAt(row, col).equals("Product D")) {
//                    ProductDPage productDPage = new ProductDPage();
//                    productDPage.setVisible(true);
//                    }
//            }
//        });
//
//                    // Set up the scroll pane
//                    scrollPane = new JScrollPane(inventoryTable);
//                    add(scrollPane);
//
//                    // Display the JFrame
//        setVisible(true);
//    }
//
//public static void main(String[] args) {
//        Inventory inventoryPage = new Inventory();
//        }
//}
//    
//    
//
