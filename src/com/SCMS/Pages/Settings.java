package com.SCMS.Pages;

import java.awt.*;
import java.io.File;

import javax.swing.*;

public class Settings extends JPanel{
    private JLabel profilePictureLabel;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField emailTextField;
    private JTextField phoneTextField;
    private JTextField addressTextField;
    private JComboBox<String> languageComboBox;
    private JCheckBox emailCheckBox;
    private JCheckBox smsCheckBox;
    
    // Account Settings management
    public Settings(){
        setLayout(new BorderLayout());
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(200, 0));
        sidebar.add(ProfilePicture());
        sidebar.add(Account());
        add(sidebar, BorderLayout.WEST);
        add(Language(), BorderLayout.CENTER);
        add(Notification(), BorderLayout.CENTER);
        add(Theme(), BorderLayout.EAST);
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

    private JPanel ProfilePicture(){
        JPanel profilePicturePanel = new JPanel();
        profilePicturePanel.setLayout(new BorderLayout());
        profilePicturePanel.setBorder(BorderFactory.createTitledBorder("Profile Picture"));

        profilePictureLabel = new JLabel();
        profilePictureLabel.setPreferredSize(new Dimension(150, 150));
        profilePicturePanel.setPreferredSize(new Dimension(150, 150));
        profilePictureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        profilePictureLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton uploadButton = new JButton("Upload");
        uploadButton.addActionListener((e)-> {
            uploadProfilePicture();
        });

        profilePicturePanel.add(profilePictureLabel, BorderLayout.CENTER);
        profilePicturePanel.add(uploadButton, BorderLayout.SOUTH);

        return profilePicturePanel;
    }

    private JPanel Account(){
        JPanel accountDetailsPanel = new JPanel();
        accountDetailsPanel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameTextField = new JTextField();
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameTextField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        emailTextField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone:");
        phoneTextField = new JPasswordField();
        JLabel addressLabel = new JLabel("Address:");
        addressTextField = new JPasswordField();

        accountDetailsPanel.add(firstNameLabel);
        accountDetailsPanel.add(firstNameTextField);
        accountDetailsPanel.add(lastNameLabel);
        accountDetailsPanel.add(lastNameTextField);
        accountDetailsPanel.add(emailLabel);
        accountDetailsPanel.add(emailTextField);
        accountDetailsPanel.add(phoneLabel);
        accountDetailsPanel.add(phoneTextField);
        accountDetailsPanel.add(addressLabel);
        accountDetailsPanel.add(addressTextField);
        return accountDetailsPanel;
    }

    private void saveAccountSettings() {
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String email = emailTextField.getText();

        // Perform save operation here

        JOptionPane.showMessageDialog(this, "Account settings saved successfully!");
    }

    private JPanel Language(){
        JPanel languagePanel = new JPanel();
        languagePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        languagePanel.setBorder(BorderFactory.createTitledBorder("Language Selection"));

        String[] languages = { "English", "French", "German", "Spanish" };
        languageComboBox = new JComboBox<>(languages);

        languagePanel.add(languageComboBox);
        return languagePanel;
    }

    private JPanel Notification(){
        JPanel notificationPanel = new JPanel();
        notificationPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        notificationPanel.setBorder(BorderFactory.createTitledBorder("Notification Settings"));

        emailCheckBox = new JCheckBox("Email Notifications");
        smsCheckBox = new JCheckBox("SMS Notifications");

        notificationPanel.add(emailCheckBox);
        notificationPanel.add(smsCheckBox);
        return notificationPanel;
    }

    private JPanel Theme(){
        JPanel themePanel = new JPanel();
        themePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        themePanel.setBorder(BorderFactory.createTitledBorder("Theme Selection"));

        String[] themes = { "Light", "Dark" };
        JComboBox<String> themeComboBox = new JComboBox<>(themes);

        themePanel.add(themeComboBox);
        return themePanel;
    }

    private JPanel Security(){
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
