package com.SCMS.Pages;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

public class order extends JPanel {

	/**
	 * Create the panel.
	 */
	public order(String id,String customer,String product,String price,String status,String dateandday) {
//		JPanel panel = new JPanel();
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(id);
		lblNewLabel_1.setForeground(new Color(112, 128, 144));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_1.setBounds(10, 21, 64, 25);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Customer");
		lblNewLabel_2.setBounds(10, 56, 79, 13);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Products");
		lblNewLabel_3.setBounds(10, 79, 79, 13);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setBounds(10, 102, 79, 13);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Delivery Status");
		lblNewLabel_5.setBounds(10, 125, 117, 13);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(customer);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_6.setBounds(216, 56, 79, 13);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(product);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_7.setBounds(216, 79, 79, 13);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(price);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8.setBounds(216, 102, 79, 13);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(status);
		lblNewLabel_9.setForeground(new Color(0, 255, 64));
		lblNewLabel_9.setBounds(216, 125, 79, 13);
		add(lblNewLabel_9);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 21, 329, 2);
	     add(separator_1);
		
		JButton btnNewButton = new JButton("Accept");
		btnNewButton.setBounds(20, 143, 85, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Decline");
		btnNewButton_1.setBounds(120, 143, 85, 21);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remove");
		btnNewButton_2.setBounds(226, 143, 85, 21);
		add(btnNewButton_2);
		
		JLabel lblNewLabel_10 = new JLabel("15 may 2023, 13:00");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_10.setBounds(10, 0, 143, 23);
		add(lblNewLabel_10);
		

	}

}
