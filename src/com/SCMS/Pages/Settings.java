package com.SCMS.Pages;

import com.SCMS.Auth.SessionManager;
import com.SCMS.Utils.Database;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;
import java.util.Properties;

public class Settings extends JPanel {
    private JLabel profilePictureLabel;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField emailTextField;
    private JTextField phoneTextField;
    private JTextField addressTextField;
    private JComboBox<String> languageComboBox;
    private JCheckBox emailCheckBox;
    private Database db = new Database();
    private String imagepath;

    public Settings() {
        setLayout(new BorderLayout());
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(350, 0));
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
            ImageIcon imageIcon = new ImageIcon(selectedFile.getPath());
            Image image = imageIcon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
            profilePictureLabel.setIcon(new ImageIcon(image));
            imagepath = selectedFile.getPath();
        }

    }

    private JPanel ProfilePicture() {
        JPanel profilePicturePanel = new JPanel();
        profilePicturePanel.setLayout(new BorderLayout());
        profilePicturePanel.setBorder(BorderFactory.createTitledBorder("Profile Picture"));
        profilePicturePanel.setBackground(Color.WHITE);

        profilePictureLabel = new JLabel();
        profilePictureLabel.setPreferredSize(new Dimension(150, 50));
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

    private JPanel Account() {
        JPanel accountDetailsPanel = new JPanel();
        accountDetailsPanel.setLayout(new GridBagLayout());
        accountDetailsPanel.setBorder(BorderFactory.createTitledBorder("Account Details"));
        accountDetailsPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        Map<String, String> userInfo = db.userInfo(SessionManager.getAuthenticatedUser());

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameTextField = new JTextField(userInfo.get("fname"));
        firstNameTextField.setPreferredSize(new Dimension(200, 30)); // Set preferred size

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameTextField = new JTextField(userInfo.get("lname"));
        lastNameTextField.setPreferredSize(new Dimension(200, 30)); // Set preferred size

        JLabel emailLabel = new JLabel("Email:");
        emailTextField = new JTextField(userInfo.get("email"));
        emailTextField.setPreferredSize(new Dimension(200, 30)); // Set preferred size

        JLabel phoneLabel = new JLabel("Phone:");
        phoneTextField = new JTextField(userInfo.get("phone"));
        phoneTextField.setPreferredSize(new Dimension(200, 30)); // Set preferred size

        JLabel addressLabel = new JLabel("Address:");
        addressTextField = new JTextField(userInfo.get("address"));
        addressTextField.setPreferredSize(new Dimension(200, 30)); // Set preferred size

        gbc.gridx = 0;
        gbc.gridy = 0;
        accountDetailsPanel.add(firstNameLabel, gbc);
        gbc.gridx = 1;
        accountDetailsPanel.add(firstNameTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        accountDetailsPanel.add(lastNameLabel, gbc);
        gbc.gridx = 1;
        accountDetailsPanel.add(lastNameTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        accountDetailsPanel.add(emailLabel, gbc);
        gbc.gridx = 1;
        accountDetailsPanel.add(emailTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        accountDetailsPanel.add(phoneLabel, gbc);
        gbc.gridx = 1;
        accountDetailsPanel.add(phoneTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        accountDetailsPanel.add(addressLabel, gbc);
        gbc.gridx = 1;
        accountDetailsPanel.add(addressTextField, gbc);

        // Create the save button
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveButtonListener());

        // Add the save button to the accountDetailsPanel
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        accountDetailsPanel.add(saveButton, gbc);

        return accountDetailsPanel;
    }

    private JPanel Language() {
        JPanel languagePanel = new JPanel();
        languagePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        languagePanel.setBorder(BorderFactory.createTitledBorder("Language Selection"));
        languagePanel.setBackground(Color.WHITE);

        String[] languages = { "English", "French", "German", "Spanish" };
        languageComboBox = new JComboBox<>(languages);

        languagePanel.add(languageComboBox);
        return languagePanel;
    }

    private JPanel Notification() {
        JPanel notificationPanel = new JPanel();
        notificationPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        notificationPanel.setBorder(BorderFactory.createTitledBorder("Notification Settings"));
        notificationPanel.setBackground(Color.WHITE);

        emailCheckBox = new JCheckBox("Email Notifications");
        notificationPanel.add(emailCheckBox);
        return notificationPanel;
    }

    private JPanel Theme() {
        JPanel themePanel = new JPanel();
        themePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        themePanel.setBorder(BorderFactory.createTitledBorder("Theme Selection"));
        themePanel.setBackground(Color.WHITE);

        String[] themes = { "Light", "Dark" };
        JComboBox<String> themeComboBox = new JComboBox<>(themes);

        themePanel.add(themeComboBox);
        return themePanel;
    }

    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the updated information from the text fields
            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String email = emailTextField.getText();
            String phone = phoneTextField.getText();
            String address = addressTextField.getText();

            // Save the information to the SQL database
            boolean saved = db.saveUserInfo(SessionManager.getAuthenticatedUser(), firstName, lastName, email, phone,address, imagepath);
            if (saved) {
                JOptionPane.showMessageDialog(Settings.this, "Information saved successfully");
            } else {
                JOptionPane.showMessageDialog(Settings.this, "Failed to save information", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            // Check if email notifications are enabled
            if (emailCheckBox.isSelected()) {
                // Send email notification
                sendEmailNotification(email);
            }
        }
    }

    private void sendEmailNotification(String email) {
        // SMTP server configuration
        String host = "smtp.elasticemail.com";
        int port = 2525;
        String username = "birukmesfin246@gmail.com";
        String password = "AB2194EDDFAD43A826C75F388C9A65064686";

        // Sender and recipient email addresses
        String from = "birukmesfin246@gmail.com";
        String to = email;

        // Email subject and content
        String subject = "Email Notification";
        String content = "You have successfully activated your email notification. we will be sending you updates as well as any related info about your supplies. Have a nice day!";

        // Set properties for SMTP server
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Create a session with SMTP server authentication
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a new message
            Message message = new MimeMessage(session);

            // Set the sender and recipient addresses
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set the email subject and content
            message.setSubject(subject);
            message.setText(content);

            // Send the message
            Transport.send(message);

            System.out.println("Email notification sent successfully to: " + email);
        } catch (MessagingException ex) {
            System.out.println("Failed to send email notification: " + ex.getMessage());
        }
    }
}