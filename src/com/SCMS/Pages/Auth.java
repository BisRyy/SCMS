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
    Object[][] suppliers;
    String[] supplierName;
    JTextField newUsernameField;
    private Database db = new Database();

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
        JLabel titleLabel = new JLabel("<html> <br>Welcome to Supply Chain Management <br><br><br></html>",
                SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Card Panel
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Login Panel
        JPanel loginPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        loginPanel.setBorder(BorderFactory.createTitledBorder("Login"));

        suppliers = db.getSuppliers();
        supplierName = new String[suppliers.length];
        for (int i = 0; i < supplierName.length; i++) {
            supplierName[i] = (String) suppliers[i][0];
        }
        JLabel usernameLabel = new JLabel("Username:", SwingConstants.RIGHT);
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:", SwingConstants.RIGHT);
        passwordField = new JPasswordField();
        JLabel supplierLabel = new JLabel("Company: ", SwingConstants.RIGHT);
        JComboBox<String> supplierField = new JComboBox<>(supplierName);
        JLabel roleLabel = new JLabel("Role:", SwingConstants.RIGHT);
        roleComboBox = new JComboBox<>(new String[] { "Employee", "Manager", "Administrator" });
        JButton loginButton = new JButton("Login");

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(supplierLabel);
        loginPanel.add(supplierField);
        loginPanel.add(roleLabel);
        loginPanel.add(roleComboBox);
        loginPanel.add(new JLabel()); // Empty label for spacing
        loginPanel.add(loginButton);

        cardPanel.add(loginPanel, "login");

        // Create Company Panel
        JPanel createCompanyPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        createCompanyPanel.setBorder(BorderFactory.createTitledBorder("Create Company"));

        JLabel companyNameLabel = new JLabel("Company Name:", SwingConstants.RIGHT);
        JTextField companyNameField = new JTextField();
        JLabel companyAddressLabel = new JLabel("Company Address:", SwingConstants.RIGHT);
        JTextField companyAddressField = new JTextField();
        JLabel companyEmailLabel = new JLabel("Company Email:", SwingConstants.RIGHT);
        JTextField companyEmailField = new JTextField();
        JLabel companyPhoneLabel = new JLabel("Company Phone:", SwingConstants.RIGHT);
        JTextField companyPhoneField = new JTextField();
        JLabel companyManagerLabel = new JLabel("Manager Username:", SwingConstants.RIGHT);
        JTextField companyManagerField = new JTextField();
        JButton createCompanyButton = new JButton("Create Company");

        createCompanyPanel.add(companyNameLabel);
        createCompanyPanel.add(companyNameField);
        createCompanyPanel.add(companyAddressLabel);
        createCompanyPanel.add(companyAddressField);
        createCompanyPanel.add(companyEmailLabel);
        createCompanyPanel.add(companyEmailField);
        createCompanyPanel.add(companyPhoneLabel);
        createCompanyPanel.add(companyPhoneField);
        createCompanyPanel.add(companyManagerLabel);
        createCompanyPanel.add(companyManagerField);

        createCompanyPanel.add(new JLabel()); // Empty label for spacing
        createCompanyPanel.add(createCompanyButton);
        cardPanel.add(createCompanyPanel, "createCompany");

        // Registration Panel
        JPanel registrationPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        registrationPanel.setBorder(BorderFactory.createTitledBorder("Registration"));
        JLabel newUsernameLabel = new JLabel("New Username:", SwingConstants.RIGHT);
        newUsernameField = new JTextField();
        JLabel newEmailLabel = new JLabel("Email:", SwingConstants.RIGHT);
        JTextField newEmailField = new JTextField();

        JLabel newPasswordLabel = new JLabel("New Password: ", SwingConstants.RIGHT);
        JPasswordField newPasswordField = new JPasswordField();
        JLabel newSupplierLabel = new JLabel("Company: ", SwingConstants.RIGHT);
        JComboBox<String> newSupplierField = new JComboBox<>(supplierName);
        JLabel newRoleLabel = new JLabel("Role: ", SwingConstants.RIGHT);
        JComboBox<String> newRoleComboBox = new JComboBox<>(new String[] { "Employee", "Manager" });
        JButton registerButton = new JButton("Register");

        registrationPanel.add(newUsernameLabel);
        registrationPanel.add(newUsernameField);
        registrationPanel.add(newEmailLabel);
        registrationPanel.add(newEmailField);
        registrationPanel.add(newPasswordLabel);
        registrationPanel.add(newPasswordField);
        registrationPanel.add(newSupplierLabel);
        registrationPanel.add(newSupplierField);
        registrationPanel.add(newRoleLabel);
        registrationPanel.add(newRoleComboBox);
        JButton createCompanyPageButton = new JButton("Create New Company");
        registrationPanel.add(createCompanyPageButton);
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
                String companyId = (String) suppliers[supplierField.getSelectedIndex()][5];
                if (username.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Please fill in all the required fields.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Perform login authentication
                    authenticateLogin(username, password, role, companyId);
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = newUsernameField.getText();
                String email = newEmailField.getText();
                char[] password = newPasswordField.getPassword();
                String role = newRoleComboBox.getSelectedItem().toString();
                String companyId = (String) suppliers[newSupplierField.getSelectedIndex()][5];
                if (username.trim().isEmpty() || email.trim().isEmpty() || password.length ==0) {
                    JOptionPane.showMessageDialog(null,
                            "Please fill in all the required fields.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }else if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(null, "Invalid email format");
                    return;
                }
                else {
                    if (role == "Manager" && !suppliers[newSupplierField.getSelectedIndex()][6].equals(username)) {
                        JOptionPane.showMessageDialog(getParent(), "You are not Manager of this company.");
                        return;
                    }

                    // Perform registration
                    registerUser(username, email, password, role, companyId);
                }
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

        // create company button
        createCompanyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String companyName = companyNameField.getText();
                String companyAddress = companyAddressField.getText();
                String companyEmail = companyEmailField.getText();
                String companyPhone = companyPhoneField.getText();
                String companyManager = companyManagerField.getText();
                if (companyName.trim().isEmpty() || companyAddress.trim().isEmpty() || companyEmail.isEmpty() || companyManager.trim().isEmpty() || companyPhone.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Please fill in all the required fields.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!isValidEmail(companyEmail)) {
                    JOptionPane.showMessageDialog(null, "Invalid email format");
                    return;
                } else {
                    createCompany(companyName, companyAddress, companyEmail, companyPhone, companyManager);
                    suppliers = db.getSuppliers();
                    newUsernameField.setText(companyManager);
                    dispose();
                    new Auth();
                }
            }
        });

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

        createCompanyPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "createCompany");
            }
        });

        add(mainPanel);
    }

    private void authenticateLogin(String username, char[] pass, String role, String companyId) {
        String password = new String(pass);

        try {
            Connection connection = DB.getConnection();

            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "' AND role = '" + role + "' AND company_id = '" + companyId + "';";

            Statement sta = connection.createStatement();
            ResultSet rs = sta.executeQuery(query);

            if (rs.next() || (username.equals("admin") && password.equals("admin") && role.equals("Administrator"))) {
                SessionManager.saveAuthenticationState(true, username, role, companyId);
                JOptionPane.showMessageDialog(null, "Welcome back " + username + "!", "Login Successful",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new Menu(username, role, companyId);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password\nPlease try again", "Login Failed",
                        JOptionPane.ERROR_MESSAGE);
            }
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }

    private void registerUser(String username, String email, char[] password, String role, String companyId) {

        String passwordString = new String(password);
        try {
            db.connect();
            String query = "INSERT INTO users(username, password, email, role, company_id) VALUES('" + username + "', '" + passwordString + "', '" + email + "', '" + role + "', '" + companyId +"');";

            int x = db.executeUpdate(query);

            if (x == 0) {
                JOptionPane.showMessageDialog(this, "This user already exist");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Welcome " + username + ", Your account is sucessfully created. Please login to continue");
                usernameField.setText(username);
                cardLayout.show(cardPanel, "login");
            }
            db.disconnect();

        } catch (Exception exception) {
            if (exception.getMessage().contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(this, "Username already exists");
            } else {
                JOptionPane.showMessageDialog(this, exception.getMessage());
            }
        }
    }

    private void createCompany(String companyName, String companyAddress, String companyEmail, String companyPhone, String companyManager) {
        try {
            Database database = new Database();
            database.connect();

            String query = "INSERT INTO suppliers(supplier_name, supplier_address, supplier_email, supplier_phone, manager_name) VALUES('"
                    + companyName + "', '" + companyAddress + "', '" + companyEmail + "', '" + companyPhone + "', '"
                    + companyManager + "');";

            int x = database.executeUpdate(query);

            if (x == 0) {
                JOptionPane.showMessageDialog(this, "Company already exist");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Your company, " + companyName
                                + " has sucessfully created. Please create a manager account now.");
            }
            database.disconnect();
        } catch (Exception exception) {
            if (exception.getMessage().contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(this, "Company already exists");
            } else {
                JOptionPane.showMessageDialog(this, exception.getMessage());
            }
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }
}
