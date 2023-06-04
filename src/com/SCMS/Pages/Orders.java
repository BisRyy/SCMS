package com.SCMS.Pages;

import javax.swing.JPanel;
import javax.swing.JTextField;
import com.SCMS.Components.Order;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Orders extends JPanel {

	
	   int page=0;


 	private JTextField textField;

        public Orders() {
        String DB_URL = "jdbc:mysql://localhost/SCMS";
        String USERNAME = "root";
        String PASSWORD = "";
        String QUERY = "SELECT * FROM orders limit "+page+",9";
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
		lblNewLabel.setIcon(new ImageIcon("lib/icons/search.png"));

		lblNewLabel.setForeground(Color.WHITE);
	
		textField = new JTextField();
		textField.setBounds(909, 13, 172, 19);
		panel_9.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		

		btnNewButton.setBounds(1091, 12, 85, 21);
		panel_9.add(btnNewButton);
		

		JButton btnNewButton_1 = new JButton("All orders");
		
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.black);
		btnNewButton_1.setBounds(10, 54, 100, 21);
		panel_9.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Waiting");
		
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setBackground(Color.BLACK);
		btnNewButton_1_1.setBounds(105, 54, 100, 21);
		panel_9.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Accepted");
		
		btnNewButton_1_2.setForeground(Color.WHITE);
		btnNewButton_1_2.setBackground(Color.BLACK);
		btnNewButton_1_2.setBounds(200, 54, 100, 21);
		panel_9.add(btnNewButton_1_2);
	JButton btnNewButton_1_3 = new JButton("Declined");
		
		btnNewButton_1_3.setForeground(Color.WHITE);
		btnNewButton_1_3.setBackground(Color.BLACK);
		btnNewButton_1_3.setBounds(295, 54, 100, 21);
		panel_9.add(btnNewButton_1_3);

		
		JPanel panel_10 = new JPanel();
		 
		panel_10.setBounds(0, 75, 1266, 570);
		panel_10.setBackground(Color.black);
		add(panel_10);
		panel_10.setLayout(new GridLayout(3, 3, 10, 10));

		  try(Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)){
			  Statement stmt = jdbcConnect.createStatement();
		        	ResultSet rsData = stmt.executeQuery(QUERY);
		          while(rsData.next()) {
		        	  panel_10.add(new Order(Integer.toString(rsData.getInt("user_id")),rsData.getString("user_name"),rsData.getString("product_name"),Integer.toString(rsData.getInt("product_price")),rsData.getString("Order_status"),rsData.getString("date_and_time")));
		          }
		          rsData.close();
		            } catch (SQLException e) {
		        	e.printStackTrace();
		        	}

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_10.removeAll();
		        panel_10.revalidate();
		        panel_10.repaint();

		        try(Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)){
					  Statement stmt = jdbcConnect.createStatement();
				        	ResultSet rsData = stmt.executeQuery("Select * from orders where user_name =\""+ textField.getText()+"\"");
				          while(rsData.next()) {
				        	  
				        	  panel_10.add(new Order(Integer.toString(rsData.getInt("user_id")),rsData.getString("user_name"),rsData.getString("product_name"),Integer.toString(rsData.getInt("product_price")),rsData.getString("Order_status"),rsData.getString("date_and_time")));
				        	  
				        	  }
				          rsData.close();
				            } catch (SQLException e1) {
				        	e1.printStackTrace();
				        	}
		}
			
		});
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_10.removeAll();
			     panel_10.revalidate();
			        panel_10.repaint();
			        try(Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)){
						  Statement stmt = jdbcConnect.createStatement();
					        	ResultSet rsData = stmt.executeQuery("Select * from orders where order_status =\"Declined\"");
					          while(rsData.next()) {
					        	  
					        	  panel_10.add(new Order(Integer.toString(rsData.getInt("user_id")),rsData.getString("user_name"),rsData.getString("product_name"),Integer.toString(rsData.getInt("product_price")),rsData.getString("Order_status"),rsData.getString("date_and_time")));
					        	  
					        	  }
					          rsData.close();
					            } catch (SQLException e1) {
					        	e1.printStackTrace();
					        	}
				btnNewButton_1_3.setBackground(Color.WHITE);
				btnNewButton_1_3.setForeground(Color.black);
				btnNewButton_1_2.setForeground(Color.WHITE);
				btnNewButton_1_2.setBackground(Color.BLACK);
				btnNewButton_1_1.setForeground(Color.WHITE);
				btnNewButton_1_1.setBackground(Color.BLACK);
				btnNewButton_1.setForeground(Color.WHITE);
				btnNewButton_1.setBackground(Color.BLACK);
				
			}
		});

		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_10.removeAll();
			     panel_10.revalidate();
			        panel_10.repaint();

				  try(Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)){
		  Statement stmt = jdbcConnect.createStatement();
      	ResultSet rsData = stmt.executeQuery("Select * from orders where order_status =\"Accepted\"");
        while(rsData.next()) {
      	  
      	  panel_10.add(new Order(Integer.toString(rsData.getInt("user_id")),rsData.getString("user_name"),rsData.getString("product_name"),Integer.toString(rsData.getInt("product_price")),rsData.getString("Order_status"),rsData.getString("date_and_time")));
      	  
      	  }
        rsData.close();
          } catch (SQLException e1) {
      	e1.printStackTrace();
      	}

				btnNewButton_1_2.setBackground(Color.WHITE);
				btnNewButton_1_2.setForeground(Color.black);
				btnNewButton_1_1.setForeground(Color.WHITE);
				btnNewButton_1_1.setBackground(Color.BLACK);

				btnNewButton_1_3.setForeground(Color.WHITE);
				btnNewButton_1_3.setBackground(Color.BLACK);
				btnNewButton_1.setForeground(Color.WHITE);
				btnNewButton_1.setBackground(Color.BLACK);
				
	       }

		});
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_10.removeAll();
			     panel_10.revalidate();
			        panel_10.repaint();

		  try(Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)){
			  Statement stmt = jdbcConnect.createStatement();
		        	ResultSet rsData = stmt.executeQuery("Select * from orders where order_status =\"Waiting\" limit "+page+",9");
		          while(rsData.next()) {
		        	  
		        	  panel_10.add(new Order(Integer.toString(rsData.getInt("user_id")),rsData.getString("user_name"),rsData.getString("product_name"),Integer.toString(rsData.getInt("product_price")),rsData.getString("Order_status"),rsData.getString("date_and_time")));
		        	  
		        	  }
		          rsData.close();
		            } catch (SQLException e1) {
		        	e1.printStackTrace();
		        	}
				btnNewButton_1_1.setBackground(Color.WHITE);
				btnNewButton_1_1.setForeground(Color.black);
				btnNewButton_1_2.setForeground(Color.WHITE);
				btnNewButton_1_2.setBackground(Color.BLACK);
				btnNewButton_1_3.setForeground(Color.WHITE);
				btnNewButton_1_3.setBackground(Color.BLACK);
				btnNewButton_1.setForeground(Color.WHITE);
				btnNewButton_1.setBackground(Color.BLACK);
				
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				panel_10.removeAll();
			     panel_10.revalidate();
			        panel_10.repaint();
		  try(Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)){
			  Statement stmt = jdbcConnect.createStatement();
		        	ResultSet rsData = stmt.executeQuery(QUERY);
		          while(rsData.next()) {
		        	  
		        	  panel_10.add(new Order(Integer.toString(rsData.getInt("user_id")),rsData.getString("user_name"),rsData.getString("product_name"),Integer.toString(rsData.getInt("product_price")),rsData.getString("Order_status"),rsData.getString("date_and_time")));
		        	  
		        	  }
		          rsData.close();
		            } catch (SQLException e1) {
		        	e1.printStackTrace();
		        	}
		      btnNewButton_1.setBackground(Color.white);
				btnNewButton_1.setForeground(Color.black);
				btnNewButton_1_2.setForeground(Color.WHITE);
				btnNewButton_1_2.setBackground(Color.BLACK);
				btnNewButton_1_3.setForeground(Color.WHITE);
				btnNewButton_1_3.setBackground(Color.BLACK);
				btnNewButton_1_1.setForeground(Color.WHITE);
				btnNewButton_1_1.setBackground(Color.BLACK);

				
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

		        try(Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)){
					  Statement stmt = jdbcConnect.createStatement();
				        	ResultSet rsData = stmt.executeQuery("SELECT * FROM orders limit "+page+",9");
				          while(rsData.next()) {
				        	  panel_10.add(new Order(Integer.toString(rsData.getInt("user_id")),rsData.getString("user_name"),rsData.getString("product_name"),Integer.toString(rsData.getInt("product_price")),rsData.getString("Order_status"),rsData.getString("date_and_time")));
				          }
				          rsData.close();
				            } catch (SQLException e1) {
				        	e1.printStackTrace();
				        	}

				}
			}
		});

		btnNewButton_9_1.setBounds(427, 18, 119, 21);
		panel_11.add(btnNewButton_9_1);
		
		
		
		JButton btnNewButton_9 = new JButton("Next page");
	btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
		        try(Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)){
					  Statement stmt = jdbcConnect.createStatement();
					  Statement stmt1 = jdbcConnect.createStatement();
					   ResultSet count = stmt1.executeQuery("SELECT count(*) as count from orders;");
						  count.next();
						  if(page+9<= count.getInt("count")) {
			              page=page+9;
						  ResultSet rsData = stmt.executeQuery("SELECT * FROM orders limit "+page+",9");
						
						
			    panel_10.removeAll();
		        panel_10.revalidate();
		        panel_10.repaint();
				   while(rsData.next()) {
				    panel_10.add(new Order(Integer.toString(rsData.getInt("user_id")),rsData.getString("user_name"),rsData.getString("product_name"),Integer.toString(rsData.getInt("product_price")),rsData.getString("Order_status"),rsData.getString("date_and_time")));
				          }
				   rsData.close();
		        }
		        }
//				          
					  
				             catch (SQLException e1) {
				        	e1.printStackTrace();
				        	}
					  
			
		        
			
					  
		        

			}
			
		});
	
	   btnNewButton_9.setBounds(664, 18, 119, 21);
		panel_11.add(btnNewButton_9);

	}
}