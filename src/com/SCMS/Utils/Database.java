package com.SCMS.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.HashMap;
import java.sql.PreparedStatement;

import com.SCMS.Auth.SessionManager;

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
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        return statement.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }

    public Object[][] getOrders(){
        Object[][] orders = null;
        try {
            connect();
            ResultSet resultSet = executeQuery("select * from orders o join products p on o.product_id = p.product_id join suppliers s on p.supplier_id = s.supplier_id join categories c2 on p.category_id = c2.category_id;");
            int rowCount = getRowCount(resultSet);
            int columnCount = 12;
            orders = new Object[rowCount][columnCount];
            resultSet.beforeFirst();
            int i = 0;
            while (resultSet.next()) {
                orders[i][0] = resultSet.getString("order_id");
                orders[i][1] = resultSet.getString("name");
                orders[i][2] = resultSet.getInt("order_quantity");
                orders[i][3] = resultSet.getDouble("price");
                orders[i][4] = resultSet.getString("unit");
                orders[i][5] = resultSet.getString("description");
                orders[i][6] = resultSet.getString("supplier_name");
                orders[i][7] = resultSet.getString("category_name");
                orders[i][8] = resultSet.getString("order_status");
                orders[i][9] = resultSet.getString("order_date");
                i++;
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public Object[][] getInventory(String supplier_id) {
        return getInventory(supplier_id, 0);
    }
    public Object[][] getInventory(String supplier_id, int flag) {
        Object[][] inventory = null;
        try {
            connect();
            ResultSet resultSet = executeQuery(
                    "select * from inventory i join products p on i.product_id = p.product_id join suppliers s on p.supplier_id = s.supplier_id join categories c on p.category_id = c.category_id where i.owner_id " + (flag == 1 ? "!=" : "=")+ supplier_id +";");
            int rowCount = getRowCount(resultSet);
            int columnCount = 13;
            inventory = new Object[rowCount][columnCount];
            resultSet.beforeFirst();
            int i = 0;
            while (resultSet.next()) {

                inventory[i][0] = resultSet.getString("inventory_id");
                inventory[i][1] = resultSet.getString("name");
                inventory[i][2] = resultSet.getInt("quantity");
                inventory[i][3] = resultSet.getDouble("price");
                inventory[i][4] = resultSet.getString("unit");
                inventory[i][5] = resultSet.getString("category_name");
                inventory[i][6] = resultSet.getString("supplier_name");
                inventory[i][7] = resultSet.getString("date_added");
                inventory[i][8] = resultSet.getString("expiry_date");
                inventory[i][9] = resultSet.getString("info");
                inventory[i][10] = resultSet.getString("product_id");
                inventory[i][11] = resultSet.getString("inventory_id");
                inventory[i][12] = resultSet.getString("image");
                i++;
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventory;
    }

    private int getRowCount(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.last();
                return resultSet.getRow();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean addInventory(String product_id, int quantity, String location, String expiry_date, String owner_id, String description) {
        try {
            String query = "insert into inventory(product_id, quantity, location, expiry_date, owner_id, info) values(" + product_id + ", " + quantity + ", '" + location + "', '" + expiry_date + "','" + owner_id + "','"+ description +"');";
            connect();
            executeUpdate(query);
            disconnect();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean removeInventory(String id) {
        String query = "DELETE FROM inventory WHERE inventory_id='" + id + "';";
        try {
            connect();
            executeUpdate(query);
            disconnect();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Object[][] getCategories(){
        Object[][] categories = null;
        try {
            connect();
            ResultSet resultSet = executeQuery("select * from categories where deleted = 0;");
            int rowCount = getRowCount(resultSet);
            int columnCount = 2;
            categories = new Object[rowCount][columnCount];
            resultSet.beforeFirst();
            int i = 0;
            while (resultSet.next()) {
                categories[i][0] = resultSet.getString("category_id");
                categories[i][1] = resultSet.getString("category_name");
                i++;
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public Object[][] getProducts(String supplier_id) {
        Object[][] products = null;
        try {
            connect();
            ResultSet resultSet = executeQuery(
                    "select * from products p join suppliers s on p.supplier_id = s.supplier_id where p.supplier_id = " + supplier_id +" AND p.deleted = 0;");
            int rowCount = getRowCount(resultSet);
            int columnCount = 9;
            products = new Object[rowCount][columnCount];
            resultSet.beforeFirst();
            int i = 0;
            while (resultSet.next()) {

                products[i][0] = resultSet.getString("code");
                products[i][1] = resultSet.getString("name");
                products[i][2] = resultSet.getDouble("price");
                products[i][3] = resultSet.getString("unit");
                products[i][4] = resultSet.getString("category_id");
                products[i][5] = resultSet.getString("supplier_name");
                products[i][6] = resultSet.getString("description");
                products[i][7] = resultSet.getString("product_id");
                products[i][8] = resultSet.getString("image");
                i++;
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public boolean addProduct(String name, String code, double price, String unit, String category, String description,
            String image, String supplier_id) {
        String query = "INSERT INTO products (name, code, price, unit, category_id, description, image, supplier_id) VALUES('"
                + name + "', '"
                + code + "', '" + price + "', '" + unit + "', '" + category + "', '" + description + "', '" + image
                + "', '"
                + supplier_id + "');";
        try {
            connect();
            executeUpdate(query);
            disconnect();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // add category to database
    public boolean addCategory(String name) {
        String query = "INSERT INTO categories (category_name) VALUES('" + name + "');";
        try {
            connect();
            executeUpdate(query);
            disconnect();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    // remove category from database
    public boolean removeCategory(String id) {
        String query = "UPDATE categories SET deleted = 1 WHERE category_id='" + id + "';";
        try {
            connect();
            executeUpdate(query);
            disconnect();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean removeProduct(String id) {
        String query = "UPDATE products SET deleted = 1 WHERE product_id='" + id + "';";
        try {
            connect();
            executeUpdate(query);
            disconnect();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean orderProduct(String u_id, String prod_id, int quantity, String status, String company_id, String note) {
        String query = "INSERT INTO orders(user_id,company_id, product_id, order_quantity, order_status, note) VALUES('" + u_id +"','" + company_id +"', '"
                + prod_id + "', '" + quantity + "', '" + status +"', '" + note + "')";

        try {
            connect();
            executeUpdate(query);
            disconnect();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Object[][] getSuppliers() {
        Object[][] suppliers = null;
        try {
            connect();
            ResultSet resultSet = executeQuery(
                    "select * from suppliers;");
            int rowCount = getRowCount(resultSet);
            int columnCount = 8;
            suppliers = new Object[rowCount][columnCount];
            resultSet.beforeFirst();
            int i = 0;
            while (resultSet.next()) {
                suppliers[i][0] = resultSet.getString("supplier_name");
                suppliers[i][1] = resultSet.getString("supplier_address");
                suppliers[i][2] = resultSet.getString("supplier_phone");
                suppliers[i][3] = resultSet.getString("supplier_name");
                suppliers[i][4] = resultSet.getString("supplier_email");
                suppliers[i][5] = resultSet.getString("supplier_id");
                suppliers[i][6] = resultSet.getString("manager_name");
                i++;
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return suppliers;
    }

    // get user id from username

    public int getUsernameId() {
        return getUsernameId(SessionManager.getAuthenticatedUser());
    }
    
    public int getUsernameId(String username) {
        try {
            connect();
            ResultSet resultSet = executeQuery("select user_id from users where username = '" + username + "';");
            resultSet.next();
            int id = resultSet.getInt("user_id");
            disconnect();
            return id;
        } catch (SQLException e) {

        }
        return 0;
    }
    
    public Map<String, String> userInfo(String info) {
        String sql = "SELECT * FROM users WHERE username = ?";

        try {
            connect();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, info);
            ResultSet resultSet = statement.executeQuery();

            Map<String, String> userInfo = new HashMap<>();

            if(resultSet.next())
            {
                // Get the info from the database
                String fname = resultSet.getString("fname");
                String lname = resultSet.getString("lname");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
        
                // Put the info in the map
                userInfo.put("fname", fname);
                userInfo.put("lname", lname);
                userInfo.put("email", email);
                userInfo.put("phone", phone);
                userInfo.put("address", address);
            }
    
            disconnect();
            return userInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return null;
    }   
    
    public boolean saveUserInfo(String username, String fname, String lname, String email, String phone, String address, String image)
    {
        String sql = "UPDATE users SET fname = ?, lname = ?, email = ?,  phone = ?, address = ?, image_data = ? WHERE username = ?";

        try{
            connect();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, fname);
            statement.setString(2, lname);
            statement.setString(3, email);
            statement.setString(4, phone);
            statement.setString(5, address);
            statement.setString(6, image);
            statement.setString(7, username);
            statement.executeUpdate();
            disconnect();
            return true;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteUser(String username)
    {
        String sql = "DELETE FROM users WHERE username = ?";

        try
        {
            connect();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.executeUpdate();
            disconnect();
            return true;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    
        return false;
    }
}