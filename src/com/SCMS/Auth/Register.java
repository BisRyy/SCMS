package com.SCMS.Auth;
import java.awt.*;
import javax.swing.*;

import com.SCMS.Utils.DB;

import java.awt.event.*;
import java.sql.*;

public class Register extends JFrame {
    JLabel titleLabel;
    JLabel usernameLabel;
    JLabel passwordLabel;
    JLabel emailLabel;
    JLabel companyLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JTextField emailField;
    JTextField companyField;
    JButton registerButton;
    JLabel loginLabel;

    public Register() {
        setTitle("Registration - Supply Chain Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        titleLabel = new JLabel("Registration");
        titleLabel.setFont(new Font("Geomanist", Font.BOLD, 20));
        titleLabel.setBounds(150, 20, 200, 30);

        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(50, 80, 80, 25);

        usernameField = new JTextField();
        usernameField.setBounds(140, 80, 200, 25);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 120, 80, 25);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 120, 200, 25);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(50, 160, 80, 25);

        emailField = new JTextField();
        emailField.setBounds(140, 160, 200, 25);

        registerButton = new JButton("Register");
        registerButton.setBounds(160, 260, 80, 25);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Registration logic here
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String email = emailField.getText();
                String msg = "" + username;
                msg += " \n";
                if (username.length() < 4) {
                    JOptionPane.showMessageDialog(registerButton, "Enter a valid username");
                }

                // Perform registration actions
                try {
                    Connection connection = DB.getConnection();

                    String query = "INSERT INTO users(username, password, email) VALUES('" + username + "', '" + password + "', '" + email + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);

                    if (x == 0) {
                        JOptionPane.showMessageDialog(registerButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(registerButton,
                                "Welcome, " + msg + "Your account is sucessfully created. Please login to continue");
                    dispose();
                    LogIn login = new LogIn();
                    login.setVisible(true);
                    }
                    connection.close();


                } catch (Exception exception) {
                    if (exception.getMessage().contains("Duplicate entry")) {
                        JOptionPane.showMessageDialog(registerButton, "Username already exists");
                    } else {
                        JOptionPane.showMessageDialog(registerButton, exception.getMessage());
                    }
                }                
            }
        });

        loginLabel = new JLabel("Already have an account? Login");
        loginLabel.setForeground(Color.BLUE);
        loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLabel.setBounds(100, 300, 200, 20);
        loginLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose();
                LogIn login = new LogIn();
                login.setVisible(true);
            }

            public void mouseEntered(MouseEvent e) {
                loginLabel.setForeground(Color.WHITE);
            }

            public void mouseExited(MouseEvent e) {
                loginLabel.setForeground(Color.BLUE);
            }
        });

        panel.add(titleLabel);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(registerButton);
        panel.add(loginLabel);

        add(panel);
    }

    public static void main(String[] args) {
        Register register = new Register();
        register.setVisible(true);
    }
}
