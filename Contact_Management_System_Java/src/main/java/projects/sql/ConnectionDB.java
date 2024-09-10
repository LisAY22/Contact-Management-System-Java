package projects.sql;

// java.sql is the Java standard library that contains the interfaces and classes to connect to databases and execute SQL queries.
import java.sql.Connection;         // This imports the Connection interface, which represents a connection to a database. 
import java.sql.DriverManager;      // This imports the DriverManager class, which manages a list of database drivers and is used to establish a connection to a database.
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;       // This imports the SQLException class, which is used to handle any SQL-related errors that occur during database interactions.

/**
 *
 * @author lisaj
 */
public class ConnectionDB {
    private static Connection con;
    
    public Connection obtainConnection() {
        if (con == null) {
            try {
                // The term jdbc stands for Java Database Connectivity. It's an API in Java that defines how a Java application can connect to databases and interact with them using SQL 
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact_information?serverTimezone=UTC", "root","Bromi.22AY04");
                System.out.println("CONNECTION ESTABLISHED");
            } catch (SQLException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        return con;
    }
    
    public ResultSet contacts() {
        try {
            String query = "SELECT * FROM Contact";
            PreparedStatement pstmt = con.prepareStatement(query);
            
            // executeQuery() is used for SELECT queries. 
            // It returns a ResultSet object that holds the results of the query.
            return pstmt.executeQuery();
        }
        catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            
            return null;
        }
    }
    
    public ResultSet searchContact(String name_id) {
        String query;

        boolean isId = false;
        int id = 0;

        // Check if the input can be parsed as an integer
        try {
            id = Integer.parseInt(name_id);
            isId = true;
        } catch (NumberFormatException e) {
            // Input is not an integer, so it must be a name
            isId = false;
        }

        if (isId) {
            query = "SELECT * FROM Contact WHERE ID_Contact = ?";
        } else {
            query = "SELECT * FROM Contact WHERE Name = ?";
        }

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            if (isId) {
                pstmt.setInt(1, id);
            } else {
                pstmt.setString(1, name_id);
            }
            return pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            return null;
        }
    }

    
    public void addContact (String name, String phone_number, String email_address, String address) {
        try {
            // Define a string, this will be the query
            // The question marks (?) are placeholders for the values ​​to be inserted.
            String query = "INSERT INTO Contact(Name, Phone_Number, Email_Address, Adress) VALUES (?, ?, ?, ?)";
            // PreparedStatement: Class that represents a precompiled SQL query.
            PreparedStatement pstmt = con.prepareStatement(query);

            // Set values for the placeholders (?)
            pstmt.setString(1, name);
            pstmt.setString(2, phone_number);
            pstmt.setString(3, email_address);
            pstmt.setString(4, address);

            // executeUpdate() is used for INSERT, UPDATE, or DELETE queries. 
            // This method returns an integer representing the number of rows affected by the operation
            int rowsInserted = pstmt.executeUpdate();
            
            if (rowsInserted > 0) {
                System.out.println("CONTACT SAVED");
            }
        }
        catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }            
    }
    
    public void updateContact (int id, String name, String phone_number, String email_address, String address) {
        try {
            String query = "UPDATE Contact SET Name = ?, Phone_Number = ?, Email_Address = ?, Adress = ? "
                    + "WHERE ID_Contact = ?";
            PreparedStatement pstmt = con.prepareStatement(query);

            // Set values for the placeholders (?)
            pstmt.setString(1, name);
            pstmt.setString(2, phone_number);
            pstmt.setString(3, email_address);
            pstmt.setString(4, address);
            pstmt.setInt(5, id);

            int rowsInserted = pstmt.executeUpdate();
            
            if (rowsInserted > 0) {
                System.out.println("CONTACT SAVED");
            }
        }
        catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }            
    }
    
}
