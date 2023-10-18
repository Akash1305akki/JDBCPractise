package com.productionunit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatingDatabase {

    public static void main(String[] Ak) {
        // Define Connection Parameters
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "Akash1305";
        String dbName = "production_db";

        try {
            // Establish Connection
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            // Create the database if it doesn't exist
            String createDbSQL = "CREATE DATABASE IF NOT EXISTS " + dbName;
            statement.execute(createDbSQL);

            // Close the resources
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully Created DB...");
    }
}
