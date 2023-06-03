package com.SCMS.Pages;

import javax.swing.JPanel;
import javax.swing.JTextField;
import com.SCMS.Components.Order;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Orders extends JPanel {

	String[] cid= {"QCf2","Ace2","CA33","W2ER","Qwer","Plo2","rrre","Plo2","rrre","qwe","asdsd","xcxcv","aewe","asfaew"};
	String[] customers = {"Ararsa","Oliyad","Lalisa","Bisrat","Biruk","Biyaol","Birhanu","Biyaol","Birhanu","sdsdf","sdfsad","asdfasdfawewe","hello","qweer"};
	String[] dayanddate= {"15 may 2023, 3:00"};
	String[] product = {"Tv"};
	String[] price = {"200$"};
	String[] status= {"Delivered","Delayed","cancelled","waiting..."};
	int page=0;
 	private JTextField textField;

        public Orders() {
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(0, 0, 1266, 75);
		panel_9.setBackground(new Color(0, 0, 0));
		add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(798, 10, 101, 24);
		panel_9.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\arars\\Downloads\\search (1).png"));
		lblNewLabel.setForeground(Color.WHITE);
		
		textField = new JTextField();
		textField.setBounds(909, 13, 172, 19);
		panel_9.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		

		btnNewButton.setBounds(1091, 12, 85, 21);
		panel_9.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Waiting..");
		
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.black);
		btnNewButton_1.setBounds(10, 54, 85, 21);
		panel_9.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Accepted");
		
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setBackground(Color.BLACK);
		btnNewButton_1_1.setBounds(105, 54, 85, 21);
		panel_9.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Declined");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1_2.setBackground(Color.WHITE);
				btnNewButton_1_2.setForeground(Color.black);
				btnNewButton_1_1.setForeground(Color.WHITE);
				btnNewButton_1_1.setBackground(Color.BLACK);
				btnNewButton_1.setForeground(Color.WHITE);
				btnNewButton_1.setBackground(Color.BLACK);
				
			}
		});
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1_1.setBackground(Color.WHITE);
				btnNewButton_1_1.setForeground(Color.black);
				btnNewButton_1.setForeground(Color.WHITE);
				btnNewButton_1.setBackground(Color.BLACK);
				btnNewButton_1_2.setForeground(Color.WHITE);
				btnNewButton_1_2.setBackground(Color.BLACK);
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setBackground(Color.WHITE);
				btnNewButton_1.setForeground(Color.black);
				btnNewButton_1_1.setForeground(Color.WHITE);
				btnNewButton_1_1.setBackground(Color.BLACK);
				btnNewButton_1_2.setForeground(Color.WHITE);
				btnNewButton_1_2.setBackground(Color.BLACK);
				
			}
		});
		btnNewButton_1_2.setForeground(Color.WHITE);
		btnNewButton_1_2.setBackground(Color.BLACK);
		btnNewButton_1_2.setBounds(200, 54, 85, 21);
		panel_9.add(btnNewButton_1_2);
		
		JPanel panel_10 = new JPanel();
		 
		panel_10.setBounds(0, 75, 1266, 570);
		panel_10.setBackground(Color.black);
		add(panel_10);
		panel_10.setLayout(new GridLayout(3, 3, 10, 10));
		for(int i=page; i<page+9; i++) {
          panel_10.add(new Order(cid[i], customers[i], product[0], price[0], status[3], dayanddate[0]));
        }
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_10.removeAll();
		        panel_10.revalidate();
		        panel_10.repaint();
		       for(int i=0; i<customers.length; i++) {
		    	   if(customers[i]==textField.getText()) {
	                    panel_10.add(new Order(cid[i], customers[i], product[0], price[0], status[3], dayanddate[0]));
		    	   }
		    	   
	         }
		}
			
		});
	   JPanel panel_11 = new JPanel();
		panel_11.setBounds(0, 647, 1266, 49);
		panel_11.setBackground(new Color(0, 0, 0));
		add(panel_11);
		panel_11.setLayout(null);
	
		
		JButton btnNewButton_9_1 = new JButton("Previous Page");
		btnNewButton_9_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(page!=0) {
				page=page-9;
				
		     panel_10.removeAll();
		     panel_10.revalidate();
		        panel_10.repaint();
		       for(int i=page; i<9 && i<customers.length; i++) {
	          panel_10.add(new Order(cid[i], customers[i], product[0], price[0], status[3], dayanddate[0]));
	        }
				}
			}
		});

		btnNewButton_9_1.setBounds(427, 18, 119, 21);
		panel_11.add(btnNewButton_9_1);
		
		
		
		JButton btnNewButton_9 = new JButton("Next page");
	btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(page+9<customers.length) {
					page=page+9;
			    panel_10.removeAll();
		        panel_10.revalidate();
		        panel_10.repaint();
		        for(int i=page; i<page+9 && i<customers.length; i++) {
	                 panel_10.add(new Order(cid[i], customers[i], product[0], price[0], status[3], dayanddate[0]));
	         
	            }
				}
		      
			}
			
		});
	
	   btnNewButton_9.setBounds(664, 18, 119, 21);
		panel_11.add(btnNewButton_9);

	}
}
