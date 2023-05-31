package com.SCMS.Auth;
import java.awt.*;
import javax.swing.*;

import com.SCMS.Menu;
import com.SCMS.Utils.DB;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LogIn extends JFrame {
    JLabel titleLabel;
    JLabel usernameLabel;
    JLabel passwordLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;
    JLabel registerLabel;

    public LogIn() {
        setTitle("Login - Supply Chain Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Geomanist", Font.BOLD, 20));
        titleLabel.setBounds(170, 30, 80, 30);

        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(50, 80, 80, 25);

        usernameField = new JTextField();
        usernameField.setBounds(140, 80, 200, 25);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 120, 80, 25);

        passwordField = new JPasswordField();
        passwordField.setBounds(140, 120, 200, 25);

        loginButton = new JButton("Login");
        loginButton.setBounds(160, 180, 80, 25);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Login logic here
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Perform login actions
                try{
                    Connection connection = DB.getConnection();

                    String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";

                    Statement sta = connection.createStatement();
                    ResultSet rs = sta.executeQuery(query);

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        dispose();
                        Menu menu = new Menu();
                        menu.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password");
                    }
                    connection.close();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
        });

        registerLabel = new JLabel("Don't have an account? Register");
        registerLabel.setForeground(Color.BLUE);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.setBounds(90, 230, 220, 20);
        registerLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose();
                Register register = new Register();
                register.setVisible(true);
            }

            public void mouseEntered(MouseEvent e) {
                registerLabel.setForeground(Color.WHITE);
            }

            public void mouseExited(MouseEvent e) {
                registerLabel.setForeground(Color.BLUE);
            }
        });

        panel.add(titleLabel);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerLabel);

        add(panel);
    }

    public static void main(String[] args) {
        LogIn login = new LogIn();
        login.setVisible(true);
    }
}
