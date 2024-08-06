package Controller;

import Model.History;
import Model.LoginAttempts;
import Model.Logs;
import Model.Product;
import Model.User;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//added libs
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class SQLite {
    
    public int DEBUG_MODE = 0;
    String driverURL = "jdbc:sqlite:" + "database.db";
    
    public void createNewDatabase() {
        try (Connection conn = DriverManager.getConnection(driverURL)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Database database.db created.");
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void createHistoryTable() {
        String sql = "CREATE TABLE IF NOT EXISTS history (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " username TEXT NOT NULL,\n"
            + " name TEXT NOT NULL,\n"
            + " stock INTEGER DEFAULT 0,\n"
            + " timestamp TEXT NOT NULL\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table history in database.db created.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void createLogsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS logs (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " event TEXT NOT NULL,\n"
            + " username TEXT NOT NULL,\n"
            + " desc TEXT NOT NULL,\n"
            + " timestamp TEXT NOT NULL\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table logs in database.db created.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
     
    public void createProductTable() {
        String sql = "CREATE TABLE IF NOT EXISTS product (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " name TEXT NOT NULL UNIQUE,\n"
            + " stock INTEGER DEFAULT 0,\n"
            + " price REAL DEFAULT 0.00\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table product in database.db created.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
     
    public void createUserTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " username TEXT NOT NULL UNIQUE,\n"
            + " password TEXT NOT NULL,\n"
            + " role INTEGER DEFAULT 2,\n"
            + " locked INTEGER DEFAULT 0\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table users in database.db created.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    public void createLogInAttempts() {
        String sql = "CREATE TABLE IF NOT EXISTS login_attempts (\n"
            + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + " username TEXT NOT NULL UNIQUE,\n"
            + " attempts INTEGER DEFAULT 0,\n"
            + " last_attempt TEXT NOT NULL\n"
            + ");";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table users in database.db created.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void dropHistoryTable() {
        String sql = "DROP TABLE IF EXISTS history;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table history in database.db dropped.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void dropLogsTable() {
        String sql = "DROP TABLE IF EXISTS logs;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table logs in database.db dropped.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void truncateLogs() {
        String sql = "DELETE FROM logs;";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table logs in database.db truncated.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void dropProductTable() {
        String sql = "DROP TABLE IF EXISTS product;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table product in database.db dropped.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void dropUserTable() {
        String sql = "DROP TABLE IF EXISTS users;";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table users in database.db dropped.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void addHistory(String username, String name, int stock, String timestamp) {
        String sql = "INSERT INTO history(username,name,stock,timestamp) VALUES('" + username + "','" + name + "','" + stock + "','" + timestamp + "')";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void addLogs(String event, String username, String desc, String timestamp) {
        String sql = "INSERT INTO logs(event,username,desc,timestamp) VALUES('" + event + "','" + username + "','" + desc + "','" + timestamp + "')";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
   public void updateLogEntry(String timestamp, String newEvent, String newDesc) {
    // SQL statement to update the log entry with the given timestamp
        String sql = "UPDATE logs SET event = ?, desc = ? WHERE timestamp = ?";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); // Adjust format as needed

        try {
            // Parse the string timestamp to java.sql.Timestamp
            java.util.Date parsedDate = dateFormat.parse(timestamp);
            Timestamp timestampstr = new Timestamp(parsedDate.getTime());
            System.out.println("Formatted Timestamp: " + timestampstr + " inside db");

            try (Connection conn = DriverManager.getConnection(driverURL);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // Set the parameters for the SQL query
                pstmt.setString(1, newEvent);
                pstmt.setString(2, newDesc);
                pstmt.setString(3, timestamp); // Use Timestamp object

           
                // Execute the update statement
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Log entry updated successfully.");
                } else {
                    System.out.println("No log entry found with the given timestamp.");
                }
            }
        } catch (Exception ex) {
            // Print stack trace for better debugging
            ex.printStackTrace();
        }
    }

    
    public void addProduct(String name, int stock, double price) {
        String sql = "INSERT INTO product(name,stock,price) VALUES('" + name + "','" + stock + "','" + price + "')";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void addUser(String username, String password) {
        // implemented prepared statement
        try (Connection conn = DriverManager.getConnection(driverURL)) {
            String sql = "INSERT INTO users(username, password) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
                
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error inserting into database: " + ex.getMessage());
        }
    }
    
    
    public ArrayList<History> getHistory(){
        String sql = "SELECT id, username, name, stock, timestamp FROM history";
        ArrayList<History> histories = new ArrayList<History>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                histories.add(new History(rs.getInt("id"),
                                   rs.getString("username"),
                                   rs.getString("name"),
                                   rs.getInt("stock"),
                                   rs.getString("timestamp")));
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return histories;
    }
    
    public ArrayList<History> getHistoryByUser(String username) {
        String sql = "SELECT id, username, name, stock, timestamp FROM history WHERE username = ?";
        ArrayList<History> histories = new ArrayList<History>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    histories.add(new History(rs.getInt("id"),
                                              rs.getString("username"),
                                              rs.getString("name"),
                                              rs.getInt("stock"),
                                              rs.getString("timestamp")));
                }
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return histories;
    }

    public ArrayList<Logs> getLogs(){
        String sql = "SELECT id, event, username, desc, timestamp FROM logs";
        ArrayList<Logs> logs = new ArrayList<Logs>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                logs.add(new Logs(rs.getInt("id"),
                                   rs.getString("event"),
                                   rs.getString("username"),
                                   rs.getString("desc"),
                                   rs.getString("timestamp")));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return logs;
    }
    
    public ArrayList<Product> getProduct(){
        String sql = "SELECT id, name, stock, price FROM product";
        ArrayList<Product> products = new ArrayList<Product>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                products.add(new Product(rs.getInt("id"),
                                   rs.getString("name"),
                                   rs.getInt("stock"),
                                   rs.getFloat("price")));
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return products;
    }
    
    public boolean updateProduct(String previousName, String newName, double price, int stock) {
        String sql = "UPDATE product SET name = ?, price = ?, stock = ? WHERE name = ?";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, newName);
            pstmt.setDouble(2, price);
            pstmt.setInt(3, stock);
            pstmt.setString(4, previousName);
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Return true if update was successful
        } catch (Exception ex) {
            System.out.print(ex);
            return false;
        }
    }
    
        // update the product stock
    public boolean updateProductStock(String productName, int newStock) {
        String sql = "UPDATE product SET stock = ? WHERE name = ?";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.println("INSIDE SQL");
            System.out.println(productName);
            System.out.println(newStock);
            
            
            pstmt.setInt(1, newStock);
            pstmt.setString(2, productName);
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Return true if update was successful
        } catch (Exception ex) {
            System.out.print(ex);
            return false;
        }
    }

    public ArrayList<User> getUsers(){
        String sql = "SELECT id, username, password, role, locked FROM users";
        ArrayList<User> users = new ArrayList<User>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                users.add(new User(rs.getInt("id"),
                                   rs.getString("username"),
                                   rs.getString("password"),
                                   rs.getInt("role"),
                                   rs.getInt("locked")));
            }
        } catch (Exception ex) {}
        return users;
    }
    public ArrayList<LoginAttempts> getLoginAttempts(){
        String sql = "SELECT id, username, attempts, last_attempt FROM login_attempts";
        ArrayList<LoginAttempts> loginAttempts = new ArrayList<LoginAttempts>();
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                loginAttempts.add(new LoginAttempts(rs.getInt("id"),
                                   rs.getString("username"),
                                   rs.getInt("attempts"),
                                   rs.getString("last_attempt")));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return loginAttempts;
    }
    public void updateLoginAttempts(String username, String timestamp) {
        String sqlSelect = "SELECT attempts FROM login_attempts WHERE username = ?";
        String sqlInsert = "INSERT INTO login_attempts (username, attempts, last_attempt) VALUES (?, 1, ?)";
        String sqlUpdate = "UPDATE login_attempts SET attempts = attempts + 1, last_attempt = ? WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmtSelect = conn.prepareStatement(sqlSelect);
             PreparedStatement pstmtInsert = conn.prepareStatement(sqlInsert);
             PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdate)) {

            pstmtSelect.setString(1, username);
            ResultSet rs = pstmtSelect.executeQuery();

            if (rs.next()) {
                // User exists, update login attempts
                pstmtUpdate.setString(1, timestamp);
                pstmtUpdate.setString(2, username);
                pstmtUpdate.executeUpdate();
            } else {
                // User does not exist, insert new record
                pstmtInsert.setString(1, username);
                pstmtInsert.setString(2, timestamp);
                pstmtInsert.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addUser(String username, String password, int role) {
        String sql = "INSERT INTO users(username,password,role) VALUES('" + username + "','" + password + "','" + role + "')";
        
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public void removeUser(String username) {
        String sql = "DELETE FROM users WHERE username='" + username + "';";

        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("User " + username + " has been deleted.");
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    
    public Product getProduct(String name){
        String sql = "SELECT name, stock, price FROM product WHERE name='" + name + "';";
        Product product = null;
        try (Connection conn = DriverManager.getConnection(driverURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            product = new Product(rs.getString("name"),
                                   rs.getInt("stock"),
                                   rs.getFloat("price"));
        } catch (Exception ex) {
            System.out.print(ex);
        }
        return product;
    }
    
    public boolean deleteProductByName(String name) {
        String sql = "DELETE FROM product WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // Return true if delete was successful
        } catch (Exception ex) {
            System.out.print(ex);
            return false;
        }
    }

    public void updateLockAccountStatus(String username, int status){
        String sql = "UPDATE users SET locked = ? WHERE username = ?";
           
        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

           
            pstmt.setInt(1, status);  
            pstmt.setString(2, username); 
            // Execute the update
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Account status updated successfully.");
            } 
            else {
                System.out.println("No account found with the specified username.");
            }
        } catch (SQLException ex) {
        // Handle any SQL exceptions
            System.out.print(ex);
        }
            
    }
    public String getLockedTimestamp(String username) {
        String sql = "SELECT last_attempt FROM login_attempts WHERE username = ?";
        String lastAttempt = "";

        try (Connection conn = DriverManager.getConnection(driverURL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                lastAttempt = rs.getString("last_attempt");
             
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lastAttempt;
    }
    public void deleteLoginAttempt(String username){
        String sql = "DELETE FROM login_attempts WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.executeUpdate();
            System.out.println("Deleted login attempt for username: " + username);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void updateUserPassword(String username, String newPassword) {
        String sql = "UPDATE users SET password = ? WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newPassword);
            pstmt.setString(2, username);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Password updated successfully.");
            } else {
                System.out.println("No account found with the specified username.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateRole(String username, int role) {
        String sql = "UPDATE users SET role = ? WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(driverURL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, role);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
