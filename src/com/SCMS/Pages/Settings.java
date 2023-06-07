package com.SCMS.Pages;

import java.awt.*;
import java.io.File;

import javax.swing.*;

public class Settings extends JPanel {
    private JLabel profilePictureLabel;
    private JComboBox<String> languageComboBox;
    private JCheckBox emailCheckBox;
    private JCheckBox smsCheckBox;

    // Account Settings management
    public Settings() {
        setLayout(new BorderLayout());
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(200, 0));
        sidebar.add(ProfilePicture());
        // sidebar.add(Account());
        add(sidebar, BorderLayout.WEST);
        add(Language(), BorderLayout.CENTER);
        add(Notification(), BorderLayout.CENTER);
        // add(Theme(), BorderLayout.EAST);
    }

    private void uploadProfilePicture() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            // Perform image upload and update the profile picture label
            ImageIcon imageIcon = new ImageIcon(selectedFile.getPath());
            // scale image
            Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            profilePictureLabel.setIcon(new ImageIcon(image));
        }
    }

    private JPanel ProfilePicture() {
        JPanel profilePicturePanel = new JPanel();
        profilePicturePanel.setLayout(new BorderLayout());
        profilePicturePanel.setBorder(BorderFactory.createTitledBorder("Profile Picture"));

        profilePictureLabel = new JLabel();
        profilePictureLabel.setPreferredSize(new Dimension(150, 150));
        profilePicturePanel.setPreferredSize(new Dimension(150, 150));
        profilePictureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        profilePictureLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton uploadButton = new JButton("Upload");
        uploadButton.addActionListener((e) -> {
            uploadProfilePicture();
        });

        profilePicturePanel.add(profilePictureLabel, BorderLayout.CENTER);
        profilePicturePanel.add(uploadButton, BorderLayout.SOUTH);

        return profilePicturePanel;
    }

    // private void saveAccountSettings() {
    // String firstName = firstNameTextField.getText();
    // String lastName = lastNameTextField.getText();
    // String email = emailTextField.getText();
    //
    // // Perform save operation here
    //
    // JOptionPane.showMessageDialog(this, "Account settings saved successfully!");
    // }

    private JPanel Language() {
        JPanel languagePanel = new JPanel();
        languagePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        languagePanel.setBorder(BorderFactory.createTitledBorder("Language Selection"));

        String[] languages = { "English", "French", "German", "Spanish" };
        languageComboBox = new JComboBox<>(languages);

        languagePanel.add(languageComboBox);
        return languagePanel;
    }

    private JPanel Notification() {
        JTextArea idText;
        JTextArea nameText;
        JTextField priceField;
        JTextField quantityField;
        JTextField categoryCombo;
        JTextField shortDescriptionField;

        JPanel notificationPanel = new JPanel();
        notificationPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        notificationPanel.setBorder(BorderFactory.createTitledBorder("Notification Settings"));

        emailCheckBox = new JCheckBox("Email Notifications");
        smsCheckBox = new JCheckBox("SMS Notifications");

        JLabel shortDescriptionLabel = new JLabel("Username");
        shortDescriptionField = new JTextField();
        JLabel idLabel = new JLabel("First Name");
        JLabel nameLabel = new JLabel("Last Name");
        idText = new JTextArea();
        nameText = new JTextArea();
        JLabel priceLabel = new JLabel("Email");
        JLabel quantity = new JLabel("Phone");
        priceField = new JTextField();
        quantityField = new JTextField();
        JLabel categoryLabel = new JLabel("Address");
        categoryCombo = new JTextField();
        JButton submitButton = new JButton("Update");

        notificationPanel.setLayout(new GridLayout(7, 2, 20, 20));
        notificationPanel.add(shortDescriptionLabel);
        notificationPanel.add(idLabel);
        notificationPanel.add(shortDescriptionField);
        notificationPanel.add(idText);
        notificationPanel.add(nameLabel);
        notificationPanel.add(priceLabel);
        notificationPanel.add(nameText);
        notificationPanel.add(priceField);
        notificationPanel.add(quantity);
        notificationPanel.add(categoryLabel);
        notificationPanel.add(quantityField);
        notificationPanel.add(categoryCombo);
        notificationPanel.add(submitButton);

        return notificationPanel;
    }

    private JPanel Security() {
        JPanel securityPanel = new JPanel();
        securityPanel.setLayout(new GridLayout(2, 2, 10, 10));
        securityPanel.setBorder(BorderFactory.createTitledBorder("Security Settings"));

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        JPasswordField confirmPasswordField = new JPasswordField();

        securityPanel.add(passwordLabel);
        securityPanel.add(passwordField);
        securityPanel.add(confirmPasswordLabel);
        securityPanel.add(confirmPasswordField);
        return securityPanel;
    }
}