package projects.sql;

// java.sql is the Java standard library that contains the interfaces and classes to connect to databases and execute SQL queries.
import java.sql.Connection;         // This imports the Connection interface, which represents a connection to a database. 
import java.sql.DriverManager;      // This imports the DriverManager class, which manages a list of database drivers and is used to establish a connection to a database.
import java.sql.PreparedStatement;
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
    
    public boolean addContact (String name, String phone_number, String email_address, String address) throws SQLException {
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
            
        // Runs the SQL query and returns the number of rows affected
        int rowsInserted = pstmt.executeUpdate();
            
        return rowsInserted > 0;
    }
    
}
