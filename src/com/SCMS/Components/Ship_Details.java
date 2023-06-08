package com.SCMS.Components;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ship_Details extends JPanel {
	String DB_URL = "jdbc:mysql://localhost/SCMS";
	String USERNAME = "root";
	String PASSWORD = "";
	int page = 0;

	public Ship_Details(String shipID, String starting_point, String destination, String status) {

		setBackground(new Color(204, 204, 204));
		setBounds(463, 0, 923, 769);

		setLayout(null);

		Panel panel_5 = new Panel();
		panel_5.setBounds(0, 0, 923, 161);
		add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_9 = new JLabel("Shipment ID");
		lblNewLabel_9.setBounds(10, 10, 123, 25);
		panel_5.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblNewLabel_10 = new JLabel(shipID);
		lblNewLabel_10.setBounds(20, 45, 79, 25);
		panel_5.add(lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.ITALIC, 17));

		JButton btnNewButton_3 = new JButton(status);
		btnNewButton_3.setBounds(575, 11, 99, 31);
		panel_5.add(btnNewButton_3);
		btnNewButton_3.setForeground(new Color(102, 102, 255));
		btnNewButton_3.setBackground(new Color(0, 204, 255));

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBounds(114, 72, 170, 55);
		panel_5.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_11 = new JLabel("From");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_11.setBounds(10, 1, 120, 21);
		panel_6.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel(starting_point);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_12.setBounds(10, 32, 120, 23);
		panel_6.add(lblNewLabel_12);

		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBackground(Color.WHITE);
		panel_6_1.setBounds(338, 72, 170, 55);
		panel_5.add(panel_6_1);
		panel_6_1.setLayout(null);

		JLabel lblNewLabel_13 = new JLabel("To");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_13.setBounds(0, -1, 128, 23);
		panel_6_1.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel(destination);
		lblNewLabel_14.setBounds(0, 32, 99, 23);
		panel_6_1.add(lblNewLabel_14);

		JPanel panel_7 = new JPanel();

		panel_7.setBounds(0, 161, 923, 255);
		add(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setBackground(new Color(255, 255, 255));
		lblNewLabel_17.setIcon(new ImageIcon("C:\\Users\\arars\\Desktop\\java\\SCMS\\lib\\icons\\2023-06-06 (1).png"));
		panel_7.add(lblNewLabel_17);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 418, 923, 351);
		add(panel_8);
		panel_8.setLayout(null);

		JLabel lblNewLabel_18 = new JLabel("Orders");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_18.setBounds(10, 10, 108, 28);
		panel_8.add(lblNewLabel_18);

		JLabel lblNewLabel_19 = new JLabel("#");
		lblNewLabel_19.setBounds(10, 65, 45, 13);
		panel_8.add(lblNewLabel_19);

		JLabel lblNewLabel_20 = new JLabel("Order_id");
		lblNewLabel_20.setBounds(65, 65, 66, 13);
		panel_8.add(lblNewLabel_20);

		JLabel lblNewLabel_21 = new JLabel("Product_name");
		lblNewLabel_21.setBounds(229, 65, 96, 13);
		panel_8.add(lblNewLabel_21);

		JLabel lblNewLabel_21_1 = new JLabel("Order_quantity");
		lblNewLabel_21_1.setBounds(390, 65, 96, 13);
		panel_8.add(lblNewLabel_21_1);

		JPanel panel_9 = new JPanel();
		panel_9.setBounds(0, 91, 923, 193);
		panel_8.add(panel_9);
		panel_9.setLayout(new GridLayout(4, 1, 0, 0));
		try {
			Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			Statement stmt = jdbcConnect.createStatement();

			ResultSet rsData = stmt.executeQuery(
					"select * from orders o join users u on o.user_id = u.user_id join products p on o.product_id = p.product_id where shipment_id="
							+ shipID + " limit " + page + ",4");
			while (rsData.next()) {
				panel_9.add(new order_list(shipID, Integer.toString(rsData.getInt("order_id")),
						rsData.getString("name"), Integer.toString(rsData.getInt("price")),
						Integer.toString(rsData.getInt("order_quantity")),
						Integer.toString(rsData.getInt("order_quantity") * rsData.getInt("price")),
						rsData.getString("username")));

			}
			rsData.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		JButton btnNewButton_4_2 = new JButton("<");
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (page != 0) {
					page = page - 4;
					panel_9.removeAll();
					panel_9.revalidate();
					panel_9.repaint();
					try {
						Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
						Statement stmt = jdbcConnect.createStatement();

						ResultSet rsData = stmt.executeQuery(
								"select * from orders o join users u on o.user_id = u.user_id join products p on o.product_id = p.product_id where shipment_id="
										+ shipID + " limit " + page + ",4");
						while (rsData.next()) {
							panel_9.add(new order_list(shipID, Integer.toString(rsData.getInt("order_id")),
									rsData.getString("name"), Integer.toString(rsData.getInt("price")),
									Integer.toString(rsData.getInt("order_quantity")),
									Integer.toString(rsData.getInt("order_quantity") * rsData.getInt("price")),
									rsData.getString("username")));

						}
						rsData.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_4_2.setBounds(602, 61, 42, 21);
		panel_8.add(btnNewButton_4_2);

		JButton btnNewButton_4_1_1 = new JButton(">");
		btnNewButton_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
					Statement stmt = jdbcConnect.createStatement();
					Statement stmt1 = jdbcConnect.createStatement();
					ResultSet count = stmt1
							.executeQuery("SELECT count(*) as count from orders where shipment_id=" + shipID);
					count.next();
					if (page + 4 < count.getInt("count")) {
						page = page + 4;
						panel_9.removeAll();
						panel_9.revalidate();
						panel_9.repaint();
						ResultSet rsData = stmt.executeQuery(
								"select * from orders o join users u on o.user_id = u.user_id join products p on o.product_id = p.product_id where shipment_id="
										+ shipID + " limit " + page + ",4");
						while (rsData.next()) {
							panel_9.add(new order_list(shipID, Integer.toString(rsData.getInt("order_id")),
									rsData.getString("name"), Integer.toString(rsData.getInt("price")),
									Integer.toString(rsData.getInt("order_quantity")),
									Integer.toString(rsData.getInt("order_quantity") * rsData.getInt("price")),
									rsData.getString("username")));

						}
						rsData.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_4_1_1.setBounds(654, 61, 42, 21);
		panel_8.add(btnNewButton_4_1_1);

		JLabel lblNewLabel_21_1_1 = new JLabel("Total Price");
		lblNewLabel_21_1_1.setBounds(496, 65, 96, 13);
		panel_8.add(lblNewLabel_21_1_1);

		JLabel lblNewLabel_26 = new JLabel("Price");
		lblNewLabel_26.setBounds(335, 65, 45, 13);
		panel_8.add(lblNewLabel_26);

		JLabel lblNewLabel_21_2 = new JLabel("Customer");
		lblNewLabel_21_2.setBounds(146, 65, 73, 13);
		panel_8.add(lblNewLabel_21_2);
	}

}