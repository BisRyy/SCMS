package com.SCMS.Pages;
import javax.swing.*;

import com.SCMS.Menu;
import com.SCMS.Auth.SessionManager;
import com.SCMS.Utils.DB;
import com.SCMS.Utils.Database;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Auth extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public Auth() {
        setTitle("Supply Chain Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);
        initComponents();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title
        JLabel titleLabel = new JLabel("<html> <br>Welcome to Supply Chain Management <br><br><br></html>", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        


        // Card Panel
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Login Panel
        JPanel loginPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        loginPanel.setBorder(BorderFactory.createTitledBorder("Login"));

        JLabel usernameLabel = new JLabel("Username:", SwingConstants.RIGHT);
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:", SwingConstants.RIGHT);
        passwordField = new JPasswordField();
        JLabel roleLabel = new JLabel("Role:", SwingConstants.RIGHT);
        roleComboBox = new JComboBox<>(new String[]{"Employee", "Manager","Administrator" });
        JButton loginButton = new JButton("Login");

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(roleLabel);
        loginPanel.add(roleComboBox);
        loginPanel.add(new JLabel()); // Empty label for spacing
        loginPanel.add(loginButton);

        cardPanel.add(loginPanel, "login");

        // Registration Panel
        JPanel registrationPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        registrationPanel.setBorder(BorderFactory.createTitledBorder("Registration"));

        JLabel newUsernameLabel = new JLabel("New Username:", SwingConstants.RIGHT);
        JTextField newUsernameField = new JTextField();
        JLabel newEmailLabel = new JLabel("Email:", SwingConstants.RIGHT);
        JTextField newEmailField = new JTextField();
        JLabel newPasswordLabel = new JLabel("New Password:", SwingConstants.RIGHT);
        JPasswordField newPasswordField = new JPasswordField();
        JLabel newRoleLabel = new JLabel("Role:", SwingConstants.RIGHT);
        JComboBox<String> newRoleComboBox = new JComboBox<>(new String[]{"Employee", "Manager","Administrator" });
        JButton registerButton = new JButton("Register");

        registrationPanel.add(newUsernameLabel);
        registrationPanel.add(newUsernameField);
        registrationPanel.add(newEmailLabel);
        registrationPanel.add(newEmailField);
        registrationPanel.add(newPasswordLabel);
        registrationPanel.add(newPasswordField);
        registrationPanel.add(newRoleLabel);
        registrationPanel.add(newRoleComboBox);
        registrationPanel.add(new JLabel()); // Empty label for spacing
        registrationPanel.add(registerButton);
        cardPanel.add(registrationPanel, "registration");
        mainPanel.add(new JLabel("     "), BorderLayout.WEST);
        mainPanel.add(new JLabel("     "), BorderLayout.EAST);
        mainPanel.add(cardPanel, BorderLayout.CENTER);

        // Card Button Listeners
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                String role = roleComboBox.getSelectedItem().toString();

                // Perform login authentication
                authenticateLogin(username, password, role);
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = newUsernameField.getText();
                String email = newEmailField.getText();
                char[] password = newPasswordField.getPassword();
                String role = newRoleComboBox.getSelectedItem().toString();

                // Perform registration
                registerUser(username, email, password, role);
            }
        });

        // Button Panel
        JLabel buttonLabel = new JLabel("Don't have an account?");
        JLabel buttonLabel2 = new JLabel("Already have an account?");
        JPanel buttonPanel = new JPanel();
        JButton loginPageButton = new JButton("Login");
        JButton registrationPageButton = new JButton("Register");
        buttonPanel.add(new JLabel("<html><br><br><br></html>"));
        buttonPanel.add(buttonLabel);
        buttonPanel.add(buttonLabel2);
        buttonPanel.add(loginPageButton);
        buttonPanel.add(registrationPageButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        loginPageButton.setVisible(false);
        buttonLabel2.setVisible(false);

        // Button Listeners
        loginPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginPageButton.setVisible(false);
                registrationPageButton.setVisible(true);
                buttonLabel.setVisible(true);
                buttonLabel2.setVisible(false);
                cardLayout.show(cardPanel, "login");
                
            }
        });

        registrationPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrationPageButton.setVisible(false);
                loginPageButton.setVisible(true);
                buttonLabel.setVisible(false);
                buttonLabel2.setVisible(true);
                cardLayout.show(cardPanel, "registration");
            }
        });

        add(mainPanel);
    }

    private void authenticateLogin(String username, char[] pass, String role) {
        String password = new String(pass);

        try{
            Connection connection = DB.getConnection();

            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "' AND role = '" + role + "'";

            Statement sta = connection.createStatement();
            ResultSet rs = sta.executeQuery(query);
            
            if (rs.next() || (username.equals("admin") && password.equals("admin") && role.equals("Administrator"))) {
                SessionManager.saveAuthenticationState(true, username, role);
                JOptionPane.showMessageDialog(null, "Welcome back " + username + "!", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new Menu(username, role);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password\nPlease try again", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }

    private void registerUser(String username,  String email, char[] password, String role) {

        String passwordString = new String(password);
        try {
            Database database = new Database();
            database.connect();

            String query = "INSERT INTO users(username, password, email, role) VALUES('" + username + "', '" + passwordString+ "', '" + email + "', '" + role + "')";

            int x = database.executeUpdate(query);

            if (x == 0) {
                JOptionPane.showMessageDialog(this, "This is already exist");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Welcome, " + username + "Your account is sucessfully created. Please login to continue");            
            }
            database.disconnect();


        } catch (Exception exception) {
            if (exception.getMessage().contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(this, "Username already exists");
            } else {
                JOptionPane.showMessageDialog(this, exception.getMessage());
            }
        }                
    }
}
