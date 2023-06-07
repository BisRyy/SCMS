package com.SCMS.Components;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class order_list extends JPanel {

	public order_list(String item_no,String order_id,String product_name,String price,String order_quantity,String total_price,String customer){
		
		
		setLayout(null);
		
		JLabel lblNewLabel_22 = new JLabel(item_no);
		lblNewLabel_22.setBounds(10, 10, 45, 13);
		add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel(order_id);
		lblNewLabel_23.setBounds(65, 10, 45, 13);
	    add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel(product_name);
		lblNewLabel_24.setBounds(260, 10, 45, 13);
		add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel(order_quantity);
		lblNewLabel_25.setBounds(410, 10, 45, 13);
		add(lblNewLabel_25);
		
		JLabel lblNewLabel_27 = new JLabel(price);
		lblNewLabel_27.setBounds(336, 10, 45, 13);
		add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel(total_price);
		lblNewLabel_28.setBounds(500, 10, 45, 13);
		add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel(customer);
		lblNewLabel_29.setBounds(147, 10, 45, 13);
		add(lblNewLabel_29);
	}

}
