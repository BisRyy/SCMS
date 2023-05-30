package com.SCMS;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class orders extends JPanel {
	private JTextField textField;
        public orders() {
		setBackground(new Color(0, 128, 128));
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(84, 24, 308, 30);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(31, 10, 118, 44);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 87, 329, 164);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("QH29");
		lblNewLabel_1.setBounds(10, 10, 45, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Customer");
		lblNewLabel_2.setBounds(10, 56, 79, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Products");
		lblNewLabel_3.setBounds(10, 79, 79, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setBounds(10, 102, 79, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Delivery Status");
		lblNewLabel_5.setBounds(10, 125, 117, 13);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Ararsa");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_6.setBounds(216, 56, 79, 13);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("LG TV");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_7.setBounds(216, 79, 79, 13);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("2800$");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8.setBounds(216, 102, 79, 13);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("cancelled");
		lblNewLabel_9.setForeground(new Color(255, 0, 0));
		lblNewLabel_9.setBounds(216, 125, 79, 13);
		panel.add(lblNewLabel_9);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 33, 329, 2);
		panel.add(separator_1);
		
		JButton btnNewButton = new JButton("Accept");
		btnNewButton.setBounds(20, 143, 85, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Decline");
		btnNewButton_1.setBounds(120, 143, 85, 21);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remove");
		btnNewButton_2.setBounds(226, 143, 85, 21);
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(31, 261, 329, 164);
		add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("QH29");
		lblNewLabel_1_1.setBounds(10, 10, 45, 13);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Customer");
		lblNewLabel_2_1.setBounds(10, 56, 79, 13);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Products");
		lblNewLabel_3_1.setBounds(10, 79, 79, 13);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Price");
		lblNewLabel_4_1.setBounds(10, 102, 79, 13);
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Delivery Status");
		lblNewLabel_5_1.setBounds(10, 125, 79, 13);
		panel_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Abebe");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_6_1.setBounds(216, 56, 45, 13);
		panel_1.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Beko TV");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_7_1.setBounds(216, 79, 45, 13);
		panel_1.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("2800$");
		lblNewLabel_8_1.setBounds(216, 102, 45, 13);
		panel_1.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("Delayed");
		lblNewLabel_9_1.setForeground(Color.ORANGE);
		lblNewLabel_9_1.setBounds(216, 125, 45, 13);
		panel_1.add(lblNewLabel_9_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 33, 329, 2);
		panel_1.add(separator);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(427, 87, 329, 164);
		add(panel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("QH29");
		lblNewLabel_1_2.setBounds(10, 10, 45, 13);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Customer");
		lblNewLabel_2_2.setBounds(10, 56, 79, 13);
		panel_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Products");
		lblNewLabel_3_2.setBounds(10, 79, 79, 13);
		panel_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_4_2 = new JLabel("Price");
		lblNewLabel_4_2.setBounds(10, 102, 79, 13);
		panel_2.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_5_2 = new JLabel("Delivery Status");
		lblNewLabel_5_2.setBounds(10, 125, 79, 13);
		panel_2.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_6_2 = new JLabel("Ararsa");
		lblNewLabel_6_2.setBounds(216, 56, 45, 13);
		panel_2.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_7_2 = new JLabel("TV");
		lblNewLabel_7_2.setBounds(216, 79, 45, 13);
		panel_2.add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_8_2 = new JLabel("2800$");
		lblNewLabel_8_2.setBounds(216, 102, 45, 13);
		panel_2.add(lblNewLabel_8_2);
		
		JLabel lblNewLabel_9_2 = new JLabel("cancelled");
		lblNewLabel_9_2.setBounds(216, 125, 45, 13);
		panel_2.add(lblNewLabel_9_2);
		
		JButton btnNewButton_3 = new JButton("Accept");
		btnNewButton_3.setBounds(20, 143, 85, 21);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Decline");
		btnNewButton_4.setBounds(115, 143, 85, 21);
		panel_2.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Remove");
		btnNewButton_5.setBounds(216, 143, 85, 21);
		panel_2.add(btnNewButton_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(427, 261, 329, 164);
		add(panel_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("QH29");
		lblNewLabel_1_3.setBounds(10, 10, 45, 13);
		panel_3.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("Customer");
		lblNewLabel_2_3.setBounds(10, 56, 79, 13);
		panel_3.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("Products");
		lblNewLabel_3_3.setBounds(10, 79, 79, 13);
		panel_3.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_4_3 = new JLabel("Price");
		lblNewLabel_4_3.setBounds(10, 102, 79, 13);
		panel_3.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_5_3 = new JLabel("Delivery Status");
		lblNewLabel_5_3.setBounds(10, 125, 79, 13);
		panel_3.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_6_3 = new JLabel("Ararsa");
		lblNewLabel_6_3.setBounds(216, 56, 79, 13);
		panel_3.add(lblNewLabel_6_3);
		
		JLabel lblNewLabel_7_3 = new JLabel("TV");
		lblNewLabel_7_3.setBounds(216, 79, 79, 13);
		panel_3.add(lblNewLabel_7_3);
		
		JLabel lblNewLabel_8_3 = new JLabel("2800$");
		lblNewLabel_8_3.setBounds(216, 102, 79, 13);
		panel_3.add(lblNewLabel_8_3);
		
		JLabel lblNewLabel_9_3 = new JLabel("cancelled");
		lblNewLabel_9_3.setBounds(216, 125, 79, 13);
		panel_3.add(lblNewLabel_9_3);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(833, 87, 329, 164);
		add(panel_2_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("QH29");
		lblNewLabel_1_2_1.setBounds(10, 10, 45, 13);
		panel_2_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Customer");
		lblNewLabel_2_2_1.setBounds(10, 56, 79, 13);
		panel_2_1.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Products");
		lblNewLabel_3_2_1.setBounds(10, 79, 79, 13);
		panel_2_1.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Price");
		lblNewLabel_4_2_1.setBounds(10, 102, 79, 13);
		panel_2_1.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("Delivery Status");
		lblNewLabel_5_2_1.setBounds(10, 125, 79, 13);
		panel_2_1.add(lblNewLabel_5_2_1);
		
		JLabel lblNewLabel_6_2_1 = new JLabel("Ararsa");
		lblNewLabel_6_2_1.setBounds(216, 56, 79, 13);
		panel_2_1.add(lblNewLabel_6_2_1);
		
		JLabel lblNewLabel_7_2_1 = new JLabel("TV");
		lblNewLabel_7_2_1.setBounds(216, 79, 79, 13);
		panel_2_1.add(lblNewLabel_7_2_1);
		
		JLabel lblNewLabel_8_2_1 = new JLabel("2800$");
		lblNewLabel_8_2_1.setBounds(216, 102, 79, 13);
		panel_2_1.add(lblNewLabel_8_2_1);
		
		JLabel lblNewLabel_9_2_1 = new JLabel("cancelled");
		lblNewLabel_9_2_1.setBounds(216, 125, 79, 13);
		panel_2_1.add(lblNewLabel_9_2_1);
		
		JButton btnNewButton_6 = new JButton("Accept");
		btnNewButton_6.setBounds(20, 143, 85, 21);
		panel_2_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Decline");
		btnNewButton_7.setBounds(115, 143, 85, 21);
		panel_2_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Remove");
		btnNewButton_8.setBounds(216, 143, 85, 21);
		panel_2_1.add(btnNewButton_8);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBounds(833, 261, 329, 164);
		add(panel_2_2);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("QH29");
		lblNewLabel_1_2_2.setBounds(10, 10, 45, 13);
		panel_2_2.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Customer");
		lblNewLabel_2_2_2.setBounds(10, 56, 79, 13);
		panel_2_2.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_3_2_2 = new JLabel("Products");
		lblNewLabel_3_2_2.setBounds(10, 79, 79, 13);
		panel_2_2.add(lblNewLabel_3_2_2);
		
		JLabel lblNewLabel_4_2_2 = new JLabel("Price");
		lblNewLabel_4_2_2.setBounds(10, 102, 79, 13);
		panel_2_2.add(lblNewLabel_4_2_2);
		
		JLabel lblNewLabel_5_2_2 = new JLabel("Delivery Status");
		lblNewLabel_5_2_2.setBounds(10, 125, 79, 13);
		panel_2_2.add(lblNewLabel_5_2_2);
		
		JLabel lblNewLabel_6_2_2 = new JLabel("Ararsa");
		lblNewLabel_6_2_2.setBounds(216, 56, 79, 13);
		panel_2_2.add(lblNewLabel_6_2_2);
		
		JLabel lblNewLabel_7_2_2 = new JLabel("TV");
		lblNewLabel_7_2_2.setBounds(216, 79, 79, 13);
		panel_2_2.add(lblNewLabel_7_2_2);
		
		JLabel lblNewLabel_8_2_2 = new JLabel("2800$");
		lblNewLabel_8_2_2.setBounds(216, 102, 79, 13);
		panel_2_2.add(lblNewLabel_8_2_2);
		
		JLabel lblNewLabel_9_2_2 = new JLabel("cancelled");
		lblNewLabel_9_2_2.setBounds(216, 125, 79, 13);
		panel_2_2.add(lblNewLabel_9_2_2);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setLayout(null);
		panel_2_3.setBounds(31, 435, 329, 164);
		add(panel_2_3);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("QH29");
		lblNewLabel_1_2_3.setBounds(10, 10, 45, 13);
		panel_2_3.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_2_2_3 = new JLabel("Customer");
		lblNewLabel_2_2_3.setBounds(10, 56, 79, 13);
		panel_2_3.add(lblNewLabel_2_2_3);
		
		JLabel lblNewLabel_3_2_3 = new JLabel("Products");
		lblNewLabel_3_2_3.setBounds(10, 79, 79, 13);
		panel_2_3.add(lblNewLabel_3_2_3);
		
		JLabel lblNewLabel_4_2_3 = new JLabel("Price");
		lblNewLabel_4_2_3.setBounds(10, 102, 79, 13);
		panel_2_3.add(lblNewLabel_4_2_3);
		
		JLabel lblNewLabel_5_2_3 = new JLabel("Delivery Status");
		lblNewLabel_5_2_3.setBounds(10, 125, 79, 13);
		panel_2_3.add(lblNewLabel_5_2_3);
		
		JLabel lblNewLabel_6_2_3 = new JLabel("Abera");
		lblNewLabel_6_2_3.setBounds(216, 56, 79, 13);
		panel_2_3.add(lblNewLabel_6_2_3);
		
		JLabel lblNewLabel_7_2_3 = new JLabel("Sumsung TV");
		lblNewLabel_7_2_3.setBounds(216, 79, 79, 13);
		panel_2_3.add(lblNewLabel_7_2_3);
		
		JLabel lblNewLabel_8_2_3 = new JLabel("2800$");
		lblNewLabel_8_2_3.setBounds(216, 102, 79, 13);
		panel_2_3.add(lblNewLabel_8_2_3);
		
		JLabel lblNewLabel_9_2_3 = new JLabel("Delivered'");
		lblNewLabel_9_2_3.setForeground(Color.GREEN);
		lblNewLabel_9_2_3.setBounds(216, 125, 79, 13);
		panel_2_3.add(lblNewLabel_9_2_3);
		
		JPanel panel_2_4 = new JPanel();
		panel_2_4.setLayout(null);
		panel_2_4.setBounds(427, 435, 329, 164);
		add(panel_2_4);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("QH29");
		lblNewLabel_1_2_4.setBounds(10, 10, 45, 13);
		panel_2_4.add(lblNewLabel_1_2_4);
		
		JLabel lblNewLabel_2_2_4 = new JLabel("Customer");
		lblNewLabel_2_2_4.setBounds(10, 56, 79, 13);
		panel_2_4.add(lblNewLabel_2_2_4);
		
		JLabel lblNewLabel_3_2_4 = new JLabel("Products");
		lblNewLabel_3_2_4.setBounds(10, 79, 79, 13);
		panel_2_4.add(lblNewLabel_3_2_4);
		
		JLabel lblNewLabel_4_2_4 = new JLabel("Price");
		lblNewLabel_4_2_4.setBounds(10, 102, 79, 13);
		panel_2_4.add(lblNewLabel_4_2_4);
		
		JLabel lblNewLabel_5_2_4 = new JLabel("Delivery Status");
		lblNewLabel_5_2_4.setBounds(10, 125, 79, 13);
		panel_2_4.add(lblNewLabel_5_2_4);
		
		JLabel lblNewLabel_6_2_4 = new JLabel("Ararsa");
		lblNewLabel_6_2_4.setBounds(216, 56, 79, 13);
		panel_2_4.add(lblNewLabel_6_2_4);
		
		JLabel lblNewLabel_7_2_4 = new JLabel("TV");
		lblNewLabel_7_2_4.setBounds(216, 79, 79, 13);
		panel_2_4.add(lblNewLabel_7_2_4);
		
		JLabel lblNewLabel_8_2_4 = new JLabel("2800$");
		lblNewLabel_8_2_4.setBounds(216, 102, 79, 13);
		panel_2_4.add(lblNewLabel_8_2_4);
		
		JLabel lblNewLabel_9_2_4 = new JLabel("cancelled");
		lblNewLabel_9_2_4.setBounds(216, 125, 79, 13);
		panel_2_4.add(lblNewLabel_9_2_4);
		
		JPanel panel_2_5 = new JPanel();
		panel_2_5.setLayout(null);
		panel_2_5.setBounds(833, 435, 329, 164);
		add(panel_2_5);
		
		JLabel lblNewLabel_1_2_5 = new JLabel("QH29");
		lblNewLabel_1_2_5.setBounds(10, 10, 45, 13);
		panel_2_5.add(lblNewLabel_1_2_5);
		
		JLabel lblNewLabel_2_2_5 = new JLabel("Customer");
		lblNewLabel_2_2_5.setBounds(10, 56, 79, 13);
		panel_2_5.add(lblNewLabel_2_2_5);
		
		JLabel lblNewLabel_3_2_5 = new JLabel("Products");
		lblNewLabel_3_2_5.setBounds(10, 79, 79, 13);
		panel_2_5.add(lblNewLabel_3_2_5);
		
		JLabel lblNewLabel_4_2_5 = new JLabel("Price");
		lblNewLabel_4_2_5.setBounds(10, 102, 79, 13);
		panel_2_5.add(lblNewLabel_4_2_5);
		
		JLabel lblNewLabel_5_2_5 = new JLabel("Delivery Status");
		lblNewLabel_5_2_5.setBounds(10, 125, 79, 13);
		panel_2_5.add(lblNewLabel_5_2_5);
		
		JLabel lblNewLabel_6_2_5 = new JLabel("Ararsa");
		lblNewLabel_6_2_5.setBounds(216, 56, 79, 13);
		panel_2_5.add(lblNewLabel_6_2_5);
		
		JLabel lblNewLabel_7_2_5 = new JLabel("TV");
		lblNewLabel_7_2_5.setBounds(216, 79, 79, 13);
		panel_2_5.add(lblNewLabel_7_2_5);
		
		JLabel lblNewLabel_8_2_5 = new JLabel("2800$");
		lblNewLabel_8_2_5.setBounds(216, 102, 79, 13);
		panel_2_5.add(lblNewLabel_8_2_5);
		
		JLabel lblNewLabel_9_2_5 = new JLabel("cancelled");
		lblNewLabel_9_2_5.setBounds(216, 125, 79, 13);
		panel_2_5.add(lblNewLabel_9_2_5);

	}
}
