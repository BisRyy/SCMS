package com.SCMS.Pages;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.GridLayout;

public class Orders extends JPanel {
	String[] cid= {"QCf2","Ace2","CA33","W2ER","Qwer","Plo2","rrre"};
	String[] customers = {"Ararsa","Oliyad","Lalisa","Bisrat","Biruk","Biyaol","Birhanu"};
	String[] dayanddate= {"15 may 2023, 3:00"};
	String[] product = {"Tv"};
	String[] price = {"200$"};
	String[] status= {"Deliverd","Delayed","cancelled"};
 	private JTextField textField;
 	private order oder;
        public Orders() {
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(0, 0, 0));
		panel_9.setBounds(0, 0, 1266, 65);
		add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search:");
		lblNewLabel.setBounds(64, 31, 101, 24);
		panel_9.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\arars\\Downloads\\search (1).png"));
		lblNewLabel.setForeground(Color.WHITE);
		
		textField = new JTextField();
		textField.setBounds(166, 34, 172, 19);
		panel_9.add(textField);
		textField.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 255));
		panel_10.setBounds(0, 67, 1266, 570);
		add(panel_10);
		panel_10.setLayout(new GridLayout(3, 3, 10, 10));
		for(int i=0; i<customers.length; i++) {
			panel_10.add(oder = new order(cid[i], customers[i], product[0], price[0], status[1], dayanddate[0]));
		}
		
		
