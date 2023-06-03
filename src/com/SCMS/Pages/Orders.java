package com.SCMS.Pages;

import javax.swing.JPanel;
import javax.swing.JTextField;
import com.SCMS.Components.Order;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.GridLayout;

public class Orders extends JPanel {

	String[] cid= {"QCf2","Ace2","CA33","W2ER","Qwer","Plo2","rrre","Plo2","rrre"};
	String[] customers = {"Ararsa","Oliyad","Lalisa","Bisrat","Biruk","Biyaol","Birhanu","Biyaol","Birhanu"};
	String[] dayanddate= {"15 may 2023, 3:00"};
	String[] product = {"Tv"};
	String[] price = {"200$"};
	String[] status= {"Delivered","Delayed","cancelled"};
 	private JTextField textField;

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

			panel_10.add(new Order(cid[i], customers[i], product[0], price[0], status[0], dayanddate[0]));

		}
		
		

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
