package com.SCMS.Pages;

import javax.swing.JPanel;
import javax.swing.JTextField;
import com.SCMS.Components.Order;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Orders extends JPanel {

	int page = 0;

	private JTextField textField;

	public Orders() {
		String DB_URL = "jdbc:mysql://localhost/SCMS";
		String USERNAME = "root";
		String PASSWORD = "";
		String QUERY = "select * from orders o join users u on o.user_id = u.user_id join products p on o.product_id = p.product_id limit "
				+ page + ",9";
		setBackground(new Color(0, 0, 0));
		setLayout(null);

		JPanel Headpanel = new JPanel();

		Headpanel.setBounds(0, 0, 1266, 75);
		Headpanel.setBackground(new Color(0, 0, 0));
		add(Headpanel);
		Headpanel.setLayout(null);

		JLabel SearchLabel = new JLabel("Search:");
		SearchLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		SearchLabel.setBounds(798, 10, 101, 24);
		Headpanel.add(SearchLabel);
		SearchLabel.setIcon(new ImageIcon("lib/icons/search.png"));

		SearchLabel.setForeground(Color.WHITE);

		textField = new JTextField();
		textField.setBounds(909, 13, 172, 19);
		Headpanel.add(textField);
		textField.setColumns(10);

		JButton SearchButton = new JButton("Search");

		SearchButton.setBounds(1091, 12, 85, 21);
		Headpanel.add(SearchButton);

		JButton AllOrders = new JButton("All orders");

		AllOrders.setBackground(Color.WHITE);
		AllOrders.setForeground(Color.black);
		AllOrders.setBounds(10, 54, 100, 21);
		Headpanel.add(AllOrders);

		JButton Waiting = new JButton("Waiting");

		Waiting.setForeground(Color.WHITE);
		Waiting.setBackground(Color.BLACK);
		Waiting.setBounds(105, 54, 100, 21);
		Headpanel.add(Waiting);

		JButton AcceptedButton = new JButton("Accepted");

		AcceptedButton.setForeground(Color.WHITE);
		AcceptedButton.setBackground(Color.BLACK);
		AcceptedButton.setBounds(200, 54, 100, 21);
		Headpanel.add(AcceptedButton);
		JButton DeclinedButton = new JButton("Declined");

		DeclinedButton.setForeground(Color.WHITE);
		DeclinedButton.setBackground(Color.BLACK);
		DeclinedButton.setBounds(295, 54, 100, 21);
		Headpanel.add(DeclinedButton);

		JPanel Mainpanel = new JPanel();

		Mainpanel.setBounds(0, 75, 1266, 570);
		Mainpanel.setBackground(Color.black);
		add(Mainpanel);
		Mainpanel.setLayout(new GridLayout(3, 3, 10, 10));

		try {
			Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			Statement stmt = jdbcConnect.createStatement();
			ResultSet rsData = stmt.executeQuery(QUERY);
			while (rsData.next()) {
				Mainpanel.add(new Order(Integer.toString(rsData.getInt("user_id")), rsData.getString("username"),
						rsData.getString("name"), Integer.toString(rsData.getInt("price")),
						rsData.getString("order_status"), rsData.getString("order_date")));
			}
			rsData.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JPanel FooterPanel = new JPanel();
		FooterPanel.setBounds(0, 647, 1266, 49);
		FooterPanel.setBackground(new Color(0, 0, 0));
		add(FooterPanel);
		FooterPanel.setLayout(null);

		JButton PreviousPage = new JButton("Previous Page");
		PreviousPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (page != 0) {
					page = page - 9;

					Mainpanel.removeAll();
					Mainpanel.revalidate();
					Mainpanel.repaint();

					try (Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
						Statement stmt = jdbcConnect.createStatement();
						ResultSet rsData = stmt.executeQuery(
								"select * from orders o join users u on o.user_id = u.user_id join products p on o.product_id = p.product_id limit "
										+ page + ",9");
						while (rsData.next()) {
							Mainpanel.add(new Order(Integer.toString(rsData.getInt("user_id")),
									rsData.getString("username"), rsData.getString("name"),
									Integer.toString(rsData.getInt("price")), rsData.getString("order_status"),
									rsData.getString("order_date")));
						}
						rsData.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}
			}
		});

		PreviousPage.setBounds(427, 18, 119, 21);
		FooterPanel.add(PreviousPage);

		JButton NextPage = new JButton("Next page");
		NextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try (Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
					Statement stmt = jdbcConnect.createStatement();
					Statement stmt1 = jdbcConnect.createStatement();
					ResultSet count = stmt1.executeQuery("SELECT count(*) as count from orders;");
					count.next();
					if (page + 9 < count.getInt("count")) {
						page = page + 9;
						ResultSet rsData = stmt.executeQuery(
								"select * from orders o join users u on o.user_id = u.user_id join products p on o.product_id = p.product_id limit "
										+ page + ",9");

						Mainpanel.removeAll();
						Mainpanel.revalidate();
						Mainpanel.repaint();
						while (rsData.next()) {
							Mainpanel.add(new Order(Integer.toString(rsData.getInt("user_id")),
									rsData.getString("username"), rsData.getString("name"),
									Integer.toString(rsData.getInt("price")), rsData.getString("order_status"),
									rsData.getString("order_date")));
						}
						rsData.close();
					}
				}

				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		});

		NextPage.setBounds(664, 18, 119, 21);
		FooterPanel.add(NextPage);

		DeclinedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page = 0;
				Mainpanel.removeAll();
				Mainpanel.revalidate();
				Mainpanel.repaint();
				try (Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
					Statement stmt = jdbcConnect.createStatement();
					ResultSet rsData = stmt
							.executeQuery(
									"select * from orders o join users u on o.user_id = u.user_id join products p on o.product_id = p.product_id where order_status =\"Declined\" limit "
											+ page + ",9");
					while (rsData.next()) {

						Mainpanel.add(new Order(Integer.toString(rsData.getInt("user_id")),
								rsData.getString("username"), rsData.getString("name"),
								Integer.toString(rsData.getInt("price")), rsData.getString("order_status"),
								rsData.getString("order_date")));

					}
					rsData.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				FooterPanel.removeAll();
				FooterPanel.revalidate();
				FooterPanel.repaint();
				JButton nextpage = new JButton("Next page");
				nextpage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						try (Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
							Statement stmt = jdbcConnect.createStatement();
							Statement stmt1 = jdbcConnect.createStatement();
							ResultSet count = stmt1.executeQuery(
									"SELECT count(*) as count from orders where order_status =\"Declined\";");
							count.next();
							if (page + 9 < count.getInt("count")) {
								page = page + 9;
								ResultSet rsData = stmt.executeQuery(
										"select * from orders o join users u on o.user_id = u.user_id join products p on o.product_id = p.product_id where order_status =\"Declined\" limit "
												+ page + ",9");

								Mainpanel.removeAll();
								Mainpanel.revalidate();
								Mainpanel.repaint();
								while (rsData.next()) {
									Mainpanel.add(new Order(Integer.toString(rsData.getInt("user_id")),
											rsData.getString("username"), rsData.getString("name"),
											Integer.toString(rsData.getInt("price")),
											rsData.getString("order_status"), rsData.getString("order_date")));
								}
								rsData.close();
							}
						}

						catch (SQLException e1) {
							e1.printStackTrace();
						}

					}

				});
				nextpage.setBounds(664, 18, 119, 21);
				FooterPanel.add(nextpage);
				JButton previouspage = new JButton("Previous Page");
				nextpage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						try (Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
							Statement stmt = jdbcConnect.createStatement();

							if (page != 0) {
								page = page - 9;
								ResultSet rsData = stmt.executeQuery(
										"select * from orders o join users u on o.user_id = u.user_id join products p on o.product_id = p.product_id where order_status =\"Declined\" limit "
												+ page + ",9");

								Mainpanel.removeAll();
								Mainpanel.revalidate();
								Mainpanel.repaint();
								while (rsData.next()) {
									Mainpanel.add(new Order(Integer.toString(rsData.getInt("user_id")),
											rsData.getString("username"), rsData.getString("name"),
											Integer.toString(rsData.getInt("price")),
											rsData.getString("order_status"), rsData.getString("order_date")));
								}
								rsData.close();
							}
						}

						catch (SQLException e1) {
							e1.printStackTrace();
						}

					}

				});
				previouspage.setBounds(427, 18, 119, 21);
				FooterPanel.add(previouspage);
				DeclinedButton.setBackground(Color.WHITE);
				DeclinedButton.setForeground(Color.black);
				AcceptedButton.setForeground(Color.WHITE);
				AcceptedButton.setBackground(Color.BLACK);
				Waiting.setForeground(Color.WHITE);
				Waiting.setBackground(Color.BLACK);
				AllOrders.setForeground(Color.WHITE);
				AllOrders.setBackground(Color.BLACK);

			}
		});
		AllOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page = 0;

				Mainpanel.removeAll();
				Mainpanel.revalidate();
				Mainpanel.repaint();
				try (Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
					Statement stmt = jdbcConnect.createStatement();
					ResultSet rsData = stmt.executeQuery(QUERY);
					while (rsData.next()) {

						Mainpanel.add(new Order(Integer.toString(rsData.getInt("user_id")),
								rsData.getString("username"), rsData.getString("name"),
								Integer.toString(rsData.getInt("price")), rsData.getString("order_status"),
								rsData.getString("order_date")));

					}
					rsData.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				FooterPanel.removeAll();
				FooterPanel.revalidate();
				FooterPanel.repaint();
				JButton Anextpage = new JButton("Next page");
				Anextpage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						try (Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
							Statement stmt = jdbcConnect.createStatement();
							Statement stmt1 = jdbcConnect.createStatement();
							ResultSet count = stmt1.executeQuery("SELECT count(*) as count from orders;");
							count.next();
							if (page + 9 < count.getInt("count")) {
								page = page + 9;
								ResultSet rsData = stmt.executeQuery(
										"select * from orders o join users u on o.user_id = u.user_id join products p on o.product_id = p.product_id limit "
												+ page + ",9");

								Mainpanel.removeAll();
								Mainpanel.revalidate();
								Mainpanel.repaint();
								while (rsData.next()) {
									Mainpanel.add(new Order(Integer.toString(rsData.getInt("user_id")),
											rsData.getString("username"), rsData.getString("name"),
											Integer.toString(rsData.getInt("price")),
											rsData.getString("order_status"), rsData.getString("order_date")));
								}
								rsData.close();
							}
						}

						catch (SQLException e1) {
							e1.printStackTrace();
						}

					}

				});
				JButton PreviousPage = new JButton("Previous Page");
				PreviousPage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (page != 0) {
							page = page - 9;

							Mainpanel.removeAll();
							Mainpanel.revalidate();
							Mainpanel.repaint();

							try (Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
								Statement stmt = jdbcConnect.createStatement();
								ResultSet rsData = stmt.executeQuery(
										"select * from orders o join users u on o.user_id = u.user_id join products p on o.product_id = p.product_id limit "
												+ page + ",9");
								while (rsData.next()) {
									Mainpanel.add(new Order(Integer.toString(rsData.getInt("user_id")),
											rsData.getString("username"), rsData.getString("name"),
											Integer.toString(rsData.getInt("price")),
											rsData.getString("order_status"), rsData.getString("order_date")));
								}
								rsData.close();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}

						}
					}
				});

				PreviousPage.setBounds(427, 18, 119, 21);
				FooterPanel.add(PreviousPage);
				Anextpage.setBounds(664, 18, 119, 21);
				FooterPanel.add(Anextpage);
				AllOrders.setBackground(Color.white);
				AllOrders.setForeground(Color.black);
				AcceptedButton.setForeground(Color.WHITE);
				AcceptedButton.setBackground(Color.BLACK);
				DeclinedButton.setForeground(Color.WHITE);
				DeclinedButton.setBackground(Color.BLACK);
				Waiting.setForeground(Color.WHITE);
				Waiting.setBackground(Color.BLACK);

			}
		});
		AcceptedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page = 0;
				Mainpanel.removeAll();
				Mainpanel.revalidate();
				Mainpanel.repaint();

				try (Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
					Statement stmt = jdbcConnect.createStatement();
					ResultSet rsData = stmt.executeQuery(
							"select * from orders o join users u on o.user_id = u.user_id join products p on o.product_id = p.product_id where order_status =\"Accepted\"");
					while (rsData.next()) {

						Mainpanel.add(new Order(Integer.toString(rsData.getInt("user_id")),
								rsData.getString("username"), rsData.getString("name"),
								Integer.toString(rsData.getInt("price")), rsData.getString("order_status"),
								rsData.getString("order_date")));

					}
					rsData.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				FooterPanel.removeAll();
				FooterPanel.revalidate();
				FooterPanel.repaint();
				JButton nextpage = new JButton("Next page");
				nextpage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						try (Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
							Statement stmt = jdbcConnect.createStatement();
							Statement stmt1 = jdbcConnect.createStatement();
							ResultSet count = stmt1.executeQuery(
									"SELECT count(*) as count from orders where order_status =\"Accepted\";");
							count.next();
							if (page + 9 < count.getInt("count")) {
								page = page + 9;
								ResultSet rsData = stmt.executeQuery(
										"select * from orders o join users u on o.user_id = u.user_id join products p on o.product_id = p.product_id where order_status =\"Accepted\" limit "
												+ page + ",9");

								Mainpanel.removeAll();
								Mainpanel.revalidate();
								Mainpanel.repaint();
								while (rsData.next()) {
									Mainpanel.add(new Order(Integer.toString(rsData.getInt("user_id")),
											rsData.getString("username"), rsData.getString("name"),
											Integer.toString(rsData.getInt("price")),
											rsData.getString("order_status"), rsData.getString("order_date")));
								}
								rsData.close();
							}
						}

						catch (SQLException e1) {
							e1.printStackTrace();
						}

					}

				});
				JButton previouspage = new JButton("Previous Page");
				nextpage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						try (Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
							Statement stmt = jdbcConnect.createStatement();

							if (page != 0) {
								page = page - 9;
								ResultSet rsData = stmt.executeQuery(
										"select * from orders o join users u on o.user_id = u.user_id join products p on o.product_id = p.product_id where order_status =\"Accepted\" limit "
												+ page + ",9");

								Mainpanel.removeAll();
								Mainpanel.revalidate();
								Mainpanel.repaint();
								while (rsData.next()) {
									Mainpanel.add(new Order(Integer.toString(rsData.getInt("user_id")),
											rsData.getString("username"), rsData.getString("name"),
											Integer.toString(rsData.getInt("price")),
											rsData.getString("order_status"), rsData.getString("order_date")));
								}
								rsData.close();
							}
						}

						catch (SQLException e1) {
							e1.printStackTrace();
						}

					}

				});
				previouspage.setBounds(427, 18, 119, 21);
				FooterPanel.add(previouspage);
				nextpage.setBounds(664, 18, 119, 21);
				FooterPanel.add(nextpage);

				AcceptedButton.setBackground(Color.WHITE);
				AcceptedButton.setForeground(Color.black);
				Waiting.setForeground(Color.WHITE);
				Waiting.setBackground(Color.BLACK);

				DeclinedButton.setForeground(Color.WHITE);
				DeclinedButton.setBackground(Color.BLACK);
				AllOrders.setForeground(Color.WHITE);
				AllOrders.setBackground(Color.BLACK);

			}

		});
		Waiting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page = 0;
				Mainpanel.removeAll();
				Mainpanel.revalidate();
				Mainpanel.repaint();

				try (Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
					Statement stmt = jdbcConnect.createStatement();
					ResultSet rsData = stmt
							.executeQuery(
									"select * from orders o join users u on o.user_id = u.user_id join products p on o.product_id = p.product_id where order_status =\"Waiting\" limit "
											+ page + ",9");
					while (rsData.next()) {

						Mainpanel.add(new Order(Integer.toString(rsData.getInt("user_id")),
								rsData.getString("username"), rsData.getString("name"),
								Integer.toString(rsData.getInt("price")), rsData.getString("order_status"),
								rsData.getString("order_date")));

					}
					rsData.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				FooterPanel.removeAll();
				FooterPanel.revalidate();
				FooterPanel.repaint();
				JButton nextpage = new JButton("Next page");
				nextpage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						try (Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
							Statement stmt = jdbcConnect.createStatement();
							Statement stmt1 = jdbcConnect.createStatement();
							ResultSet count = stmt1.executeQuery(
									"SELECT count(*) as count from orders where order_status =\"Waiting\";");
							count.next();
							if (page + 9 < count.getInt("count")) {
								page = page + 9;
								ResultSet rsData = stmt.executeQuery(
										"select * from orders o join users u on o.user_id = u.user_id join products p on o.product_id = p.product_id where order_status =\"Waiting\" limit "
												+ page + ",9");

								Mainpanel.removeAll();
								Mainpanel.revalidate();
								Mainpanel.repaint();
								while (rsData.next()) {
									Mainpanel.add(new Order(Integer.toString(rsData.getInt("user_id")),
											rsData.getString("username"), rsData.getString("name"),
											Integer.toString(rsData.getInt("price")),
											rsData.getString("order_status"), rsData.getString("order_date")));
								}
								rsData.close();
							}
						}

						catch (SQLException e1) {
							e1.printStackTrace();
						}

					}

				});
				JButton previouspage = new JButton("Previous Page");
				nextpage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						try (Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
							Statement stmt = jdbcConnect.createStatement();

							if (page != 0) {
								page = page - 9;
								ResultSet rsData = stmt.executeQuery(
										"select * from orders o join users u on o.user_id = u.user_id join products p on o.product_id = p.product_id where order_status =\"Waiting\" limit "
												+ page + ",9");

								Mainpanel.removeAll();
								Mainpanel.revalidate();
								Mainpanel.repaint();
								while (rsData.next()) {
									Mainpanel.add(new Order(Integer.toString(rsData.getInt("user_id")),
											rsData.getString("username"), rsData.getString("name"),
											Integer.toString(rsData.getInt("price")),
											rsData.getString("order_status"), rsData.getString("order_date")));
								}
								rsData.close();
							}
						}

						catch (SQLException e1) {
							e1.printStackTrace();
						}

					}

				});
				previouspage.setBounds(427, 18, 119, 21);
				FooterPanel.add(previouspage);
				nextpage.setBounds(664, 18, 119, 21);
				FooterPanel.add(nextpage);
				Waiting.setBackground(Color.WHITE);
				Waiting.setForeground(Color.black);
				AcceptedButton.setForeground(Color.WHITE);
				AcceptedButton.setBackground(Color.BLACK);
				DeclinedButton.setForeground(Color.WHITE);
				DeclinedButton.setBackground(Color.BLACK);
				AllOrders.setForeground(Color.WHITE);
				AllOrders.setBackground(Color.BLACK);

			}
		});
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainpanel.removeAll();
				Mainpanel.revalidate();
				Mainpanel.repaint();
				FooterPanel.removeAll();
				FooterPanel.revalidate();
				FooterPanel.repaint();

				try (Connection jdbcConnect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
					Statement stmt = jdbcConnect.createStatement();
					ResultSet rsData = stmt
							.executeQuery(
									"select * from orders o join users u on o.user_id = u.user_id join products p on o.product_id = p.product_id where username =\""
											+ textField.getText() + "\"");
					while (rsData.next()) {

						Mainpanel.add(new Order(Integer.toString(rsData.getInt("user_id")),
								rsData.getString("username"), rsData.getString("name"),
								Integer.toString(rsData.getInt("price")), rsData.getString("order_status"),
								rsData.getString("order_date")));

					}
					rsData.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		});
	}
}