//		JPanel panel = new JPanel();
//		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		panel_10.add(panel);
//		panel.setBackground(new Color(255, 255, 255));
//		panel.setLayout(null);
//		
//		JLabel lblNewLabel_1 = new JLabel("#QH29");
//		lblNewLabel_1.setForeground(new Color(112, 128, 144));
//		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
//		lblNewLabel_1.setBounds(10, 21, 64, 25);
//		panel.add(lblNewLabel_1);
//		
//		JLabel lblNewLabel_2 = new JLabel("Customer");
//		lblNewLabel_2.setBounds(10, 56, 79, 13);
//		panel.add(lblNewLabel_2);
//		
//		JLabel lblNewLabel_3 = new JLabel("Products");
//		lblNewLabel_3.setBounds(10, 79, 79, 13);
//		panel.add(lblNewLabel_3);
//		
//		JLabel lblNewLabel_4 = new JLabel("Price");
//		lblNewLabel_4.setBounds(10, 102, 79, 13);
//		panel.add(lblNewLabel_4);
//		
//		JLabel lblNewLabel_5 = new JLabel("Delivery Status");
//		lblNewLabel_5.setBounds(10, 125, 117, 13);
//		panel.add(lblNewLabel_5);
//		
//		JLabel lblNewLabel_6 = new JLabel("Ararsa");
//		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_6.setBounds(216, 56, 79, 13);
//		panel.add(lblNewLabel_6);
//		
//		JLabel lblNewLabel_7 = new JLabel("LG TV");
//		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_7.setBounds(216, 79, 79, 13);
//		panel.add(lblNewLabel_7);
//		
//		JLabel lblNewLabel_8 = new JLabel("2800$");
//		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_8.setBounds(216, 102, 79, 13);
//		panel.add(lblNewLabel_8);
//		
//		JLabel lblNewLabel_9 = new JLabel("Delivered");
//		lblNewLabel_9.setForeground(new Color(0, 255, 64));
//		lblNewLabel_9.setBounds(216, 125, 79, 13);
//		panel.add(lblNewLabel_9);
//		
//		JSeparator separator_1 = new JSeparator();
//		separator_1.setBounds(0, 21, 329, 2);
//		panel.add(separator_1);
//		
//		JButton btnNewButton = new JButton("Accept");
//		btnNewButton.setBounds(20, 143, 85, 21);
//		panel.add(btnNewButton);
//		
//		JButton btnNewButton_1 = new JButton("Decline");
//		btnNewButton_1.setBounds(120, 143, 85, 21);
//		panel.add(btnNewButton_1);
//		
//		JButton btnNewButton_2 = new JButton("Remove");
//		btnNewButton_2.setBounds(226, 143, 85, 21);
//		panel.add(btnNewButton_2);
//		
//		JLabel lblNewLabel_10 = new JLabel("15 may 2023, 13:00");
//		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_10.setBounds(10, 0, 143, 23);
//		panel.add(lblNewLabel_10);
//		
//		JPanel panel_2 = new JPanel();
//		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		panel_10.add(panel_2);
//		panel_2.setLayout(null);
//		panel_2.setBackground(Color.WHITE);
//		
//		JLabel lblNewLabel_1_2 = new JLabel("#QH29");
//		lblNewLabel_1_2.setForeground(new Color(112, 128, 144));
//		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 13));
//		lblNewLabel_1_2.setBounds(10, 21, 64, 25);
//		panel_2.add(lblNewLabel_1_2);
//		
//		JLabel lblNewLabel_2_2 = new JLabel("Customer");
//		lblNewLabel_2_2.setBounds(10, 56, 79, 13);
//		panel_2.add(lblNewLabel_2_2);
//		
//		JLabel lblNewLabel_3_2 = new JLabel("Products");
//		lblNewLabel_3_2.setBounds(10, 79, 79, 13);
//		panel_2.add(lblNewLabel_3_2);
//		
//		JLabel lblNewLabel_4_2 = new JLabel("Price");
//		lblNewLabel_4_2.setBounds(10, 102, 79, 13);
//		panel_2.add(lblNewLabel_4_2);
//		
//		JLabel lblNewLabel_5_2 = new JLabel("Delivery Status");
//		lblNewLabel_5_2.setBounds(10, 125, 117, 13);
//		panel_2.add(lblNewLabel_5_2);
//		
//		JLabel lblNewLabel_6_2 = new JLabel("Biruk");
//		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_6_2.setBounds(216, 56, 79, 13);
//		panel_2.add(lblNewLabel_6_2);
//		
//		JLabel lblNewLabel_7_2 = new JLabel("LG TV");
//		lblNewLabel_7_2.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_7_2.setBounds(216, 79, 79, 13);
//		panel_2.add(lblNewLabel_7_2);
//		
//		JLabel lblNewLabel_8_2 = new JLabel("2800$");
//		lblNewLabel_8_2.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_8_2.setBounds(216, 102, 79, 13);
//		panel_2.add(lblNewLabel_8_2);
//		
//		JLabel lblNewLabel_9_2 = new JLabel("cancelled");
//		lblNewLabel_9_2.setForeground(Color.RED);
//		lblNewLabel_9_2.setBounds(216, 125, 79, 13);
//		panel_2.add(lblNewLabel_9_2);
//		
//		JSeparator separator_1_1 = new JSeparator();
//		separator_1_1.setBounds(0, 21, 329, 2);
//		panel_2.add(separator_1_1);
//		
//		JButton btnNewButton_3 = new JButton("Accept");
//		btnNewButton_3.setBounds(20, 143, 85, 21);
//		panel_2.add(btnNewButton_3);
//		
//		JButton btnNewButton_1_1 = new JButton("Decline");
//		btnNewButton_1_1.setBounds(120, 143, 85, 21);
//		panel_2.add(btnNewButton_1_1);
//		
//		JButton btnNewButton_2_1 = new JButton("Remove");
//		btnNewButton_2_1.setBounds(226, 143, 85, 21);
//		panel_2.add(btnNewButton_2_1);
//		
//		JLabel lblNewLabel_10_1 = new JLabel("15 may 2023, 13:00");
//		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_10_1.setBounds(10, 0, 143, 23);
//		panel_2.add(lblNewLabel_10_1);
//		
//		JPanel panel_4 = new JPanel();
//		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		panel_10.add(panel_4);
//		panel_4.setLayout(null);
//		panel_4.setBackground(Color.WHITE);
//		
//		JLabel lblNewLabel_1_4 = new JLabel("#QH29");
//		lblNewLabel_1_4.setForeground(new Color(112, 128, 144));
//		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.ITALIC, 13));
//		lblNewLabel_1_4.setBounds(10, 21, 64, 25);
//		panel_4.add(lblNewLabel_1_4);
//		
//		JLabel lblNewLabel_2_4 = new JLabel("Customer");
//		lblNewLabel_2_4.setBounds(10, 56, 79, 13);
//		panel_4.add(lblNewLabel_2_4);
//		
//		JLabel lblNewLabel_3_4 = new JLabel("Products");
//		lblNewLabel_3_4.setBounds(10, 79, 79, 13);
//		panel_4.add(lblNewLabel_3_4);
//		
//		JLabel lblNewLabel_4_4 = new JLabel("Price");
//		lblNewLabel_4_4.setBounds(10, 102, 79, 13);
//		panel_4.add(lblNewLabel_4_4);
//		
//		JLabel lblNewLabel_5_4 = new JLabel("Delivery Status");
//		lblNewLabel_5_4.setBounds(10, 125, 117, 13);
//		panel_4.add(lblNewLabel_5_4);
//		
//		JLabel lblNewLabel_6_4 = new JLabel("oliyad");
//		lblNewLabel_6_4.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_6_4.setBounds(216, 56, 79, 13);
//		panel_4.add(lblNewLabel_6_4);
//		
//		JLabel lblNewLabel_7_4 = new JLabel("LG TV");
//		lblNewLabel_7_4.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_7_4.setBounds(216, 79, 79, 13);
//		panel_4.add(lblNewLabel_7_4);
//		
//		JLabel lblNewLabel_8_4 = new JLabel("2800$");
//		lblNewLabel_8_4.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_8_4.setBounds(216, 102, 79, 13);
//		panel_4.add(lblNewLabel_8_4);
//		
//		JLabel lblNewLabel_9_4 = new JLabel("cancelled");
//		lblNewLabel_9_4.setForeground(Color.RED);
//		lblNewLabel_9_4.setBounds(216, 125, 79, 13);
//		panel_4.add(lblNewLabel_9_4);
//		
//		JSeparator separator_1_2 = new JSeparator();
//		separator_1_2.setBounds(0, 21, 329, 2);
//		panel_4.add(separator_1_2);
//		
//		JButton btnNewButton_4 = new JButton("Accept");
//		btnNewButton_4.setBounds(20, 143, 85, 21);
//		panel_4.add(btnNewButton_4);
//		
//		JButton btnNewButton_1_2 = new JButton("Decline");
//		btnNewButton_1_2.setBounds(120, 143, 85, 21);
//		panel_4.add(btnNewButton_1_2);
//		
//		JButton btnNewButton_2_2 = new JButton("Remove");
//		btnNewButton_2_2.setBounds(226, 143, 85, 21);
//		panel_4.add(btnNewButton_2_2);
//		
//		JLabel lblNewLabel_10_2 = new JLabel("15 may 2023, 13:00");
//		lblNewLabel_10_2.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_10_2.setBounds(10, 0, 143, 23);
//		panel_4.add(lblNewLabel_10_2);
//		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		panel_10.add(panel_1);
//		panel_1.setLayout(null);
//		panel_1.setBackground(Color.WHITE);
//		
//		JLabel lblNewLabel_1_1 = new JLabel("#QH29");
//		lblNewLabel_1_1.setForeground(new Color(112, 128, 144));
//		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
//		lblNewLabel_1_1.setBounds(10, 21, 64, 25);
//		panel_1.add(lblNewLabel_1_1);
//		
//		JLabel lblNewLabel_2_1 = new JLabel("Customer");
//		lblNewLabel_2_1.setBounds(10, 56, 79, 13);
//		panel_1.add(lblNewLabel_2_1);
//		
//		JLabel lblNewLabel_3_1 = new JLabel("Products");
//		lblNewLabel_3_1.setBounds(10, 79, 79, 13);
//		panel_1.add(lblNewLabel_3_1);
//		
//		JLabel lblNewLabel_4_1 = new JLabel("Price");
//		lblNewLabel_4_1.setBounds(10, 102, 79, 13);
//		panel_1.add(lblNewLabel_4_1);
//		
//		JLabel lblNewLabel_5_1 = new JLabel("Delivery Status");
//		lblNewLabel_5_1.setBounds(10, 125, 117, 13);
//		panel_1.add(lblNewLabel_5_1);
//		
//		JLabel lblNewLabel_6_1 = new JLabel("Bisrat");
//		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_6_1.setBounds(216, 56, 79, 13);
//		panel_1.add(lblNewLabel_6_1);
//		
//		JLabel lblNewLabel_7_1 = new JLabel("LG TV");
//		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_7_1.setBounds(216, 79, 79, 13);
//		panel_1.add(lblNewLabel_7_1);
//		
//		JLabel lblNewLabel_8_1 = new JLabel("2800$");
//		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_8_1.setBounds(216, 102, 79, 13);
//		panel_1.add(lblNewLabel_8_1);
//		
//		JLabel lblNewLabel_9_1 = new JLabel("Delayed");
//		lblNewLabel_9_1.setForeground(new Color(255, 128, 0));
//		lblNewLabel_9_1.setBounds(216, 125, 79, 13);
//		panel_1.add(lblNewLabel_9_1);
//		
//		JSeparator separator_1_3 = new JSeparator();
//		separator_1_3.setBounds(0, 21, 329, 2);
//		panel_1.add(separator_1_3);
//		
//		JButton btnNewButton_5 = new JButton("Accept");
//		btnNewButton_5.setBounds(20, 143, 85, 21);
//		panel_1.add(btnNewButton_5);
//		
//		JButton btnNewButton_1_3 = new JButton("Decline");
//		btnNewButton_1_3.setBounds(120, 143, 85, 21);
//		panel_1.add(btnNewButton_1_3);
//		
//		JButton btnNewButton_2_3 = new JButton("Remove");
//		btnNewButton_2_3.setBounds(226, 143, 85, 21);
//		panel_1.add(btnNewButton_2_3);
//		
//		JLabel lblNewLabel_10_3 = new JLabel("15 may 2023, 13:00");
//		lblNewLabel_10_3.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_10_3.setBounds(10, 0, 143, 23);
//		panel_1.add(lblNewLabel_10_3);
//		
//		JPanel panel_3 = new JPanel();
//		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		panel_10.add(panel_3);
//		panel_3.setLayout(null);
//		panel_3.setBackground(Color.WHITE);
//		
//		JLabel lblNewLabel_1_3 = new JLabel("#QH29");
//		lblNewLabel_1_3.setForeground(new Color(112, 128, 144));
//		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.ITALIC, 13));
//		lblNewLabel_1_3.setBounds(10, 21, 64, 25);
//		panel_3.add(lblNewLabel_1_3);
//		
//		JLabel lblNewLabel_2_3 = new JLabel("Customer");
//		lblNewLabel_2_3.setBounds(10, 56, 79, 13);
//		panel_3.add(lblNewLabel_2_3);
//		
//		JLabel lblNewLabel_3_3 = new JLabel("Products");
//		lblNewLabel_3_3.setBounds(10, 79, 79, 13);
//		panel_3.add(lblNewLabel_3_3);
//		
//		JLabel lblNewLabel_4_3 = new JLabel("Price");
//		lblNewLabel_4_3.setBounds(10, 102, 79, 13);
//		panel_3.add(lblNewLabel_4_3);
//		
//		JLabel lblNewLabel_5_3 = new JLabel("Delivery Status");
//		lblNewLabel_5_3.setBounds(10, 125, 117, 13);
//		panel_3.add(lblNewLabel_5_3);
//		
//		JLabel lblNewLabel_6_3 = new JLabel("Birhanu");
//		lblNewLabel_6_3.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_6_3.setBounds(216, 56, 79, 13);
//		panel_3.add(lblNewLabel_6_3);
//		
//		JLabel lblNewLabel_7_3 = new JLabel("LG TV");
//		lblNewLabel_7_3.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_7_3.setBounds(216, 79, 79, 13);
//		panel_3.add(lblNewLabel_7_3);
//		
//		JLabel lblNewLabel_8_3 = new JLabel("2800$");
//		lblNewLabel_8_3.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_8_3.setBounds(216, 102, 79, 13);
//		panel_3.add(lblNewLabel_8_3);
//		
//		JLabel lblNewLabel_9_3 = new JLabel("cancelled");
//		lblNewLabel_9_3.setForeground(Color.RED);
//		lblNewLabel_9_3.setBounds(216, 125, 79, 13);
//		panel_3.add(lblNewLabel_9_3);
//		
//		JSeparator separator_1_4 = new JSeparator();
//		separator_1_4.setBounds(0, 21, 329, 2);
//		panel_3.add(separator_1_4);
//		
//		JButton btnNewButton_6 = new JButton("Accept");
//		btnNewButton_6.setBounds(20, 143, 85, 21);
//		panel_3.add(btnNewButton_6);
//		
//		JButton btnNewButton_1_4 = new JButton("Decline");
//		btnNewButton_1_4.setBounds(120, 143, 85, 21);
//		panel_3.add(btnNewButton_1_4);
//		
//		JButton btnNewButton_2_4 = new JButton("Remove");
//		btnNewButton_2_4.setBounds(226, 143, 85, 21);
//		panel_3.add(btnNewButton_2_4);
//		
//		JLabel lblNewLabel_10_4 = new JLabel("15 may 2023, 13:00");
//		lblNewLabel_10_4.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_10_4.setBounds(10, 0, 143, 23);
//		panel_3.add(lblNewLabel_10_4);
//		
//		JPanel panel_5 = new JPanel();
//		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		panel_10.add(panel_5);
//		panel_5.setLayout(null);
//		panel_5.setBackground(Color.WHITE);
//		
//		JLabel lblNewLabel_1_5 = new JLabel("#QH29");
//		lblNewLabel_1_5.setForeground(new Color(112, 128, 144));
//		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.ITALIC, 13));
//		lblNewLabel_1_5.setBounds(10, 21, 64, 25);
//		panel_5.add(lblNewLabel_1_5);
//		
//		JLabel lblNewLabel_2_5 = new JLabel("Customer");
//		lblNewLabel_2_5.setBounds(10, 56, 79, 13);
//		panel_5.add(lblNewLabel_2_5);
//		
//		JLabel lblNewLabel_3_5 = new JLabel("Products");
//		lblNewLabel_3_5.setBounds(10, 79, 79, 13);
//		panel_5.add(lblNewLabel_3_5);
//		
//		JLabel lblNewLabel_4_5 = new JLabel("Price");
//		lblNewLabel_4_5.setBounds(10, 102, 79, 13);
//		panel_5.add(lblNewLabel_4_5);
//		
//		JLabel lblNewLabel_5_5 = new JLabel("Delivery Status");
//		lblNewLabel_5_5.setBounds(10, 125, 117, 13);
//		panel_5.add(lblNewLabel_5_5);
//		
//		JLabel lblNewLabel_6_5 = new JLabel("Lalisa");
//		lblNewLabel_6_5.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_6_5.setBounds(216, 56, 79, 13);
//		panel_5.add(lblNewLabel_6_5);
//		
//		JLabel lblNewLabel_7_5 = new JLabel("LG TV");
//		lblNewLabel_7_5.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_7_5.setBounds(216, 79, 79, 13);
//		panel_5.add(lblNewLabel_7_5);
//		
//		JLabel lblNewLabel_8_5 = new JLabel("2800$");
//		lblNewLabel_8_5.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_8_5.setBounds(216, 102, 79, 13);
//		panel_5.add(lblNewLabel_8_5);
//		
//		JLabel lblNewLabel_9_5 = new JLabel("cancelled");
//		lblNewLabel_9_5.setForeground(Color.RED);
//		lblNewLabel_9_5.setBounds(216, 125, 79, 13);
//		panel_5.add(lblNewLabel_9_5);
//		
//		JSeparator separator_1_5 = new JSeparator();
//		separator_1_5.setBounds(0, 21, 329, 2);
//		panel_5.add(separator_1_5);
//		
//		JButton btnNewButton_7 = new JButton("Accept");
//		btnNewButton_7.setBounds(20, 143, 85, 21);
//		panel_5.add(btnNewButton_7);
//		
//		JButton btnNewButton_1_5 = new JButton("Decline");
//		btnNewButton_1_5.setBounds(120, 143, 85, 21);
//		panel_5.add(btnNewButton_1_5);
//		
//		JButton btnNewButton_2_5 = new JButton("Remove");
//		btnNewButton_2_5.setBounds(226, 143, 85, 21);
//		panel_5.add(btnNewButton_2_5);
//		
//		JLabel lblNewLabel_10_5 = new JLabel("15 may 2023, 13:00");
//		lblNewLabel_10_5.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_10_5.setBounds(10, 0, 143, 23);
//		panel_5.add(lblNewLabel_10_5);
//		
//		JPanel panel_6 = new JPanel();
//		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		panel_10.add(panel_6);
//		panel_6.setLayout(null);
//		panel_6.setBackground(Color.WHITE);
//		
//		JLabel lblNewLabel_1_6 = new JLabel("#QH29");
//		lblNewLabel_1_6.setForeground(new Color(112, 128, 144));
//		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.ITALIC, 13));
//		lblNewLabel_1_6.setBounds(10, 21, 64, 25);
//		panel_6.add(lblNewLabel_1_6);
//		
//		JLabel lblNewLabel_2_6 = new JLabel("Customer");
//		lblNewLabel_2_6.setBounds(10, 56, 79, 13);
//		panel_6.add(lblNewLabel_2_6);
//		
//		JLabel lblNewLabel_3_6 = new JLabel("Products");
//		lblNewLabel_3_6.setBounds(10, 79, 79, 13);
//		panel_6.add(lblNewLabel_3_6);
//		
//		JLabel lblNewLabel_4_6 = new JLabel("Price");
//		lblNewLabel_4_6.setBounds(10, 102, 79, 13);
//		panel_6.add(lblNewLabel_4_6);
//		
//		JLabel lblNewLabel_5_6 = new JLabel("Delivery Status");
//		lblNewLabel_5_6.setBounds(10, 125, 117, 13);
//		panel_6.add(lblNewLabel_5_6);
//		
//		JLabel lblNewLabel_6_6 = new JLabel("Biyaol");
//		lblNewLabel_6_6.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_6_6.setBounds(216, 56, 79, 13);
//		panel_6.add(lblNewLabel_6_6);
//		
//		JLabel lblNewLabel_7_6 = new JLabel("LG TV");
//		lblNewLabel_7_6.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_7_6.setBounds(216, 79, 79, 13);
//		panel_6.add(lblNewLabel_7_6);
//		
//		JLabel lblNewLabel_8_6 = new JLabel("2800$");
//		lblNewLabel_8_6.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_8_6.setBounds(216, 102, 79, 13);
//		panel_6.add(lblNewLabel_8_6);
//		
//		JLabel lblNewLabel_9_6 = new JLabel("cancelled");
//		lblNewLabel_9_6.setForeground(Color.RED);
//		lblNewLabel_9_6.setBounds(216, 125, 79, 13);
//		panel_6.add(lblNewLabel_9_6);
//		
//		JSeparator separator_1_6 = new JSeparator();
//		separator_1_6.setBounds(0, 21, 329, 2);
//		panel_6.add(separator_1_6);
//		
//		JButton btnNewButton_8 = new JButton("Accept");
//		btnNewButton_8.setBounds(20, 143, 85, 21);
//		panel_6.add(btnNewButton_8);
//		
//		JButton btnNewButton_1_6 = new JButton("Decline");
//		btnNewButton_1_6.setBounds(120, 143, 85, 21);
//		panel_6.add(btnNewButton_1_6);
//		
//		JButton btnNewButton_2_6 = new JButton("Remove");
//		btnNewButton_2_6.setBounds(226, 143, 85, 21);
//		panel_6.add(btnNewButton_2_6);
//		
//		JLabel lblNewLabel_10_6 = new JLabel("15 may 2023, 13:00");
//		lblNewLabel_10_6.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_10_6.setBounds(10, 0, 143, 23);
//		panel_6.add(lblNewLabel_10_6);
//		
//		JPanel panel_7 = new JPanel();
//		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		panel_10.add(panel_7);
//		panel_7.setLayout(null);
//		panel_7.setBackground(Color.WHITE);
//		
//		JLabel lblNewLabel_1_7 = new JLabel("#QH29");
//		lblNewLabel_1_7.setForeground(new Color(112, 128, 144));
//		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.ITALIC, 13));
//		lblNewLabel_1_7.setBounds(10, 21, 64, 25);
//		panel_7.add(lblNewLabel_1_7);
//		
//		JLabel lblNewLabel_2_7 = new JLabel("Customer");
//		lblNewLabel_2_7.setBounds(10, 56, 79, 13);
//		panel_7.add(lblNewLabel_2_7);
//		
//		JLabel lblNewLabel_3_7 = new JLabel("Products");
//		lblNewLabel_3_7.setBounds(10, 79, 79, 13);
//		panel_7.add(lblNewLabel_3_7);
//		
//		JLabel lblNewLabel_4_7 = new JLabel("Price");
//		lblNewLabel_4_7.setBounds(10, 102, 79, 13);
//		panel_7.add(lblNewLabel_4_7);
//		
//		JLabel lblNewLabel_5_7 = new JLabel("Delivery Status");
//		lblNewLabel_5_7.setBounds(10, 125, 117, 13);
//		panel_7.add(lblNewLabel_5_7);
//		
//		JLabel lblNewLabel_6_7 = new JLabel("Adugna");
//		lblNewLabel_6_7.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_6_7.setBounds(216, 56, 79, 13);
//		panel_7.add(lblNewLabel_6_7);
//		
//		JLabel lblNewLabel_7_7 = new JLabel("LG TV");
//		lblNewLabel_7_7.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_7_7.setBounds(216, 79, 79, 13);
//		panel_7.add(lblNewLabel_7_7);
//		
//		JLabel lblNewLabel_8_7 = new JLabel("2800$");
//		lblNewLabel_8_7.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_8_7.setBounds(216, 102, 79, 13);
//		panel_7.add(lblNewLabel_8_7);
//		
//		JLabel lblNewLabel_9_7 = new JLabel("cancelled");
//		lblNewLabel_9_7.setForeground(Color.RED);
//		lblNewLabel_9_7.setBounds(216, 125, 79, 13);
//		panel_7.add(lblNewLabel_9_7);
//		
//		JSeparator separator_1_7 = new JSeparator();
//		separator_1_7.setBounds(0, 21, 329, 2);
//		panel_7.add(separator_1_7);
//		
//		JButton btnNewButton_10 = new JButton("Accept");
//		btnNewButton_10.setBounds(20, 143, 85, 21);
//		panel_7.add(btnNewButton_10);
//		
//		JButton btnNewButton_1_7 = new JButton("Decline");
//		btnNewButton_1_7.setBounds(120, 143, 85, 21);
//		panel_7.add(btnNewButton_1_7);
//		
//		JButton btnNewButton_2_7 = new JButton("Remove");
//		btnNewButton_2_7.setBounds(226, 143, 85, 21);
//		panel_7.add(btnNewButton_2_7);
//		
//		JLabel lblNewLabel_10_7 = new JLabel("15 may 2023, 13:00");
//		lblNewLabel_10_7.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_10_7.setBounds(10, 0, 143, 23);
//		panel_7.add(lblNewLabel_10_7);
//		
//		JPanel panel_8 = new JPanel();
//		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		panel_10.add(panel_8);
//		panel_8.setLayout(null);
//		panel_8.setBackground(Color.WHITE);
//		
//		JLabel lblNewLabel_1_8 = new JLabel("#QH29");
//		lblNewLabel_1_8.setForeground(new Color(112, 128, 144));
//		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.ITALIC, 13));
//		lblNewLabel_1_8.setBounds(10, 21, 64, 25);
//		panel_8.add(lblNewLabel_1_8);
//		
//		JLabel lblNewLabel_2_8 = new JLabel("Customer");
//		lblNewLabel_2_8.setBounds(10, 56, 79, 13);
//		panel_8.add(lblNewLabel_2_8);
//		
//		JLabel lblNewLabel_3_8 = new JLabel("Products");
//		lblNewLabel_3_8.setBounds(10, 79, 79, 13);
//		panel_8.add(lblNewLabel_3_8);
//		
//		JLabel lblNewLabel_4_8 = new JLabel("Price");
//		lblNewLabel_4_8.setBounds(10, 102, 79, 13);
//		panel_8.add(lblNewLabel_4_8);
//		
//		JLabel lblNewLabel_5_8 = new JLabel("Delivery Status");
//		lblNewLabel_5_8.setBounds(10, 125, 117, 13);
//		panel_8.add(lblNewLabel_5_8);
//		
//		JLabel lblNewLabel_6_8 = new JLabel("Israel");
//		lblNewLabel_6_8.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_6_8.setBounds(216, 56, 79, 13);
//		panel_8.add(lblNewLabel_6_8);
//		
//		JLabel lblNewLabel_7_8 = new JLabel("LG TV");
//		lblNewLabel_7_8.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_7_8.setBounds(216, 79, 79, 13);
//		panel_8.add(lblNewLabel_7_8);
//		
//		JLabel lblNewLabel_8_8 = new JLabel("2800$");
//		lblNewLabel_8_8.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_8_8.setBounds(216, 102, 79, 13);
//		panel_8.add(lblNewLabel_8_8);
//		
//		JLabel lblNewLabel_9_8 = new JLabel("cancelled");
//		lblNewLabel_9_8.setForeground(Color.RED);
//		lblNewLabel_9_8.setBounds(216, 125, 79, 13);
//		panel_8.add(lblNewLabel_9_8);
//		
//		JSeparator separator_1_8 = new JSeparator();
//		separator_1_8.setBounds(0, 21, 329, 2);
//		panel_8.add(separator_1_8);
//		
//		JButton btnNewButton_11 = new JButton("Accept");
//		btnNewButton_11.setBounds(20, 143, 85, 21);
//		panel_8.add(btnNewButton_11);
//		
//		JButton btnNewButton_1_8 = new JButton("Decline");
//		btnNewButton_1_8.setBounds(120, 143, 85, 21);
//		panel_8.add(btnNewButton_1_8);
//		
//		JButton btnNewButton_2_8 = new JButton("Remove");
//		btnNewButton_2_8.setBounds(226, 143, 85, 21);
//		panel_8.add(btnNewButton_2_8);
//		
//		JLabel lblNewLabel_10_8 = new JLabel("15 may 2023, 13:00");
//		lblNewLabel_10_8.setFont(new Font("Tahoma", Font.BOLD, 10));
//		lblNewLabel_10_8.setBounds(10, 0, 143, 23);
//		panel_8.add(lblNewLabel_10_8);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(0, 0, 0));
		panel_11.setBounds(0, 647, 1266, 49);
		add(panel_11);
		panel_11.setLayout(null);
		
		JButton btnNewButton_9_1 = new JButton("Previous Page");
		btnNewButton_9_1.setBounds(427, 18, 119, 21);
		panel_11.add(btnNewButton_9_1);
		
		JButton btnNewButton_9 = new JButton("Next page");
		btnNewButton_9.setBounds(664, 18, 119, 21);
		panel_11.add(btnNewButton_9);

	}
}
