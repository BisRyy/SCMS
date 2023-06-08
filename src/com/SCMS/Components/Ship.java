package com.SCMS.Components;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import com.SCMS.Pages.Shipment;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ship extends JPanel {
	Ship_Details ship;
	JPanel s = this;

	public Ship(String shipID, String from, String To, String status, String track) {

		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Shipment ID:");
		lblNewLabel_3.setBounds(10, 10, 90, 26);
		add(lblNewLabel_3);

		JButton btnNewButton = new JButton(status);
		btnNewButton.setBackground(new Color(204, 255, 255));
		btnNewButton.setForeground(new Color(0, 51, 255));
		btnNewButton.setBounds(367, 13, 85, 21);
		btnNewButton.setEnabled(false);
		add(btnNewButton);

		JLabel lblNewLabel_4 = new JLabel(shipID);
		lblNewLabel_4.setBounds(10, 34, 65, 13);
		add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("From");
		lblNewLabel_5.setBounds(30, 57, 45, 13);
		add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel(from);
		lblNewLabel_6.setBounds(40, 80, 105, 13);
		add(lblNewLabel_6);

		JLabel lblNewLabel_5_1 = new JLabel("To");
		lblNewLabel_5_1.setBounds(197, 57, 45, 13);
		add(lblNewLabel_5_1);

		JLabel lblNewLabel_6_1 = new JLabel(To);
		lblNewLabel_6_1.setBounds(207, 80, 105, 13);
		add(lblNewLabel_6_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 46, 341, 2);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 144, 341, 2);
		add(separator_1);

		JLabel lblNewLabel_7 = new JLabel("Tracking Number:");
		lblNewLabel_7.setBounds(10, 121, 105, 13);
		add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel(track);
		lblNewLabel_8.setBounds(155, 121, 65, 13);
		add(lblNewLabel_8);

		JButton btnNewButton_1 = new JButton("Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container parentContainer = s.getParent().getParent().getParent();
				Ship_Details sh = new Ship_Details(shipID, from, To, status);
				// parentContainer.remove(new Ship_Details(shipID,from,To,status));
				parentContainer.add(sh);

				parentContainer.revalidate();
				parentContainer.repaint();

			}
		});
		btnNewButton_1.setBounds(93, 156, 85, 21);
		add(btnNewButton_1);

	}

}