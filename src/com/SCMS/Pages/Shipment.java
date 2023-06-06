package com.SCMS.Pages;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Panel;

public class Shipment extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Shipment() {
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
		panel_2.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Shipment ID:");
		lblNewLabel_3.setBounds(10, 10, 65, 26);
		panel_3.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("In Transit");
		btnNewButton.setBackground(new Color(0, 204, 255));
		btnNewButton.setForeground(new Color(102, 102, 255));
		btnNewButton.setBounds(367, 13, 85, 21);
		panel_3.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("1232");
		lblNewLabel_4.setBounds(10, 34, 65, 13);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("From");
		lblNewLabel_5.setBounds(30, 57, 45, 13);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Main Warehouse");
		lblNewLabel_6.setBounds(30, 80, 85, 13);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_1 = new JLabel("To");
		lblNewLabel_5_1.setBounds(197, 57, 45, 13);
		panel_3.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Branch warehouse");
		lblNewLabel_6_1.setBounds(197, 80, 85, 13);
		panel_3.add(lblNewLabel_6_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 46, 272, 2);
		panel_3.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 126, 272, 2);
		panel_3.add(separator_1);
		
		JLabel lblNewLabel_7 = new JLabel("Tracking Number:");
		lblNewLabel_7.setBounds(10, 103, 85, 13);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("#24532");
		lblNewLabel_8.setBounds(125, 103, 65, 13);
		panel_3.add(lblNewLabel_8);
		
		JButton btnNewButton_1 = new JButton("Details");
		btnNewButton_1.setBounds(101, 138, 85, 21);
		panel_3.add(btnNewButton_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(255, 255, 255));
		panel_3_1.setLayout(null);
		panel_2.add(panel_3_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Shipment ID:");
		lblNewLabel_3_1.setBounds(10, 10, 65, 26);
		panel_3_1.add(lblNewLabel_3_1);
		
		JButton btnNewButton_2 = new JButton("In Transit");
		btnNewButton_2.setForeground(new Color(102, 102, 255));
		btnNewButton_2.setBackground(new Color(0, 204, 255));
		btnNewButton_2.setBounds(367, 13, 85, 21);
		panel_3_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_4_1 = new JLabel("1232");
		lblNewLabel_4_1.setBounds(10, 34, 65, 13);
		panel_3_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("From");
		lblNewLabel_5_2.setBounds(30, 57, 45, 13);
		panel_3_1.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_6_2 = new JLabel("Main Warehouse");
		lblNewLabel_6_2.setBounds(30, 80, 85, 13);
		panel_3_1.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("To");
		lblNewLabel_5_1_1.setBounds(197, 57, 45, 13);
		panel_3_1.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Branch warehouse");
		lblNewLabel_6_1_1.setBounds(197, 80, 85, 13);
		panel_3_1.add(lblNewLabel_6_1_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 46, 272, 2);
		panel_3_1.add(separator_2);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 126, 272, 2);
		panel_3_1.add(separator_1_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Tracking Number:");
		lblNewLabel_7_1.setBounds(10, 103, 85, 13);
		panel_3_1.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("#24532");
		lblNewLabel_8_1.setBounds(125, 103, 65, 13);
		panel_3_1.add(lblNewLabel_8_1);
		
		JButton btnNewButton_1_1 = new JButton("Details");
		btnNewButton_1_1.setBounds(101, 138, 85, 21);
		panel_3_1.add(btnNewButton_1_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(new Color(255, 255, 255));
		panel_3_2.setLayout(null);
		panel_2.add(panel_3_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Shipment ID:");
		lblNewLabel_3_2.setBounds(10, 10, 65, 26);
		panel_3_2.add(lblNewLabel_3_2);
		
		JButton btnNewButton_5 = new JButton("In Transit");
		btnNewButton_5.setForeground(new Color(102, 102, 255));
		btnNewButton_5.setBackground(new Color(0, 204, 255));
		btnNewButton_5.setBounds(367, 13, 85, 21);
		panel_3_2.add(btnNewButton_5);
		
		JLabel lblNewLabel_4_2 = new JLabel("1232");
		lblNewLabel_4_2.setBounds(10, 34, 65, 13);
		panel_3_2.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("From");
		lblNewLabel_5_3.setBounds(30, 57, 45, 13);
		panel_3_2.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_6_3 = new JLabel("Main Warehouse");
		lblNewLabel_6_3.setBounds(30, 80, 85, 13);
		panel_3_2.add(lblNewLabel_6_3);
		
		JLabel lblNewLabel_5_1_2 = new JLabel("To");
		lblNewLabel_5_1_2.setBounds(197, 57, 45, 13);
		panel_3_2.add(lblNewLabel_5_1_2);
		
		JLabel lblNewLabel_6_1_2 = new JLabel("Branch warehouse");
		lblNewLabel_6_1_2.setBounds(197, 80, 85, 13);
		panel_3_2.add(lblNewLabel_6_1_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 46, 272, 2);
		panel_3_2.add(separator_3);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(10, 126, 272, 2);
		panel_3_2.add(separator_1_2);
		
		JLabel lblNewLabel_7_2 = new JLabel("Tracking Number:");
		lblNewLabel_7_2.setBounds(10, 103, 85, 13);
		panel_3_2.add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_8_2 = new JLabel("#24532");
		lblNewLabel_8_2.setBounds(125, 103, 65, 13);
		panel_3_2.add(lblNewLabel_8_2);
		
		JButton btnNewButton_1_2 = new JButton("Details");
		btnNewButton_1_2.setBounds(101, 138, 85, 21);
		panel_3_2.add(btnNewButton_1_2);
		
		JButton btnNewButton_6 = new JButton("Add New Shipment");
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_6.setBounds(122, 662, 183, 21);
		panel.add(btnNewButton_6);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 204, 204));
		panel_4.setBounds(463, 0, 923, 769);
		add(panel_4);
		panel_4.setLayout(null);
		
		Panel panel_5 = new Panel();
		panel_5.setBounds(0, 0, 923, 161);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Shipment ID");
		lblNewLabel_9.setBounds(10, 10, 123, 25);
		panel_5.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_10 = new JLabel("1232");
		lblNewLabel_10.setBounds(20, 45, 79, 25);
		panel_5.add(lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.ITALIC, 17));
		
		JButton btnNewButton_3 = new JButton("In Transit");
		btnNewButton_3.setBounds(575, 11, 99, 31);
		panel_5.add(btnNewButton_3);
		btnNewButton_3.setForeground(new Color(102, 102, 255));
		btnNewButton_3.setBackground(new Color(0, 204, 255));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBounds(10, 72, 170, 55);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("Driver");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_11.setBounds(10, 1, 120, 21);
		panel_6.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_12.setBounds(10, 32, 120, 23);
		panel_6.add(lblNewLabel_12);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBackground(Color.WHITE);
		panel_6_1.setBounds(200, 72, 170, 55);
		panel_5.add(panel_6_1);
		panel_6_1.setLayout(null);
		
		JLabel lblNewLabel_13 = new JLabel("Phone Number");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_13.setBounds(0, -1, 128, 23);
		panel_6_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setBounds(0, 32, 99, 23);
		panel_6_1.add(lblNewLabel_14);
		
		JPanel panel_6_2 = new JPanel();
		panel_6_2.setBackground(Color.WHITE);
		panel_6_2.setBounds(380, 72, 170, 55);
		panel_5.add(panel_6_2);
		panel_6_2.setLayout(null);
		
		JLabel lblNewLabel_15 = new JLabel("Adress");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_15.setBounds(10, 0, 150, 33);
		panel_6_2.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_16.setBounds(10, 31, 100, 25);
		panel_6_2.add(lblNewLabel_16);
		
		JPanel panel_7 = new JPanel();
		
		panel_7.setBounds(0, 161, 923, 255);
		panel_4.add(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setBackground(new Color(255, 255, 255));
		lblNewLabel_17.setIcon(new ImageIcon("C:\\Users\\arars\\Desktop\\java\\SCMS\\lib\\icons\\2023-06-06 (1).png"));
		panel_7.add(lblNewLabel_17);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 418, 923, 351);
		panel_4.add(panel_8);
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
		
		JPanel panel_10 = new JPanel();
		panel_9.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_22 = new JLabel("1");
		lblNewLabel_22.setBounds(10, 10, 45, 13);
		panel_10.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("123");
		lblNewLabel_23.setBounds(65, 10, 45, 13);
		panel_10.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("Tv");
		lblNewLabel_24.setBounds(260, 10, 45, 13);
		panel_10.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("12");
		lblNewLabel_25.setBounds(410, 10, 45, 13);
		panel_10.add(lblNewLabel_25);
		
		JLabel lblNewLabel_27 = new JLabel("200");
		lblNewLabel_27.setBounds(336, 10, 45, 13);
		panel_10.add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("14520");
		lblNewLabel_28.setBounds(500, 10, 45, 13);
		panel_10.add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("Ararsa");
		lblNewLabel_29.setBounds(147, 10, 45, 13);
		panel_10.add(lblNewLabel_29);
		
		JPanel panel_10_2 = new JPanel();
		panel_10_2.setLayout(null);
		panel_9.add(panel_10_2);
		
		JLabel lblNewLabel_22_2 = new JLabel("1");
		lblNewLabel_22_2.setBounds(10, 10, 45, 13);
		panel_10_2.add(lblNewLabel_22_2);
		
		JLabel lblNewLabel_23_2 = new JLabel("123");
		lblNewLabel_23_2.setBounds(65, 10, 45, 13);
		panel_10_2.add(lblNewLabel_23_2);
		
		JLabel lblNewLabel_24_2 = new JLabel("Tv");
		lblNewLabel_24_2.setBounds(260, 10, 45, 13);
		panel_10_2.add(lblNewLabel_24_2);
		
		JLabel lblNewLabel_25_2 = new JLabel("15");
		lblNewLabel_25_2.setBounds(410, 10, 45, 13);
		panel_10_2.add(lblNewLabel_25_2);
		
		JLabel lblNewLabel_27_1 = new JLabel("300");
		lblNewLabel_27_1.setBounds(337, 10, 45, 13);
		panel_10_2.add(lblNewLabel_27_1);
		
		JPanel panel_10_3 = new JPanel();
		panel_10_3.setLayout(null);
		panel_9.add(panel_10_3);
		
		JLabel lblNewLabel_22_3 = new JLabel("1");
		lblNewLabel_22_3.setBounds(10, 10, 45, 13);
		panel_10_3.add(lblNewLabel_22_3);
		
		JLabel lblNewLabel_23_3 = new JLabel("123");
		lblNewLabel_23_3.setBounds(65, 10, 45, 13);
		panel_10_3.add(lblNewLabel_23_3);
		
		JLabel lblNewLabel_24_3 = new JLabel("Tv");
		lblNewLabel_24_3.setBounds(260, 10, 45, 13);
		panel_10_3.add(lblNewLabel_24_3);
		
		JLabel lblNewLabel_25_3 = new JLabel("13");
		lblNewLabel_25_3.setBounds(410, 10, 45, 13);
		panel_10_3.add(lblNewLabel_25_3);
		
		JLabel lblNewLabel_27_2 = new JLabel("150");
		lblNewLabel_27_2.setBounds(335, 10, 45, 13);
		panel_10_3.add(lblNewLabel_27_2);
		
		JPanel panel_10_1 = new JPanel();
		panel_10_1.setLayout(null);
		panel_9.add(panel_10_1);
		
		JLabel lblNewLabel_22_1 = new JLabel("1");
		lblNewLabel_22_1.setBounds(10, 10, 45, 13);
		panel_10_1.add(lblNewLabel_22_1);
		
		JLabel lblNewLabel_23_1 = new JLabel("123");
		lblNewLabel_23_1.setBounds(65, 10, 45, 13);
		panel_10_1.add(lblNewLabel_23_1);
		
		JLabel lblNewLabel_24_1 = new JLabel("Tv");
		lblNewLabel_24_1.setBounds(260, 10, 45, 13);
		panel_10_1.add(lblNewLabel_24_1);
		
		JLabel lblNewLabel_25_1 = new JLabel("10");
		lblNewLabel_25_1.setBounds(410, 10, 45, 13);
		panel_10_1.add(lblNewLabel_25_1);
		
		JLabel lblNewLabel_27_3 = new JLabel("750");
		lblNewLabel_27_3.setBounds(336, 10, 45, 13);
		panel_10_1.add(lblNewLabel_27_3);
		
		JButton btnNewButton_4_2 = new JButton("<");
		btnNewButton_4_2.setBounds(602, 61, 42, 21);
		panel_8.add(btnNewButton_4_2);
		
		JButton btnNewButton_4_1_1 = new JButton(">");
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
