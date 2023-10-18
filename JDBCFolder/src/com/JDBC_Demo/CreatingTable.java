package com.JDBC_Demo;
import java.sql.*;

public class CreatingTable {

    public static void main(String[] Ak) {
        // Define Connection Parameters
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Akash1305";
        String dbName = "Employee_db";

        try {
            // Establish Connection
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // Use the specified database
            statement.execute("USE " + dbName);

            //Create the table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS employee (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "first_name VARCHAR(50)," +
                    "last_name VARCHAR(50)," +
                    "salary DECIMAL(10, 2)" +
                    ")";
            statement.execute(createTableSQL);

            //Close the resources
            statement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully Created Employee Table...");
    }
}