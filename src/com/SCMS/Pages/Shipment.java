package com.SCMS.Pages;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JTextField;

import com.SCMS.Components.Add_shipment;
import com.SCMS.Components.Ship;
import com.SCMS.Components.Ship_Details;
import com.SCMS.Components.order_list;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Shipment extends JPanel {
	private JTextField textField;
	private Add_shipment add;
	private Ship ship;
	private order_list ord;
	private Ship_Details shipD;
	int page = 0;
	int track_number = 234;
	String DB_URL = "jdbc:mysql://localhost/SCMS";
	String USERNAME = "root";
	String PASSWORD = "";
	String QUERY = "select * from shipments limit " + page + ",3";

	public Ship_Details[] shiping;

	public Shipment() {

		shiping = new Ship_Details[100];
		setLayout(null);

		JPanel panel = new JPanel();

		panel.setBounds(0, 0, 462, 769);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 462, 95);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Shipments");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(32, 10, 154, 43);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Track your shipment");
		lblNewLabel_1.setForeground(new Color(204, 204, 204));
		lblNewLabel_1.setBounds(32, 53, 131, 25);
		panel_1.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(321, 30, 131, 19);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Search");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\arars\\Desktop\\java\\SCMS\\lib\\icons\\search.png"));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(243, 25, 68, 25);
		panel_1.add(lblNewLabel_2);

		JButton btnNewButton_4 = new JButton("<");
		btnNewButton_4.setBounds(360, 74, 42, 21);
		panel_1.add(btnNewButton_4);

		JButton btnNewButton_4_1 = new JButton(">");
		btnNewButton_4_1.setBounds(412, 74, 42, 21);
		panel_1.add(btnNewButton_4_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 93, 462, 549);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 1, 0, 5));

		try {
			Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			Statement stmt = jdbcConnect.createStatement();
			ResultSet rsData = stmt.executeQuery(QUERY);
			while (rsData.next()) {
				panel_2.add(new Ship(Integer.toString(rsData.getInt("shipment_id")), rsData.getString("starting_point"),
						rsData.getString("destination"), rsData.getString("shipment_status"),
						Integer.toString(track_number * rsData.getInt("shipment_id"))));
			}
			rsData.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (page != 0) {
					page = page - 3;
					panel_2.removeAll();
					panel_2.revalidate();
					panel_2.repaint();
					try {
						Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
						Statement stmt = jdbcConnect.createStatement();
						ResultSet rsData = stmt.executeQuery("select * from shipments limit " + page + ",3");
						while (rsData.next()) {
							panel_2.add(new Ship(Integer.toString(rsData.getInt("shipment_id")),
									rsData.getString("starting_point"), rsData.getString("destination"),
									rsData.getString("shipment_status"),
									Integer.toString(track_number * rsData.getInt("shipment_id"))));
						}
						rsData.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
					Statement stmt = jdbcConnect.createStatement();
					Statement stmt1 = jdbcConnect.createStatement();
					ResultSet count = stmt1.executeQuery("SELECT count(*) as count from shipments;");
					count.next();
					if (page + 3 < count.getInt("count")) {
						page = page + 3;
						panel_2.removeAll();
						panel_2.revalidate();
						panel_2.repaint();
						ResultSet rsData = stmt.executeQuery("select * from shipments limit " + page + ",3");
						while (rsData.next()) {
							panel_2.add(new Ship(Integer.toString(rsData.getInt("shipment_id")),
									rsData.getString("starting_point"), rsData.getString("destination"),
									rsData.getString("shipment_status"),
									Integer.toString(track_number * rsData.getInt("shipment_id"))));
						}
						rsData.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		JButton btnNewButton_6 = new JButton("Add New Shipment");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Add_shipment();

			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_6.setBounds(122, 662, 183, 21);
		panel.add(btnNewButton_6);

	}
}