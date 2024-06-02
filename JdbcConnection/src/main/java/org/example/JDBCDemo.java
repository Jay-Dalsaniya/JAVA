package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) {
        // Database connection URL
        String url = "jdbc:mysql://localhost:3306/jdbcconnection";
        // Database username
        String username = "root";
        // Database password
        String password = "";

        try {
            // Load and register the JDBC driver for MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            // Create a statement object to send SQL queries to the database
            Statement statement = connection.createStatement();
            // Execute a query to retrieve data from the 'student' table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

            // Iterate through the result set and print each row
            while (resultSet.next()) {
                // Print the first column (int), second column (String), and third column (int)
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3));
            }

            // Close the connection to the database
            connection.close();
        } catch (Exception e) {
            // Print the exception if an error occurs
            System.out.println(e);
        }
    }
}
