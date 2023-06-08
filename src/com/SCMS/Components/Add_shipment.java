package com.SCMS.Components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.Choice;

public class Add_shipment extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private List<Integer> selectedRows;
    private JButton showSelectedButton;
    String DB_URL = "jdbc:mysql://localhost:3306/SCMS";
    String USERNAME = "root";
    String PASSWORD = "";
    int ship = 1;
    private TableColumn checkboxColumn;

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Add_shipment frame = new Add_shipment();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Add_shipment() {
        setTitle("Table Selection Example");

        setPreferredSize(new Dimension(600, 300));

        // Create table model with sample data
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Select");
        tableModel.addColumn("order_id");
        tableModel.addColumn("Name");
        tableModel.addColumn("Produt_Name");
        tableModel.addColumn("Price");
        tableModel.addColumn("Order_quantity");
        tableModel.addColumn("order_date");

        // Add sample data rows
        try (Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            Statement stmt = jdbcConnect.createStatement();

            ResultSet rsData = stmt.executeQuery(
                    "select * from orders o join users u on o.user_id = u.user_id join products p on o.product_id = p.product_id where order_status =\"Accepted\"");

            while (rsData.next()) {
                tableModel.addRow(new Object[] { false, Integer.toString(rsData.getInt("order_id")),
                        rsData.getString("username"), rsData.getString("name"),
                        Integer.toString(rsData.getInt("price")),
                        rsData.getString("order_quantity"), rsData.getString("order_date") });
            }
            rsData.close();
        }

        catch (SQLException e1) {
            e1.printStackTrace();
        }
        //

        // Create JTable with the table model
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Create list to store selected row indices
        selectedRows = new ArrayList<>();

        // Add list selection listener to the table
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();

                    // Clear the previous selection
                    selectedRows.clear();

                    // Check if a row is selected
                    if (selectedRow != -1) {
                        selectedRows.add(selectedRow);
                    }
                }
            }
        });

        // Create checkbox column
        TableColumn checkboxColumn = table.getColumnModel().getColumn(0);
        checkboxColumn.setCellEditor(table.getDefaultEditor(Boolean.class));
        checkboxColumn.setCellRenderer(table.getDefaultRenderer(Boolean.class));
        JPanel buttonPanel = new JPanel();

        // Add the table and button panel to the frame
        getContentPane().setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        JLabel ll = new JLabel("Starting point");
        String[] starting_point = { "warehouse1", "warehouse2", "warehouse3" };
        JComboBox<String> startP = new JComboBox<>(starting_point);
        JLabel Destination = new JLabel("Destination");
        String[] destination = { "warehouse4", "warehouse5", "warehouse6" };
        JComboBox<String> destin = new JComboBox<>(destination);
        buttonPanel.add(ll);
        buttonPanel.add(startP);
        buttonPanel.add(Destination);
        buttonPanel.add(destin);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Create button to show selected items
        showSelectedButton = new JButton("Add To shipments");
        showSelectedButton.addActionListener((e) -> {
            int rowCount = table.getRowCount();
            int colCount = table.getColumnCount();
            int x = 0;

            try (Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {

                Statement stmt1 = jdbcConnect.createStatement();
                Statement stmt2 = jdbcConnect.createStatement();
                Statement stmt3 = jdbcConnect.createStatement();

                stmt3.executeUpdate("insert into shipments (starting_point,destination,shipment_status) values ('"
                        + startP.getSelectedItem().toString() + "','" + destin.getSelectedItem().toString() + "',"
                        + "'In Transit')");
                for (int i = 0; i < rowCount; i++) {
                    Object value1 = true;
                    Object value = table.getValueAt(i, 0);
                    if (value == value1) {
                        x++;
                        for (int j = 1; j < 2; j++) {

                            Object value2 = table.getValueAt(i, j);
                            stmt1.executeUpdate("update orders set  shipment_id=" + ship + " where order_id=" + value2);
                            stmt2.executeUpdate("update orders set order_status=\"Shipped\" where order_id=" + value2);
                        }
                    }
                }
            }

            catch (SQLException e1) {
                e1.printStackTrace();
            }

            ship++;
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "Please Select Order");
            } else {
                JOptionPane.showMessageDialog(null, "Shipment Placed Successfully");
            }
            dispose();

        });
        // Create a panel to hold the button
        buttonPanel.add(showSelectedButton);
        pack();
        setVisible(true);
    }
}
