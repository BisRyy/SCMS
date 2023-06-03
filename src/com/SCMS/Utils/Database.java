package com.SCMS.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/SCMS";
    private Connection connection;
    private String url;
    private String user;
    private String password;

    public Database(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Database() {

    }

    public void connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            if (user == null || password == null) {
                connection = DriverManager.getConnection(CONNECTION_STRING, "root", "");
            } else {
                connection = DriverManager.getConnection(url, user, password);
            }
        }
    }

    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }
}
