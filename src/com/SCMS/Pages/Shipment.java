package com.SCMS.Pages;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

public class Shipment extends JPanel {

    public Shipment() {
        this.setBorder(BorderFactory.createTitledBorder("Shipment"));
        this.setLayout(new FlowLayout());
        this.add(new JLabel("Shipment"), BorderLayout.CENTER);

        // explain what is shipment and its purpose features and how to use it
        add(new JLabel("Shipment is where you can manage your shipments and track them. "), BorderLayout.NORTH);
        add(new JLabel("You can combine multiple orders into one shipment. "), BorderLayout.WEST);
        add(new JLabel("You can add new shipment, edit or delete existing ones. "), BorderLayout.CENTER);
        add(new JLabel("You can also track your shipment by entering the tracking number. "), BorderLayout.SOUTH);
    }
}
